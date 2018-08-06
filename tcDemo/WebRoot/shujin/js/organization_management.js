var thisURL = document.URL;    
var getval =thisURL.split('?')[1];  

var rootId = null;
var curDeptIdSelected = null;
var curPageNum = 1;

if(getval){
	var paramVal = getval.split("=")[1];
	curDeptIdSelected = paramVal;
}

$(function(){
	//显示左侧菜单 调用接口：
	initPage();
	//获取企业名称
	getMemberInfo();
	//解散部门按钮绑定事件
	$("#dismissDepartmentBtn").click(dismissDepartment);

	//点击新增部门
	$("#newDept").click(function(){
		var option = {
			width:"643px",
			height:"auto",
			title:"新建部门",
			content:$("#newDeptContent").html(),
			foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
			afterOpen:function(win){
				//此处定义打开窗口后要执行的操作
				//输入框绑定事件
				win.content.find(".leo-input").focus(function(){
					$(this).addClass("leo-input-focus");
				});
				win.content.find(".leo-input").blur(function(){
					if($(this).val() == null || $(this).val() == ""){
						$(this).removeClass("leo-input-focus");
					}
				});

				//调用接口获取职级人员数量限制
				$.ajax({
					url:ctx + "/api/enterprise/rank!getRankTypeList.do",
					dataType:"json",
					success:function(result){
						//leoAlert(JSON.stringify(result));
						//初始化左侧部门树列表
						if(result.result == "1"){
							var deptOwnerData = result.message[0];
							var deptAssistantData = result.message[1];
							var deptMemberData = result.message[2];
							//部门负责人 添加
							var doScroll = $("<div style=\"width:365px;height:112px;\">");
							var doLeftArea = $("<div class=\"left\" style=\"max-width:210px;\">");
							var doPlusBtnArea = $("<div class=\"left sticker-btn-plus\"><a class=\"icon-plus\"></a></div>");
							var doClearDiv = $("<div class=\"clear\">");
							doScroll.append(doLeftArea).append(doPlusBtnArea).append(doClearDiv);
							win.content.find("#deptOwner").append(doScroll);
							doPlusBtnArea.click(function(){
								choseEmployeeWin(0,1,function(selectedDataArr){
									//点击确定按钮后，执行以下操作
									//已选择的人员数量
									var existCount = win.content.find("#deptOwner .leo-sticker-simple.leo-sticker-simple-del").length;
									//判断选择的人员数量是否超过限制
									if(selectedDataArr.length > deptOwnerData.rank_type_maxPerson-existCount){
										leoAlert("当前职级限制可选人员" + deptOwnerData.rank_type_maxPerson + "个，本次最多还可以选择" + (deptOwnerData.rank_type_maxPerson - existCount) + "个人员");
										return false;
									} else if(selectedDataArr.length > 0 && selectedDataArr.length <= deptOwnerData.rank_type_maxPerson-existCount) {
										//将当前选择的人员显示到新增部门窗口
										for(var i = 0; i < selectedDataArr.length; i++){
											var stickerData = selectedDataArr[i];
											var deptOwnerSticker = new LeoStickerSimple({
												stickerType:"withDelBtn",
												id:stickerData.id,
												img:stickerData.img,
												title: stickerData.title,
												delBtnClick: function(e,_self){
													//alert("点击按钮");
													
													_self.simpleSticker.remove();
													//当删除人员后，要重新判断是否显示+按钮
													
													if(doLeftArea.find(".leo-sticker-simple").length < deptOwnerData.rank_type_maxPerson){
														doPlusBtnArea.show();
													}
												}
											});
											doLeftArea.append(deptOwnerSticker);
										}
										//如果达到限制人数，则隐藏+按钮
										if(doLeftArea.find(".leo-sticker-simple").length >= deptOwnerData.rank_type_maxPerson){
											doPlusBtnArea.hide();
										}
										
//										if(selectedDataArr.length == deptOwnerData.rank_type_maxPerson){
//											doPlusBtnArea.hide();
//										}
									}
								});
							});

							//部门助理添加
							var asScroll = $("<div style=\"width:365px;height:112px;\">");
							var asLeftArea = $("<div class=\"left\" style=\"max-width:210px;\">");
							var asPlusBtnArea = $("<div class=\"left sticker-btn-plus\"><a class=\"icon-plus\"></a></div>");
							var asClearDiv = $("<div class=\"clear\">");
							asScroll.append(asLeftArea).append(asPlusBtnArea).append(asClearDiv);	
							win.content.find("#deptAssistant").append(asScroll);
							asPlusBtnArea.click(function(){
								choseEmployeeWin(0,1,function(selectedDataArr){
									//点击确定按钮后，执行以下操作
									//已选择的人员数量
									var existCount = win.content.find("#deptAssistant .leo-sticker-simple.leo-sticker-simple-del").length;
									//判断选择的人员数量是否超过限制
									if(selectedDataArr.length > deptAssistantData.rank_type_maxPerson-existCount){
										leoAlert("当前职级限制可选人员" + deptAssistantData.rank_type_maxPerson + "个，本次最多还可以选择" + (deptAssistantData.rank_type_maxPerson - existCount) + "个人员");
										return false;
									} else if(selectedDataArr.length > 0 && selectedDataArr.length <= deptAssistantData.rank_type_maxPerson-existCount) {
										//将当前选择的人员显示到新增部门窗口
										for(var i = 0; i < selectedDataArr.length; i++){
											var stickerData = selectedDataArr[i];
											var assistantSticker = new LeoStickerSimple({
												stickerType:"withDelBtn",
												id:stickerData.id,
												img:stickerData.img,
												title: stickerData.title,
												delBtnClick: function(e,_self){
													//alert("点击按钮");
													
													_self.simpleSticker.remove();
													//当删除人员后，要重新判断是否显示+按钮
													
													if(asLeftArea.find(".leo-sticker-simple").length < deptAssistantData.rank_type_maxPerson){
														asPlusBtnArea.show();
													}
												}
											});
											asLeftArea.append(assistantSticker);
										}

										//如果达到限制人数，则隐藏+按钮
										if(asLeftArea.find(".leo-sticker-simple").length >= deptAssistantData.rank_type_maxPerson){
											asPlusBtnArea.hide();
										}

//										if(selectedDataArr.length == deptAssistantData.rank_type_maxPerson){
//											asPlusBtnArea.hide();
//										}
										initLeoJScroll(asScroll);
									}
								});
							});
							
							//显示部门成员
							var scroll = $("<div style=\"width:365px;height:112px;\">");
							var leftArea = $("<div class=\"left\" style=\"max-width:210px;\">");
							var plusBtnArea = $("<div class=\"left sticker-btn-plus\"><a class=\"icon-plus\"></a></div>");
							var clearDiv = $("<div class=\"clear\">");
							scroll.append(leftArea).append(plusBtnArea).append(clearDiv);
							win.content.find("#deptMember").append(scroll);
							win.content.css("padding-bottom","20px");
							plusBtnArea.click(function(){
								choseEmployeeWin(0,1,function(selectedDataArr){
									//点击确定按钮后，执行以下操作
									//已选择的人员数量
									var existCount = win.content.find("#deptMember .leo-sticker-simple.leo-sticker-simple-del").length;
									//判断选择的人员数量是否超过限制
									if(selectedDataArr.length > deptMemberData.rank_type_maxPerson-existCount){
										leoAlert("当前职级限制可选人员" + deptMemberData.rank_type_maxPerson + "个，本次最多还可以选择" + (deptMemberData.rank_type_maxPerson - existCount) + "个人员");
										return false;
									} else if(selectedDataArr.length > 0 && selectedDataArr.length <= deptMemberData.rank_type_maxPerson-existCount) {
										//将当前选择的人员显示到新增部门窗口
										for(var i = 0; i < selectedDataArr.length; i++){
											var stickerData = selectedDataArr[i];
											var memSticker = new LeoStickerSimple({
												stickerType:"withDelBtn",
												id:stickerData.id,
												img:stickerData.img,
												title: stickerData.title,
												delBtnClick: function(e,_self){
													//alert("点击按钮");
													
													_self.simpleSticker.remove();
													//当删除人员后，要重新判断是否显示+按钮
													
													if(leftArea.find(".leo-sticker-simple").length < deptMemberData.rank_type_maxPerson){
														plusBtnArea.show();
													}
												}
											});
											leftArea.append(memSticker);
										}
										//如果达到限制人数，则隐藏+按钮
										if(leftArea.find(".leo-sticker-simple").length >= deptMemberData.rank_type_maxPerson){
											plusBtnArea.hide();
										}
//										if(selectedDataArr.length == deptMemberData.rank_type_maxPerson){
//											plusBtnArea.hide();
//										}
										initLeoJScroll(scroll);
									}
								});
							});


						} else {
							leoAlert(result.message);
						}
					},
					error:function(){
						leoAlert("出错了:(");
						
					}
				});				
			}
		};
		var win = new LeoPopWin(option);
		win.open();
		win.foot.find(".cancel").click(function(){
			win.close();
		});
		win.foot.find(".confirm").click(function(){
			var right1EleArr = win.content.find("#deptOwner").find(".leo-sticker-simple.leo-sticker-simple-del");
			var right2EleArr = win.content.find("#deptAssistant").find(".leo-sticker-simple.leo-sticker-simple-del");
			var right3EleArr = win.content.find("#deptMember").find(".leo-sticker-simple.leo-sticker-simple-del");
			var right1IdArr = new Array();
			var right2IdArr = new Array();
			var right3IdArr = new Array();
			
			for(var i = 0; i < right1EleArr.length; i++){
				var eleObj = right1EleArr[i];
				right1IdArr.push($(eleObj).attr("data-id"));
			}

			for(var i = 0; i < right2EleArr.length; i++){
				var eleObj = right2EleArr[i];
				right2IdArr.push($(eleObj).attr("data-id"));
			}

			for(var i = 0; i < right3EleArr.length; i++){
				var eleObj = right3EleArr[i];
				right3IdArr.push($(eleObj).attr("data-id"));
			}

			//调用接口：/api/enterprise/department!createDepartmentWithMemberLists.do 
			$.ajax({
				url:ctx + "/api/enterprise/department!createDepartmentWithMemberLists.do?ajax=yes",
				data:{
					"department_Name" : win.content.find("input[name='department_Name']").val(),
					"superior_Department_Id" : win.content.find("input[name='superior_Department_Id']").val(),
					"right1":right1IdArr.join(","),
					"right2":right2IdArr.join(","),
					"right3":right3IdArr.join(",")
				},
				type:"post",
				dataType:"json",
				success:function(result){
					
					//初始化左侧部门树列表
					if(result.result == "1"){

						leoAlert(result.message);
						win.close();
						initPage();
					} else {
						leoAlert(result.message);
					}
				},
				error:function(){
					leoAlert("出错了:(");
					
				}
			});
		});
	});
	//点击移动员工
	$("#moveEmp").click(function(){
		var option = {
			width:"803px",
			height:"739px",
			title:"移动员工",
			content:$("#moveEmployee").html(),
			foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
			afterOpen:function(win){
				//初始化左侧下拉菜单
				//调用接口：api/enterprise/department!getDepartmentList.do
				$.ajax({
					url:ctx + "/api/enterprise/department!getDepartmentList.do",
					dataType:"json",
					success:function(result){
						if(result.result == "1"){
							//初始化左侧下拉菜单
							win.content.find("#deptLeft").leoDropdown({
								placeholder:"请选择部门",
								data:result.message,
								onChange:function(self){
									//根据所选部门ID获取员工
									getEmployeeByDeptId(self.val(),function(data){
										//初始化列表
										win.content.find("#leo-listbox-js-left").leoListbox({
											data:data
										});
									});
									//当本部门选择变化之后，如果对侧部门不为空，对侧列表刷新
									var rightDeptVal = win.content.find("#deptRight").leoDropdownValue();
									if(typeof rightDeptVal != "undefined" && rightDeptVal != null && rightDeptVal != ""){
										getEmployeeByDeptId(rightDeptVal,function(data){
											//初始化列表
											win.content.find("#leo-listbox-js-right").leoListbox({
												data:data
											});
										});
									}
									

								}
							});

							//初始化右侧下拉菜单
							win.content.find("#deptRight").leoDropdown({
								placeholder:"请选择部门",
								data:result.message,
								onChange:function(self){
									//根据所选部门ID获取员工
									getEmployeeByDeptId(self.val(),function(data){
										//初始化列表
										win.content.find("#leo-listbox-js-right").leoListbox({
											data:data
										});
									});
									//当本部门选择变化之后，如果对侧部门不为空，对侧列表刷新
									var leftDeptVal = win.content.find("#deptLeft").leoDropdownValue();
									if(typeof leftDeptVal != "undefined" && leftDeptVal != null && leftDeptVal != ""){
										getEmployeeByDeptId(leftDeptVal,function(data){
											//初始化列表
											win.content.find("#leo-listbox-js-left").leoListbox({
												data:data
											});
										});
									}
								}
							});
						} else {
							leoAlert(result.message);
						}
					},
					error:function(){
						leoAlert("出错了:(");
						
					}
				});

				
				
				//初始化列表
				win.content.find("#leo-listbox-js-left").leoListbox({
					data:[]
				});
				win.content.find("#leo-listbox-js-right").leoListbox({
					data:[]
				});
				
				win.content.find("#leo-listbox-btn-left").click(function(){
					//将右侧列表选项移动到左侧列表
					
					//移动前先检查是否选择要移动的员工所属的部门
					var fromDept = win.content.find("#deptRight").leoDropdownValue();
					if(fromDept == ""){
						leoAlert("请选择要移动员工所属的部门");
						return false;
					}
					//移动前先检查是否选择要移动到的部门
					var toDept = win.content.find("#deptLeft").leoDropdownValue()
					if(toDept == ""){
						leoAlert("请选择要移动到哪个部门");
						return false;
					}

					if(fromDept == toDept){
						leoAlert("请选择不同的部门");
						return false;
					}
					win.content.find("#leo-listbox-js-right").leoListboxMove(win.content.find("#leo-listbox-js-left"));
				});
				
				win.content.find("#leo-listbox-btn-right").click(function(){
					//将左侧列表选项移动到右侧列表
					var fromDept = win.content.find("#deptLeft").leoDropdownValue();
					if(fromDept == ""){
						leoAlert("请选择要移动员工所属的部门");
						return false;
					}
					//移动前先检查是否选择要移动到的部门
					var toDept = win.content.find("#deptRight").leoDropdownValue()
					if(toDept == ""){
						leoAlert("请选择要移动到哪个部门");
						return false;
					}

					if(fromDept == toDept){
						leoAlert("请选择不同的部门");
						return false;
					}
					win.content.find("#leo-listbox-js-left").leoListboxMove(win.content.find("#leo-listbox-js-right"));
				});
			}
		};
		var win = new LeoPopWin(option);
		win.open();
		win.foot.find(".cancel").click(function(){
			win.close();
		});
		win.foot.find(".confirm").click(function(){
			//通过判断两侧各自data-arr 和 data-arr-moved的元素数量，来确定是从哪移动到哪，从而确定移动到的部门以及员工
			var leftDept = win.content.find("#deptLeft").leoDropdownValue();
			var rightDept = win.content.find("#deptRight").leoDropdownValue();

			var leftData = win.content.find("#leo-listbox-js-left").leoListboxData();
			var leftDataMoved = win.content.find("#leo-listbox-js-left").leoListboxDataMoved();
			var rightData = win.content.find("#leo-listbox-js-right").leoListboxData();
			var rightDataMoved = win.content.find("#leo-listbox-js-right").leoListboxDataMoved();

			var memMovedIdStr = "";
			var deptIdMovedTo = "";
			//如果左侧移动后的数据少于移动前数据，说明是从左侧移动到右侧
			if(leftDataMoved.length < leftData.length){
				//获取左侧移动的人员ID
				memMovedIdStr = win.content.find("#leo-listbox-js-left").leoListboxMemberIdMoved();
				deptIdMovedTo = rightDept;
			}
			//如果右侧移动后的数据少于移动前数据，说明是从右侧移动到左侧
			if(rightDataMoved.length < rightData.length){
				//获取右侧移动的人员ID
				memMovedIdStr = win.content.find("#leo-listbox-js-right").leoListboxMemberIdMoved();
				deptIdMovedTo = leftDept;
			}
			//调用接口移动员工：/api/enterprise/departmentmember!moveMemberToDepartment.do
			if(memMovedIdStr != "" && deptIdMovedTo != ""){
				$.ajax({
					url:ctx + "/api/enterprise/departmentmember!moveMemberToDepartment.do",
					data:{
						"to_department_id" : deptIdMovedTo,
						"rank" : 0,
						"right" : memMovedIdStr
					},
					dataType:"json",
					success:function(result){
						//初始化左侧部门树列表
						if(result.result == "1"){
							leoAlert(result.message);
							win.close();
						} else {
							leoAlert(result.message);
						}
					},
					error:function(){
						leoAlert("出错了:(");
						
					}
				});
			}

			win.close();
		});
	});
	/*add by circleone 0828*/
	 $(".button_quit").click(function(){
	   		$.ajax({
            url:"/api/shop/member!logout.do?ajax=yes",
            type:"POST",
            data:{},
            dataType:"json",
            async:false,
            success:function(json){
            	console.log(json);
            	if(json.result ==1){
            		//退出登录
            		window.location.href = "/index.html";
            	}
            }
        	});
	   });
});

