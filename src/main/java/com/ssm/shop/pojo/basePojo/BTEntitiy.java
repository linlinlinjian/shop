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

	public BTEntitiy(int currentPage,int totalSize,List<?> rows) {
		this.currentPage = currentPage;
		this.numPerPage = DEFAULT_NUM_PER_PAGE;
		this.totalSize = totalSize;
		this.totalPage = (totalSize + DEFAULT_NUM_PER_PAGE - 1) / DEFAULT_NUM_PER_PAGE;
		this.rows = rows;
	}
	public BTEntitiy(int currentPage,int totalSize,List<?> rows,String hasNextPage) {
		this.currentPage = currentPage;
		this.numPerPage = DEFAULT_NUM_PER_PAGE;
		this.totalSize = totalSize;
		this.totalPage = (totalSize + DEFAULT_NUM_PER_PAGE - 1) / DEFAULT_NUM_PER_PAGE;
		this.rows = rows;
		this.hasNextPage = hasNextPage;
	}

	public BTEntitiy(int currentPage,int totalSize,List<?> rows,int page) {
		this.currentPage = currentPage;
		this.numPerPage = page;
		this.totalSize = totalSize;
		this.totalPage = (totalSize + page - 1) / page;
		this.rows = rows;
	}
	
	private int currentPage; // 当前�?
	
    private int numPerPage; // 每页显示多少�?
    
    private int totalPage; // 总页�?
    
	private int totalSize;
	
	private String hasNextPage;

	private List<?> rows;

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
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
