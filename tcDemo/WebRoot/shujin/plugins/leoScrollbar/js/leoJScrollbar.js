/*--------------------------------------------------------------------------------------------------*/
//jQuery.browser={};(function(){jQuery.browser.msie=false; jQuery.browser.version=0;if(navigator.userAgent.match(/MSIE ([0-9]+)./)){ jQuery.browser.msie=true;jQuery.browser.version=RegExp.$1;}})();
var userAgent = navigator.userAgent.toLowerCase();
    // Figure out what browser is being used 
jQuery.browser = {
    version: (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [])[1],
    safari: /webkit/.test(userAgent),
    opera: /opera/.test(userAgent),
    msie: /msie/.test(userAgent) && !/opera/.test(userAgent),
    mozilla: /mozilla/.test(userAgent) && !/(compatible|webkit)/.test(userAgent)
};
$.fn.extend({//添加滚轮事件
	mousewheel:function(Func){
		return this.each(function(){
			var _self = this;
		    _self.D = 0;//滚动方向
			if($.browser.msie||$.browser.safari){
			   _self.onmousewheel=function(){_self.D = event.wheelDelta;event.returnValue = false;Func && Func.call(_self);};
			}else{
			   _self.addEventListener("DOMMouseScroll",function(e){
					_self.D = e.detail>0?-1:1;
					e.preventDefault();
					Func && Func.call(_self);
			   },false); 
			}
		});
	}
});
$.fn.extend({
	jscroll:function(j){
		return this.each(function(){
			j = j || {}
			j.Bar = j.Bar||{};//2级对象
			j.Btn = j.Btn||{};//2级对象
			j.Bar.Bg = j.Bar.Bg||{};//3级对象
			j.Bar.Bd = j.Bar.Bd||{};//3级对象
			j.Btn.uBg = j.Btn.uBg||{};//3级对象
			j.Btn.dBg = j.Btn.dBg||{};//3级对象
			var jun = { W:"15px"
						,BgUrl:""
						,Bg:"#efefef"
						,Bar:{  Pos:"up"
								,Bd:{Out:"#b5b5b5",Hover:"#ccc"}
								,Bg:{Out:"#fff",Hover:"#fff",Focus:"orange"}}
						,Btn:{  btn:true
								,uBg:{Out:"#ccc",Hover:"#fff",Focus:"orange"}
								,dBg:{Out:"#ccc",Hover:"#fff",Focus:"orange"}}
						,Fn:function(){}}
			j.W = j.W||jun.W;
			j.BgUrl = j.BgUrl||jun.BgUrl;
			j.Bg = j.Bg||jun.Bg;
			j.Bar.Pos = j.Bar.Pos||jun.Bar.Pos;
			j.Bar.Bd.Out = j.Bar.Bd.Out||jun.Bar.Bd.Out;
			j.Bar.Bd.Hover = j.Bar.Bd.Hover||jun.Bar.Bd.Hover;
			j.Bar.Bg.Out = j.Bar.Bg.Out||jun.Bar.Bg.Out;
			j.Bar.Bg.Hover = j.Bar.Bg.Hover||jun.Bar.Bg.Hover;
			j.Bar.Bg.Focus = j.Bar.Bg.Focus||jun.Bar.Bg.Focus;
			j.Btn.btn = j.Btn.btn!=undefined?j.Btn.btn:jun.Btn.btn;
			j.Btn.uBg.Out = j.Btn.uBg.Out||jun.Btn.uBg.Out;
			j.Btn.uBg.Hover = j.Btn.uBg.Hover||jun.Btn.uBg.Hover;
			j.Btn.uBg.Focus = j.Btn.uBg.Focus||jun.Btn.uBg.Focus;
			j.Btn.dBg.Out = j.Btn.dBg.Out||jun.Btn.dBg.Out;
			j.Btn.dBg.Hover = j.Btn.dBg.Hover||jun.Btn.dBg.Hover;
			j.Btn.dBg.Focus = j.Btn.dBg.Focus||jun.Btn.dBg.Focus;
			j.Fn = j.Fn||jun.Fn;
			
			var _self = this;
			
			var Stime,Sp=0,Isup=0;
			$(_self).css({overflow:"hidden",position:"relative","padding-top":"0px","padding-bottom":"0px","max-height":"296px"});
			
			var dw = $(_self).width(), //容器区域宽度
				dh = $(_self).height();//容器区域高度
			var sw = j.W ? parseInt(j.W) : 21;//滚动条宽度
			var sl = dw - sw;//容器区域宽度 减去 滚动条宽度
			var bw = j.Btn.btn==true ? sw : 0;//上下按钮的高度，如果滚动条有上下按钮，则取滚动条宽度，否则为0
			
			if($(_self).children(".jscroll-c").height()==null){//存在性检测
				$(_self).wrapInner("<div class='jscroll-c' style='top:0px;z-index:9999;zoom:1;position:relative;overflow:auto;'></div>");
				$(_self).children(".jscroll-c").prepend("<div style='height:0px;overflow:hidden'></div>");
				$(_self).append("<div class='jscroll-e' unselectable='on' style=' height:100%;top:0px;right:0;-moz-user-select:none;position:absolute;overflow:hidden;z-index:10000;'><div class='jscroll-u' style='position:absolute;top:0px;width:100%;left:0;background:blue;overflow:hidden'></div><div class='jscroll-h'  unselectable='on' style='background-size:contain;position:absolute;left:0;-moz-user-select:none;'></div><div class='jscroll-d' style='position:absolute;bottom:0px;width:100%;left:0;overflow:hidden;'></div></div>");
			}
			var jscrollc = $(_self).children(".jscroll-c");
			var jscrolle = $(_self).children(".jscroll-e");
			var jscrollh = jscrolle.children(".jscroll-h");
			var jscrollu = jscrolle.children(".jscroll-u");
			var jscrolld = jscrolle.children(".jscroll-d");
			if($.browser.msie){document.execCommand("BackgroundImageCache", false, true);}
			jscrollc.css({"padding-right":sw});//右侧填充滚动条宽度，用以显示滚动条
			jscrolle.css({width:sw,background:j.Bg,"background-image":j.BgUrl});
			jscrollh.css({top:bw,background:j.Bar.Bg.Out,"background-image":j.BgUrl,"border-color":j.Bar.Bd.Out,width:sw-2});
			jscrollu.css({height:bw,background:j.Btn.uBg.Out,"background-image":j.BgUrl});
			jscrolld.css({height:bw,background:j.Btn.dBg.Out,"background-image":j.BgUrl});
			jscrollh.hover(function(){if(Isup==0)$(this).css({background:j.Bar.Bg.Hover,"background-image":j.BgUrl,"border-color":j.Bar.Bd.Hover})},function(){if(Isup==0)$(this).css({background:j.Bar.Bg.Out,"background-image":j.BgUrl,"border-color":j.Bar.Bd.Out})})
			jscrollu.hover(function(){if(Isup==0)$(this).css({background:j.Btn.uBg.Hover,"background-image":j.BgUrl})},function(){if(Isup==0)$(this).css({background:j.Btn.uBg.Out,"background-image":j.BgUrl})})
			jscrolld.hover(function(){if(Isup==0)$(this).css({background:j.Btn.dBg.Hover,"background-image":j.BgUrl})},function(){if(Isup==0)$(this).css({background:j.Btn.dBg.Out,"background-image":j.BgUrl})})
//			jscrollc.
			var sch = jscrollc.height();//内容区域高度
			//var sh = Math.pow(dh,2) / sch ;//Math.pow(x,y)x的y次方
			//var sh = (dh-2*bw)*dh / sch
			var sh = 112;//滚动条高度
			if(sh<10){sh=10}
			if(dh <= 120){
				sh = 42;//dh/3;
				jscrolle.css({background:"3px 0px no-repeat","background-image":"url(" + ctx + "/themes/yconsume/images/scrollbar_small_sprite.png)"});
				jscrollh.css({background:"-33px 0px no-repeat","background-image":"url(" + ctx + "/themes/yconsume/images/scrollbar_small_sprite.png)"});
				jscrollh.hover(
					function(){
						if(Isup==0)
							$(this).css({background:"-33px 0px no-repeat","background-image":"url(" + ctx + "/themes/yconsume/images/scrollbar_small_sprite.png)","border-color":"none"});
					},
					function(){
						if(Isup==0)
							$(this).css({background:"-33px 0px no-repeat","background-image":"url(" + ctx + "/themes/yconsume/images/scrollbar_small_sprite.png)","border-color":"none"});
					}
				);
				
			}
			var wh = sh/6//滚动时候跳动幅度
		//	sh = parseInt(sh);
			var curT = 0,//当前滚动条距离顶部的距离
				allowS=false;//是否允许滚动
			jscrollh.height(sh);
			//如果内容区域高度 小于等于 容器高度，则不显示滚动条
			if(sch<=dh){
				jscrollc.css({padding:0});
				jscrolle.css({display:"none"})
			} else {
				allowS=true;//允许滚动
				jscrolle.css({display:"block"}); //显示滚动条
			}
			//如果初始化时，显示内容底部
			if(j.Bar.Pos!="up"){
				curT=dh-sh-bw;
				setT();
			}
			jscrollh.bind("mousedown",function(e){
				j['Fn'] && j['Fn'].call(_self);
				Isup=1;
				jscrollh.css({background:j.Bar.Bg.Focus,"background-image":j.BgUrl});
				if(dh <= 120){
					jscrollh.css({background:"-33px 0px no-repeat","background-image":"url(" + ctx + "/themes/yconsume/images/scrollbar_small_sprite.png)"});
				}
				var pageY = e.pageY ,t = parseInt($(this).css("top"));
				$(document).mousemove(function(e2){
					 curT =t+ e2.pageY - pageY;//pageY浏览器可视区域鼠标位置，screenY屏幕可视区域鼠标位置
						setT();
				});
				$(document).mouseup(function(){
					Isup=0;
					jscrollh.css({background:j.Bar.Bg.Out,"background-image":j.BgUrl,"border-color":j.Bar.Bd.Out})
					if(dh <= 120){
						jscrollh.css({background:"-33px 0px no-repeat","background-image":"url(" + ctx + "/themes/yconsume/images/scrollbar_small_sprite.png)"});
					}
					$(document).unbind();
				});
				return false;
			});
			jscrollu.bind("mousedown",function(e){
			j['Fn'] && j['Fn'].call(_self);
				Isup=1;
				jscrollu.css({background:j.Btn.uBg.Focus,"background-image":j.BgUrl})
				_self.timeSetT("u");
				$(document).mouseup(function(){
					Isup=0;
					jscrollu.css({background:j.Btn.uBg.Out,"background-image":j.BgUrl})
					$(document).unbind();
					clearTimeout(Stime);
					Sp=0;
				});
				return false;
			});
			jscrolld.bind("mousedown",function(e){
			j['Fn'] && j['Fn'].call(_self);
				Isup=1;
				jscrolld.css({background:j.Btn.dBg.Focus,"background-image":j.BgUrl})
				_self.timeSetT("d");
				$(document).mouseup(function(){
					Isup=0;
					jscrolld.css({background:j.Btn.dBg.Out,"background-image":j.BgUrl})
					$(document).unbind();
					clearTimeout(Stime);
					Sp=0;
				});
				return false;
			});
			_self.timeSetT = function(d){
				var self=this;
				if(d=="u"){curT-=wh;}else{curT+=wh;}
				setT();
				Sp+=2;
				var t =500 - Sp*50;
				if(t<=0){t=0};
				Stime = setTimeout(function(){self.timeSetT(d);},t);
			}
			jscrolle.bind("mousedown",function(e){
					j['Fn'] && j['Fn'].call(_self);
							curT = curT + e.pageY - jscrollh.offset().top - sh/2;
							asetT();
							return false;
			});
			function asetT(){				
						if(curT<bw){curT=bw;}
						if(curT>dh-sh-bw){curT=dh-sh-bw;}
						jscrollh.stop().animate({top:curT},100);
						var scT = -((curT-bw)*sch/(dh-2*bw));
						jscrollc.stop().animate({top:scT},1000);
			};
			function setT(){		
				//如果当前滚动条距离顶部距离小于上下按钮的高度，则距离顶部高度为上下按钮的高度
				if(curT<bw){curT=bw;}
				//如果当前滚动条距离顶部距离大于上下按钮高度，则设置为容器高度-滚动条高度-上下按钮高度
				if(curT>dh-sh-bw){curT=dh-sh-bw;}
				//通过以上两个条件，控制滚动条不会超出滚动区域
				//设置滚动条距离顶部位置
				jscrollh.css({top:curT});
				//计算内容区域距离顶部位置
				
				var scT = -((curT-bw)*(sch-dh)/(dh-2*bw-sh));//-((curT-bw)*sch/(dh-2*bw));
				jscrollc.css({top:scT});
			};
			$(_self).mousewheel(function(){
					if(allowS!=true) return;
					j['Fn'] && j['Fn'].call(_self);
					if(this.D>0){curT-=wh;}else{curT+=wh;};
					setT();
			})
		});
	}
});

