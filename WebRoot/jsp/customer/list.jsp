﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
	
	<!-- 引入jquery的包 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>
	// 提交分页的查询的表单
	function to_page(page) {
		if (page) {
			$("#page").val(page);
		}
		document.customerForm.submit();
	}

	// 页面的加载的时候自动执行的代码
	$(function() {
		// 发送ajax的请求
		var url = "${ pageContext.request.contextPath }/dict_findByCode.action";
		var param = {
			"dict_type_code" : "006"
		};


		$.post(url, param, function(data) {
			// 遍历,data为url执行后返回的数据内容
			$(data).each(
					function(i, n) {
					//在第一次页面加载的时候，所有都是默认的，然后值栈里面也没有对应的值，所以就没有对应选中的，所以就是以option顺序的第一个为选中的，就是--请选择--的那一个
						var vsId = "${model.level.dict_id}";
						//如果值栈里面的值和当前遍历的值相等的话，则选中该值
						if (vsId == n.dict_id) {
							$("#levelId").append(
									"<option value='"+n.dict_id+"' selected>"
											+ n.dict_item_name + "</option>");
						} else {
							$("#levelId").append(
									"<option value='"+n.dict_id+"'>"
											+ n.dict_item_name + "</option>");
						}

					});
		}, "json");

		// 获取客户来源
		var param = {
			"dict_type_code" : "002"
		};
		$.post(url, param, function(data) {
			// 遍历
			$(data).each(
					function(i, n) {
						var vsId = "${model.source.dict_id}";
						//如果值栈里面的值和当前遍历的值相等的话，则选中该值
						if (vsId == n.dict_id) {
							$("#sourceId").append(
									"<option value='"+n.dict_id+"' selected>"
											+ n.dict_item_name + "</option>");
						} else {
							$("#sourceId").append(
									"<option value='"+n.dict_id+"'>"
											+ n.dict_item_name + "</option>");
						}

					});
		}, "json");
	});
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>


	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/customer_findByPage.action"
		method=post>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0>
					</TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }
						/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
												
													<!-- 就是注意这个model，它就是超级厉害 -->
													<TD>客户名称：</TD>
													<TD>
													<INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="cust_name"
														value="${ model.cust_name }">
													</TD>
													<!-- 其实这种传值就是name和value这两个值起作用，在后台获取的关键 -->
													<!-- 注意，这个model很重要，这个就是请求的那个类的模型，它是类的一个属性，所以会默认压入值栈中 -->
													<!-- 只是这个名字不再是我们所理解的customer、linkman之类的，就是model -->
													
													
													<td>客户级别</td>
													<td><select name="level.dict_id" id="levelId">
															<option value="">--请选择--</option>
													</select></td>

													<td>客户来源</td>
													<td><select name="source.dict_id" id="sourceId">
															<option value="">--请选择--</option>
													</select></td>

													<TD><INPUT class=button id=sButton2 type=submit
														value="筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE></TD>
								</TR>

								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>联系人</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												
												<c:forEach items="${page.beanList}" var="customer">
													<TR
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<TD>${customer.cust_name }</TD>

														<TD>${customer.level.dict_item_name }</TD>
														<TD>${customer.source.dict_item_name }</TD>

														<TD>${customer.cust_linkman }</TD>
														<TD>${customer.cust_phone }</TD>
														<TD>${customer.cust_mobile }</TD>
														<TD><a
															href="${pageContext.request.contextPath }/customer_initUpdate?cust_id=${customer.cust_id}">修改</a>
															&nbsp;&nbsp; 
															<!-- 点击触发事件，然后return ture 才会进入链接出动作，否则不进行处理 -->
															<a
															href="${pageContext.request.contextPath}/customer_delete.action?cust_id=${customer.cust_id}"
															onclick="return window.confirm('确定删除吗？')">删除</a></TD>
													</TR>

												</c:forEach>

											</TBODY>
										</TABLE></TD>
								</TR>

								<TR>
									<TD>
									
									
									<SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${page.totalCount}</B>]条记录，共[<B>${page.totalPage}</B>]页
												,每页显示 <select name="pageSize">
													<option value="2"
														<c:if test="${page.pageSize==2 }">selected</c:if>>2</option>
													<option value="3"
														<c:if test="${page.pageSize==3 }">selected</c:if>>3</option>
												</select> 条

												<c:if test="${ page.pageCode > 1 }">
													[<A href="javascript:to_page(${page.pageCode-1})">前一页</A>]
												</c:if>

												<B>${page.pageCode}</B>

												<c:if test="${ page.pageCode < page.totalPage }">
													[<A href="javascript:to_page(${page.pageCode+1})">后一页</A>] 
												</c:if>

												到 <input type="text" size="3" id="page" name="pageCode" />
												页 <input type="button" value="Go" onclick="to_page()" />
											</DIV> </SPAN>
											
											
											
											</TD>
								</TR>
							</TBODY>
						</TABLE></TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0>
					</TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
