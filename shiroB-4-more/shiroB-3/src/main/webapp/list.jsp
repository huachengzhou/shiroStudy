<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list and logout</title>
	<!-- 必须在引入bootstrap之前先引入jquery模块 -->
	<!-- The jQuery module must be introduced before the introduction of bootstrap -->
	<script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>

	<!-- 必须在bootstrap之前先引入tether模块 -->
	<!-- The tether module must be introduced before bootstrap -->
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/tether/tether-1.3.3/dist/js/tether.min.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/components/module-bootstrap/tether/tether-1.3.3/dist/css/tether.min.css" rel="stylesheet" type="text/css">

	<!-- 引入bootstrap模块 -->
	<!-- Introducing bootstrap module -->
	<link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/js/popper.min.js"></script>
	<style type="text/css">
		.TestdivA{
			width: 1000px;height: auto;margin-right: auto;margin-left: auto;
		}
		.TestdivB{
			text-align: center;margin-top: 20px;
		}
		.mx{
			margin-top: 20px;margin-bottom: 5px;
		}
	</style>
</head>
<body>
	
	<div class="TestdivA">
		<div class="TestdivB">
			<h4>List Page</h4><br/>
			<a href="${pageContext.request.contextPath}/admin.jsp" class="btn btn-info mx">admin</a><br/>
			<a href="${pageContext.request.contextPath}/user.jsp" class="btn btn-info mx">user</a><br/>
			<button id="btnSubmit" class="btn btn-info mx">退出</button><br/>
		</div>
	</div>
<script type="text/javascript">
    var btnForm = document.getElementById("btnSubmit");
    btnForm.onclick = function () {
		console.info("submit");
		var href = "${pageContext.request.contextPath}/sys/logout.action";
		window.location.href = href;
    };
</script>
</body>
</html>