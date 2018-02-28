package cn.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.demo.mapper.ItemsMapper;
import cn.demo.bean.Items;

@Controller
public class ItemController {
	@Autowired
	public ItemsMapper itemMapper;

	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList() {
		List<Items> list = itemMapper.selectByExampleWithBLOBs(null);
							
		ModelAndView mv = new ModelAndView();
		mv.setViewName("itemList");
		mv.addObject("itemList", list);
		return mv;
		
	}
	
	@RequestMapping(value="/item/editItem.action")
	public ModelAndView editItem(Integer id) {
		Items item = itemMapper.selectByPrimaryKey(id);
							
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editItem");
		mv.addObject("item", item);
		return mv;
		
	}
	
	@RequestMapping(value="/item/updateitem.action")
	public ModelAndView updateItem(Items item) {
		int i = itemMapper.updateByPrimaryKeySelective(item);
							
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editItem");
		mv.addObject("item", item);
		return mv;
		
	}
	
	@RequestMapping(value="/item/deletes.action")
	public ModelAndView deletes(Integer[] ids) {
		/*int i = itemMapper.updateByPrimaryKeySelective(item);*/
		for (Integer integer : ids) {
			System.out.println(integer);
		}
						
		ModelAndView mv = new ModelAndView();
		mv.setViewName("itemList");
		
		return mv;
		
	}
	
}
