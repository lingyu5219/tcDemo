<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%
	String syllabusId = (String)request.getAttribute("syllabusId");
%>
<jsp:include page="../common/meta.jsp"></jsp:include>
<script type="text/javascript" src="${basePath }/static/common/js/edumgt/mgtSybitem.js"></script>
<title>${menuName }</title>
</head>
<script type="text/javascript">
var syllabusId ='<%=syllabusId%>';
</script>
<body class="hold-transition skin-blue sidebar-mini fixed">
	<div class="wrapper">
		<jsp:include page="../template/head.jsp"></jsp:include>
		<jsp:include page="../template/menu.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<jsp:include page="../template/contentHeader.jsp"></jsp:include>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header with-border">
								<form id="queryForm" class="form-horizontal no-padding" role="form" action="#" method="post">
					                <div class="col-md-4">
										<div class="form-group">
						                    <label class="col-md-3 control-label" for="userName">请输入</label>
						                    <div class="col-md-9">
						                    	<input type="text" class="form-control" id="sybitemCondition" name="sybitemCondition" placeholder="课程，教室，教师，星期">
						                    </div>
						                </div>
					                </div>
					                <div class="col-md-4">
					                </div>				                
					                <div class="col-xs-6 col-md-1">
			                			<button type="button" id="btn-query" class="btn btn-block btn-primary"><i class="fa fa-search"></i></button>
					                </div>
					                <div class="col-xs-6 col-md-1">
			                			<button type="button" id="btn-add" class="btn btn-block btn-primary"><i class="fa fa-plus"></i></button>
					                </div>
								</form>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="dataListTable" class="table table-condensed table-hover">
									<thead>
									<tr>
										<th style="width: 10px">#</th>
										<th>ID</th>
										<th>课程</th>
										<th>周次</th>
										<th>星期</th>
										<th>节次</th>
										<th>教室</th>
										<th>教师</th>
										<th>操做</th>
									</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="../template/footer.jsp"></jsp:include>
	</div>
</body>
</html>