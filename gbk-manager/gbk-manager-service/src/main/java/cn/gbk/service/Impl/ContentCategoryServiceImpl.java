package cn.gbk.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.gbk.commit.pojo.EasyUITreeNode;
import cn.gbk.commit.pojo.ObjectListPage;
import cn.gbk.commit.utils.E3Result;
import cn.gbk.mapper.TbContentCategoryMapper;
import cn.gbk.mapper.TbContentMapper;
import cn.gbk.pojo.TbContent;
import cn.gbk.pojo.TbContentCategory;
import cn.gbk.pojo.TbContentCategoryExample;
import cn.gbk.pojo.TbItem;
import cn.gbk.pojo.TbItemExample;
import cn.gbk.pojo.TbContentCategoryExample.Criteria;
import cn.gbk.pojo.TbContentExample;
import cn.gbk.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{
	@Autowired
	TbContentCategoryMapper contentCategoryMapper;
	@Autowired
	TbContentMapper categoryMapper;
	
	public List<EasyUITreeNode> getContentCategoryList(Long parentId){
		
		
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public E3Result addContentCategory(TbContentCategory category) {
		TbContentCategory category2 = contentCategoryMapper.selectByPrimaryKey(category.getParentId());
		category2.setIsParent(true);
		contentCategoryMapper.updateByPrimaryKey(category2);
		category.setStatus(1);
		category.setSortOrder(1);
		Date date = new Date();
		category.setCreated(date);
		category.setUpdated(date);
		category.setParentId((long) 0);
		contentCategoryMapper.insert(category);
		return E3Result.ok();
	}

	@Override
	public E3Result updateContentCategory(TbContentCategory category) {
		TbContentCategory category2 = contentCategoryMapper.selectByPrimaryKey(category.getId());
		category2.setName(category.getName());
		contentCategoryMapper.updateByPrimaryKey(category2);	
		return E3Result.ok();
	}
	
	@Override
	public E3Result deleteContentCategory(TbContentCategory category) {
	
		
		contentCategoryMapper.deleteByPrimaryKeySetParentIdNull(category.getId());	
		return E3Result.ok();
	}

	@Override
	public ObjectListPage getContentList(Long categoryId, Integer page, Integer rows) {
		
		PageHelper.startPage(page, rows);
		
		TbContentExample example = new TbContentExample();
		cn.gbk.pojo.TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = categoryMapper.selectByExample(example);
		ObjectListPage objectListPage = new ObjectListPage();
		objectListPage.setRows(list);
		
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		objectListPage.setTotal(pageInfo.getTotal());
		return objectListPage;
	}
	
	@Override
	public List<TbContent> getContentListIndex(Long categoryId) {
		
		
		
		TbContentExample example = new TbContentExample();
		cn.gbk.pojo.TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = categoryMapper.selectByExample(example);
		
		return list;
	}
}
