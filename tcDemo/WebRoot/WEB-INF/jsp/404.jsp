<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
	<jsp:include page="common/meta.jsp"></jsp:include>
	<script type="text/javascript" src="${basePath}static/common/js/login.js"></script>
	<title>出错了</title>
</head>
<body class="hold-transition skin-blue layout-top-nav">
	<div class="wrapper">
		<jsp:include page="template/topNav.jsp"></jsp:include>
		<div class="content-wrapper img-vertical-middle">
			<span>
				<img class="img-responsive" src="${basePath}static/images/404.png" alt="出错了"/>
			</span>
		</div>
		<jsp:include page="template/footer.jsp"></jsp:include>
	</div>
</body>
</html>