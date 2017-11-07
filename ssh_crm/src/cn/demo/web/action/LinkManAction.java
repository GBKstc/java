package cn.demo.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.demo.domain.Linkman;
import cn.demo.service.LinkManService;
import cn.demo.utils.PageBean;


public class LinkManAction extends ActionSupport implements ModelDriven<Linkman>{

	private static final long serialVersionUID = 2L;

	private Linkman linkman = new Linkman();
	
	private LinkManService linkManService ;
	private Integer pageSize;
	private Integer page;
	
	public String list() throws Exception {
		System.out.println(pageSize);
		System.out.println(page);
		System.out.println(linkman);
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(linkman.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkman.getLkm_name()+"%"));
		}	
		PageBean pb = linkManService.getPageBean(dc,pageSize,page);
		System.out.println(pb);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add() throws Exception {
		System.out.println(linkman);
		linkManService.saveLinkMan(linkman);
		return null;
	}
	
//	public String delete() throws Exception {
//		customerService.deleteCustomer(customer);
//		System.out.println(customer);
//		return "delete";
//	}
	

	
	
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

	

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	@Override
	public Linkman getModel() {
		// TODO Auto-generated method stub
		return linkman;
	}
	public Linkman getLinkman() {
		return linkman;
	}

	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}
	

}
