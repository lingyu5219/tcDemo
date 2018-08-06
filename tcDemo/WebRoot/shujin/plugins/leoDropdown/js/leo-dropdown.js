$.fn.extend({
	leoDropdown:function(option){
		var scrollFlag = false;
		//创建外层div,使用相对、绝对定位
		var relativeDiv = $(this);
		relativeDiv.css("position","relative");
		relativeDiv.css("height","36px");
		var absoluteDiv = $("<div style=\"width:100%; position:absolute; top:0px; left:0px; z-index:10001;\">");
		relativeDiv.append(absoluteDiv);
		//创建div容器
		var wrap = $("<div>");
		wrap.addClass("leo-dropdown");
		//下拉框
		var p = $("<p>");
		if (option.placeholder && option.placeholder != "") {
			p.text(option.placeholder);
		}
		//用于存储选择项的value
		var input = $("<input type=\"hidden\"/>");
		p.append(input);

		

		//箭头图标
		var mark = $("<i>");
		p.append(mark);
		//创建滚动条面板
		var scroll = $("<div class=\"leoJScroll leo-dropdown-scroll\">");
		var ul = $("<ul>");
		if (option.data && option.data.length > 0) {
			for (var i = 0; i < option.data.length; i++) {
				var opt = option.data[i];
				var li = $("<li>");
				var a = $("<a href=\"javascript:void(0);\">");
				a.attr("data-value",opt.id);
				a.text(opt.text);
				li.append(a);
				ul.append(li);
				//点击选项
				a.click(function(){ 
					var txt = $(this).text();
					var value = $(this).attr("data-value");
					input.val(value);
					p.empty();
					p.append(txt).append(input).append(mark); 
					ul.hide();
					scroll.css("display","none");
					mark.removeClass("open");

					//由于input为hidden,无法触发change事件，因此改变值后，直接执行操作
					
					if(option.onChange && typeof option.onChange == "function"){
						option.onChange(input);
					}
				});
				
			}
		}
		scroll.append(ul);
		wrap.append(p).append(scroll);
		absoluteDiv.append(wrap);
		//绑定点击事件下拉菜单
		p.click(function(){
			if(scroll.css("display") == "none" && ul.css("display")=="none"){
				
				scroll.css("display","block");
				ul.show(100);
				if (!scrollFlag) {
					setTimeout(function(){
						initLeoJScroll(scroll);
						scrollFlag = true;
					},100);
				}
				mark.addClass("open");
			}else{ 
				ul.slideUp("fast");
				scroll.css("display","none");
				mark.removeClass("open");
			} 
		});
		
		return relativeDiv;
	},

	leoDropdownValue : function(){
		return $(this).find("input[type=hidden]").val();
	}
});