//页面初始化 显示左侧菜单 调用接口：/api/enterprise/department!getDepmentListForSelect.do
function initPage(){
	$.ajax({
		url:ctx + "/api/enterprise/department!getDepmentListForSelect.do",
		dataType:"json",
		success:function(result){
			//leoAlert(JSON.stringify(result));
			//初始化左侧部门树列表
			if(result.result == "1"){
				rootId = result.message.department_id;
				if(curDeptIdSelected == null){
					curDeptIdSelected = result.message.department_id;
				}
				//根据当前左侧部门菜单所选部门获取页面公司负责人、助理、部门成员数据
				getMemberByDeptIdWithPage(curDeptIdSelected,curPageNum);
				//生成左侧部门树
				$("#dept-tree").empty();
				$("#dept-tree").leoTreeMenu({
					withMemberCount:true,
					scroll:true,
					curActive:curDeptIdSelected,
					data:[result.message],
					fn:function(treeMenu){
						//生成树形菜单后，要做的事情
						//此处左侧菜单区域，需要撑开，但是树形菜单，采用了绝对定位，无法撑开父容器，需要改成相对定位
						treeMenu.css("width","205px");
						treeMenu.find(".leo-absolute-panel").css("position","relative");
						treeMenu.find(".leo-absolute-panel").css("width","224px");
						
					},
					nodeClick:function(node){
						//alert("nodeID:" + node.department_id);
						getMemberByDeptIdWithPage(node.department_id,1);
					}
				});
			} else {
				leoAlert(result.message);
			}
		},
		error:function(){
			leoAlert("出错了:(");
			
		}
	});
}
//获取企业名称
function getMemberInfo(){
	$.ajax({
		url:ctx + "/api/enterprise/enterprise!getMemberInfo.do",
		dataType:"json",
		success:function(result){
			$("#enterpriseName").text(result.enterprisename);
			$("#nickName").text(result.nickname);
		},
		error:function(){
			leoAlert("出错了:(");
			
		}
	});
}

