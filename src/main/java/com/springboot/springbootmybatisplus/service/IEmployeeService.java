package com.springboot.springbootmybatisplus.service;

import com.springboot.springbootmybatisplus.Bean.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.springbootmybatisplus.Bean.Result;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author liuxiang
 * @since 2020-07-27
 */
public interface IEmployeeService extends IService<Employee> {

    Result getEmployees(int page, int size);

}
