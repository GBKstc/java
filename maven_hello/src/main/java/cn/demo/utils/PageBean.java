package cn.demo.utils;

import java.util.List;

import com.google.gson.annotations.Expose;

public class PageBean {
	
	
	public PageBean(Integer total, Integer page, Integer pageSize) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.page = page;
		if(this.page==null) {
			this.page = 1;
		}
		
		if(this.pageSize==null) {
			this.pageSize = 10;
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
	@Expose
	private Integer total;
	//总页数
	@Expose
	private Integer totalPage;
	//每页显示
	@Expose
	private Integer pageSize;
	//当前页
	@Expose
	private Integer page;
//	//分页数据
//	private List list;
	
	
	
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

	@Override
	public String toString() {
		return "PageBean [total=" + total + ", totalPage=" + totalPage + ", pageSize=" + pageSize + ", page=" + page
				 + "]";
	}
	
	public Integer getStart() {
		return (this.page-1)*this.pageSize;
	}
	
	
	
}
