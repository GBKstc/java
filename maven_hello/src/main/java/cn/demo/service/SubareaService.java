package cn.demo.service;

import java.util.List;

import cn.demo.bean.Subarea;

public interface SubareaService {

	void addSubarea(Subarea model);

	Object getSubareaList(Integer page, Integer pageSize);
	
	List<Subarea> getSubareaList();

	Object getSubareaList(Integer page, Integer pageSize, Subarea model);



}
