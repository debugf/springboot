package com.springboot.springbootmybatisplus.controller;


import com.springboot.springbootmybatisplus.Bean.Employee;
import com.springboot.springbootmybatisplus.Bean.Result;
import com.springboot.springbootmybatisplus.annotation.UserLoginToken;
import com.springboot.springbootmybatisplus.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author liuxiang
 * @since 2020-07-27
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @UserLoginToken
    @GetMapping(value = "")
    public Result getEmployees(@RequestParam(name = "page",required = false, defaultValue = "1") Integer page,
                               @RequestParam(name = "size",required = false, defaultValue = "10") Integer size){
        return employeeService.getEmployees(page,size);
    }

    @UserLoginToken
    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getById(id);
    }

    @UserLoginToken
    @PostMapping(value = "/add")
    public boolean addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @UserLoginToken
    @PutMapping(value = "/put")
    public boolean putEmployee(@RequestBody Employee employee){
        return employeeService.updateById(employee);
    }

    @UserLoginToken
    @DeleteMapping(value = "/dal")
    public boolean dalEmployee(@RequestBody Employee employee){
        return employeeService.removeById(employee);
    }


}