function initLeoJScroll(className){
	//初始化滚动条
	var scrollObj = null;
	if(typeof className == 'string'){
		scrollObj = $(className);
	} else {
		scrollObj = className;
	}
	if (scrollObj == null) {
		return;
	}
	scrollObj.find(".jscroll-c").css("top","0px");
	var rs = scrollObj.jscroll({
		W:"18px",
		BgUrl:"url(" + ctx + "/themes/yconsume/images/org_sprite.png)",
		Bg:"-210px -66px no-repeat",
		Bar:{
			Pos:"up",
			Bd:{Out:"none",Hover:"none",},
			Bg:{Out:"-259px -252px no-repeat",Hover:"-259px -252px no-repeat",Focus:"-259px -252px no-repeat"}
		},
		Btn:{
			btn:false
		},
		Fn:function(){}
	});
	//alert(rs.length);
}

//根据内容区域指定位置，计算内容区域距离顶部距离，以及滚动条距离顶部距离
//function LeoJScrollMove(y){
//	curT = curT + e.pageY - jscrollh.offset().top - sh/2;
//	
//	if(curT<bw){curT=bw;}
//	if(curT>dh-sh-bw){curT=dh-sh-bw;}
//	jscrollh.stop().animate({top:curT},100);
//	var scT = -((curT-bw)*sch/(dh-2*bw));
//	jscrollc.stop().animate({top:scT},1000);
//	
//	return false;
//}
