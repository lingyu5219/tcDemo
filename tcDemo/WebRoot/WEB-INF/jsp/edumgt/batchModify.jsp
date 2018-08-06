<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="updateForm" class="form-horizontal no-padding" role="form" method="post">
	<input type="hidden" name="batchId"/>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">学年</label>
				<div class="col-md-9">
					<select class="form-control yearIdSelect2" name="yearId" style="width: 100%">
					</select>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">专业方向</label>
				<div class="col-md-9">
					<select class="form-control majorIdSelect2" name="majorId" style="width: 100%">
					</select>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">班级名称</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="batchName"/>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">备注</label>
				<div class="col-md-9">
					<textarea class="form-control" rows="3" name="remark"></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
	      	<div class="col-md-9 col-md-offset-3">
	      		<button type="button" class="btn btn-flat btn-block btn-primary btn-update">保存</button>
	      	</div>
      	</div>
	</div>
</form>
