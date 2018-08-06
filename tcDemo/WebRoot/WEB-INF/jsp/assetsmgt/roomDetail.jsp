<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="detailForm" class="form-horizontal no-padding" role="form" method="post">
	<input type="hidden" name="roomId"/>
	<div class="row">
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">教室名称</label>
                  	<div class="col-md-9">
			    	<input type="text" readonly class="form-control" id="roomName" name="roomName" placeholder="教室名称" />
				</div>
			</div>
           </div>
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">区域ID</label>
                  	<div class="col-md-9">
			    	<input type="text" readonly class="form-control" id="centerId" name="centerId" placeholder="区域ID" />
				</div>
			</div>
           </div>
          </div>
          <div class="row">
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">操作人</label>
                  	<div class="col-md-9">
			    	<input type="text" readonly class="form-control" id="createBy" name="createBy" placeholder="操作人" />
				</div>
			</div>
           </div>
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">时间</label>
                  	<div class="col-md-9">
			    	<input type="text" readonly class="form-control" name="createTime" placeholder="请输入时间" />
				</div>
			</div>
           </div>
          </div>
          <div class="row">
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">备注</label>
                  	<div class="col-md-9">
                  		<textarea class="form-control" rows="3"  readonly id="remark" name="remark" placeholder="请输入备注 ..."></textarea>
	            </div>
			</div>
           </div>
       </div>
</form>
		