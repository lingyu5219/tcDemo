<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="detailForm" class="form-horizontal no-padding" role="form"
	method="post">
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">名字</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="name" name="staffName"
						value="${staff.staffName}" readonly="readonly" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">年龄</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="birthday"
						name="staffBirthday" value="${staff.staffBirthday}"
						readonly="readonly" />
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
						name="staffPhone" value="${staff.staffPhone}" readonly="readonly" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">Email</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="email"
						name="staffEmail" value="${staff.staffEmail}" readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">职位</label>
				<div class="col-md-9">
					<select name="positionId" class="form-control"
						onfocus="this.defaultIndex=this.selectedIndex;"
						onchange="this.selectedIndex=this.defaultIndex;">
						<c:forEach items="${Position}" var="pi">
							<option value="${pi.positionId}">${pi.positionName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">用户ID</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="userId" name="userId"
						value="${staff.userId}" readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">部门</label>
				<div class="col-md-9">
					<select name="deptId" class="form-control"
						onfocus="this.defaultIndex=this.selectedIndex;"
						onchange="this.selectedIndex=this.defaultIndex;">
						<c:forEach items="${Dept}" var="dp">
							<option value="${dp.deptId}">${dp.deptName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
</form>