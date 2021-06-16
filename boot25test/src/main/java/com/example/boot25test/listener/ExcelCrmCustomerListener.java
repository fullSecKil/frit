package com.example.boot25test.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.boot25test.pojo.CrmCustomer;
import com.example.boot25test.pojo.SysUser;
import com.example.boot25test.service.CrmCustomerServiceImpl;
import com.example.boot25test.service.SysUserServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ExcelCrmCustomerListener extends AnalysisEventListener<CrmCustomer> {

    /**
     * 每隔500条存储数据库
     */
    private static final int BATCH_COUNT = 500;

    private CrmCustomerServiceImpl crmCustomerService;

    private SysUserServiceImpl sysUserService;

    private List<CrmCustomer> list = new ArrayList<>(BATCH_COUNT);

    public ExcelCrmCustomerListener(SysUserServiceImpl sysUserService, CrmCustomerServiceImpl crmCustomerService) {
        this.sysUserService = sysUserService;
        this.crmCustomerService = crmCustomerService;
    }

    @Override
    public void invoke(CrmCustomer data, AnalysisContext context) {
        // 客户级别
        String customerDegree = data.getCustomerDegree();
        if (StringUtils.isBlank(customerDegree)) {
            data.setCustomerDegree("0");
        } else if (StringUtils.startsWith(customerDegree, "A")) {
            data.setCustomerDegree("5");
        } else if (StringUtils.startsWith(customerDegree, "B")) {
            data.setCustomerDegree("4");
        } else if (StringUtils.startsWith(customerDegree, "C")) {
            data.setCustomerDegree("3");
        } else {
            data.setCustomerDegree("0");
        }
        data.setCustomerId(null);
        data.setDelFlag("0");
        data.setIsShare("0");
        String industry = data.getIndustry();
        if (StringUtils.isBlank(industry) || "其它".equals(industry)) {
            data.setIndustry("20");
        } else if ("仪器仪表".equals(industry)) {
            data.setIndustry("15");
        } else if ("医疗".equals(industry)) {
            data.setIndustry("7");
        } else if ("研究所".equals(industry)) {
            data.setIndustry("21");
        } else if ("新能源".equals(industry)) {
            data.setIndustry("22");
        } else if ("消费电子".equals(industry)) {
            data.setIndustry("1");
        } else if ("通信".equals(industry)) {
            data.setIndustry("8");
        } else if ("设备".equals(industry)) {
            data.setIndustry("23");
        } else if ("汽车".equals(industry)) {
            data.setIndustry("6");
        } else if ("航空".equals(industry)) {
            data.setIndustry("16");
        } else if ("电子元器件".equals(industry)) {
            data.setIndustry("2");
        } else if ("材料".equals(industry)) {
            data.setIndustry("12");
        }
       /* if (StringUtils.isBlank(industry) || "其它".equals(industry)) {
            data.setIndustry("0");
        } else if ("仪器仪表".equals(industry)) {
            data.setIndustry("22");
        } else if ("医疗".equals(industry)) {
            data.setIndustry("32");
        } else if ("研究所".equals(industry)) {
            data.setIndustry("39");
        } else if ("新能源".equals(industry)) {
            data.setIndustry("40");
        } else if ("消费电子".equals(industry)) {
            data.setIndustry("41");
        } else if ("通信".equals(industry)) {
            data.setIndustry("25");
        } else if ("设备".equals(industry)) {
            data.setIndustry("42");
        } else if ("汽车".equals(industry)) {
            data.setIndustry("43");
        } else if ("航空".equals(industry)) {
            data.setIndustry("44");
        } else if ("电子元器件".equals(industry)) {
            data.setIndustry("2");
        } else if ("材料".equals(industry)) {
            data.setIndustry("45");
        }*/

        SysUser one = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, data.getBelongTo()).last("limit 1"));
        data.setSourceBelongTo(one.getLoginName());
        data.setBelongTo(one.getLoginName());
        data.setUpdateBy(one.getLoginName());
        data.setTrasferTo(one.getLoginName());
        data.setCreateBy(one.getLoginName());
        data.setCustomerId(null);
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (this.list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            this.list.clear();
        }
    }


    private void saveData() {
        crmCustomerService.saveBatch(list);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }
}
