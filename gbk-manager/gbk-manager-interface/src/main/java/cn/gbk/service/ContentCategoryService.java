package cn.gbk.service;

import java.util.List;

import cn.gbk.commit.pojo.EasyUITreeNode;
import cn.gbk.commit.utils.E3Result;
import cn.gbk.pojo.TbContent;
import cn.gbk.pojo.TbContentCategory;

public interface ContentCategoryService {
	
	public List<EasyUITreeNode> getContentCategoryList(Long parentId);

	public E3Result addContentCategory(TbContentCategory category);

	E3Result updateContentCategory(TbContentCategory category);

	E3Result deleteContentCategory(TbContentCategory category);

	public Object getContentList(Long categoryId, Integer page, Integer rows);

	List<TbContent> getContentListIndex(Long categoryId);

}
