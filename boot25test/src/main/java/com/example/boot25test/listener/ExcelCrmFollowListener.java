package com.example.boot25test.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.boot25test.pojo.CrmCustomer;
import com.example.boot25test.pojo.CrmFollow;
import com.example.boot25test.pojo.CrmPerson;
import com.example.boot25test.pojo.SysUser;
import com.example.boot25test.service.CrmCustomerServiceImpl;
import com.example.boot25test.service.CrmFollowServiceImpl;
import com.example.boot25test.service.SysUserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExcelCrmFollowListener extends AnalysisEventListener<CrmFollow> {

    private CrmCustomerServiceImpl crmCustomerService;
    private SysUserServiceImpl sysUserService;
    private CrmFollowServiceImpl crmFollowService;

    /**
     * 每隔500条存储数据库
     */
    private static final int BATCH_COUNT = 500;

    private List<CrmFollow> list = new ArrayList<>(BATCH_COUNT);

    private List<String> lostCustomer = new ArrayList<>(BATCH_COUNT);

    public ExcelCrmFollowListener(CrmCustomerServiceImpl crmCustomerService, SysUserServiceImpl sysUserService, CrmFollowServiceImpl crmFollowService) {
        this.crmCustomerService = crmCustomerService;
        this.sysUserService = sysUserService;
        this.crmFollowService = crmFollowService;
    }

    @Override
    public void invoke(CrmFollow data, AnalysisContext context) {
        String followStatus = data.getFollowStatus();
        CrmCustomer one = crmCustomerService.getOne(Wrappers.<CrmCustomer>lambdaQuery().eq(CrmCustomer::getCustomerName, followStatus).select(CrmCustomer::getCustomerId).last("limit 1"));
        if(Objects.nonNull(one)){
            data.setCustomerId(one.getCustomerId());
            SysUser one2 = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, data.getCreateBy()).last("limit 1"));
            data.setCreateBy(one2.getLoginName());
            data.setFollowDate(data.getCreateTime());
            data.setFollowStatus(null);

            String followType = data.getFollowType();
            if("电话".equals(followType)){
                data.setFollowType("1");
            }else {
                data.setFollowType("4");
            }
            data.setDelFlag("0");
            list.add(data);
            // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
            if (this.list.size() >= BATCH_COUNT) {
                saveData();
                // 存储完成清理 list
                this.list.clear();
            }
        }else{
            lostCustomer.add(followStatus);
        }
    }

    private void saveData() {
        crmFollowService.saveBatch(list);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        System.out.println("未找到客户：");
        lostCustomer.stream().distinct().forEach(System.out::println);
    }
}
