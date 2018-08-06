<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<form id="addForm" class="form-horizontal no-padding" role="form" method="post">
			<div class="row">
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">学期</label>
	                   	<div class="col-md-9">
					    	<input type="text" class="form-control" name="description" placeholder="请输入学期" />
						</div>
					</div>
	            </div>
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">备注</label>
	                   	<div class="col-md-9">
					    	<input type="text" class="form-control" name="remark" placeholder="请输入 备注" />
						</div>
					</div>
	            </div>
            </div>
            <div class="row">
	            <div class="col-sm-6">
	            	<div class="col-md-9 col-md-offset-3">
	            		<button type="button" class="btn btn-flat btn-block btn-primary btn-save">保存</button>
	            	</div>
	            </div>
	        </div>
		</form>
		