package com.liuxiang.springboot.controller;


import com.liuxiang.springboot.bean.Employees;
import com.liuxiang.springboot.bean.Users;
import com.liuxiang.springboot.mapper.EmployeeMapper;
import com.liuxiang.springboot.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TongYongController {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/user/{id}")
    public Users getUsers(@PathVariable("id") Integer id){
        return usersMapper.getUserById(id);
    }

    @GetMapping("/user")
    public Users insertUser(Users users){
        usersMapper.insertUser(users);
        return users;
    }

    @GetMapping("/emp/{id}")
    public Employees getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    public Employees insertEmp(Employees employees){
        employeeMapper.insertEmp(employees);
        return employees;
    }

}
