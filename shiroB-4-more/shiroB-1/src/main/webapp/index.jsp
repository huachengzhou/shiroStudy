<html>
<head>
    <title>hello</title>
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

    <style>
        .TestdivA{
            width: 1000px;height: auto;margin-right: auto;margin-left: auto;
        }
        .TestdivB{
            text-align: center;margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="TestdivA container-fluid">
        <div class="TestdivB card-header">
            <h2 class="card-title">Hello World!</h2><br/>
            <a href="${pageContext.request.contextPath}/springmvc/test/success.action" class="btn">success</a>
        </div>
    </div>
</body>
</html>
