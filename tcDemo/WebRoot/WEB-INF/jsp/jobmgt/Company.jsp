<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp"></jsp:include>
<title>职位</title>

<script>
<!--搜索按钮-->
	function search() {
		if ($("#searchText").val() === "") {
			tcAlert("请输入要搜索的内容");
		} else {
			window.location.href = "${basePath}/company/queryCompanyBycoName?coname="
					+ $("#searchText").val();
		}
	}
	<!--添加按钮-->
	function add() {
		window.location.href = "${basePath}/forward?page=jobmgt/CompanyAdd";
	}
	<!--删除按钮-->
	function del() {
		var cho = $('input:radio[name=choose]:checked').val(); //定义选中的单选框的值
		if (cho == null) {
			tcAlert("请选择要删除的公司");
		} else {
			window.location.href = "${basePath}/company/queryCompanyDelete?coId="
					+ cho;
		}
	}
	<!--修改按钮-->
	function upd() {
		var cho = $('input:radio[name=choose]:checked').val(); //定义选中的单选框的值
		if (cho == null) {
			tcAlert("请选择要修改的公司");
		} else {
			window.location.href = "${basePath}/company/queryCompanyById?coname="
					+ cho;
		}
	}
</script>

</head>

<body class="hold-transition skin-blue sidebar-mini fixed">
	<div class="wrapper">
		<jsp:include page="../template/head.jsp"></jsp:include>
		<jsp:include page="../template/menu.jsp"></jsp:include>
		<div class="content-wrapper">
			<jsp:include page="../template/contentHeader.jsp"></jsp:include>
			<!-- Main content -->
			<section class="content">

			<div class="row visible-on">
				<div class="col-xs-12">
					<div class="box">
						<!-- /.box-header -->
						<div class="box-header with-border">
						   
						   
						   <form id="queryForm" class="form-horizontal no-padding"
								role="form" action="${basePath}/staff/queryStaffList"
								method="post">

								<div class="col-md-2"></div>
								<!-- 搜索框 -->
								<div class="col-md-6">
									<input id="searchText" class="form-control" type="text"
										value="" />
								</div>
								<!-- 搜索按钮 -->
								<div class="col-md-2">
									<input type="button" class="btn btn-primary" id="sButton"
										onclick="search()" style="width: 100%;" value="搜索" />
								</div>
								<div class="col-md-2"></div>
							</form>
						</div>
						<!-- box-header -->

						<!-- 公司信息表 -->
						<!-- /.box-body -->
						<div class="box-body">


							<table class="table table-hover">
								<thead>
									<tr>
										<th style="width: 33%">选择</th>
										<th style="width: 33%">公司ID</th>
										<th style="width: 33%">公司名</th>
									</tr>
								</thead>

								<c:forEach var="position" items="${positionList}">
									<tr>
										<td><input name="choose" type="radio"
											value="${position.positionId}"></td>
										<td>${position.positionId}</td>
										<td>${position.positionName}</td>
									</tr>
								</c:forEach>
							</table>


							<!-- 增删改按钮 -->
							<div class="row visible-on">
								<div class="col-md-2"></div>
								<div class="col-md-2">
									<input type="button" id="addButton" class="btn btn-primary"
										onclick="add()" value="增加公司信息" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<input type="button" id="delButton" class="btn btn-primary"
										onclick="del()" value="删除公司信息" />
								</div>
								<div class="col-md-1"></div>
								<div id="delete" class="col-md-2">
									<input type="button" id="updButton" class="btn btn-primary"
										onclick="upd()" value="修改公司信息" />
								</div>
								<div class="col-md-2"></div>
							</div>
						</div>
						<!-- box-body -->
					</div>
					<!-- box -->
				</div>
				<!-- xs-12 -->
			</div>
			<!-- row --> </section>
		</div>
		<!-- <div class="content-wrapper"> -->
		<jsp:include page="../template/footer.jsp"></jsp:include>
	</div>
	<!-- <div class="wrapper"> -->

</body>
</html>