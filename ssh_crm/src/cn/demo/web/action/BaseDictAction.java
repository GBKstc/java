package cn.demo.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import cn.demo.domain.BaseDict;
import cn.demo.service.BaseDictService;

public class BaseDictAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BaseDictService baseDictService ;
	private String baseType ;

	

	@Override
	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		dc.add(Restrictions.eq("dict_type_code", baseType));
		
		List<BaseDict> list = baseDictService.getBaseDictList(dc);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return null;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}
	
	
	

}
