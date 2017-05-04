package com.ywj.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.ywj.domain.Customer;
import com.ywj.domain.Dict;
import com.ywj.domain.PageBean;
import com.ywj.service.CustomerService;
import com.ywj.utils.UploadUtils;

/**
 * 客户的控制层
 * 
 * @author Administrator
 */
public class CustomerAction extends ActionSupport implements
		ModelDriven<Customer> {

	private static final long serialVersionUID = 113695314694166436L;

	// 不要忘记手动new
	private Customer customer = new Customer();

	public Customer getModel() {
		return customer;
	}

	// 提供service的成员属性，提供set方法
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
//=============================================================================
	
	
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

	/**
	 * 分页的查询方法
	 * 
	 * @return
	 */
	public String findByPage() {
		// 调用service业务层
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		// 拼接条件
		String cust_name = customer.getCust_name();
		if (cust_name != null && !cust_name.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
		}

		// 拼接客户级别,这是个Dict的实例对象
		Dict level = customer.getLevel();
		if (level != null && level.getDict_id() != null
				&& !level.getDict_id().trim().isEmpty()) {
			// 反正尽量的多判断一点东西，会有好处的.
			// 看清楚这个eq内容的写法
			criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
		}
		// 拼接客户的来源
		Dict source = customer.getSource();
		if (source != null && source.getDict_id() != null
				&& !source.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
		}

		// 如果没有拼接内容的话就是默认的，就是都查询出来
		// 查询
		PageBean<Customer> page = customerService.findByPage(pageCode,
				pageSize, criteria);
		// 压栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		// 栈顶是map<"page",page对象>
		vs.set("page", page);
		return "page";
	}

	/*
	 * 
	 */
	public String initAddUI() {

		return "initAddUI";
	}

	/*
	 * 文件上传，需要在action中定义类的成员属性，命名是有规则的
	 * private File upload;//表示要上传的文件 private
	 * String uploadFileName;//表示要上传文件的文件名 private String
	 * uploadContentType;//表示要上传文件的MIME类型 提供相应的set方法，拦截器就注入值了
	 */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 保存客户的方法
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String save() throws IOException {
		//文件名不为空，则用户有选择相应的文件
		if(uploadFileName!=null){
			String uuidName=UploadUtils.getUUIDName(uploadFileName);
			String path="D:\\Tomcat 7.0\\webapps\\upload\\";
			File file=new File(path+uuidName);
			FileUtils.copyFile(upload, file);
			customer.setFilePath(path+uuidName);
			
		}
		customerService.save(customer);
		return "save";
	}
	
	/*
	 * 删除客户
	 */
	public String delete(){
		customer=customerService.findById(customer.getCust_id());
		//获取上传文件的路径
		String filepath=customer.getFilePath();
		//删除客户
		customerService.delete(customer);
		//删除文件
		File file=new File(filepath);
		if(file.exists()){
			file.delete();
		}
		return "delete";
	}

}
