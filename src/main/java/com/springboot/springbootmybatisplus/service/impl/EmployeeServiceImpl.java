package com.springboot.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.springbootmybatisplus.Bean.Employee;
import com.springboot.springbootmybatisplus.Bean.Result;
import com.springboot.springbootmybatisplus.mapper.EmployeeMapper;
import com.springboot.springbootmybatisplus.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author liuxiang
 * @since 2020-07-27
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    private static Map<String, Code> codeMap;

    public Result getEmployees(int page, int size){
        codeMap = new ConcurrentHashMap<>();
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Page<Employee> pages = new Page<>();
            pages.setCurrent(page);
            pages.setSize(size);
            IPage<Employee> employeeIPage = employeeMapper.selectPage(pages, null);
            if(employeeIPage.getPages() < page){
                result.setMsg("无数据");
            }else {
                result.setMsg("查询成功");
                result.setDetail(employeeIPage);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
