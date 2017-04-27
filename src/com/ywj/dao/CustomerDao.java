package com.ywj.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.ywj.domain.Customer;
import com.ywj.domain.PageBean;

public interface CustomerDao {
	
	public void save(Customer customer);

	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
