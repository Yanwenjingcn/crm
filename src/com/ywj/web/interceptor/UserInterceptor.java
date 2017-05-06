package com.ywj.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.ywj.domain.User;

/*
 * 
 * 
 */
public class UserInterceptor extends MethodFilterInterceptor{

	/*
	 * 拦截目标Action的方法
	 * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		
		User u=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(u==null){
			return "login";
		}
		
		//执行下一个拦截器
		return arg0.invoke();
	}
	

}
