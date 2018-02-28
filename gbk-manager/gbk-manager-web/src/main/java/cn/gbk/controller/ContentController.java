package cn.gbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gbk.commit.pojo.EasyUITreeNode;
import cn.gbk.commit.utils.JsonUtils;
import cn.gbk.pojo.TbContentCategory;
import cn.gbk.service.ContentCategoryService;

@Controller
public class ContentController {
	@Autowired
	ContentCategoryService service;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public String getContentCategoryList(@RequestParam(name="id",defaultValue="0")Long parentId) {
		List<EasyUITreeNode> list = service.getContentCategoryList(parentId);
		return JsonUtils.objectToJson(list);
	}
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public String addContentCategory(TbContentCategory Category) {
		
		return JsonUtils.objectToJson(service.addContentCategory(Category));
	}
	
	@RequestMapping("/content/category/update")
	@ResponseBody
	public String updateContentCategory(TbContentCategory Category) {
		
		return JsonUtils.objectToJson(service.updateContentCategory(Category));
	}
	
	@RequestMapping("/content/category/delete")
	@ResponseBody
	public String deleteContentCategory(TbContentCategory Category) {
		
		return JsonUtils.objectToJson(service.deleteContentCategory(Category));
	}
	
	@RequestMapping("/content/query/list")
	@ResponseBody
	public String getContentList(Long categoryId,Integer page,Integer rows) {
		
		return JsonUtils.objectToJson(service.getContentList(categoryId,page,rows));
	}
}
