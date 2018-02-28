package cn.gbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gbk.commit.pojo.EasyUITreeNode;
import cn.gbk.service.ItemCatService;

@Controller
public class ItemCatController {
	
	@Autowired
	ItemCatService catService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCat(
			@RequestParam(name="id",defaultValue="0")long parent_id) {
		
		return catService.getItemCat(parent_id);
	}
}
