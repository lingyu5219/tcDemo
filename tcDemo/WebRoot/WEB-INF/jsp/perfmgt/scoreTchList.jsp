<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${menuName}</title>
<!--meta.jsp-->
<jsp:include page="../common/meta.jsp"></jsp:include>

<script
	src="${basePath}/static/common/js/perfmgt/scoreTchList.js"></script>
<style>
.row {
	margin-top: 5px;
	margin-bottom: 5px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
	<div class="wrapper">
		<jsp:include page="../template/head.jsp"></jsp:include>
		<jsp:include page="../template/menu.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<jsp:include page="../template/contentHeader.jsp"></jsp:include>
			<!-- Main content -->
			<section class="content">
			<form id="queryForm"  method="post">
				<div class="row  visible-on">
					<label class="col-md-1 control-label">年级</label>
					<div class="col-md-3">
						<select id="yearName" name="yearName" class="form-control">
							<option value=''>请选择..</option>
						</select>
					</div>
					<label class="col-md-1 control-label">专业</label>
					<div class="col-md-3">
						<select id="majorName" name="majorName" class="form-control">
						</select>
					</div>
					<label class="col-md-1 control-label">班级</label>
					<div class="col-md-3">
						<select id="batchName" name="batchName" class="form-control">
						</select>
					</div>
				</div>
				<div class="row  visible-on">
					<label class="col-md-1 control-label">学期</label>
					<div class="col-md-3">
						<select id="termName" name="termName" class="form-control">
							<option value=''>请选择..</option>
						</select>
					</div>
					<label class="col-md-1 control-label">课程</label>
					<div class="col-md-3">
						<select id="courseName" name="courseName" class="form-control">
						</select>
					</div>
					<label class="col-md-1 control-label">姓名或学号</label>
					<div class="col-md-3">
						<input type="text" name="stuName" class="input-group form-control" />
					</div>
				</div>
				
				<script>
						var jsonDate = $.parseJSON('${jsonDate}');

						for (var i = 0; i < jsonDate['yearName'].length; i++) {
							var option = $("<option>").val(
									jsonDate['yearName'][i]).text(
									jsonDate['yearName'][i]);
							$("select[name='yearName']").append(option);
						}

						$("select[name='yearName']")
								.change(
										function() {
											var selected_year = $(this).val();
											if (selected_year == null) {
												$("select[name='majorName']")
														.empty();
											} else {
												$("select[name='majorName']")
														.empty();
												$("select[name='majorName']")
														.append(
																$("<option>")
																		.val(
																				null)
																		.text(
																				'请选择..'));
												for (var i = 0; i < jsonDate[selected_year].length; i++) {
													var option = $("<option>")
															.val(
																	jsonDate[selected_year][i])
															.text(
																	jsonDate[selected_year][i]);

													$(
															"select[name='majorName']")
															.append(option);
												}
											}
										});

						$("select[name='majorName']")
								.change(
										function() {
											var selected_major = $(this).val();
											if (selected_major == null) {
												$("select[name='batchName']")
														.empty();
											} else {
												$("select[name='batchName']")
														.empty();
												$("select[name='batchName']")
														.append(
																$("<option>")
																		.val(
																				null)
																		.text(
																				'请选择..'));
												for (var i = 0; i < jsonDate[selected_major].length; i++) {
													var option = $("<option>")
															.val(
																	jsonDate[selected_major][i])
															.text(
																	jsonDate[selected_major][i]);
													$(
															"select[name='batchName']")
															.append(option);
												}
											}
										});
						for (var i = 0; i < jsonDate['termName'].length; i++) {
							var option = $("<option>").val(
									jsonDate['termName'][i]).text(
									jsonDate['termName'][i]);
							$("select[name='termName']").append(option);
						}
						
						$("select[name='termName']")
						.change(
								function() {
									var selected_term = $(this).val();
									if (selected_term == null) {
										$("select[name='courseName']")
												.empty();
									} else {
										$("select[name='courseName']")
												.empty();
										$("select[name='courseName']")
												.append(
														$("<option>")
																.val(
																		null)
																.text(
																		'请选择..'));
										for (var i = 0; i < jsonDate[selected_term].length; i++) {
											var option = $("<option>")
													.val(
															jsonDate[selected_term][i])
													.text(
															jsonDate[selected_term][i]);
											$(
													"select[name='courseName']")
													.append(option);
										}
									}
								});
					</script>
				<!--查询按钮-->
				<div class="row  visible-on">
					<div class="col-md-3 col-md-offset-9" style="text-align: center">
						<button type="button" id="btn-query" class="btn btn-block btn-primary"><i class="fa fa-search"></i></button>
					</div>
				</div>
			</form>
			<div class="row  visible-on">			
				<div class="col-md-12 table-responsive">
					<!-- /.box-header -->
					<table id="scoreListTable"
						class="table table-condensed table-hover">
						<thead>
							<tr>
								<th style="width: 10px">#</th>
								<th>成绩Id</th>
								<th>学年</th>
								<th>学期</th>
								<th>专业</th>
								<th>班级 </th>
								<th>学号</th>
								<th>姓名</th>
								<th>课程</th>
								<th>成绩</th>
								<th>操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			</section>
		</div>
		<jsp:include page="../template/footer.jsp"></jsp:include>
	</div>
</body>
</html>