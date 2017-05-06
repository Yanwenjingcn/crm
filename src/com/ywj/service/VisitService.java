package com.ywj.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ywj.domain.PageBean;
import com.ywj.domain.Visit;

public interface VisitService {

	PageBean<Visit> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria);

	void save(Visit visit);

}
