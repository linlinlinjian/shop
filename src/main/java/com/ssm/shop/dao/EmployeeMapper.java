package com.ssm.shop.dao;

import com.ssm.shop.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {
    List<Employee> listEmployee(Employee employee);
}
