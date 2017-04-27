package com.ywj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ywj.domain.User;



/**
 * 鎸佷箙灞傦細閮藉彲浠ョ户鎵縃ibernateDaoSupport绫�
 * 
 * @author Administrator
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/**
	 * 閫氳繃鐧诲綍鍚嶈繘琛岄獙璇�
	 */
	public User checkCode(String user_code) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 淇濆瓨鐢ㄦ埛
	 */
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	/**
	 * 鐧诲綍鍔熻兘
	 * 閫氳繃鐢ㄦ埛鍚嶅拰瀵嗙爜鍜岀敤鎴风殑鐘舵�
	 */
	public User login(User user) {
		// QBC鐨勬煡璇紝鎸夋潯浠惰繘琛屾煡璇�
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		// 鎷兼帴鏌ヨ鐨勬潯浠�
		criteria.add(Restrictions.eq("user_code", user.getUser_code()));
		criteria.add(Restrictions.eq("user_password", user.getUser_password()));
		criteria.add(Restrictions.eq("user_state", "1"));
		// 鏌ヨ
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}








