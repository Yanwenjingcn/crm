package com.ywj.web.action;

import java.util.List;

import org.apache.struts2.components.If;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.ywj.domain.Customer;
import com.ywj.domain.Linkman;
import com.ywj.domain.PageBean;
import com.ywj.service.LinkmanService;

public class LinkmanAction extends BaseAction implements ModelDriven<Linkman>{

	
	private Linkman linkman=new Linkman();
	public Linkman getModel() {
		return linkman;
	}
	
	private LinkmanService linkmanService;
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}
	
	//==========================================================
	
	
	/*
	 * 分页查询联系人信息
	 */
	public String findByPage(){
		PageBean<Linkman> page;
		//拿到离线参数
		DetachedCriteria criteria=DetachedCriteria.forClass(Linkman.class);
		
		//模糊查询
		String name=linkman.getLkm_name();
		if(name!=null&&!name.trim().isEmpty()){
			criteria.add(Restrictions.like("lkm_name", "%"+name+"%"));
		}
		
		//获取查询的id号
		Customer c=linkman.getCustomer();
		if(c!=null&&c.getCust_id()!=null){
			criteria.add(Restrictions.eq("customer.cust_id", c.getCust_id()));
		}
		
		page=linkmanService.findByPage(this.getPageCode(),
				this.getPageSize(), criteria);
		
		this.setVS("page", page);
		
		return "page";
	}

}