//调用接口 获取页面负责人、助理、成员 ：/api/enterprise/department!getDepartmentWithMemberListIncludePageInfo.do
function getMemberByDeptIdWithPage(deptId,goPage){
	
	curPageNum = goPage;
	//alert("当前所选部门ID:" + curDeptIdSelected);department_id:curDeptIdSelected,
	var getUrl = ctx + "/api/enterprise/departmentmember!getMemberListByDepartmentID.do?member_list_type=facefordepartment";
	if(deptId != null){
		curDeptIdSelected = deptId;
		getUrl += "&department_id=" + curDeptIdSelected;
	}
	$.ajax({
		url:getUrl,
		data:{
			current_page:goPage
		},
		dataType:"json",
		success:function(result){
			//leoAlert(JSON.stringify(result));
			if(result.result == 1){
				//当前页
				var curPage = result.current_page;
				//总页数
				var totalPage = result.total_page;
				//清空数据
				$("#company-owner").empty();
				$("#company-owner").parent().prev().text("");
				$("#company-assistant").empty();
				$("#company-assistant").parent().prev().text("");
				$("#dept-member").empty();
				$("#dept-member").parent().prev().html($("#dept-member").parent().prev().find("i").prop("outerHTML"));

				//公司负责人数据
				if(result.right1){
					var leader = result.right1.member_list;
					
					//设置职级名称
					$("#company-owner").parent().prev().text(result.right1.rank_name);

					for(var i=0; i < leader.length; i++){
						var leaderItem = leader[i];
						//除数大于1 判断行数
						var page = i/5; 
						if(leaderItem.member_no == null){
							leaderItem.member_no = "";
						}
						var sticker = new LeoSticker({
							img:leaderItem.face,
							title: leaderItem.nickname,
							subTitle: "员工编号：" + leaderItem.member_no,
							splitTop: page >= 1 ? true : false,
							splitRight: i % 5 != 4 && i != leader.length - 1 ? true : false, 
							delBtnClick: function(e){
								delEmployee(leaderItem);
							}
						});
						$("#company-owner").append(sticker);
					}
					//给对应的+按钮添加click
					var totalLimit1 = result.right1.rank_type_maxperson;
					var existCount1 = result.right1.member_list.length;
					if(existCount1 < totalLimit1) {
						$("#company-owner").next().find("a").show().unbind("click").click(function(){
							choseEmployee(result.right1,1);
						});
					} else {
						$("#company-owner").next().find("a").hide();
					}
				}
				//公司助理数据
				if(result.right2){
					var assistant = result.right2.member_list;
					
					$("#company-assistant").parent().prev().text(result.right2.rank_name);
					for(var i=0; i < assistant.length; i++){
						var assistantItem = assistant[i];
						//除数大于1 判断行数
						var page = i/5; 
						if(assistantItem.member_no == null){
							assistantItem.member_no = "";
						}
						var sticker = new LeoSticker({
							img:assistantItem.face,
							title: assistantItem.nickname,
							subTitle: "员工编号：" + assistantItem.member_no,
							splitTop: page >= 1 ? true : false,
							splitRight: i % 5 != 4 && i != assistant.length -1 ? true : false, 
							delBtnClick: function(e){
								delEmployee(assistantItem);
							}
						});
						$("#company-assistant").append(sticker);
					}

					//给对应的+按钮添加click
					var totalLimit2 = result.right2.rank_type_maxperson;
					var existCount2 = result.right2.member_list.length;
					if(existCount2 < totalLimit2) {
						$("#company-assistant").next().find("a").show().unbind("click").click(function(){
							choseEmployee(result.right2,2);
						});
					} else {
						$("#company-assistant").next().find("a").hide();
					}
				}
				//部门成员
				if(result.right3){
					var member = result.right3.member_list;
					
					$("#dept-member").parent().prev().html(result.right3.rank_name + $("#dept-member").parent().prev().find("i").prop("outerHTML"));

					//部门成员
					for(var i=0; i < member.length; i++){
						var memberItem = member[i];
						//除数大于1 判断行数
						var page = i/5; 
						if(memberItem.member_no == null){
							memberItem.member_no = "";
						}
						var sticker = new LeoSticker({
							img:memberItem.face,
							title: memberItem.nickname,
							subTitle: "员工编号：" + memberItem.member_no,
							splitTop: page >= 1 ? true : false,
							splitRight: i % 5 != 4 && i != member.length - 1 ? true : false, 
							delBtnClick: function(e){
								delEmployee(memberItem);
							}
						});
						$("#dept-member").append(sticker);
					}
					//给对应的+按钮添加click
					var totalLimit3 = result.right3.rank_type_maxperson;
					var existCount3 = result.right3.member_list.length;

					if(existCount3 < totalLimit3) {
						$("#dept-member").next().find("a").show().unbind("click").click(function(){
							choseEmployee(result.right3,0);
						});
					} else {
						$("#dept-member").next().find("a").hide();
					}
				}

				$("#dept-member").parent().prev().find("i").unbind('click').click(function(){
					//收缩时，如果人员数量超过5个，则清空，只显示5个
					//展开时，再恢复原有的人员
					if(member.length >= 5){
						if($(this).attr("class") == "icon-collapse"){
							$("#dept-member").empty();
							$(this).removeClass("icon-collapse");
							$(this).addClass("icon-collapsed");
							for(var i=0; i < 5; i++){
								var memberItem = member[i];
								//除数大于1 判断行数
								var page = i/5; 
								if(memberItem.member_no == null){
									memberItem.member_no = "";
								}
								var sticker = new LeoSticker({
									img:memberItem.face,
									title: memberItem.nickname,
									subTitle: "员工编号：" + memberItem.member_no,
									splitTop: page >= 1 ? true : false,
									splitRight: i % 5 != 4 && i != member.length - 1 ? true : false, 
									delBtnClick: function(e){
										delEmployee(memberItem);
									}
								});
								$("#dept-member").append(sticker);
							}
						} else if($(this).attr("class") == "icon-collapsed"){
							$("#dept-member").empty();
							$(this).removeClass("icon-collapsed");
							$(this).addClass("icon-collapse");
							for(var i=0; i < member.length; i++){
								var memberItem = member[i];
								//除数大于1 判断行数
								var page = i/5; 
								if(memberItem.member_no == null){
									memberItem.member_no = "";
								}
								var sticker = new LeoSticker({
									img:memberItem.face,
									title: memberItem.nickname,
									subTitle: "员工编号：" + memberItem.member_no,
									splitTop: page >= 1 ? true : false,
									splitRight: i % 5 != 4 && i != member.length - 1 ? true : false, 
									delBtnClick: function(e){
										delEmployee(memberItem);
									}
								});
								$("#dept-member").append(sticker);
							}
						}
					}
				});

				//部门成员分页
				$("#dept-member-pagination").leoPagination({
					totalPage:totalPage,
					curPage:curPage,
					goPage:function(num){

						getMemberByDeptIdWithPage(curDeptIdSelected,num);
					}
				});

			} else {
				leoAlert(result.message);
			}
			
		},
		error:function(){
			leoAlert("出错了:(");
			
		}
	});
}

