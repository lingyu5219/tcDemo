var LeoPopWin = function(option){
	var win = this;
	this.option = option;
	this.winId = new Date().getTime();
	//创建遮罩层
	this.leo_popup_win_fade = $("<div class=\"leo-popup-win-fade\">");
	this.leo_popup_win_fade.attr("id","fade_" + this.winId);
	//创建主窗口
	this.leo_popup_win = $("<div class=\"leo-popup-win\">");
	this.leo_popup_win.attr("id","win_" + this.winId);
	
	//窗口宽度
	if(option.width){
		this.leo_popup_win.css("width",option.width);
	}
	//窗口高度
	if(option.height){
		this.leo_popup_win.css("height",option.height);
	}

	//窗口高度
	if(option.maxHeight){
		this.leo_popup_win.css("max-height",option.maxHeight);
	}
	
	//创建关闭按钮
	if(option.closeBtn){
		this.closeBtnWrap = $("<div class=\"closeBtnWrap\">");
		this.closeBtn = $("<i>")
		this.closeBtnWrap.append(this.closeBtn);
		this.leo_popup_win.append(this.closeBtnWrap);
		//关闭按钮绑定click
		this.closeBtn.click(function(){
			win.close();
		});
	}
	
	//创建标题
	if(option.title){
		this.title = $("<div class=\"leo-title\">");
		this.title.text(option.title);
		this.title.css("border-top-left-radius","8px");
		this.title.css("border-top-right-radius","8px");
		this.leo_popup_win.append(this.title);
	}
	//创建内容
	this.content = $("<div class=\"leo-content\"></div>");
	this.content.append(option.content);
	//如果没有title，则需要将content的左上角 和  右上角设置为圆角
	if(!option.title){
		this.content.css("border-top-left-radius","8px");
		this.content.css("border-top-right-radius","8px");
	}
	this.leo_popup_win.append(this.content);
	//创建底部
	this.foot = $("<div class=\"leo-foot\">");
	this.foot.append(option.foot);
	this.foot.css("border-bottom-left-radius","8px");
	this.foot.css("border-bottom-right-radius","8px");
	this.leo_popup_win.append(this.foot);
	//绑定窗口resize事件，重新设置窗口位置
	
	$(window).resize(function() {
		  win.position();
	});
//	$(window).scroll(function() {
//		  win.position();
//	});
	
}
//弹出窗口
LeoPopWin.prototype.open = function(){
	var win = this;
	$("body").append(this.leo_popup_win_fade).append(this.leo_popup_win);
	this.leo_popup_win_fade.show();
	this.leo_popup_win.show();
	this.position();
	if(this.option.afterOpen && typeof this.option.afterOpen == "function"){
		var afterOpenFn = this.option.afterOpen;
		setTimeout(function(){
			afterOpenFn(win);
		}, 200);
	}
}
//关闭窗口
LeoPopWin.prototype.close = function(){
	this.leo_popup_win_fade.hide();
	this.leo_popup_win.hide();
	this.leo_popup_win_fade.remove();
	this.leo_popup_win.remove();
}
//计算尺寸，设置窗口居中
LeoPopWin.prototype.position = function(){
	var dw = $(window).width();  
    var ow = this.leo_popup_win.outerWidth();  
    var dh = $(window).height();  
    var oh = this.leo_popup_win.outerHeight();  
    var l = (dw - ow) / 2;  
    var t = (dh - oh) / 2 > 0 ? (dh - oh) / 2 : 10;  
    var lDiff = this.leo_popup_win.offset().left - this.leo_popup_win.position().left;  
    var tDiff = this.leo_popup_win.offset().top - this.leo_popup_win.position().top;  
    l = l + $(window).scrollLeft() - lDiff;  
    t = t + $(window).scrollTop() - tDiff;  
    this.leo_popup_win.css("left",l + "px");  
    this.leo_popup_win.css("top",t + "px"); 
}

var leoAlert = function(msg){
	var option = {
		width:"300px",
		title:"提示",
		closeBtn:true,
		content:msg
	};
	var win = new LeoPopWin(option);
	win.open();
}
