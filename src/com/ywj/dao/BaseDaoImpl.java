package com.ywj.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ywj.domain.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;

	public BaseDaoImpl() {
		// this表示的子类，c表示就是CustomerDaoImpl的Class对象
		Class c = this.getClass();
		// CustomerDaoImpl extends BaseDaoImpl<Customer> map<k,v>
		// 第2步：获取到是BaseDaoImpl<Customer>
		Type type = c.getGenericSuperclass();

		// 目的：把type接口转换成子接口
		if (type instanceof ParameterizedType) {
			ParameterizedType ptype = (ParameterizedType) type;

			// 获取到 Customer
			Type[] types = ptype.getActualTypeArguments();
			this.clazz = (Class) types[0];
			System.out.println(this.clazz);
		}
	}

	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);

	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	/*
	 * 通过主键来查询
	 * 
	 */
	public T findById(Long id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
	}

	public PageBean<T> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// 创建分页对象
		PageBean<T> pageBean = new PageBean<T>();
		
		// 设置当前页
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);


		// 查找分页记录
		List<T> beanList = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode - 1) * pageSize, pageSize);
	
		if (beanList != null && beanList.size() > 0) {
			pageBean.setBeanList(beanList);
		}

		criteria.setProjection(null);
		
		
		// 查找总记录数
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			int totalCount = list.get(0).intValue();
			// 总记录数
			pageBean.setTotalCount(totalCount);
		}


		return pageBean;
	}

}
