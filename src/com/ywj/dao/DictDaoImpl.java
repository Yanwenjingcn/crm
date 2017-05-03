package com.ywj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ywj.domain.Dict;

public class DictDaoImpl extends HibernateDaoSupport implements DictDao {

	public List<Dict> findByCode(String dict_type_code) {
		
		return (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code = ?", dict_type_code);
	}

}
