package cn.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.Customer;
import cn.demo.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer pageSize, Integer page);

}
