<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<form id="updateForm" class="form-horizontal no-padding" role="form" method="post">
		  <input type="hidden" name="equipmentId"/>
			<div class="row">
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">设备名称</label>
	                   	<div class="col-md-9">
					    	<input type="text" class="form-control" name="equipmentName" placeholder="请输入设备名称" />
						</div>
					</div>
	            </div>
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">设备类型</label>
	                   	<div class="col-md-9">
					    	<input type="text" class="form-control" name="equipmentType" placeholder="请输入设备类型" />
						</div>
					</div>
	            </div>
	            </div>
	            <div class="row">
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">设备状态</label>
	                   	<div class="col-md-9">
					    	<input type="text" class="form-control" name="equipmentState" placeholder="请输入设备状态" />
						</div>
					</div>
	            </div>
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">操作人</label>
	                   	<div class="col-md-9">
					    	<input type="text" class="form-control" name="createBy" placeholder="操作人" />
						</div>
					</div>
	            </div>
	            </div>
	            <div class="row">
	          
           
	            <div class="col-sm-6">
	             	<div class="form-group">
	                    <label class="col-md-3 control-label">备注</label>
	                   	<div class="col-md-9">	
	                   		<textarea class="form-control" rows="3" name="remark" placeholder="请输入备注 ..."></textarea>
			            </div>
					</div>
	            </div>
	            <div class="col-sm-6">
	            	<div class="col-md-9 col-md-offset-3">
	            		
	            		<button type="button" class="btn btn-flat btn-block btn-primary btn-update">保存</button>
	            	</div>
	            </div>
	        </div>
		</form>
		