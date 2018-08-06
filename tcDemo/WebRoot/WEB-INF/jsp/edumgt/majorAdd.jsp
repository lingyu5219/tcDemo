<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL:JSP标准标签库 -->
<form id="addForm" class="form-horizontal no-padding" role="form"
	method="post">
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-md-2 control-label">专业方向名称</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="majorName"
						name="majorName" placeholder="请输入专业方向名称" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-md-2 control-label">备注</label>
				<div class="col-md-10">
					<textarea class="form-control" rows="3" name="remark"
						placeholder="请输入备注 ..."></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
        	<div class="col-md-10 col-md-offset-2">
        		<button type="button" class="btn btn-flat btn-block btn-primary btn-save">保存</button>
        	</div>
        </div>
	</div>
</form>

