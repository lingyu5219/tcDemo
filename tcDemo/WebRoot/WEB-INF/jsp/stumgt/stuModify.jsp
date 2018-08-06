<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="updateForm" class="form-horizontal no-padding" role="form" method="post">
	<input type="hidden" name="stuId"/>
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
				<label class="col-md-3 control-label">班级</label>
				<div class="col-md-9">
					<select class="form-control batchIdSelect2" name="batchId" style="width: 100%">
						<option selected="selected" value="0">请选择班级</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">学号</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="stuNo"/>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">姓名</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="stuName"/>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">性别</label>
				<div class="col-md-9">
					<select class="form-control stuSexSelect2" name="stuSex" style="width: 100%">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">出生日期</label>
				<div class="col-md-9">
					<input type="text" readonly class="form-control datepicker"
						id="stuBirthday" name="stuBirthday" placeholder="请选择日期" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">身份证</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="stuIdcard"
						placeholder="请输入身份证号" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">手机</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="stuMobile"
						placeholder="请输入手机号码" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">E-mail</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="stuEmail"
						placeholder="请输入邮箱" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">民族</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="stuNation"
						placeholder="请输入民族" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">联系地址</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="stuAddress"
						placeholder="请输入联系地址" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">备注</label>
				<div class="col-md-9">
					<textarea class="form-control" rows="3" name="remark"
						placeholder="请输入备注 ..."></textarea>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-md-12">
           		<button type="button" class="btn btn-flat btn-block btn-primary btn-update">保存</button>
			</div>
		</div>
	</div>
</form>
		