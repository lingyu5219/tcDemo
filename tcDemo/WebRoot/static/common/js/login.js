/*jQuery(function($){
	var basePath = "${basePath}";
    $.supersized({
        // Functionality
        slide_interval     : 4000,    // Length between transitions
        transition         : 1,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
        transition_speed   : 1000,    // Speed of transition
        performance        : 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)

        // Size & Position
        min_width          : 0,    // Min width allowed (in pixels)
        min_height         : 0,    // Min height allowed (in pixels)
        vertical_center    : 1,    // Vertically center background
        horizontal_center  : 1,    // Horizontally center background
        fit_always         : 0,    // Image will never exceed browser width or height (Ignores min. dimensions)
        fit_portrait       : 1,    // Portrait images will not exceed browser height
        fit_landscape      : 0,    // Landscape images will not exceed browser width

        // Components
        slide_links        : 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
        slides             : [    // Slideshow Images
                                 {image : '../static/images/login-bg-1.jpg'},
                                 {image : '../static/images/login-bg-2.jpg'},
                                 {image : '../static/images/login-bg-3.jpg'}
                       ]
    });
});
jQuery(document).ready(function() {

    $('.page-container form').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
*/
$(function () {
	//初始化复选框
	$('input[type="checkbox"].icheck').iCheck({
        checkboxClass: 'icheckbox_square-blue'
    });
	
	$("#loginForm").validate( {
		rules: {
			userName: {
				required: true,
				isCharOrDigit: true
			},
			userPassword: {
				required: true,
				isPassword: true
			}
		},
		messages: {
			userName: {
				required: "默认为青大学号"
			},
			userPassword: {
				required: "请输入密码,默认为青大学号"
			}
		},
		errorElement: "em",
		errorPlacement: function (error, element) {
			// Add the `help-block` class to the error element
			error.addClass("help-block");

			if (element.prop("type" ) === "checkbox") {
				error.insertAfter(element.parents(".input-group"));
			} else {
				error.insertAfter(element.parents(".input-group"));
			}
		},
		highlight: function ( element, errorClass, validClass ) {
			$(element).parents(".form-group").addClass("has-error");
		},
		unhighlight: function (element, errorClass, validClass) {
			$(element).parents(".form-group").removeClass("has-error");
		}
	});
});