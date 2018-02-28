package cn.gbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import cn.gbk.service.ContentCategoryService;

@Controller
public class IndexController {
	@Autowired
	ContentCategoryService contentCategoryService;
	
	@Value("${LUNBO_ID}")
	private Long LUNBO_ID;
	
	@RequestMapping("/front/index")
	public String frontShowPage(Model model) {
		
		Object list = contentCategoryService.getContentListIndex(LUNBO_ID);
		model.addAttribute("ad1List", list);
		return "front/index";
	}
}
