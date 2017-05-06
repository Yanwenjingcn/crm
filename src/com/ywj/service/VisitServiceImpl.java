package com.ywj.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ywj.dao.VisitDao;
import com.ywj.domain.PageBean;
import com.ywj.domain.Visit;

@Transactional
@Service(value="visitService")
public class VisitServiceImpl implements VisitService {

	@Resource(name="visitDao")
	private VisitDao visitDao;

	public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		
		return visitDao.findByPage(pageCode, pageSize, criteria);
	}

	public void save(Visit visit) {
		visitDao.save(visit);
		
	}
}
