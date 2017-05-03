package com.ywj.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ywj.domain.Dict;
import com.ywj.service.DictService;
import com.ywj.utils.FastJsonUtil;

public class DictAction extends ActionSupport implements ModelDriven<Dict> {

	//不要忘记啊
	private Dict dict=new Dict();
	public Dict getModel() {
		return dict;
	}

	private DictService dictService;

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	/*
	 * 依据type_code查询客户级别或者客户来源
	 */
	public String findByCode() {
		// 调用业务层
		String code=dict.getDict_type_code();
		List<Dict> list = dictService.findByCode(dict.getDict_type_code());
		// List<Dict> list = dictService.findByCode("006");

		// 使用fastjson，把list转换成json字符串
		String jsonString = FastJsonUtil.toJSONString(list);
		// 把json字符串写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		// 输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
	}

}