//获取待分配部门的人员
function getMemberUnallocated(page,win){
	
	$.ajax({
		url:ctx + "/api/enterprise/department!getDepartmentWithMemberListIncludePageInfo.do",
		data:{
			department_id:0,
			current_page:page
		},
		dataType:"json",
		success:function(result){
			//leoAlert(JSON.stringify(result));
			if(result.result == 1){
				//部门负责人数据
				var leader = result.right1;
				//部门助理数据
				var assistant = result.right2;
				//部门成员
				var member = result.right3;
				//当前页
				var curPage = result.current_page;
				//总页数
				var totalPage = result.total_page;
	
				//清空数据
				$("#company-owner").empty();
				$("#company-assistant").empty();
				$("#dept-member").empty();

				for(var i=0; i < leader.length; i++){
					var leaderItem = leader[i];
					//除数大于1 判断行数
					var page = i/5; 
					
					var sticker = new LeoSticker({
						img:leaderItem.face,
						title: leaderItem.nickname,
						subTitle: "员工编号：" + leaderItem.member_id,
						splitTop: page >= 1 ? true : false,
						splitRight: i % 5 != 4 && i != leader.length - 1 ? true : false, 
						delBtnClick: function(e){
							delEmployee(leaderItem);
						}
					});
					$("#company-owner").append(sticker);
				}
				for(var i=0; i < assistant.length; i++){
					var assistantItem = assistant[i];
					//除数大于1 判断行数
					var page = i/5; 
					
					var sticker = new LeoSticker({
						img:assistantItem.face,
						title: assistantItem.nickname,
						subTitle: "员工编号：" + assistantItem.member_id,
						splitTop: page >= 1 ? true : false,
						splitRight: i % 5 != 4 && i != assistant.length -1 ? true : false, 
						delBtnClick: function(e){
							delEmployee(assistantItem);
						}
					});
					$("#company-assistant").append(sticker);
				}
				//部门成员
				for(var i=0; i < member.length; i++){
					var memberItem = member[i];
					//除数大于1 判断行数
					var page = i/5; 
					
					var sticker = new LeoSticker({
						img:memberItem.face,
						title: memberItem.nickname,
						subTitle: "员工编号：" + memberItem.member_id,
						splitTop: page >= 1 ? true : false,
						splitRight: i % 5 != 4 && i != member.length - 1 ? true : false, 
						delBtnClick: function(e){
							delEmployee(memberItem);
						}
					});
					$("#dept-member").append(sticker);
				}
				//部门成员分页
				if(totalPage > 1){
					
				}

			}
			
		},
		error:function(){
			leoAlert("出错了:(");
			
		}
	});
}
//根据部门id获取人员
function getEmployeeByDeptId(deptId, success){
	$.ajax({
		url:ctx + "/api/enterprise/departmentmember!getMemberListByDepartmentID.do",
		data:{"department_id" : deptId},
		dataType:"json",
		success:function(result){
			//初始化左侧部门树列表
			if(result.result == "1"){
				success(result.message);
			} else {
				leoAlert(result.message);
			}
		},
		error:function(){
			leoAlert("出错了:(");
		}
	});
}

