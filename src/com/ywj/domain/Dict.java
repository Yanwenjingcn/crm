package com.ywj.domain;

/**
 * 瀛楀吀琛�
 * @author Administrator
 */
public class Dict {
	
	/**
	 *  `dict_id` varchar(32) NOT NULL COMMENT '鏁版嵁瀛楀吀id(涓婚敭)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '鏁版嵁瀛楀吀绫诲埆浠ｇ爜',
  `dict_type_name` varchar(64) NOT NULL COMMENT '鏁版嵁瀛楀吀绫诲埆鍚嶇О',
  `dict_item_name` varchar(64) NOT NULL COMMENT '鏁版嵁瀛楀吀椤圭洰鍚嶇О',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '鏁版嵁瀛楀吀椤圭洰(鍙负绌�',
  `dict_sort` int(10) DEFAULT NULL COMMENT '鎺掑簭瀛楁',
  `dict_enable` char(1) NOT NULL COMMENT '1:浣跨敤 0:鍋滅敤',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '澶囨敞',
	 */
	
	private String dict_id;
	// 鏁版嵁瀛楀吀绫诲埆浠ｇ爜 01 06
	private String dict_type_code;
	// 绫诲埆鍚嶇О 01鎵�睘浜庤涓�06瀹㈡埛绾у埆
	private String dict_type_name;
	// 瀛楀吀椤圭洰鍚嶇О
	private String dict_item_name;
	
	private String dict_item_code;
	// 鎺掑簭瀛楁
	private Integer dict_sort;
	private String dict_enable;
	private String dict_memo;
	
	public String getDict_id() {
		return dict_id;
	}
	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public String getDict_type_name() {
		return dict_type_name;
	}
	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}
	public String getDict_item_name() {
		return dict_item_name;
	}
	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}
	public String getDict_item_code() {
		return dict_item_code;
	}
	public void setDict_item_code(String dict_item_code) {
		this.dict_item_code = dict_item_code;
	}
	public Integer getDict_sort() {
		return dict_sort;
	}
	public void setDict_sort(Integer dict_sort) {
		this.dict_sort = dict_sort;
	}
	public String getDict_enable() {
		return dict_enable;
	}
	public void setDict_enable(String dict_enable) {
		this.dict_enable = dict_enable;
	}
	public String getDict_memo() {
		return dict_memo;
	}
	public void setDict_memo(String dict_memo) {
		this.dict_memo = dict_memo;
	}

}









