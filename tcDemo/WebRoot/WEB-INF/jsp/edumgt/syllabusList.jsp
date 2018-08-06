<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/meta.jsp"></jsp:include>
<script type="text/javascript" src="${basePath }/static/common/js/edumgt/syllabus.js"></script>
<title>${menuName }</title>
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
	<div class="wrapper">
		<jsp:include page="../template/head.jsp"></jsp:include>
		<jsp:include page="../template/menu.jsp"></jsp:include>
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
					                <div class="col-md-2">
										<div class="form-group">
						                    <div class="col-md-9">
												<select class="form-control" id="tempYear" name="tempYear">
												</select>						                    
						                    </div>
						                </div>
					                </div>
					                <div class="col-md-2">
					                	<div class="form-group">
					                		<div class="col-md-9">
											  	<select class="form-control" id="tempSylQuarter" name="tempSylQuarter">
											  	</select>											  						                		
					                		</div>					                	
					                	</div>
					                </div>
					                <div  class="col-md-2">
					                	<div  class="form-group">
					                		<div class="col-md-9">
											  	<select class="form-control" id="tempBatch" name="tempBatch">
											  		<option selected="selected" value="1">java1</option>
											  		<option value="2">java2</option>
											  		<option value="3">java3</option>
											  		<option value="4">java4</option>
											  	</select>					                		
					                		</div>					                	
					                	</div>					                
					                </div>				                
					                <div class="col-xs-6 col-md-1">
			                			<button type="button" id="btn-query" class="btn btn-block btn-primary"><i class="fa fa-search"></i></button>
					                </div>				                
								</form>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div style="height:30px">									
									<span class="syllabusHeader" id="syllabusHeader" style="text-align: center ;line-height: 30px;display:block;">${year }级   ${sylQuarter }  ${batchName }班</span>								
								</div>
								<table id="dataListTable" class="table table-condensed table-hover">
									<thead>
										<tr>
											<th style="width: 10px">#</th>
											<th>星期一</th>
											<th>星期二</th>
											<th>星期三</th>
											<th>星期四</th>
											<th>星期五</th>
											<th>星期六</th>
											<th>星期天</th>
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