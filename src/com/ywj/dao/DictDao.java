package com.ywj.dao;

import java.util.List;

import com.ywj.domain.Dict;



public interface DictDao {

	List<Dict> findByCode(String dict_type_code);

}
