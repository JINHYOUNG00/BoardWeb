<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
BoardVO vo = (BoardVO) request.getAttribute("result");
String logId = (String)session.getAttribute("logId");
String msg = (String)request.getAttribute("message");
%>

<h3>삭제화면</h3>
<form name="myFrm" action="deleteBoard.do">
	<table class="table">
		<tr>
			<th>정말 삭제하시겠습니까?</th>	
		</tr>
		<tr align="center">
			<td colspan="2"><button class="btn btn-danger" type="submit">삭제</button></td>
		</tr>
	</table>
	<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>
<script type="text/javascript">

	const logId = "<%=logId %>";
	const writer = "<%=vo.getWriter() %>";
	
	document.forms.myFrm.addEventListener('submit', function(e){
		e.preventDefault();
		if(logId != writer){
			alert("권한이 없습니다.");
			return;
		} 
		this.submit();
	});

</script>