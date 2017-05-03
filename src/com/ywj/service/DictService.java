package com.ywj.service;

import java.util.List;

import com.ywj.domain.Dict;

public interface DictService {

	List<Dict> findByCode(String dict_type_code);

}
