<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="updateForm" class="form-horizontal no-padding" role="form" method="post">
<input type="hidden" name="id"/>
	<div class="row">
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">年份</label>
                  	<div class="col-md-9">
							<select class="form-control" id="yearObj.yearId" name="yearObj.yearId">							
							</select>
				</div>
			</div>
           </div>
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">学期</label>
                  	<div class="col-md-9">
						  	<select class="form-control" id="semester.semesterId" name="semester.semesterId">					  	
						  	</select>
				</div>
			</div>
           </div>
          </div>
          <div class="row">
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">起止日期</label>
                  	<div class="col-md-9">
                    		<input type="text" readonly class=datepicker  placeholder="开始日期" id="beginTime" name="beginTime"><br>							
                    		<input type="text" readonly class="datepicker" placeholder="结束日期" id="endTime" name="endTime">								
							<div class="alert alert-danger" id="hiddenDate" style="display:none"></div>				
				</div>
			</div>
           </div>
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">班级</label>
                  	<div class="col-md-9">
						  	<select class="form-control" id="batch.batchId" name="batch.batchId">
						  		<option selected="selected" value="1">java1</option>
						  		<option value="2">java2</option>
						  		<option value="3">java3</option>
						  		<option value="4">java4</option>
						  	</select>
				</div>
			</div>
           </div>
          </div>
          <div  class="row">
	           <div class="col-sm-6">
	           	<div class="col-md-9 col-md-offset-3">
	           		<button type="button" class="btn btn-flat btn-block btn-primary btn-update">保存</button>
	           	</div>
	           </div>          
          </div>
</form>
		