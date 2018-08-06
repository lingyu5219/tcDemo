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

<script src="${basePath}/static/common/js/perfmgt/attendStuList.js"></script>
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
				<h1>学生端</h1>
			</div>
			<form id="queryForm" action="${basePath}/perfmgt/queryAttendForStu"
				method="post">
				<div class="row visible-on">
					<div class="col-md-1"></div>
					<div class="col-md-1" style="text-align: center">
						<h4>时间</h4>
					</div>
					<div class="col-md-7">
						<div class="input-daterange input-group" id="datepicker">
							<input type="text" readonly class="form-control" id="time1" name="time1"
								placeholder="请输入开始日期" /> <span class="input-group-addon">to</span>
							<input type="text" readonly class="form-control" id="time2" name="time2"
								placeholder="请输入结束日期" />
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
					</div>
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