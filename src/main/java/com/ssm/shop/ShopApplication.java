package com.ssm.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ServletComponentScan
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
@MapperScan("com.ssm.shop.dao")
public class ShopApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShopApplication.class, args);
    }

//    @RequestMapping({"/"})
//    public String redirect(){
//        return "redirect:http://129.28.172.154:8080/builder/client/index.html";
//    }
}
