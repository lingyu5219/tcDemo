<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="updateForm" class="form-horizontal no-padding" role="form" method="post">
	<input type="hidden" name="userId"/>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">账号</label>
                <div class="col-md-9">
			    	<input type="text" class="form-control" id="userAccount" name="userAccount" placeholder="请输入账号" />
				</div>
		    </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">密码</label>
                <div class="col-md-9">
			    	<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="******" />
				</div>
			</div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">姓名</label>
                <div class="col-md-9">
			    	<input type="text" class="form-control" id="userName" name="userName" placeholder="请输入姓名" />
				</div>
			</div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">电话</label>
                <div class="col-md-9">
			    	<input type="text" class="form-control" id="userPhone" name="userPhone" placeholder="请输入电话" />
				</div>
			</div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">身份证</label>
                <div class="col-md-9">
			    	<input type="text" class="form-control" id="userIdcard" name="userIdcard" placeholder="请输入身份证号" />
				</div>
			</div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">E-Mail</label>
                <div class="col-md-9">
			    	<input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="请输入邮箱" />
				</div>
			</div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">日期</label>
                <div class="col-md-9">
			    	<input type="text" readonly class="form-control datepicker" name="createTime"  placeholder="请输入开始日期" />
				</div>
			</div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">下拉框</label>
                <div class="col-md-9">
			    	<select class="form-control roleSelect2" name="createBy" style="width: 100%">
			    		<!-- <option selected="selected"></option> -->
					</select>
				</div>
			</div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-md-3 control-label">备注</label>
                <div class="col-md-9">
               		<textarea class="form-control" rows="3" id="remark" name="remark" placeholder="请输入备注 ..."></textarea>
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
		