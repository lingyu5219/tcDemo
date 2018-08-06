<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<jsp:include page="../common/meta.jsp"></jsp:include>
	
	<title>请假管理</title>
	</head>
	<body>
		<div class="container">
		   <div class="row">
		      <div class="col-md-6">${leave.leaveType }</div>
		      <div class="col-md-6">${leave.leaveDetl}</div>      
		   </div>
		</div>
		
	</body>
</html>