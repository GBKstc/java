package cn.gbk.service;

import cn.gbk.commit.pojo.ObjectListPage;
import cn.gbk.commit.utils.E3Result;
import cn.gbk.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(Long Id);

	ObjectListPage getItemList(Integer page, Integer rows);

	E3Result saveItem(TbItem item, String desc);

	E3Result instockItem(Long[] ids);

	E3Result deleteItem(Long[] ids);

	E3Result reshelfItem(Long[] ids);

	Object getItemDescById(Long id);

	E3Result updateItem(TbItem item, String desc);

}
