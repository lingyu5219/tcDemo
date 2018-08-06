<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="updateForm" class="form-horizontal no-padding" role="form" method="post">
<input type="hidden" name="id"/>
	<div class="row">
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">星期</label>
                  	<div class="col-md-9">
						<select class="form-control" id="date" name="date">
					  		<option selected="selected" value="1">星期一</option>
					  		<option value="2">星期二</option>
					  		<option value="3">星期三</option>
					  		<option value="4">星期四</option>
					  		<option value="5">星期五</option>
					  		<option value="6">星期六</option>
					  		<option value="7">星期日</option>
					  	</select>
				</div>
			</div>
           </div>
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">课程</label>
                  	<div class="col-md-9">
						<select class="form-control" id="major.majorId" name="major.majorId">
							<option value="1">Java基础</option>
							<option value="2">Java基础2</option>
							<option value="3">Java高级</option>
					  	</select>
				</div>
			</div>
           </div>
          </div>
          <div class="row">
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">周次</label>
                  	<div class="col-md-9">
						<div class="input-daterange input-group" id="datepicker">
						    <input type="text" class="form-control" id="begin" name="begin" placeholder="起始周次" oninput="weekInput(event)">
						    <span class="input-group-addon">to</span>
						    <input type="text" class="form-control" id="end" name="end" placeholder="结束周次" oninput="weekInput(event)">						
						</div>
						<div class="alert alert-danger" id="hiddenWeek" style="display:none"></div>				
					  	<input type="hidden" name="week" value="0"/>
					</div>
			</div>
           </div>
           <div class="col-sm-6">
            	<div class="form-group">
                   <label class="col-md-3 control-label">节次</label>
                  	<div class="col-md-9">
					  	<select class="form-control" id="section" name="section" multiple="multiple">
					  		<option selected="selected" value="1">1,2</option>
					  		<option value="2">3,4</option>
					  		<option value="3">5,6</option>
					  		<option value="4">7,8</option>
					  	</select>
				</div>
			</div>
           </div>
          </div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
				    <label class="col-md-3 control-label" for="classroomId">教室</label>
				    <div class="col-md-9">
					  	<select class="form-control" id="room.roomId" name="room.roomId">
					  	</select>				    
				    </div>				
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label class="col-md-3 control-label" for="teacherId">教师</label>
				    <div class="col-md-9">
					  	<select class="form-control" id="staff.staffId" name="staff.staffId">
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
		