//删除员工
function delEmployee(member){
	var option = {
		title:"提示",
		content:"是否将此员工删除？",
		foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
		afterOpen:function(){
			
		}
	};
	var win = new LeoPopWin(option);
	win.open();
	win.foot.find(".cancel").click(function(){
		win.close();
	});
	win.foot.find(".confirm").click(function(){
		//调用接口将员工移除到未分配部门
		$.ajax({
			url:ctx + "/api/enterprise/departmentmember!deleteMemberFromDepartment.do",
			data:{
				"relation_id" : member.relation_id
			},
			dataType:"json",
			success:function(result){
				leoAlert(result.message);
				initPage();
				//getMemberByDeptIdWithPage(curDeptIdSelected,curPageNum);
			},
			error:function(){
				leoAlert("出错了:(");
			}
		});
		win.close();
	});
}

//点击选择部门按钮弹出窗口
function chooseDeptWin(btn){
	var idInput = $(btn).prev().prev();
	var textInput = $(btn).prev();
	//创建盒子
	var treeBox = $("<div class=\"leo-box\">");
	treeBox.css({"width":"242px","height":"331px","margin-left":"137px","margin-top":"5px","padding-top":"17px"});
	//生成部门树
	var deptTreeDiv = $("<div>");
	
	var option = {
		width:"505px",
		height:"620px",
		title:"部门选择列表",
		content:"",
		foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
		afterOpen:function(win){
			//生成部门树
			//调用接口：api/enterprise/department!getDepmentListForSelect.do
			$.ajax({
				url:ctx + "/api/enterprise/department!getDepmentListForSelect.do",
				dataType:"json",
				success:function(result){
					
					//初始化部门树列表
					if(result.result == "1"){
						var deptTree = deptTreeDiv.leoTreeMenu({
							data:[result.message],
							fn:function(){
								//生成树形菜单后，要做的事情
								
							}
						});
						treeBox.append(deptTree);
						win.content.append(treeBox);
						initLeoJScroll(deptTree.find(".leoJScroll"));
					} else {
						leoAlert(result.message);
					}
				},
				error:function(){
					leoAlert("出错了:(");
					
				}
			});

			
			
		}
	};
	var win = new LeoPopWin(option);
	win.open();
	win.foot.find(".cancel").click(function(){
		win.close();
	});
	win.foot.find(".confirm").click(function(){
		//alert("当前选择的部门是：" + deptTreeDiv.leoTreeMenuText());
		idInput.val(deptTreeDiv.leoTreeMenuValue());
		textInput.val(deptTreeDiv.leoTreeMenuText());
		win.close();
		
	});
	win.content.css("padding-bottom","60px");
}
//人员选择,点击+按钮调用该方法
function choseEmployee(data,rankType){
	var rankId = data.rank_id;
	var totalLimit = data.rank_type_maxperson;
	var existCount = data.member_list.length;//$(this).parent().prev().find(".leo-sticker").length;
	if(existCount < totalLimit){
		//0 待分配部门, 1 当前页
		choseEmployeeWin(0,1,function(selectedDataArr){
			//点击确定按钮后，执行以下操作

			//判断选择的人员数量是否只有一个
			if(selectedDataArr.length > (totalLimit - existCount)){
				leoAlert("当前职级限制可选人员" + totalLimit + "个，本次最多还可以选择" + (totalLimit - existCount) + "个人员");
				return false;
			} else if(selectedDataArr.length > 0 && selectedDataArr.length <= (totalLimit - existCount)) {
				var idArr = new Array();
				
				for(var i = 0; i < selectedDataArr.length; i++){
					idArr.push(selectedDataArr[i].id);
				}

				//点击确定后，调用接口，将选择的人员添加到当前部门对应的职级中
				//alert("rankId:" + rankId);
				$.ajax({
					url:ctx + "/api/enterprise/departmentmember!moveMemberToDepartment.do?department_id="+curDeptIdSelected+"&rank_id="+rankId+"&right="+idArr.join(","),
					//url:ctx + "/api/enterprise/departmentmember!moveMemberToDepartment.do?department_id="+curDeptIdSelected+"&rank_id="+rankType+"&right="+idArr.join(","),
					
					/*
					data:{
						department_id:curDeptIdSelected,
						rank_id:data.rank_id,
						right:idArr.join(",")
					},
					*/
					//dataType:"json",
					success:function(result){
						//leoAlert(JSON.stringify(result));
						//调完接口后，刷新页面，重新获取人员数据
						initPage();
						//getMemberByDeptIdWithPage(curDeptIdSelected,1);
					},
					error:function(){
						leoAlert("添加人员确定后出错了:(");
					}
				});
				
			}
		});
	}
}
//弹出人员选择窗口
function choseEmployeeWin(deptId,page,callback){
	var option = {
		width:"723px",
		maxHeight:"800px",
		title:"人员选择",
		content:$("#choseEmployee").html(),
		foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
		afterOpen:function(win){
			win.content.css("padding-bottom","11px");
			//对一键全选按钮绑定事件
			win.content.find("#selectAllByOneKey").click(function(){
				var selectAllByOneKeyBtn = $(this);
				var oneKeyWin = new LeoPopWin({
					title:"提示",
					content:"是否对员工一键全选？",
					foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
					afterOpen:function(){
						
					}
				});
				oneKeyWin.open();
				oneKeyWin.foot.find(".cancel").click(function(){
					oneKeyWin.close();
				});
				oneKeyWin.foot.find(".confirm").click(function(){
					//alert("全选");
					win.content.find("#choseEmployeeLeoStickerList").leoStickerListSelectAll();
					oneKeyWin.close();
				});
			});
			//初始化搜索框
			var searchBoxObj = win.content.find("#choseEmployeeSearchBox");
			searchBoxObj.leoSearchbox({
				width:"300px",
				name:"username",
				search:function(input){
					searchEmployee(input.val(),win,1);
				}
			});
			searchEmployee(searchBoxObj.leoSearchboxValue(),win,1);
		}
	};
	var empWin = new LeoPopWin(option);
	empWin.open();
	empWin.foot.find(".cancel").click(function(){
		empWin.close();
	});
	empWin.foot.find(".confirm").click(function(){
		//获取已选择的人员
		if(callback && typeof callback == "function"){
			var selectedDataArr = empWin.content.find("#choseEmployeeLeoStickerList").leoStickerListSelectedData();
			callback(selectedDataArr);
		}
		empWin.close();
	});
}

