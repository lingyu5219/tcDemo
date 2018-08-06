$(function(){
	$(".leo-panel-collapse").find(".icon-collapsed").click(function(){
		$(".leo-panel-collapse").find(".leo-content").slideToggle();
		$(this).toggleClass("icon-collapsed");
		$(this).toggleClass("icon-collapse");
	});
	
	$(".leo-panel-collapse").find("i").click(function(){
		$(".leo-panel-collapse").find(".leo-content").slideToggle();
		$(this).toggleClass("icon-collapse");
		$(this).toggleClass("icon-collapsed");

		/*
		if($(this).attr("class") == "icon-collapse"){
			$(".leo-panel-collapse").find(".leo-sticker-wrap").css("overflow","hidden");
			$(".leo-panel-collapse").find(".leo-sticker-wrap").animate({"height":"185px"});
			$(this).removeClass("icon-collapse");
			$(this).addClass("icon-collapsed");
		}else if($(this).attr("class") == "icon-collapsed"){
			$(".leo-panel-collapse").find(".leo-sticker-wrap").css("overflow","");
			$(".leo-panel-collapse").find(".leo-sticker-wrap").animate({"height":""});
			$(this).removeClass("icon-collapsed");
			$(this).addClass("icon-collapse");
		}*/


	});
});