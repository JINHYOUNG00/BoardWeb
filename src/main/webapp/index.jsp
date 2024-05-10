<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<a href="main.do">메인컨트롤 이동</a>
<%-- 	<jsp:forward page="main.do"></jsp:forward> --%>
	<!-- Expression Language(EL) -->
	
	<my:lines/>
	<p>${'홍길동'}</p>
	<script type="text/javascript">
		let name = "hong";
		console.log(`name => \${name}`);
	</script>
</body>
</html>