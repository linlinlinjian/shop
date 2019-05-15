package com.ssm.shop.service.impl;

import com.ssm.shop.dao.EmployeeMapper;
import com.ssm.shop.pojo.Employee;
import com.ssm.shop.service.inter.EmployeeInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("employeeService")
public class EmployeeImpl implements EmployeeInter {

    @Resource
    private EmployeeMapper employeeDao;

    @Override
    public List<Employee> listEmployee(Employee employee) {
        return employeeDao.listEmployee(employee);
    }
}
