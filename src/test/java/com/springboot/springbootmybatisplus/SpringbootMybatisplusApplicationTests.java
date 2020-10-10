package com.springboot.springbootmybatisplus;

import com.springboot.springbootmybatisplus.Bean.Employee;
import com.springboot.springbootmybatisplus.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    void contextLoads() {
        employeeService.getEmployees(1,10);
        System.out.println("搜索成功 O(∩_∩)O");
    }

}
