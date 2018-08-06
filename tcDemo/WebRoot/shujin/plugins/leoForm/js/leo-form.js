$(function(){
	$(".leo-input").focus(function(){
		$(this).addClass("leo-input-focus");
	});
});

$.fn.extend({
	leoSearchbox : function(option){
		var searchBox = $(this);
		searchBox.addClass("leo-search-box");
		if(option.width){
			searchBox.css("width",option.width);
		}
		
		var input = $("<input type=\"text\"/>");
		if(option.name){
			input.attr("name",option.name);
		}
		
		input.focus(function(){
			searchBox.addClass("leo-search-box-focus");
		});

		input.blur(function(){
			if($(this).val() == null || $(this).val() == ""){
				searchBox.removeClass("leo-search-box-focus");
			}
		});

		var button = $("<button type=\"button\"></button>");
		searchBox.append(input).append(button);

		if(option.search && typeof option.search == "function"){
			button.click(function(){
				option.search(input);
			});
		}
		return searchBox;
	},
	
	leoSearchboxValue : function(val){
		if(val && val != null){
			$(this).find("input").val(val);
		} else {
			return $(this).find("input").val();
		}
	}
});