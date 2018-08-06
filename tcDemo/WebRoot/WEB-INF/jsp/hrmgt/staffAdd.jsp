<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var PhoneNum = /^1[3,4,5,8]\d{9}$/;
	var Email = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;

	function sure() {
		if (document.getElementById("name").value == '') {
			tcAlert("教职工名字不能为空");
		} else if (document.getElementById("birthday").value == '') {
			tcAlert("教职工出生日期不能为空");
		} else if (document.getElementById("phone").value == '') {
			tcAlert("教职工电话号码不能为空");
		} else if (!PhoneNum
				.test(document.getElementById("phone").value.trim())
				&& document.getElementById("phone").value !== '') {
			tcAlert("教职工电话号码错误");
		} else if (document.getElementById("email").value == '') {
			tcAlert("教职工Email不能为空");
		} else if (!Email.test(document.getElementById("email").value.trim())
				&& document.getElementById("email").value !== '') {
			tcAlert("教职工Email错误");
		} else if (document.getElementById("userName").value == '') {
			tcAlert("用户账号不能为空");
		} else {
			$("button.btn-save").click();
		}

	}
</script>

<form id="addForm" class="form-horizontal no-padding" role="form"
	method="post">
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">名字</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="name" name="staffName"
						placeholder="请输入教职工名" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">出生日期</label>
				<div class="col-md-9">
					<input type="text" readonly class="form-control datepicker"
						id="birthday" name="staffBirthday" placeholder="请输入出生日期" />
				</div>
			</div>
		</div>

	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">电话号码</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="phone"
						name="staffPhone" placeholder="请输入电话号码" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">Email</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="email"
						name="staffEmail" placeholder="请输入Email" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">职位</label>
				<div class="col-md-9">
					<select id="positionId" name="positionId" class="form-control">
						<c:forEach items="${Position}" var="pi">
							<option value="${pi.positionId}">${pi.positionName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">用户账号</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="userName" name="userName"
						placeholder="请输入用户账号" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">部门</label>
				<div class="col-md-9">
					<select id="deptId" name="deptId" class="form-control">
						<c:forEach items="${Dept}" var="dp">
							<option value="${dp.deptId}">${dp.deptName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-md-9 col-md-offset-3">
				<button type="button" class="btn btn-flat btn-block btn-primary"
					onclick="sure()">保存</button>
				<button style="display: none" type="button"
					class="btn btn-flat btn-block btn-primary btn-save">保存</button>
			</div>
		</div>
	</div>
</form>