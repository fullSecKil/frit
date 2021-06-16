package com.example.boot25test;

import com.example.boot25test.service.CrmCustomerServiceImpl;
import com.example.boot25test.service.CrmFollowServiceImpl;
import com.example.boot25test.service.CrmPersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Boot25testApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CrmCustomerServiceImpl crmCustomerService;

    @Autowired
    private CrmPersonServiceImpl crmPersonService;

    @Autowired
    private CrmFollowServiceImpl crmFollowService;

    @Test
    void testCustomerInput() throws IOException {
        crmCustomerService.handle();
    }

    @Test
    void testCrmPerson() throws IOException {
        crmPersonService.handle();
    }

    @Test
    void testCrmFollow() throws IOException {
        crmFollowService.handle();
    }
}
