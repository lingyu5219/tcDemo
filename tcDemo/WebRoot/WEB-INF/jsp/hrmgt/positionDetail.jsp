<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="detailForm" class="form-horizontal no-padding" role="form"
	method="post">
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-md-3 control-label">职位名</label>
				<div class="col-md-9">
					<input type="text" class="form-control" id="name"
						name="positionName" value="${position.positionName}"
						readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
</form>