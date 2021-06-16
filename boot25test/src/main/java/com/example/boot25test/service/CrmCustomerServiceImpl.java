package com.example.boot25test.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boot25test.dao.CrmCustomerMapper;
import com.example.boot25test.listener.ExcelCrmCustomerListener;
import com.example.boot25test.pojo.CrmCustomer;
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
public class CrmCustomerServiceImpl extends ServiceImpl<CrmCustomerMapper, CrmCustomer> {

    @Value("${update.file.excelPath}")
    private String fileUpdatePath;

    @Autowired
    private SysUserServiceImpl sysUserService;

    public void handle() throws IOException {
        InputStream fileInputStream = Files.newInputStream(Paths.get(fileUpdatePath, "客户.xlsx"));
        // excel 导入db
        EasyExcelUtils.excelExtractorRead(fileInputStream, CrmCustomer.class, new ExcelCrmCustomerListener(sysUserService, this));
    }
}
