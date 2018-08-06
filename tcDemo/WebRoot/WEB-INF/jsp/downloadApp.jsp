<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common/meta.jsp"></jsp:include>
	<title>${sysParam}</title>  
	<script type="text/javascript">
        /*
         * 智能机浏览器版本信息:
         *
         */
        var browser = {
            versions: function() {
                var u = navigator.userAgent, app = navigator.appVersion;
                return {//移动终端浏览器版本信息
                    trident: u.indexOf('Trident') > -1, //IE内核
                    presto: u.indexOf('Presto') > -1, //opera内核
                    webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                    gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
                    mobile: !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/), //是否为移动终端
                    ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                    android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
                    iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
                    iPad: u.indexOf('iPad') > -1, //是否iPad
                    webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
                };
            }(),
            language: (navigator.browserLanguage || navigator.language).toLowerCase()
        }

        if (browser.versions.ios || browser.versions.iPhone || browser.versions.iPad) {
            window.location = basePath + "download/ios";
        } else if (browser.versions.android) {
            window.location = basePath + "download/android";
        }
		/* 
		document.writeln("语言版本: " + browser.language);
		document.writeln(" 是否为移动终端: " + browser.versions.mobile);
		document.writeln(" ios终端: " + browser.versions.ios);
		document.writeln(" android终端: " + browser.versions.android);
		document.writeln(" 是否为iPhone: " + browser.versions.iPhone);
		document.writeln(" 是否iPad: " + browser.versions.iPad);
		document.writeln(navigator.userAgent); 
		*/
    </script>
</head>
<body>
      <a href="${basePath}download/android">Android</a>
      <a href="${basePath}download/ios">IOS</a>
</body>
</html>