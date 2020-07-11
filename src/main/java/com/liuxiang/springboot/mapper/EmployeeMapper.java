package com.liuxiang.springboot.mapper;

import com.liuxiang.springboot.bean.Employees;


public interface EmployeeMapper {

    public Employees getEmpById(Integer id);

    public void insertEmp(Employees employee);
}
