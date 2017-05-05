<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page) {
		if (page) {
			$("#page").val(page);
		}
		document.customerForm.submit();

	}

	//异步加载，加载筛选的选项，这些都是通过后台以json的形式传送过来的
	//后来使用了alibaba的fastJson工具，转换为json格式
	//这种函数是在页面一加载成功就会执行的
	$(function() {
		var url = "${pageContext.request.contextPath}/customer_findAll.action";
		//发送请求链接
		$.post(url, function(data) {
			//遍历
			$(data).each(
					function() {
						//完成数据回显
						if (this.cust_id == "${model.customer.cust_id}") {
							$("#customerId").append(
									"<option value='"+this.cust_id+"' selected>"
											+ this.cust_name + "</option>")
						} else {
							$("#customerId").append(
									"<option value='"+this.cust_id+"'>"
											+ this.cust_name + "</option>")
						}

					});

		}, "json");

	});
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>

<!-- 表格提交到分页查询的action那里 -->
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/linkman_findByPage.action"
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
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
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
												
													<TD>联系人名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="lkm_name">
													</TD>
													
													<TD>所属客户：</TD>
													<TD>
														<!-- 提交的时候就是提交一个id值 --> <select name="customer.cust_id"
														id="customerId">
															<option value="">--请选择--</option>
													</select>
													</TD>


													<TD>
													<INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2>
													</TD>
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
													<TD>联系人名称</TD>
													<td>所属客户</td>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												
												<!-- 遍历数据，从值栈中获取数据 -->
												<c:forEach items="${page.beanList }" var="linkman">
													<TR
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<TD>${linkman.lkm_name }</TD>
														<TD>${linkman.customer.cust_name}</TD>
														<TD>${linkman.lkm_gender }</TD>

														<TD>${linkman.lkm_phone }</TD>
														<TD>${linkman.lkm_mobile }</TD>

														<TD><a
															href="${pageContext.request.contextPath }/linkmanServlet?method=edit&lkmId=${linkman.lkm_id}">修改</a>
															&nbsp;&nbsp; <a
															href="${pageContext.request.contextPath }/linkmanServlet?method=delete&lkmId=${linkman.lkm_id}">删除</a>
														</TD>
													</TR>

												</c:forEach>

											</TBODY>
										</TABLE></TD>
								</TR>

								<TR>
									<TD>
										<!--静态引入  --> <%@ include file="/jsp/page.jsp"%>
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
