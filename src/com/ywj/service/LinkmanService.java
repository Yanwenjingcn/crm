package com.ywj.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ywj.domain.Linkman;
import com.ywj.domain.PageBean;

public interface LinkmanService {

	PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria);



}
