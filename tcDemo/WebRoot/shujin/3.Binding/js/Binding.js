$(function () {
    var select_form = $('input:text');

    for (i = 0; i < select_form.length; i++) {
        select_form.eq(i).val(select_form.eq(i).attr('info')).css('color', '#b4c7f2');

        select_form.focus(function () {
            if ($(this).val() == $(this).attr('info')) {
                $(this).val('');
                $(this).css('color', '#7c9cef');
            }
        });

        // select_form.blur(function () {
        //     if ($(this).val() == '') {
        //         $(this).val($(this).attr('info'));
        //         $(this).css('color', '#b4c7f2');
        //     }
        // });
    }

    function setVal(obj) {
        obj.val(obj.attr('info'));
        obj.css('color', '#b4c7f2')
    }

    $('#name').blur(function() {
        var regx = /^\W+$/;
        if ($(this).val() == '') {
            setVal($(this));
            $('#name_info').html('<div class="icon icon_war"></div><div class=text_err>名字不能为空</div>');
        } else if (regx.test($(this).val())){
            $('#name_info').html('<div class="icon icon_err"></div><div class=text_err>名字格式不对</div>');
        } else {
            $('#name_info').html('<div class="icon icon_suc"></div>');
        }
    });

    $('#email').blur(function() {
        var regx = /^[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*@([A-Za-z0-9]+[-.])+[A-Za-z0-9]{2,5}$/;
        if ($(this).val() == '') {
            setVal($(this));
            $('#email_info').css('display', 'none');
        } else if(!regx.test($(this).val())) {
            $('#email_info').css('display', 'block');
            $('#email_info').html('<div class="icon icon_err"></div><div class=text_err>邮箱格式不正确</div>')
        } else {
            $('#email_info').css('display', 'block');
            $('#email_info').html('<div class="icon icon_suc"></div>')
        }
    });

    $('#pwd').blur(function() {
        var regx = /^\S{6,20}$/;
        if ($(this).val() == '') {
            $(this).attr('type', 'text');
            setVal($(this));
            $('#pwd_info').css('display', 'none');
        } else if (!regx.test($(this).val())){
            $('#pwd_info').css('display', 'block');
            $('#pwd_info').html('<div class="icon icon_err"></div><div class=text_err>密码格式有误</div>');
        } else {
            $('#pwd_info').css('display', 'block');
            $('#pwd_info').html('<div class="icon icon_suc"></div>');
        }
    });

    $('#confirm_pwd').blur(function() {
        if ($(this).val() == '') {
            $(this).attr('type', 'text');
            setVal($(this));
            $('#con_pwd_info').css('display', 'none');
        } else if ($(this).val() == $('#pwd').val()) {
            $('#con_pwd_info').css('display', 'block');
            $('#con_pwd_info').html('<div class="icon icon_suc"></div>');
        } else {
            $('#con_pwd_info').css('display', 'block');
            $('#con_pwd_info').html('<div class="icon icon_err"></div><div class=text_err>两次输入的密码不一致</div>');
        }
    });

    $('#pwd, #confirm_pwd').focus(function() {
        $(this).attr('type', 'password');
    })

    $('#phone').blur(function() {
        var regex = /^1[3|4|5|7|8][0-9]{9}$/;
        if ($(this).val() == '') {
            setVal($(this));
            $('#phone_info').css('display', 'none')
        } else if (!regex.test($(this).val())) {
            $('#phone_info').css('display', 'block');
            $('#phone_info').html('<div class="icon icon_err"></div><div class=text_err>手机号格式不正确</div>');
        } else {
            $('#phone_info').css('display', 'block');
            $('#phone_info').html('<div class="icon icon_suc"></div>');
        }
    })
})