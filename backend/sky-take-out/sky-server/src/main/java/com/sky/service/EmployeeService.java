package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【employee(员工信息)】的数据库操作Service
* @createDate 2024-10-24 22:15:22
*/
public interface EmployeeService extends IService<Employee> {
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    int add(EmployeeDTO employeeDTO);
}
