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
	src="${basePath}/static/common/js/perfmgt/scoreStuList.js"></script>
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
					<input type="text" name="userId" value="${userId}" style="display:none"/>
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
					<div class="col-md-1 col-md-offset-1" style="text-align: center">
						<button type="button" id="btn-query" class="btn btn-block btn-primary"><i class="fa fa-search"></i></button>
					</div>
				</div>
				
				<script>			
						var jsonDate = $.parseJSON('${jsonDate}');
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