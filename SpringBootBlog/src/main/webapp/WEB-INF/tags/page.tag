<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/css/common.css" rel="stylesheet">
<link href="${contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
	<div class="container">
		<jsp:include page="./common/nav.jsp"></jsp:include>
		<jsp:doBody />
	</div>
</body>
</html>