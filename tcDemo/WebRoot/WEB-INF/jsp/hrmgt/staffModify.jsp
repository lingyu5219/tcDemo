<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var Birthday = /^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/;
	var PhoneNum = /^1[3,4,5,8]\d{9}$/;
	var Email = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;

	<!--确定按钮-->
	function sure() {
		if (document.getElementById("phone").value == '') {
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
		} else {
			$("button.btn-update").click();
		}

	}
</script>


<form id="updateForm" class="form-horizontal no-padding" role="form"
	method="post">
	<div class="row">

		<input type="text" name="staffId" value="${staff.staffId}"
			style="display: none" />

		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">名字</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="name" name="staffName"
						value="${staff.staffName}" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">年龄</label>
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
						name="staffPhone" value="${staff.staffPhone}" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">Email</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="email"
						name="staffEmail" value="${staff.staffEmail}" />
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
	</div>
	<div class="row">
		<div class="col-sm-6"></div>
		<div class="col-sm-6">
			<div class="col-md-9 col-md-offset-3">
				<button type="button" class="btn btn-flat btn-block btn-primary"
					onclick="sure()">保存</button>
				<button style="display: none" type="button"
					class="btn btn-flat btn-block btn-primary btn-update">保存</button>
			</div>
		</div>
	</div>
	<div class="row"></div>
</form>