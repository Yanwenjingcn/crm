package com.ywj.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ywj.domain.Visit;

/*
 * 客户拜访持久层
 */

@Repository(value="visitDao")
public class VisitDaoImpl extends BaseDaoImpl<Visit> implements VisitDao{

	@Resource(name="sessionFactory")
	public void set2SessionFactory (SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}
