package cn.demo.service;

import java.util.List;

import cn.demo.bean.Region;

public interface RegionService {

	List<Region> getRegionList();

	void saveBatch(List<Region> regionList);

	Object getRegionList(Integer page, Integer pageSize);


}
