var LeoSticker = function(option){
	
	var leoStickerWrap = $("<div class=\"leo-sticker\">");
	var img = $("<img>");
	if(option.img && option.img != ""){
		img.attr("src",option.img);
	} else {
		img.attr("src",ctx + "/themes/yconsume/images/default_face.jpg");
	}
	var title = $("<div class=\"leo-sticker-title font-lg gray\">");
	title.text(option.title);
	var subTitle = $("<div class=\"leo-sticker-subtitle font-xs gray-light\">");
	subTitle.text(option.subTitle);
	var btn = $("<a class=\"leo-sticker-btn leo-btn-gradient leo-btn-small leo-btn-radius-lg\">删除</a>");
	if(option.delBtnClick && typeof option.delBtnClick == "function"){
		btn.click(function(e){
			option.delBtnClick(e);
		});
	}
	
	leoStickerWrap.append(img);
	leoStickerWrap.append(title);
	leoStickerWrap.append(subTitle);
	leoStickerWrap.append(btn);
	//此处需要判断当前头像所在位置，是否需要添加顶部/右部分割线
	if(option.splitTop){
		var leoStickerSplitTop = $("<div class=\"leo-sticker-split-top\"></div>");
		leoStickerWrap.append(leoStickerSplitTop);
	}
	
	if(option.splitRight){
		var leoStickerSplitRight = $("<div class=\"leo-sticker-split-right\"></div>");
		leoStickerWrap.append(leoStickerSplitRight);
	}
	
	if(option.noHover){
		return leoStickerWrap;
	}

	leoStickerWrap.mouseover(function(){
		$(this).addClass("leo-sticker-hover");
		$(this).find(".leo-sticker-btn").css("display","block");
		
		if($(this).find(".leo-sticker-split-top").css("display") != "none"){
			$(this).find(".leo-sticker-split-top").css("display","none");
		}
		if($(this).find(".leo-sticker-split-right").css("display") != "none"){
			$(this).find(".leo-sticker-split-right").css("display","none");
		}
	});
	leoStickerWrap.mouseout(function(){
		$(this).removeClass("leo-sticker-hover");
		$(this).find(".leo-sticker-btn").css("display","none");
		
		if($(this).find(".leo-sticker-split-top").css("display") == "none"){
			$(this).find(".leo-sticker-split-top").css("display","block");
		}
		if($(this).find(".leo-sticker-split-right").css("display") == "none"){
			$(this).find(".leo-sticker-split-right").css("display","block");
		}
	});
	return leoStickerWrap;
}

var LeoStickerSimple = function(option){
	var _self = this;
	var simpleSticker = $("<div>");
	_self.simpleSticker = simpleSticker;
	_self.option = option;
	simpleSticker.attr("data-id",option.id);
	simpleSticker.attr("data-item",JSON.stringify(option));
		
	var img = $("<img>");
	if(option.img && option.img != ""){
		img.attr("src",option.img);
	} else {
		img.attr("src",ctx + "/themes/yconsume/images/default_face.jpg");
	}
	
	var title = $("<div class=\"leo-sticker-simple-title\">");
	title.text(option.title);
	
	var delBtn = $("<a>");
	if(option.delBtnClick && typeof option.delBtnClick == "function"){
		delBtn.click(function(e){
			option.delBtnClick(e,_self);
		});
	}
	
	simpleSticker.append(img).append(title).append(delBtn);
	
	var stickerFade = $("<div class=\"leo-sticker-simple-fade\">");
	simpleSticker.append(stickerFade);

	switch(option.stickerType){
		case "withDelBtn": //右上角带有删除按钮
			simpleSticker.addClass("leo-sticker-simple leo-sticker-simple-del");
			break;
		case "selected": //已选中状态
			simpleSticker.addClass("leo-sticker-simple leo-sticker-simple-selected");
			break;
		case "hover": //鼠标经过状态
			simpleSticker.addClass("leo-sticker-simple leo-sticker-simple-hover");
			
			break;
		default:
			simpleSticker.addClass("leo-sticker-simple");
			simpleSticker.click(function(e){
				if(simpleSticker.attr("class").indexOf("leo-sticker-simple-selected") <= 0){
//						if(simpleSticker.find(".leo-sticker-simple-fade").length <= 0){
//							var stickerFade = $("<div class=\"leo-sticker-simple-fade\">");
//							simpleSticker.append(stickerFade);
//						} else {
//							simpleSticker.find(".leo-sticker-simple-fade").remove();
//						}
					if(simpleSticker.attr("class").indexOf("leo-sticker-simple-hover") > 0){
						simpleSticker.removeClass("leo-sticker-simple-hover");
					}
					simpleSticker.addClass("leo-sticker-simple-selected");
					
				}
				
			});
			break;
	}
	
	simpleSticker.mouseover(function(){
		if($(this).attr("class") == "leo-sticker-simple"){
			$(this).addClass("leo-sticker-simple-hover");
		}
	});
	
	simpleSticker.mouseout(function(){
		if($(this).attr("class").indexOf("leo-sticker-simple-hover") > 0){
			$(this).removeClass("leo-sticker-simple-hover");
		}
	});
	
	if(option.click && typeof option.click == "function"){
		simpleSticker.click(function(e){
			option.click(e,_self);
		});
	}
	
	return simpleSticker;
}


