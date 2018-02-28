package cn.gbk.service;

import java.util.List;

import cn.gbk.commit.pojo.EasyUITreeNode;
import cn.gbk.commit.pojo.ObjectListPage;
import cn.gbk.pojo.TbItem;

public interface ItemCatService {
	
	public List<EasyUITreeNode> getItemCat(long parent_id);

}
