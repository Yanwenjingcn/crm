package com.ywj.service;

import java.util.List;

import com.ywj.dao.DictDao;
import com.ywj.domain.Dict;

public class DictServiceImpl implements DictService {

	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ywj.service.DictService#findByCode(String)
	 */
	public List<Dict> findByCode(String dict_type_code) {
		
		return dictDao.findByCode(dict_type_code);
	}
	
}
