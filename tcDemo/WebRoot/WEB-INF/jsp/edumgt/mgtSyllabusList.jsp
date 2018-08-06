<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/meta.jsp"></jsp:include>
<script type="text/javascript" src="${basePath }/static/common/js/edumgt/mgtSyllabus.js"></script>
<title>${menuName }</title>
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
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header with-border">
								<form id="queryForm" class="form-horizontal no-padding" role="form" action="${basePath}/user/queryUserList" method="post">
					                <input type="hidden" name="query" id="query"/>
					                <div class="col-md-4">
										<div class="form-group">
						                    <label class="col-md-3 control-label">请选择</label>
						                    <div class="col-md-9">
												<select class="form-control" id="tempYear" name="tempYear">
												</select>
						                    </div>
						                </div>
					                </div>
					                <div class="col-md-6">
					                	<div class="col-xs-6 col-md-3">
					                			<select class="form-control" id="tempSylQuarter" name="tempSylQuarter">	  	
											</select>
					                	</div>
										<div class="col-xs-6 col-md-3">
										<select class="form-control" id="tempBatch" name="tempBatch">
										  	<option selected="selected" value="01">java01</option>
										  	<option value="02">java02</option>
										</select>
										</div>
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
										<th>用户ID</th>
										<th>年份</th>
										<th>学期</th>
										<th>班级</th>
										<th>开始时间</th>
										<th>结束时间</th>
										<th>操作</th>
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