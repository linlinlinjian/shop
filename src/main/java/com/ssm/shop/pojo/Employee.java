package com.ssm.shop.pojo;

import com.ssm.shop.pojo.basePojo.BaseEntity;
import lombok.Data;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-10-05
 */
@Data
public class Employee extends BaseEntity {
    private String id;

    private String account;

    private String passWord;

    private String userName;

    private String headImg;

    private String empCode;

    private String phone;

    private String isDel;

    private String regTime;

    private String remark;

    private String roleId;

    private String depId;

    private String cityList;//存储负责区域id


    private String f14;

    
    private String depName;
    
    private String companyName;
    
    private String lev;
    
    private String submitId;//提交人id，查询用
    
    private String depTask;//部门任务量
    
    private String finishTask;//已完成任务量
    
    private int taskId;
    
    private String areaid;
    
    private String companyId;
    
    private String departmentId;
	
    
}