package com.ssm.shop.controller;

import com.ssm.shop.pojo.Employee;
import com.ssm.shop.pojo.basePojo.JsonEntity;
import com.ssm.shop.service.inter.EmployeeInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Autowired
    private EmployeeInter employeeService;

    @CrossOrigin
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";

    }

    @RequestMapping("/listEmp")
    public @ResponseBody
    JsonEntity listEmp(Employee employee){
        return JsonEntity.getInstance("显示成功!",employeeService.listEmployee(employee));
    }


}

