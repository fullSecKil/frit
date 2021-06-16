package com.example.boot25test.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.boot25test.pojo.CrmCustomer;
import com.example.boot25test.pojo.CrmPerson;
import com.example.boot25test.pojo.SysUser;
import com.example.boot25test.service.CrmCustomerServiceImpl;
import com.example.boot25test.service.CrmPersonServiceImpl;
import com.example.boot25test.service.SysUserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExcelCrmPersonListener extends AnalysisEventListener<CrmPerson> {


    /**
     * 每隔500条存储数据库
     */
    private static final int BATCH_COUNT = 500;

    private CrmCustomerServiceImpl crmCustomerService;

    private SysUserServiceImpl sysUserService;

    private CrmPersonServiceImpl crmPersonService;

    private List<CrmPerson> list = new ArrayList<>(BATCH_COUNT);

    public ExcelCrmPersonListener(CrmCustomerServiceImpl crmCustomerService, SysUserServiceImpl sysUserService, CrmPersonServiceImpl crmPersonService) {
        this.crmCustomerService = crmCustomerService;
        this.sysUserService = sysUserService;
        this.crmPersonService = crmPersonService;
    }

    @Override
    public void invoke(CrmPerson data, AnalysisContext context) {
        String englishName = data.getEnglishName();
        CrmCustomer one = crmCustomerService.getOne(Wrappers.<CrmCustomer>lambdaQuery().eq(CrmCustomer::getCustomerName, englishName).select(CrmCustomer::getCustomerId).last("limit 1"));
        Long customerId = Optional.ofNullable(one).map(CrmCustomer::getCustomerId).orElse(null);
        data.setCustomerId(customerId);

        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, data.getCreateBy()));
        String loginName = Optional.ofNullable(sysUser).map(SysUser::getLoginName).orElse(null);
        data.setCreateBy(loginName);
        data.setPersonId(null);
        data.setEnglishName("");
        data.setDelFlag("0");
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (this.list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            this.list.clear();
        }
    }

    private void saveData() {
        crmPersonService.saveBatch(list);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }
}
