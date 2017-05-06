package com.ywj.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.ywj.domain.User;

/*
 * 
 * 
 */
public class UserInterceptor extends MethodFilterInterceptor {

	/*
	 * /** 用户的拦截器，判断用户是否已经登录，如果登录，执行下一个拦截器。
	 * 如果没有登录，返回到登录页面（不能对所有的请求都拦截，login和regist方法不能拦截） 继承指定拦截器
	 * 
	 * @author Administrator
	 * 
	 * @see
	 * com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept
	 * (com.opensymphony.xwork2.ActionInvocation)
	 */
	protected String doIntercept(ActionInvocation arg0) throws Exception {

		User u = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (u == null) {
			return "login";
		}

		// 执行下一个拦截器
		return arg0.invoke();
	}

}
