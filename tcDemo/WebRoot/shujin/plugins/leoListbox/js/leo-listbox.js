Array.prototype.removeByValue = function(val) {
  for(var i=0; i<this.length; i++) {
    if(this[i] == val) {
      this.splice(i, 1);
      break;
    }
  }
}

$.fn.extend({
	leoListbox : function(option){
		$(this).attr("data-arr",JSON.stringify(option.data));
		$(this).attr("data-arr-moved",JSON.stringify(option.data));
		var listbox = $(this);
		
		listbox.empty();

		//if (option.data && option.data.length > 0) {
			//添加css样式
			listbox.addClass("leo-listbox");
			//创建隐藏文本域，用于存储选中的列表项
			var input = $("<input type=\"hidden\"/>");
			//创建滚动条面板
			var scroll = $("<div class=\"leoJScroll\">");
			//创建ul
			var ul = $("<ul>");
			//创建列表项
			for(var i = 0; i < option.data.length; i++){
				var opt = option.data[i];
				var li = $("<li>");
				var a = $("<a>");
				a.attr("data-value",opt.member_id);
				a.text(opt.nickname);
				//给a绑定click
				a.click(function(){
					
					if($(this).attr("class") != "focus"){
						var inputVal = input.val();
						if (inputVal != null && inputVal != "" && inputVal.length > 0){
							inputVal += "," + $(this).attr("data-value");
						} else {
							inputVal = $(this).attr("data-value");
						}
						input.val(inputVal);
						$(this).addClass("focus");
					} else {
						var inputVal = input.val();
						if (inputVal != null && inputVal != "" && inputVal.length > 0){
							var inputVals = inputVal.split(",");
							inputVals.removeByValue($(this).attr("data-value"));
							inputVal = inputVals.join(",");
						}
						input.val(inputVal);
						$(this).removeClass("focus");
					}
				});
				
				li.append(a);
				ul.append(li);
			}
			scroll.append(ul);
			listbox.append(input);
			listbox.append(scroll);
			//初始化滚动条
			initLeoJScroll(scroll);
		//}
		return listbox;
	},
	//获取列表中选中项的value值
	leoListboxValue : function(){
		var listbox = $(this);
		return listbox.find("input[type=\"hidden\"]").val();
	},
	//获取列表中所有选项的json数组
	leoListboxData : function(){
		return JSON.parse($(this).attr("data-arr"));
	},
	
	//获取列表中所有选项的json字符串
	leoListboxDataStr : function(){
		return $(this).attr("data-arr");
	},
	
	//获取列表中移动后所有选项的json数组
	leoListboxDataMoved : function(){
		return JSON.parse($(this).attr("data-arr-moved"));
	},
	
	//获取列表中移动后所有选项的json字符串
	leoListboxDataStrMoved : function(){
		return $(this).attr("data-arr-moved");
	},
	
	//获取移动的人员id
	leoListboxMemberIdMoved : function(){
		var memData = $(this).leoListboxData();
		var memDataMoved = $(this).leoListboxDataMoved();
		
		var memIdArr = new Array();
		out:
		for(var i = 0; i < memData.length; i++){
			
			var mem = memData[i];
			for(var j = 0; j < memDataMoved.length; j++){
				var memMoved = memDataMoved[j];
				if(mem.member_id == memMoved.member_id){
					continue out;
				}
			}
			//如果执行到此，说明该人员已经移走
			memIdArr.push(mem.member_id);
		}
		return memIdArr.join(",");
	},

	//移动列表项，将当前列表中选中的项移动到指定的列表中
	leoListboxMove : function(toListbox){
		var fromValue = $(this).leoListboxValue();
		if (typeof fromValue == "undefined" || fromValue == "") {
			new LeoPopWin({
				closeBtn:true,	
				content:"请先选择要移动的选项"
			}).open();
			return false;
		}
		var fromValues = fromValue.split(",");
		var fromValueDatas = new Array();
		var fromData = $(this).leoListboxDataMoved();
		for(var i = 0; i < fromValues.length; i++){
			var fv = fromValues[i];
			for(var j = 0; j < fromData.length; j++){
				var fd = fromData[j];
				if (fv == fd.member_id) {
					fromValueDatas.push(fd);
					fromData.removeByValue(fd);
					break;
				}
			}
		}
		var toData = toListbox.leoListboxDataMoved();
		var newData = null;
		/*if(fromValueDatas.length > toData.length){
			newData = fromValueDatas.concat(toData);
		} else {
		}*/
		newData = toData.concat(fromValueDatas);
		toListbox.leoListboxRefresh(newData);
		$(this).leoListboxRefresh(fromData);
		
		//移动完成后重新初始化两个列表的滚动条
		initLeoJScroll($(this).find(".leoJScroll"));
		initLeoJScroll(toListbox.find(".leoJScroll"));
	},
	//根据给定的数据（json数组）刷新列表
	leoListboxRefresh : function(data){
		$(this).attr("data-arr-moved",JSON.stringify(data));
		var ul = $(this).find("ul");
		var input = $(this).find("input[type=\"hidden\"]");
		ul.empty();
		input.val("");
		if (data && data.length > 0) {
			for(var i = 0; i < data.length; i++){
				var opt = data[i];
				var li = $("<li>");
				var a = $("<a>");
				a.attr("data-value",opt.member_id);
				a.text(opt.nickname);
				//给a绑定click
				a.click(function(){
					
					if($(this).attr("class") != "focus"){
						var inputVal = input.val();
						if (inputVal != null && inputVal != "" && inputVal.length > 0){
							inputVal += "," + $(this).attr("data-value");
						} else {
							inputVal = $(this).attr("data-value");
						}
						input.val(inputVal);
						$(this).addClass("focus");
					} else {
						var inputVal = input.val();
						if (inputVal != null && inputVal != "" && inputVal.length > 0){
							var inputVals = inputVal.split(",");
							inputVals.removeByValue($(this).attr("data-value"));
							inputVal = inputVals.join(",");
						}
						input.val(inputVal);
						$(this).removeClass("focus");
					}
				});
				
				li.append(a);
				ul.append(li);
			}
		}
	}
});