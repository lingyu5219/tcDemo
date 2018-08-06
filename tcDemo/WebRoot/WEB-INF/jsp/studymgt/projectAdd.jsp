<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="addForm" class="form-horizontal no-padding" role="form"
	method="post">
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-md-2 control-label">项目名称</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="projectName"
						placeholder="请输入项目名称" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-md-2 control-label">项目地址</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="projectUrl"
						placeholder="请输入项目地址" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-md-2 control-label">项目文件</label>
				<div class="col-md-9">
					<input type="hidden" name="projectFile" /> 
					<input type="hidden" name="projectFileName" /> 
					<input type="hidden" name="projectFileSize" value="0"/>
					<div id="fileList" class="uploader-list"></div>
					<a id="projectFileBtn" class="btn btn-primary">选择文件</a>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-md-2 control-label">备注</label>
				<div class="col-md-9">
					<textarea class="form-control" rows="3" name="remark"
						placeholder="请输入备注 ..."></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="col-md-9 col-md-offset-2">
				<button type="button"
					class="btn btn-flat btn-block btn-primary btn-save">保存</button>
			</div>
		</div>
	</div>
</form>
