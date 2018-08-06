<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/meta.jsp"></jsp:include>
<form id="detailForm" class="form-horizontal no-padding" role="form"
	method="post">

	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">学生名</label>
				<div class="col-md-9">
					<input type="text" readonly name="stuName"
						class="from-control  form-control" />
					<input type="text" readonly  name="scorestudentId"
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
					<input type="text" readonly name="score"
						class="from-control  form-control" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">创建时间</label>
				<div class="col-md-9">
					<input type="text" readonly name="createTime"
						class="from-control  form-control" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">创建人</label>
				<div class="col-md-9">
					<input type="text" readonly name="createBy"
						class="from-control  form-control" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">备注</label>
				<div class="col-md-9">
					<textarea readonly class="form-control" rows="3" id="remark"
						name="remark" placeholder="未输入备注 ..."></textarea>
				</div>
			</div>
		</div>
	</div>	
</form>
