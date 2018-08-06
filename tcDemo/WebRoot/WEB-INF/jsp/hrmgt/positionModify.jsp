<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	function sure() {
		if (document.getElementById("name").value == '') {
			tcAlert("教职工名字不能为空");
		}else{
			$("button.btn-update").click();
		}

	}
</script>

<form id="updateForm" class="form-horizontal no-padding" role="form" method="post">
     <div class="row">
     <input type="text" name="positionId" value="${position.positionId}" style="display:none"/>
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">职位名</label>
	                   	<div class="col-md-9">
					    	<input type="text" class="form-control" id="name" name="positionName" value="${position.positionId}"/>
						</div>
					</div>
	            </div>
	            <div class="col-sm-6">
	            	<div class="col-md-9 col-md-offset-3">	
	            	    <button type="button" class="btn btn-flat btn-block btn-primary" onclick="sure()">保存</button>
	            		<button style="display:none" type="button" class="btn btn-flat btn-block btn-primary btn-update">保存</button>
	            	</div>
	            </div>
            </div>
</form>


							