//人员选择窗口调用接口获取人员
function searchEmployee(keyWord,win,page){
	/*
		调用接口获取人员数据：  /api/enterprise/department!getDepartmentWithMemberListIncludePageInfo.do
		参数 department_id 查询全部：-1，未分配部门：0
	*/
	var getMemUrl = ctx + "/api/enterprise/departmentmember!getMemberListByDepartmentID.do?member_list_type=faceforselect";
	if(keyWord != ""){
		getMemUrl += "&searchValue=" + keyWord;
	}
	$.ajax({
		url:getMemUrl,
		data:{
			//department_id:deptId,
			current_page:page
		},
		dataType:"json",
		success:function(result){
			//leoAlert(JSON.stringify(result));
			if(result.result == "1"){
				var data = result.member_list;
				var employeePage = $("<div>");
				win.content.find("#choseEmployeeLeoStickerList").leoStickerList({
					selectedEmpty:false,
					data:data,
					charFilter:function(c){
						var searchBoxObj = win.content.find("#choseEmployeeSearchBox")
						searchBoxObj.leoSearchboxValue(c);
						searchEmployee(searchBoxObj.leoSearchboxValue(),win,1);
					}
				});

				
				win.content.find("#choseEmployeeLeoStickerList .leo-sticker-list-content").append(employeePage);
				employeePage.leoPagination({
					totalPage:result.total_page,
					curPage:result.current_page,
					goPage:function(num){
						var searchBoxObj = win.content.find("#choseEmployeeSearchBox")
						searchEmployee(searchBoxObj.leoSearchboxValue(),win,num);
					}
				});
			} else {
				leoAlert(result.message);
			}
		},
		error:function(){
			leoAlert("出错了:(");
		}
	});
}

