<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/meta.jsp"></jsp:include>
	<script type="text/javascript" src="${basePath}static/common/js/stumgt/stuReg.js"></script>
	<title>学生注册</title>
</head>
<body class="hold-transition skin-blue layout-top-nav">
	<div class="wrapper">
		<jsp:include page="../template/topNav.jsp"></jsp:include>
		<div class="content-wrapper register-bg">
			<div class="container">
				<section class="content">
					<div class="col-md-7">
						<div class="register-box-body">
							<form id="regForm" action="" class="form-horizontal padding-lr-30" role="form" method="post">
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-calendar text-red"></i></span>
											<select class="form-control yearIdSelect2" id="yearId" name="yearId" style="width: 100%">
												<option selected="selected" value="0">请选择学年</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-heart text-red"></i></span>
											<select class="form-control majorIdSelect2" id="majorId" name="majorId" style="width: 100%">
												<option selected="selected" value="0">请选择专业方向</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-home text-red"></i></span>
											<select class="form-control batchIdSelect2" id="batchId" name="batchId" style="width: 100%">
												<option selected="selected" value="0">请选择班级</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-education text-red"></i></span>
											<input type="text" class="form-control" id="stuNo" name="stuNo"
												placeholder="请输入学号" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-user text-red"></i></span>
											<input type="text" class="form-control" id="stuName" name="stuName"
												placeholder="请输入姓名" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="fa fa-intersex text-red"></i></span>
											<select class="form-control stuSexSelect2" id="stuSex" name="stuSex" style="width: 100%">
												<option value="0">请选择性别</option>
												<option value="1">男</option>
												<option value="2">女</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-calendar text-red"></i></span>
											<input type="text" readonly class="form-control datepicker"
												id="stuBirthday" name="stuBirthday" placeholder="请选择出生日期" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-credit-card text-red"></i></span>
											<input type="text" class="form-control" id="stuIdcard" name="stuIdcard"
												placeholder="请输入身份证号" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-phone text-red"></i></span>
											<input type="text" class="form-control" id="stuMobile" name="stuMobile"
												placeholder="请输入手机号码" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="fa fa-envelope text-red"></i></span>
											<input type="text" class="form-control" id="stuEmail" name="stuEmail" placeholder="请输入电子邮箱" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="fa fa-group"></i></span>
											<input type="text" class="form-control" name="stuNation"
												placeholder="请输入民族" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12 input-group">
											<span class="input-group-addon"><i class="fa fa-taxi"></i></span>
											<input type="text" class="form-control" name="stuAddress"
												placeholder="请输入联系地址" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12">
											<label>
												<input type="checkbox" id="readAndAgree" name="readAndAgree" class="icheck">
												阅读并同意
												<a href="#">《NIIT用户注册协议》</a>
												<a href="#">《隐私政策》</a>
											</label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
										<div class="col-md-12">
											<button type="submit"
												class="btn btn-flat btn-block btn-primary btn-save">注册</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</section>
			</div>
		</div>
		<jsp:include page="../template/footer.jsp"></jsp:include>
	</div>
</body>
</html>