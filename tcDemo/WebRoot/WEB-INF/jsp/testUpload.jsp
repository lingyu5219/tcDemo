<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/meta.jsp"></jsp:include>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="${basePath}upload/uploadFile">
		<input type="text" name="uploadPath" value="static/upload/file/projects/" />
		<div id="fileList" class="uploader-list"></div>
		<div>
		<a id="projectFileBtn" class="btn btn-primary">选择文件</a>
		</div>
	</form>


</body>

<script>
	var leoUpload = new LeoUpload({
		fileMaxCount:1,
		fileMaxSize:5242880,//5MB
		fileLimitType:".zip|.rar",
		uploadPath : "static/upload/file/projects",
		uploadAction : basePath + "upload/uploadFile",
		delAction : basePath + "upload/delFile",
		picker : "projectFileBtn",
		fileList : "fileList",
		afterSuccess : function(data){
			tcAlert(data.fileName);
		},
		afterDelFile : function(data){
			tcAlert(data.info);
		}
	});
</script>
</html>