function choseDeptEmployeeWin(deptId,page,callback){
	var option = {
		width:"723px",
		maxHeight:"800px",
		title:"人员选择",
		content:$("#choseEmployee").html(),
		foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
		afterOpen:function(win){
			win.content.css("padding-bottom","11px");
			//对一键全选按钮绑定事件
			win.content.find("#selectAllByOneKey").click(function(){
				var selectAllByOneKeyBtn = $(this);
				var oneKeyWin = new LeoPopWin({
					title:"提示",
					content:"是否对员工一键全选？",
					foot:"<button class=\"cancel leo-btn-gradient-light leo-btn-radius-lg leo-btn-lg\">取消</button><button class=\"confirm leo-btn-gradient leo-btn-radius-lg leo-btn-lg\" style=\"margin-left:47px;\">确定</button>",
					afterOpen:function(){
						
					}
				});
				oneKeyWin.open();
				oneKeyWin.foot.find(".cancel").click(function(){
					oneKeyWin.close();
				});
				oneKeyWin.foot.find(".confirm").click(function(){
					//alert("全选");
					win.content.find("#choseEmployeeLeoStickerList").leoStickerListSelectAll();
					oneKeyWin.close();
				});
			});
			//初始化搜索框
			win.content.find("#choseEmployeeSearchBox").leoSearchbox({
				width:"300px",
				name:"username"
			});

			/*
				调用接口获取人员数据：  /api/enterprise/department!getDepartmentWithMemberListIncludePageInfo.do
				参数 department_id 查询全部：-1，未分配部门：0
			*/
			$.ajax({
				url:ctx + "/api/enterprise/department!getDepartmentWithMemberListIncludePageInfo.do",
				data:{
					department_id:deptId,
					current_page:page
				},
				dataType:"json",
				success:function(result){
					//leoAlert(JSON.stringify(result));
					if(result.result == "1"){
						var data = result.right3;
						win.content.find("#choseEmployeeLeoStickerList").leoStickerList({
							data:data
						});

					}
				},
				error:function(){
					leoAlert("出错了:(");
				}
			});
		}
	};
	var empWin = new LeoPopWin(option);
	empWin.open();
	empWin.foot.find(".cancel").click(function(){
		empWin.close();
	});
	empWin.foot.find(".confirm").click(function(){
		//获取已选择的人员
		if(callback && typeof callback == "function"){
			var selectedDataArr = empWin.content.find("#choseEmployeeLeoStickerList").leoStickerListSelectedData();
			callback(selectedDataArr);
		}
		empWin.close();
	});
}
//部门解散
function dismissDepartment(){
	if(curDeptIdSelected == rootId){
		leoAlert("主单位无法解散！");
		return false;
	}
	$.ajax({
		url:ctx + "/api/enterprise/department!dismissDepartment.do?department_id="+curDeptIdSelected,
		dataType:"json",
		success:function(result){
			leoAlert(result.message);
			
			if(result.result == "1"){
				//如果成功，则刷新页面
				curDeptIdSelected = null;
				initPage();
			}
		},
		error:function(){
			leoAlert("出错了:(");
			
		}
	});
}
