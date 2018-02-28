package cn.gbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gbk.commit.pojo.ObjectListPage;
import cn.gbk.commit.utils.E3Result;
import cn.gbk.commit.utils.IDUtils;
import cn.gbk.commit.utils.JsonUtils;
import cn.gbk.pojo.TbItem;
import cn.gbk.service.ItemService;
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{Id}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long Id) {
		
		return itemService.getItemById(Id);
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public ObjectListPage getItemList(Integer page,Integer rows) {
		
		return itemService.getItemList(page,rows);
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public String saveItem(TbItem item,String desc) {
		
		return JsonUtils.objectToJson(itemService.saveItem(item,desc));
	}
	
	@RequestMapping("/rest/item/instock")
	@ResponseBody
	public String instockItem(Long[] ids) {
		
		return JsonUtils.objectToJson(itemService.instockItem(ids));
	}
	
	@RequestMapping("/rest/item/reshelf")
	@ResponseBody
	public String reshelfItem(Long[] ids) {
		
		return JsonUtils.objectToJson(itemService.reshelfItem(ids));
	}
	
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public String deleteItem(Long[] ids) {
		
		return JsonUtils.objectToJson(itemService.deleteItem(ids));
	}
	
	@RequestMapping("/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	public String getItemDescById(@PathVariable Long itemId) {
		
		return JsonUtils.objectToJson(itemService.getItemDescById(itemId));
	}
	
	@RequestMapping("/rest/item/update")
	@ResponseBody
	public String updateItem(TbItem item,String desc) {
		
		return JsonUtils.objectToJson(itemService.updateItem(item,desc));
	}
	
}
