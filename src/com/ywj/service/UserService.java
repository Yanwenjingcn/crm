package com.ywj.service;

import com.ywj.domain.User;



public interface UserService {

	User checkCode(String user_code);

	void save(User user);

	User login(User user);

}
