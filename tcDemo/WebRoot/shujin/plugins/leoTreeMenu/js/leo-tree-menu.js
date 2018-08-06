$.fn.extend({
	leoTreeMenu : function(option){
		
		var level = 0;

		var treeMenuWrap = $(this);
		if (option.data && option.data.length > 0) {
			treeMenuWrap.addClass("leo-tree-menu");
			var absPanel = $("<div class=\"leo-absolute-panel\">");
			var treeMenuUl = createUl(option.data, option.withMemberCount, option.curActive);
			
			//默认或者设置option.scroll为true带滚动条，如果设置了option.scroll为false,则不加滚动条插件
			if(typeof option.scroll == "undefined" || option.scroll){
				var scroll = $("<div class=\"leoJScroll\">");
				scroll.append(treeMenuUl);
				absPanel.append(scroll);
				treeMenuWrap.append(absPanel);
				//初始化滚动条
				initLeoJScroll(scroll);
			} else {
				//如果不带滚动条，则将该属性以data-scroll=false设置到控件上
				treeMenuWrap.attr("data-scroll","false");
				absPanel.append(treeMenuUl);
				treeMenuWrap.append(absPanel);
			}
			
			//生成树形菜单后，执行相应的回调函数
			if(option.fn && typeof (option.fn) == "function"){
				option.fn(treeMenuWrap);
			}
		} else {
			treeMenuWrap.text("没有数据！");
		}
		
		
		function createUl(menus, withMemberCount, curActive){
			//leoAlert(JSON.stringify(menus) + level);
			level++;
			var ul = $("<ul>");
			ul.addClass("leo-tree-menu-ul"+level);
			for(var i = 0; i < menus.length; i++){
				var menuJson = menus[i];
				var li = $("<li>");
				var a = $("<a>");
				a.attr("href",menuJson.url);

				var aHtml = menuJson.department_name;
				//如果需要显示员工数量
				if(withMemberCount){
					//如果是根节点
					//if(menuJson.department_id == menuJson.superior_department_id){
					if(level == 1){
						aHtml += "<span class=\"sel_num\">&nbsp;&nbsp;&frasl;&nbsp;" + menuJson.membercount + "</span>";
					} else {
						aHtml += "<span>&nbsp;&nbsp;&frasl;&nbsp;" + menuJson.membercount + "</span>";
					}
					
				}

				a.html(aHtml);
				a.attr("data-value",menuJson.department_id);
				a.attr("data-option",JSON.stringify(menuJson));
				if(curActive && curActive == menuJson.department_id){
					a.addClass("active");
				}
				
				li.append(a);

				//如果option中指定了每个节点的click回调函数，则在此绑定click事件
				if(option.nodeClick && typeof option.nodeClick == "function"){
					a.click(function(){
						var node = $.parseJSON($(this).attr("data-option"));
						option.nodeClick(node);
					});
				}
				if(menuJson.children && menuJson.children.length > 0){
					//添加箭头图标
					var arrow = $("<i>");
					a.click(function(){
						var curA = $(this);
						
						//清除其他已选中项
						curA.parentsUntil("div").filter("ul:last").find("a").not($(this)).removeClass("active");
						//设置当前选中与否
						curA.toggleClass("active");

						curA.find("i").toggleClass("hide");
						toggleSubMenu(curA.next());
						//如果有滚动条，则每次展开、收缩后重新初始化滚动条
						var treeMenuWrap = curA.parentsUntil("div.leo-absolute-panel").last("div").parent().parent();
						if(treeMenuWrap.attr("data-scroll") != "false"){
//							setTimeout(function(){
//								var leoScroll = curA.parentsUntil("div.leo-absolute-panel").last("div");
//								
//								initLeoJScroll(leoScroll);
//							},300);
						}
					});
					a.prepend(arrow);
					//创建子菜单
					li.append(createUl(menuJson.children,withMemberCount,curActive));
				} else {
					a.click(function(){
						//清除其他已选中项
						$(this).parentsUntil("div").filter("ul:last").find("a").not($(this)).removeClass("active");
						//设置当前选中与否
						$(this).toggleClass("active");
					});
				}
				
				ul.append(li);
			}
			

			return ul;

		}
		
		function toggleSubMenu(subMenu){
			subMenu.slideToggle(300);
		}
		
		return treeMenuWrap;
	},
	
	leoTreeMenuValue : function(){
		var treeMenu = $(this);
		var value;
		treeMenu.find("a").each(function(){
			var a = $(this);
			if(a.attr("class") == "active"){
				value = a.attr("data-value");
				return false;
			}
		});
		return value;
	},

	leoTreeMenuText : function(){
		var treeMenu = $(this);
		var text;
		treeMenu.find("a").each(function(){
			var a = $(this);
			if(a.attr("class") == "active"){
				text = a.text();
				return false;
			}
		});
		return text;
	}
});