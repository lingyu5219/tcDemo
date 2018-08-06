<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="detailForm" class="form-horizontal no-padding" role="form"
	method="post">
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">参数类型</label>
				<div class="col-md-9">
					<input type="text" readonly class="form-control" id="paramType"
						name="paramType" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">参数代码</label>
				<div class="col-md-9">
					<input type="text" readonly class="form-control" id="paramCode"
						name="paramCode" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">参数名称</label>
				<div class="col-md-9">
					<input type="text" readonly class="form-control"
						id="paramName" name="paramName" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">创建者</label>
				<div class="col-md-9">
					<input type="text" readonly class="form-control" id="createBy"
						name="createByName" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">备注</label>
				<div class="col-md-9">
					<textarea readonly class="form-control" rows="3" id="remark"
						name="remark"></textarea>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">创建时间</label>
				<div class="col-md-9">
					<input type="text" readonly class="form-control" id="createTime"
						name="createTime" />
				</div>
			</div>
		</div>
	</div>
</form>
