package com.ywj.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * Action的父类
 */

public class BaseAction extends ActionSupport {

	// 属性驱动的方式，看清楚，这个是integer的
	// 当前页，默认值就是1
	private Integer pageCode = 1;

	public void setPageCode(Integer pageCode) {
		if (pageCode == null) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	// 每页显示的数据的条数
	private Integer pageSize = 2;

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCode() {
		return pageCode;
	}

	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setVS(String key,Object obj){
		ActionContext.getContext().getValueStack().set(key, obj);
	}
	
	/*
	 * 
	 */
	public void pushVS(Object obj){
		ActionContext.getContext().getValueStack().push(obj);
	}
}
