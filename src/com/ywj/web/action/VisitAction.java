package com.ywj.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.ywj.domain.PageBean;
import com.ywj.domain.User;
import com.ywj.domain.Visit;
import com.ywj.service.VisitService;

@Controller(value = "visitAction")
@Scope(value = "prototype")
public class VisitAction extends BaseAction implements ModelDriven<Visit> {
	private Visit visit = new Visit();

	public Visit getModel() {
		return visit;
	}
	
	@Resource(name="visitService")
	private VisitService visitService;
	
	//===========================================================================
	
	private String beginDate;
	private String endDate;
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String findByPage(){
		//
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user==null){
			return LOGIN;
		}
		
		
		DetachedCriteria criteria=DetachedCriteria.forClass(Visit.class);
		criteria.add(Restrictions.eq("user.user_id", user.getUser_id()));
		
		if(beginDate!=null&&!beginDate.trim().isEmpty()){
			criteria.add(Restrictions.ge("visit_time", beginDate));
		}
		if(endDate!=null&&!endDate.trim().isEmpty()){
			criteria.add(Restrictions.le("visit_time", endDate));
		}
		
		PageBean<Visit> page=visitService.findByPage(this.getPageCode(),this.getPageSize(),criteria);
		this.setVS("page", page);
		return "page";
	}
	
	
	public String save(){
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user==null){
			return LOGIN;
		}
		//这个值是没有传过来的，只能自己去获得
		visit.setUser(user);
		visitService.save(visit);
		return "save";
	}

}
