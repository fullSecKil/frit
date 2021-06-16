package com.example.boot25test.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boot25test.dao.CrmFollowMapper;
import com.example.boot25test.listener.ExcelCrmFollowListener;
import com.example.boot25test.listener.ExcelCrmPersonListener;
import com.example.boot25test.pojo.CrmFollow;
import com.example.boot25test.pojo.CrmPerson;
import com.example.boot25test.util.EasyExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Transactional(rollbackFor = Exception.class)
public class CrmFollowServiceImpl extends ServiceImpl<CrmFollowMapper, CrmFollow> {
    @Value("${update.file.excelPath}")
    private String fileUpdatePath;

    @Autowired
    private CrmCustomerServiceImpl crmCustomerService;
    @Autowired
    private SysUserServiceImpl sysUserService;

    public void handle() throws IOException {
        InputStream fileInputStream = Files.newInputStream(Paths.get(fileUpdatePath, "活动记录.xlsx"));
        // excel 导入db
        EasyExcelUtils.excelExtractorRead(fileInputStream, CrmFollow.class, new ExcelCrmFollowListener(crmCustomerService, sysUserService,this));
    }
}
