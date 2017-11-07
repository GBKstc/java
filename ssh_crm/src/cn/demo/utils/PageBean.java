package cn.demo.utils;

import java.util.List;

public class PageBean {
	
	
	public PageBean(Integer total, Integer pageSize, Integer page) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.page = page;
		if(this.page==null) {
			this.page = 1;
		}
		
		if(this.pageSize==null) {
			this.pageSize = 20;
		}
		this.totalPage = (this.total-1)/this.pageSize+1;
		if(this.page<1) {
			this.page = 1;
		}
		if(this.page>this.totalPage) {
			this.page=this.totalPage;
		}
		
	}
	//总记录
	private Integer total;
	//总页数
	private Integer totalPage;
	//每页显示
	private Integer pageSize;
	//当前页
	private Integer page;
	//分页数据
	private List list;
	
	
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [total=" + total + ", totalPage=" + totalPage + ", pageSize=" + pageSize + ", page=" + page
				+ ", list=" + list + "]";
	}
	
	public Integer getStart() {
		return (this.page-1)*this.pageSize;
	}
	
	
	
}
