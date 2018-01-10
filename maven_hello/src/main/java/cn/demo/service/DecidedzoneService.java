package cn.demo.service;

import java.util.List;

import cn.demo.bean.Decidedzone;

public interface DecidedzoneService {

	void addDecidedzone(Decidedzone model, List<String> subList);

	Object getDecidedzoneList(Integer page, Integer pageSize);


}
