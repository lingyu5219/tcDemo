$(function () {
	var tableOption = {
		//ajax查询数据的http请求url
		queryUrl : basePath + "system/queryMenuList",
		//ajax删除数据的http请求url
		delUrl : basePath + "system/delMenu",
		//增加页面
		addPageUrl : basePath + 'forward?page=system/menuAdd',
		//ajax增加数据的http请求url
		addUrl : basePath + "system/addMenu",
		//修改页面
		updatePageUrl : basePath + 'forward?page=system/menuModify',
		//ajax修改数据的http请求url
		updateUrl : basePath + "system/updateMenu",
		//查看页面
		detailPageUrl : basePath + 'forward?page=system/menuDetail',
		//Table对象
		table : $('#dataListTable'),
		//查询表单Form对象
		form : $("#queryForm"),
		//增加功能的表单formID
		addFormId : "addForm",
		//修改功能的表单formID
		updateFormId : "updateForm",
		//查看功能的表单formID
		detailFormId : "detailForm",
		//表格列
		columns : [//对应thead里面的序列
	        {"data":null,width:"20px"},
	        {"data":'moduleName'},
	        {"data":'menuId',visible:false},
	        {"data":'parentMenuName',visible:false},
	        {"data":'menuName'},
	        {"data":'location',className:'hidden-xs'},
	        {"data":'isFork',className:'hidden-xs',
	        	"render":function(data,type,full,callback) {
	        		return data == 1 ? "枝干" : "叶子";
	            }
	        },
	        {"data":'userName',visible:false},
	        {"data":'createTime',visible:false,
	        	"render":function(data,type,full,callback) {
	        		return full.createTime = data.substr(0,19);
	            }
	        },
	        {"data":null}
	    ],
		//操作按钮所在列
		operBtnColumn : 9
	};
	//初始化表格控件
	var dataTable = initDataTable(tableOption);
    
	/***************初始化查询条件模块下拉框控件******************/
	initBasicSelect2({
		url: basePath + 'system/queryModule',
		callback: function(data){
        	var result = $.map(data, function (obj) {
	    		//select2控件option选项的value是id值，显示的文本是text值，所以需要将各功能实际的ID和显示的文本值，分别赋给id和text
	    		//本功能中是讲userId对应赋值给id, userName赋值给text，此处需要各自按实际情况修改
	    		obj.id = obj.moduleId;
				obj.text = obj.moduleName;
				
				return obj;
    		});
        	$("select.moduleIdSelect2").select2({data:result});
        }
	});
	
    //查询按钮
    $("#btn-query").on("click", function () {
        dataTable.draw(true);//查询后不需要保持分页状态，回首页
    });
    
    //增加
    $("#btn-add").on("click", function () {
    	var jcAdd = addData(tableOption,
    		//以下2个方法可以自定义
    		function(){
	    		//获取表单数据，此处可自行获取表单数据
	        	var param = formToJson($("#" +tableOption.addFormId));
	        	return param;
	    	},
	    	//增加成功后的回调函数
	    	function(data){
	    		if(data.status == 1){
                	//刷新结果列表
            		dataTable.draw(true);
                }
	    		//提示信息
            	tcConfirm(data.info,"是否返回？",function(){
            		jcAdd.close();
            	});
	    	},
	    	//窗口打开后，初始化操作，可自定义初始化内容
	    	function(content){
	    		/***************初始化模块下拉框控件******************/
        		initBasicSelect2({
        			url: basePath + 'system/queryModule',
        			callback: function(data){
                    	var result = $.map(data, function (obj) {
    			    		//select2控件option选项的value是id值，显示的文本是text值，所以需要将各功能实际的ID和显示的文本值，分别赋给id和text
    			    		//本功能中是讲userId对应赋值给id, userName赋值给text，此处需要各自按实际情况修改
    			    		obj.id = obj.moduleId;
							obj.text = obj.moduleName;
							
							return obj;
			    		});
                    	content.find("select.moduleIdSelect2").select2({data:result});
                    }
        		});
	    	}
	    	
    	);
    });
    
    
    //删除
    tableOption.table.on("click",".delRow",function() {
    	//要删除那一行数据对象
        var item = dataTable.row($(this).closest('tr')).data();
        //向服务器发送删除请求的参数，使用post方式
        var params = {menuId:item.menuId};
        //调用删除方法，向服务器发送请求
        delDataTableItem(dataTable,tableOption,params,function(data){
        	if(data.status == 1){
            	//dataTable.ajax.reload();
            	dataTable.draw(true);
            }
            tcAlert(data.info, 6000);
        });
    });
    
    
    
    //修改
    tableOption.table.on("click",".editRow",function() {
    	//要修改哪一行数据对象
        var item = dataTable.row($(this).closest('tr')).data();
        var jcUpdate = updateData(tableOption,item,
        	//以下三个回掉函数可自定义
        	//此方法在窗口加载内容完成后调用，在此方法中，可执行一些初始化的操作
    		function(updateForm,item,content){
        		//此处代码可自定义，自定义实现数据回显，也可使用以下fillForm函数自动回显数据
        		fillForm(updateForm,item);
        		/***************初始化模块下拉框控件******************/
        		initBasicSelect2({
        			url: basePath + 'system/queryModule',
        			callback: function(data){
                    	var result = $.map(data, function (obj) {
    			    		//select2控件option选项的value是id值，显示的文本是text值，所以需要将各功能实际的ID和显示的文本值，分别赋给id和text
    			    		//本功能中是讲userId对应赋值给id, userName赋值给text，此处需要各自按实际情况修改
    			    		obj.id = obj.moduleId;
							obj.text = obj.moduleName;
							
							return obj;
			    		});
                    	content.find("select.moduleIdSelect2").select2({data:result});
                		content.find("select.moduleIdSelect2").val(item.moduleId).trigger('change');
                    }
        		});
        	},
        	function(){
        		//获取修改表单数据
        		var param = formToJson($("#" + tableOption.updateFormId));
        		return param;
        	},
        	function(data){
        		//修改成功后提示信息
        		if(data.status == 1){
                	//刷新结果列表
            		dataTable.draw(true);
                }
	    		//提示信息
            	tcConfirm(data.info,"是否返回？",function(){
            		jcUpdate.close();
            	});
        	}
        );
    });
    
    //查看
    tableOption.table.on("click",".detailRow",function() {
    	//要查看哪一行数据对象
        var item = dataTable.row($(this).closest('tr')).data();
        var jcDetail = detailData(tableOption,item,function(detailForm,item){
        	//此处可自定义，也可使用以下默认的fillForm函数自动回显数据
        	fillForm(detailForm,item);
        })
    });
});