$.fn.extend({
	leoSticker : function(option){
		
		var leoStickerWrap = $(this);
		leoStickerWrap.addClass("leo-sticker");
		var img = $("<img>");
		if(option.img && option.img != ""){
			img.attr("src",option.img);
		} else {
			img.attr("src",ctx + "/themes/yconsume/images/default_face.jpg");
		}
		var title = $("<div class=\"leo-sticker-title font-lg gray\">");
		title.text(option.title);
		var subTitle = $("<div class=\"leo-sticker-subtitle font-xs gray-light\">");
		subTitle.text(option.subTitle);
		var btn = $("<a class=\"leo-sticker-btn leo-btn-gradient leo-btn-small leo-btn-radius-lg\">删除</a>");
		if(option.delBtnClick && typeof option.delBtnClick == "function"){
			btn.click(function(e){
				option.delBtnClick(e);
			});
		}
		
		leoStickerWrap.append(img);
		leoStickerWrap.append(title);
		leoStickerWrap.append(subTitle);
		leoStickerWrap.append(btn);
		//此处需要判断当前头像所在位置，是否需要添加顶部/右部分割线
		if(option.splitTop){
			var leoStickerSplitTop = $("<div class=\"leo-sticker-split-top\"></div>");
			leoStickerWrap.append(leoStickerSplitTop);
		}
		
		if(option.splitRight){
			var leoStickerSplitRight = $("<div class=\"leo-sticker-split-right\"></div>");
			leoStickerWrap.append(leoStickerSplitRight);
		}
		
		leoStickerWrap.mouseover(function(){
			$(this).addClass("leo-sticker-hover");
			$(this).find(".leo-sticker-btn").css("display","inline-block");
			
			if($(this).find(".leo-sticker-split-top").css("display") != "none"){
				$(this).find(".leo-sticker-split-top").css("display","none");
			}
			if($(this).find(".leo-sticker-split-right").css("display") != "none"){
				$(this).find(".leo-sticker-split-right").css("display","none");
			}
		});
		leoStickerWrap.mouseout(function(){
			$(this).removeClass("leo-sticker-hover");
			$(this).find(".leo-sticker-btn").css("display","none");
			
			if($(this).find(".leo-sticker-split-top").css("display") == "none"){
				$(this).find(".leo-sticker-split-top").css("display","block");
			}
			if($(this).find(".leo-sticker-split-right").css("display") == "none"){
				$(this).find(".leo-sticker-split-right").css("display","block");
			}
		});
		
		return leoStickerWrap;
	},
	
	leoStickerSimple : function(option){
		var _self = this;
		_self.option = option;
		var simpleSticker = $(this);
		_self.simpleSticker = simpleSticker;
		_self.option = option;
		simpleSticker.attr("data-id",option.id);
		simpleSticker.attr("data-item",JSON.stringify(option));
		
		var img = $("<img>");
		if(option.img && option.img != ""){
			img.attr("src",option.img);
		} else {
			img.attr("src",ctx + "/themes/yconsume/images/default_face.jpg");
		}
		
		var title = $("<div class=\"leo-sticker-simple-title\">");
		title.text(option.title);
		
		var delBtn = $("<a>");
		if(option.delBtnClick && typeof option.delBtnClick == "function"){
			delBtn.click(function(e){
				option.delBtnClick(e,_self);
			});
		}
		
		simpleSticker.append(img).append(title).append(delBtn);
		
		var stickerFade = $("<div class=\"leo-sticker-simple-fade\">");
		simpleSticker.append(stickerFade);

		switch(option.stickerType){
			case "withDelBtn": //右上角带有删除按钮
				simpleSticker.addClass("leo-sticker-simple leo-sticker-simple-del");
				break;
			case "selected": //已选中状态
				simpleSticker.addClass("leo-sticker-simple leo-sticker-simple-selected");
				//simpleSticker.attr("data-selected","true");
				break;
			case "hover": //鼠标经过状态
				simpleSticker.addClass("leo-sticker-simple leo-sticker-simple-hover");
				
				break;
			default:
				simpleSticker.addClass("leo-sticker-simple");
				simpleSticker.click(function(e){
					if(simpleSticker.attr("class").indexOf("leo-sticker-simple-selected") <= 0){
//						if(simpleSticker.find(".leo-sticker-simple-fade").length <= 0){
//							var stickerFade = $("<div class=\"leo-sticker-simple-fade\">");
//							simpleSticker.append(stickerFade);
//						} else {
//							simpleSticker.find(".leo-sticker-simple-fade").remove();
//						}
						if(simpleSticker.attr("class").indexOf("leo-sticker-simple-hover") > 0){
							simpleSticker.removeClass("leo-sticker-simple-hover");
						}
						simpleSticker.addClass("leo-sticker-simple-selected");
						
					}
					
				});
				break;
		}
		
		simpleSticker.mouseover(function(){
			if($(this).attr("class") == "leo-sticker-simple"){
				$(this).addClass("leo-sticker-simple-hover");
			}
		});
		
		simpleSticker.mouseout(function(){
			if($(this).attr("class").indexOf("leo-sticker-simple-hover") > 0){
				$(this).removeClass("leo-sticker-simple-hover");
			}
		});
		
		if(option.click && typeof option.click == "function"){
			simpleSticker.click(function(e){
				option.click(e,_self);
			});
		}
		
		return simpleSticker;
	},
	
	leoStickerList : function(option){
		var stickerList = $(this);
		stickerList.addClass("leo-sticker-list");
		stickerList.attr("data-arr",JSON.stringify(option.data));
		//判断是否清空已选数据，默认清空
		//如果不清空已选数据
		//var selectedPanel = stickerList.find(".leo-sticker-list-selected");
		//获取已选数据
		var selectedData = stickerList.leoStickerListSelectedData();
		/*
		if(typeof option.selectedEmpty != "undefined" && !option.selectedEmpty && selectedPanel.length > 0 && selectedData.length > 0){
			selectedIdArr = ids.split(",");
		} else {
		*/	
		//创建已选区域面板
		var selectedPanel = $("<div class=\"leo-panel leo-sticker-list-selected\"><div class=\"leo-title\">已选</div><div class=\"leo-content leoJScroll\"></div></div>");
		stickerList.empty();

		//创建内容面板
		var content = $("<div class=\"leo-sticker-list-content\">");
		
		//创建字母list
		var ul = $("<ul>");
		for(var i = 65; i < 91; i++){
			var li = $("<li>");
			var a = $("<a>");
			a.text(String.fromCharCode(i));

			a.click(function(){
				//$(this).addClass("active");
				var c = $(this).text().toUpperCase();
				if(option.charFilter && typeof option.charFilter == "function"){
					option.charFilter(c);
				}
				/*
				var filterData = new Array();
				//根据当前点击的字母，进行数据筛选，然后重新渲染
				//对所有数据进行筛选
				for(var i = 0; i < option.data.length; i++){
					var dataItem = option.data[i];
					var namePinyin = pinyinUtil.getFirstLetter(dataItem.nickname);
					if(namePinyin != null && namePinyin != "" && namePinyin.length > 0){
						var firstLetter = namePinyin.substr(0,1).toUpperCase();
						if (firstLetter == c){
							filterData.push(dataItem);

						}
					}
				}
				//根据数据重新渲染头像
				createSticker(filterData,content,selectedPanel);
				*/

			});

			li.append(a);
			ul.append(li);
		}
		stickerList.append(ul).append(content).append(selectedPanel);
		//根据数据创建头像
		createSticker(option.data,content,selectedPanel);

		//将不在当前新的sticker列表中的已选sticker，重新生成放到已选面板中
		for(var i = 0; i < selectedData.length; i++){
			var selectedItem = selectedData[i];
			if(!isExist(selectedItem.id,option.data)){
				var simpleStickerWithDel = $("<div>").leoStickerSimple({
					stickerType:"withDelBtn",
					id:selectedItem.id,
					img:selectedItem.img,
					title: selectedItem.title,
					delBtnClick: function(e,delSelf){
						//var selectedPanel = $(delSelf).parents(".leo-sticker-list-selected");
						$(delSelf).remove();
						//删除头像后，初始化滚动条
						initLeoJScroll(selectedPanel.find(".leo-content"));
						
						//每次删除，判断已选区域面板的人员是否删除完，如果删除完，则隐藏已选面板
						var selectedSticker = selectedPanel.find(".leo-sticker-simple");
						if(selectedSticker.length <= 0){
							selectedPanel.css("display","none");
						}
					}
				});
				//增加头像时，先检查是否已经生成滚动条
				if(selectedPanel.find(".jscroll-c").length > 0){
					selectedPanel.find(".jscroll-c").append(simpleStickerWithDel);
				} else {
					selectedPanel.find(".leo-content").append(simpleStickerWithDel);
				}
				//新增头像后，初始化滚动条
				initLeoJScroll(selectedPanel.find(".leo-content"));
				
				//如果已选区域面板隐藏，则设置为显示
				if(selectedPanel.css("display") == "none"){
					selectedPanel.css("display","block");
				}
			}
		}

		//初始化滚动条
		//initLeoJScroll(content);
		
		function isSelected(id,selectedData){
			for(var i = 0; i < selectedData.length; i++){
				if (id == selectedData[i].id){
					return true;
				}
			}
			return false;
		}

		function isExist(id,dataArr){
			for(var i = 0; i < dataArr.length; i++){
				if (id == dataArr[i].relation_id){
					return true;
				}
			}
			return false;
		}

		function createSticker(data,content,selectedPanel){
			//先清空内容面板
			content.empty();
			if(data && data.length > 0){
				for(var i = 0; i < data.length; i++){
					var stickerData = data[i];
					var simpleSticker = $("<div>");
					
					simpleSticker.leoStickerSimple({
						stickerType: stickerData.selected ? "selected" : "",
						id:stickerData.relation_id,
						img:stickerData.face,
						title: stickerData.nickname,
						click:function(e,self){
							//判断是否已经选中
							if($(self).attr("data-selected") != "true"){
								//选中之后，将该头像放入已选区域
								var simpleStickerWithDelBtn = $("<div>").leoStickerSimple({
									stickerType:"withDelBtn",
									id:self.option.id,
									img:self.option.img,
									title: self.option.title,
									delBtnClick: function(e,delSelf){
										//var selectedPanel = $(delSelf).parents(".leo-sticker-list-selected");
										$(delSelf).remove();
										$(self).removeClass("leo-sticker-simple-selected");
										$(self).attr("data-selected","false");
										//删除头像后，初始化滚动条
										initLeoJScroll(selectedPanel.find(".leo-content"));
										
										//每次删除，判断已选区域面板的人员是否删除完，如果删除完，则隐藏已选面板
										var selectedSticker = selectedPanel.find(".leo-sticker-simple");
										if(selectedSticker.length <= 0){
											selectedPanel.css("display","none");
										}
									}
								});
								//增加头像时，先检查是否已经生成滚动条
								if(selectedPanel.find(".jscroll-c").length > 0){
									selectedPanel.find(".jscroll-c").append(simpleStickerWithDelBtn);
								} else {
									selectedPanel.find(".leo-content").append(simpleStickerWithDelBtn);
								}
								//新增头像后，初始化滚动条
								initLeoJScroll(selectedPanel.find(".leo-content"));
								$(self).attr("data-selected","true");
								//如果已选区域面板隐藏，则设置为显示
								if(selectedPanel.css("display") == "none"){
									selectedPanel.css("display","block");
								}
								
							}
							
						}
					});
					content.append(simpleSticker);
					//如果当前sticker已经在已选面板中，则让当前sticker触发click，处于选中装填
					if(isSelected(stickerData.relation_id, selectedData)){
						simpleSticker.click();
					}
				}
				content.append($("<div class=\"clear\">"));
			}
		}

		return stickerList;
	},
	
	leoStickerListSelectedCount:function(){
		return $(this).find(".leo-sticker-list-selected").find(".leo-sticker-simple.leo-sticker-simple-del").length;
	},

	leoStickerListSelectedIdStr:function(){
		var idArr = new Array();
		var dataArr = $(this).leoStickerListSelectedData();
		for(var i = 0; i < dataArr.length; i++){
			idArr.push(dataArr[i].id);
		}
		return idArr.join(",");
	},

	leoStickerListSelectedData:function(){
		var dataArr = new Array();
		var selectedStickers = $(this).find(".leo-sticker-list-selected").find(".leo-sticker-simple.leo-sticker-simple-del");
		selectedStickers.each(function(){
			dataArr.push(JSON.parse($(this).attr("data-item")));
		});
		return dataArr;
	},

	leoStickerListSelectAll:function(){
		var stickerEles = $(this).find(".leo-sticker-list-content").find(".leo-sticker-simple");
		var selectedPanel = $(this).find(".leo-sticker-list-selected");
		stickerEles.each(function(){
			var curSticker = $(this);
			if(curSticker.attr("data-selected") != "true"){
				//设置当前人员选中状态
				if(curSticker.attr("class").indexOf("leo-sticker-simple-selected") <= 0){
					curSticker.addClass("leo-sticker-simple-selected");
					
				}

				var dataItem = JSON.parse($(this).attr("data-item"));
				//选中之后，将该头像放入已选区域
				var simpleStickerWithDelBtn = $("<div>").leoStickerSimple({
					stickerType:"withDelBtn",
					id:dataItem.id,
					img:dataItem.img,
					title: dataItem.title,
					delBtnClick: function(e,delSelf){
						
						$(delSelf).remove();
						curSticker.removeClass("leo-sticker-simple-selected");
						curSticker.attr("data-selected","false");
						//删除头像后，初始化滚动条
						initLeoJScroll(selectedPanel.find(".leo-content"));
						
						//每次删除，判断已选区域面板的人员是否删除完，如果删除完，则隐藏已选面板
						var selectedSticker = selectedPanel.find(".leo-sticker-simple");
						if(selectedSticker.length <= 0){
							selectedPanel.css("display","none");
						}
					}
				});
				//增加头像时，先检查是否已经生成滚动条
				if(selectedPanel.find(".jscroll-c").length > 0){
					selectedPanel.find(".jscroll-c").append(simpleStickerWithDelBtn);
				} else {
					selectedPanel.find(".leo-content").append(simpleStickerWithDelBtn);
				}
				//新增头像后，初始化滚动条
				initLeoJScroll(selectedPanel.find(".leo-content"));
				curSticker.attr("data-selected","true");
				//如果已选区域面板隐藏，则设置为显示
				if(selectedPanel.css("display") == "none"){
					selectedPanel.css("display","block");
				}
				
			}
		});
	}

});