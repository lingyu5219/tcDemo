<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp"></jsp:include>
<title>成功</title>

<script type="text/javascript">
  tcAlert("操作成功");
  window.location.href="${basePath}/company/queryCompanyList";
</script>

</head>
<body>
 
</body>
</html>