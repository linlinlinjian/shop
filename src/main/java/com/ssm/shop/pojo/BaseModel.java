package com.ssm.shop.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 基础模型
 * @author Louis
 * @date Sep 13, 2018
 */
@Data
public class BaseModel {

	private Long id;
	
    private String createBy;
//
    private Date createTime;
//
    private String lastUpdateBy;

    private Date lastUpdateTime;

	private int currentPage;//传参为开始的页数

	private int pageSize;//传参为页面所用条数

}
