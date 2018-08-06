<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp"></jsp:include>
<title>添加公司信息</title>

<script>
<!--返回按钮-->
	function back() {
		window.location.href = "${basePath}/company/queryCompanyList";
	}
	<!--确定按钮-->
	function sure() {
		if (document.getElementById("name").value == '') {
			tcAlert("公司名字不能为空");
			return false;
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

							<form action="${basePath}/position/queryPositionAdd"
								onsubmit="javascript:return sure()" method="post">


								<table class="table table-hover">
									<tr>
										<td style="width: 30%">公司名</td>
										<td><input id="name" name="coName"
											class="form-control" type="text" /></td>
									</tr>
								</table>

								<div class="row visible-on">
									<div class="col-md-6"></div>
									<div class="col-md-2">
										<input type="submit" id="sureButton" class="btn btn-primary"
											value="确定" />
									</div>
									<div class="col-md-2">
										<input type="reset" id="returnButton" class="btn btn-primary"
											onclick="back()" value="返回" />
									</div>
								</div>
							</form>
							<!-- box-header -->
						</div>
						<!-- box -->
					</div>
					<!-- xs-12 -->
				</div>
				<!-- row -->
			</div>
			</section>
		</div>
		<jsp:include page="../template/footer.jsp"></jsp:include>
	</div>

</body>
</html>