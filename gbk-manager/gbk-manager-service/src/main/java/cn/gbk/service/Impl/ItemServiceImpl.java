package cn.gbk.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.gbk.commit.pojo.ObjectListPage;
import cn.gbk.commit.utils.E3Result;
import cn.gbk.commit.utils.IDUtils;
import cn.gbk.mapper.TbItemDescMapper;
import cn.gbk.mapper.TbItemMapper;
import cn.gbk.pojo.TbItem;
import cn.gbk.pojo.TbItemDesc;
import cn.gbk.pojo.TbItemDescExample;
import cn.gbk.pojo.TbItemDescExample.Criteria;
import cn.gbk.pojo.TbItemExample;
import cn.gbk.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	TbItemMapper tbItemMapper;
	
	@Autowired
	TbItemDescMapper tbItemDescMapper;
	
	@Override
	public TbItem getItemById(Long Id) {
		// TODO Auto-generated method stub
		return tbItemMapper.selectByPrimaryKey(Id);
	}
	
	@Override
	public ObjectListPage getItemList(Integer page, Integer rows) {
		
		PageHelper.startPage(page, rows);
		
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		ObjectListPage objectListPage = new ObjectListPage();
		objectListPage.setRows(list);
		
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		objectListPage.setTotal(pageInfo.getTotal());
		return objectListPage;
	}

	@Override
	public E3Result saveItem(TbItem item, String desc) {
		// TODO Auto-generated method stub
		long itemId = IDUtils.genItemId();
		Date date = new Date();
		System.out.println(item);
		System.out.println(desc);
		item.setId(itemId);
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		tbItemMapper.insert(item);
		
		TbItemDesc itemdesc = new TbItemDesc();
		itemdesc.setItemId(itemId);
		itemdesc.setCreated(date);
		itemdesc.setUpdated(date);
		itemdesc.setItemDesc(desc);
		tbItemDescMapper.insert(itemdesc);
		return E3Result.ok();
	}

	@Override
	public E3Result deleteItem(Long[] ids) {
		for (Long id : ids) {
			TbItem item = tbItemMapper.selectByPrimaryKey(id);
			item.setStatus((byte) 3);
			tbItemMapper.updateByPrimaryKeySelective(item);
		}
		return E3Result.ok();
	}
	
	@Override
	public E3Result instockItem(Long[] ids) {
		for (Long id : ids) {
			TbItem item = tbItemMapper.selectByPrimaryKey(id);
			item.setStatus((byte) 2);
			tbItemMapper.updateByPrimaryKeySelective(item);
		}
		return E3Result.ok();
	}
	
	@Override
	public E3Result reshelfItem(Long[] ids) {
		for (Long id : ids) {
			TbItem item = tbItemMapper.selectByPrimaryKey(id);
			item.setStatus((byte) 1);
			tbItemMapper.updateByPrimaryKeySelective(item);
		}
		return E3Result.ok();
	}

	@Override
	public TbItemDesc getItemDescById(Long id) {
		TbItemDescExample example = new TbItemDescExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(id);
		List<TbItemDesc> list = tbItemDescMapper.selectByExampleWithBLOBs(example);
		return list.get(0);
	}

	@Override
	public E3Result updateItem(TbItem item, String desc) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		item.setUpdated(date);
		tbItemMapper.updateByPrimaryKeySelective(item);
		
		TbItemDesc itemdesc = new TbItemDesc();
		itemdesc.setItemId(item.getId());
		itemdesc.setItemDesc(desc);
		itemdesc.setUpdated(date);
		
		tbItemDescMapper.updateByPrimaryKeySelective(itemdesc);
		return E3Result.ok();		
	}

}
