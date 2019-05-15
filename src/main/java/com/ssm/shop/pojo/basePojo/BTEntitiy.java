package com.ssm.shop.pojo.basePojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据返回格式
 * @author Administrator
 *
 */
public class BTEntitiy implements Serializable {
	private static final long serialVersionUID = 872568913505698676L;

	 public static final int DEFAULT_NUM_PER_PAGE = 10;
	 
	 
	 public static final int DEFAULT_NUM_PER_PAGEONE = 1;
	
	public BTEntitiy() {
	}

	public BTEntitiy(int currentPage,int total,List<?> rows) {
		this.currentPage = currentPage;
		this.numPerPage = DEFAULT_NUM_PER_PAGE;
		this.total = total;
		this.totalPage = (total + DEFAULT_NUM_PER_PAGE - 1) / DEFAULT_NUM_PER_PAGE;
		this.rows = rows;
	}
	public BTEntitiy(int currentPage,int total,List<?> rows,String hasNextPage) {
		this.currentPage = currentPage;
		this.numPerPage = DEFAULT_NUM_PER_PAGE;
		this.total = total;
		this.totalPage = (total + DEFAULT_NUM_PER_PAGE - 1) / DEFAULT_NUM_PER_PAGE;
		this.rows = rows;
		this.hasNextPage = hasNextPage;
	}

	public BTEntitiy(int currentPage,int total,List<?> rows,int page) {
		this.currentPage = currentPage;
		this.numPerPage = page;
		this.total = total;
		this.totalPage = (total + page - 1) / page;
		this.rows = rows;
	}
	
	private int currentPage; // 当前�?
	
    private int numPerPage; // 每页显示多少�?
    
    private int totalPage; // 总页�?
    
	private int total;
	
	private String hasNextPage;

	private List<?> rows;

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(String hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	
}
