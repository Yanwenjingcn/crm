package com.ywj.domain;

public class Customer {

	/**
	 * `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '瀹㈡埛缂栧彿(涓婚敭)',
	 * `cust_name` varchar(32) NOT NULL COMMENT '瀹㈡埛鍚嶇О(鍏徃鍚嶇О)', `cust_user_id`
	 * bigint(32) DEFAULT NULL COMMENT '璐熻矗浜篿d', `cust_create_id` bigint(32)
	 * DEFAULT NULL COMMENT '鍒涘缓浜篿d', `cust_source` varchar(32) DEFAULT NULL
	 * COMMENT '瀹㈡埛淇℃伅鏉ユ簮', `cust_industry` varchar(32) DEFAULT NULL COMMENT
	 * '瀹㈡埛鎵�睘琛屼笟', `cust_level` varchar(32) DEFAULT NULL COMMENT '瀹㈡埛绾у埆',
	 * `cust_linkman` varchar(64) DEFAULT NULL COMMENT '鑱旂郴浜�, `cust_phone`
	 * varchar(64) DEFAULT NULL COMMENT '鍥哄畾鐢佃瘽', `cust_mobile` varchar(16)
	 * DEFAULT NULL COMMENT '绉诲姩鐢佃瘽',
	 */

	private Long cust_id;
	// 瀹㈡埛鍚嶇О
	private String cust_name;
	private Long cust_user_id;
	private Long cust_create_id;

	/*
	 * // 瀹㈡埛鐨勬潵婧� private String cust_source; // 鎵�睘浜庤涓� private String
	 * cust_industry; // 瀹㈡埛鐨勭骇鍒� private String cust_level;
	 */

	// 鑱旂郴浜哄悕绉�
	private String cust_linkman;
	// 鍥哄畾鐢佃瘽
	private String cust_phone;
	// 绉诲姩鐢佃瘽
	private String cust_mobile;

	// 鎻忚堪鐨勬槸 涓�鎴风殑鏉ユ簮锛屽鏄鎴�
	private Dict source;
	// 涓�鎴风殑琛屼笟 澶氭槸瀹㈡埛
	private Dict industry;
	// 涓�鎴风骇鍒�澶氭槸瀹㈡埛
	private Dict level;

	// 上传文件保存的路径
	private String filePath;

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

	public String getCust_linkman() {
		return cust_linkman;
	}

	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
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

	public void setSource(Dict source) {
		this.source = source;
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
}
