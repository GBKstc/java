package cn.gbk.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gbk.commit.pojo.EasyUITreeNode;
import cn.gbk.mapper.TbItemCatMapper;
import cn.gbk.pojo.TbItemCat;
import cn.gbk.pojo.TbItemCatExample;
import cn.gbk.pojo.TbItemCatExample.Criteria;
import cn.gbk.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	TbItemCatMapper mapper;
	
	public List<EasyUITreeNode> getItemCat(long parent_id){
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parent_id);
		List<TbItemCat> list = mapper.selectByExample(example);
		List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
		
	}

}
