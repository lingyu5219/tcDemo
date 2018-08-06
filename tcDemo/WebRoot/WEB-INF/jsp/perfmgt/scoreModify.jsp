<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="updateForm" class="form-horizontal no-padding" role="form"
	method="post">
		<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">学生名</label>
				<div class="col-md-9">
					<input type="text" readonly name="stuName"
						class="from-control  form-control" />
					<input type="text" readonly name="scorestudentId"
						class="from-control  form-control"  style="display:none"/>
					<input type="text" readonly name="scoreId"
						class="from-control  form-control"  style="display:none"/>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">课程名</label>
				<div class="col-md-9">
					<input type="text" readonly name="courseName"
						class="from-control  form-control" />
					<input type="text" readonly name="scorecourseId"
						class="from-control  form-control"  style="display:none"/>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">成绩</label>
				<div class="col-md-9">
					<input type="text" name="score"
						class="from-control  form-control" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">备注</label>
				<div class="col-md-9">
					<textarea class="form-control" rows="3" id="remark"
						name="remark" placeholder="请输入备注 ..."></textarea>
				</div>
			</div>
		</div>
	</div>	
	<div class="row">
		<div class="col-sm-6">
			<div class="col-md-9 col-md-offset-3">
				<button type="button"
					class="btn btn-flat btn-block btn-primary btn-update">保存</button>
			</div>
		</div>
	</div>
</form>
