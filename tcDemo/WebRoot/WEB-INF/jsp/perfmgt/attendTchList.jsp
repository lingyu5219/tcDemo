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
	src="${basePath}/static/common/js/perfmgt/attendTchList.js"></script>
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
			<div class="row" style="text-align: center">
				<h1>教师端</h1>
			</div>
			<form id="queryForm"
				action="${basePath}/perfmgt/queryAttendForTeacher" method="post">
				<div class="row visible-on">
					<div class="col-md-1" style="text-align: center">
						<h4>时间</h4>
					</div>
					<div class="col-md-7">
						<div class="input-daterange input-group" id="datepicker">
							<input type="text" readonly class="form-control" id=time1
								name="time1" placeholder="请输入开始日期" /> <span
								class="input-group-addon">to</span> <input type="text" readonly
								class="form-control" id=time2 name="time2" placeholder="请输入结束日期" />
						</div>
					</div>
					<script>						
						var t = new Date();
						var year = t.getFullYear();
						var month = t.getMonth(); //获取当前月份(0-11,0代表1月)
						if (month == 0) {
							year--;
							month = 12;
						}
						t.setDate(0);
						$("#time1").val(year + "-" + month + "-01");
						$("#time2").val(year + "-" + month + "-"+t.getDate());
					</script>
					<div class="col-md-2" style="text-align: center">
						<h4>姓名或学号</h4>
					</div>
					<div class="col-md-2">
						<input type="text" name="stuName" class="input-group form-control" />
					</div>
				</div>
				<div class="row  visible-on">
					<div class="col-md-1" style="text-align: center">
						<h4>年级</h4>
					</div>
					<div class="col-md-2">
						<select id="yearName" name="yearName" class="form-control">
							<option value=''>请选择..</option>
						</select>
					</div>
					<div class="col-md-1" style="text-align: center">
						<h4>专业</h4>
					</div>
					<div class="col-md-3">
						<select id="majorName" name="majorName" class="form-control">
						</select>
					</div>
					<div class="col-md-1" style="text-align: center">
						<h4>班级</h4>
					</div>
					<div class="col-md-3">
						<select id="batchName" name="batchName" class="form-control">
						</select>
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
					</script>

					<!--查询按钮-->
					<div class="col-md-1" style="text-align: center">
						<button type="button" id="btn-query" class="btn btn-block btn-primary"><i class="fa fa-search"></i></button>
					</div>

				</div>
			</form>
			<div class="row  visible-on">
				<!--按比例显示缺勤 请假 迟到 情况-->
				<div class="col-md-3" id="chart">
					<div id="pie" style="width: 100%; height: 200px;"></div>
					<!--flot工具-->
					<script
						src="${basePath}/static/adminLTE/plugins/flot/jquery.flot.min.js"></script>
					<script
						src="${basePath}/static/adminLTE/plugins/flot/jquery.flot.pie.min.js"></script>


				</div>
				<div class="col-md-9 table-responsive">
					<!-- /.box-header -->
					<table id="attendListTable"
						class="table table-condensed table-hover">
						<thead>
							<tr>
								<th style="width: 10px">#</th>
								<th>用户Id</th>
								<th>年级</th>
								<th>专业</th>
								<th>班级</th>
								<th>姓名</th>
								<th>签到天数</th>
								<th>迟到天数</th>
								<th>请假天数</th>
								<th>总共天数</th>
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