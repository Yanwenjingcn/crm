package com.ywj.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Customer {



	private Long cust_id;

	private String cust_name;
	private Long cust_user_id;
	private Long cust_create_id;


	private String cust_linkman;

	private String cust_phone;

	private String cust_mobile;

	
	private Dict source;

	private Dict industry;

	private Dict level;

	// 上传文件保存的路径
	private String filePath;
	//
	//
	//
	//
	//与联系人的配对，客户是一方，联系人是多方
	@JSONField(serialize=false)
	//在集合上加注解，那么在转json的时候就不会进行转换
	private Set<Linkman> linkmans=new HashSet<Linkman>();
	
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public Long getCust_user_id() {
		return cust_user_id;
	}

	public void setCust_user_id(Long cust_user_id) {
		this.cust_user_id = cust_user_id;
	}

	public Long getCust_create_id() {
		return cust_create_id;
	}

	public void setCust_create_id(Long cust_create_id) {
		this.cust_create_id = cust_create_id;
	}



	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public Dict getSource() {
		return source;
	}

	public String getCust_linkman() {
		return cust_linkman;
	}

	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}

	public Dict getIndustry() {
		return industry;
	}

	public void setIndustry(Dict industry) {
		this.industry = industry;
	}

	public Dict getLevel() {
		return level;
	}

	public void setLevel(Dict level) {
		this.level = level;
	}

	public Set<Linkman> getLinkmans() {
		return linkmans;
	}

	public void setLinkmans(Set<Linkman> linkmans) {
		this.linkmans = linkmans;
	}

	public void setSource(Dict source) {
		this.source = source;
	}


}
