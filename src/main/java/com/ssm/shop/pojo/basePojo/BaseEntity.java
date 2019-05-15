package com.ssm.shop.pojo.basePojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 基础实体类,po类应继承此基础类
 * @author Administrator
 *
 */
public class BaseEntity {
	
	private String startdate;//查询开始日期
	
	private String enddate;//查询结束日期

	private int startRowNum;//传参为开始的页数
	
	private int endRowNum;//传参为页面所用条数
	
	private String franType;//可作为下拉框选项值
	
	private String selectName;//冗余参数
	
	@JsonIgnore
	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	@JsonIgnore
	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@JsonIgnore
	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	@JsonIgnore
	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	@JsonIgnore
	public String getFranType() {
		return franType;
	}

	public void setFranType(String franType) {
		this.franType = franType;
	}

	@JsonIgnore
	public String getSelectName() {
		return selectName;
	}

	public void setSelectName(String selectName) {
		this.selectName = selectName;
	}
	
	
	
}
