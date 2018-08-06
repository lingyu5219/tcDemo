<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="main-header">
    <nav class="navbar navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a href="#" class="navbar-brand">
					<span class="glyphicon glyphicon-education"></span><b> NIIT</b>
                </a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                	<i class="fa fa-bars"></i>
          		</button>
        	</div>
	        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
	          	<ul class="nav navbar-nav">
		            <li class="active"><a href="#">首页</a></li>
		            <li><a href="#">网络课堂</a></li>
		            <li><a href="#">知识库</a></li>
		            <li><a href="#">学生案例</a></li>
	          	</ul>
	        </div>
	        <div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<!-- Menu toggle button -->
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<span>客户端</span>
							<span class="caret"></span>
						</a>
		              	<ul class="dropdown-menu">
		                	<li class="text-center">
				                <img alt="APP下载" src="${basePath}static/images/download-app-qrcode.png"/>
		                    </li>
		                    <li class="text-center">
		                    	<span class="padding-large"><a href="${basePath}download/android"><span class="fa fa-android icon-large"></span></a></span>
			                    <span class="padding-large"><a href="${basePath}download/ios"><span class="fa fa-apple icon-large"></span></a></span>
		                    </li>
		              	</ul>
		            </li>
					<c:if test="${user != null }">
					<li class="user user-menu">
						<a href="${basePath}admin">
							<c:if test="${not empty user.picPath}">
							<img src="${basePath }${user.picPath }" class="user-image" alt="User Image"/>
							</c:if>
							<c:if test="${empty user.picPath}">
							<img src="${basePath}static/images/man.png" class="user-image" alt="User Image">
							</c:if>
							<span class="hidden-xs">${user.userName }</span>
						</a>
					</li>
					<li>
						<a href="${basePath }system/logout">退出</a>
					</li>
					</c:if>
					<c:if test="${user == null }">
					<li><a href="${basePath}system/login">登录</a></li>
		            <li><a href="${basePath}stumgt/regStu">注册</a></li>
		            </c:if>
		            
				</ul>
	        </div>
      	</div>
    </nav>
</header>