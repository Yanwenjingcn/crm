package com.ywj.domain;

import java.util.List;

/**
 * 鍒嗛〉鐨凧avaBean
 * @author Administrator
 */
public class PageBean<T> {
	
	// 褰撳墠椤�
	private int pageCode;
	
	// 鎬婚〉鏁�
	// private int totalPage;
	
	// 鎬昏褰曟暟
	private int totalCount;
	// 姣忛〉鏄剧ず鐨勮褰曟潯鏁�
	private int pageSize;
	// 姣忛〉鏄剧ず鐨勬暟鎹�
	private List<T> beanList;
	
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	

	public int getTotalPage() {
	
		int totalPage = totalCount / pageSize;

		if(totalCount % pageSize == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
	
	/*public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
}
