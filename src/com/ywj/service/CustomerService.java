package com.ywj.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ywj.domain.Customer;
import com.ywj.domain.PageBean;



public interface CustomerService {
	
	public void save(Customer customer);

	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	public Customer findById(Long cust_id);

	public void delete(Customer customer);
	
}
