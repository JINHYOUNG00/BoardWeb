<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
BoardVO vo = (BoardVO) request.getAttribute("result");
%>
<h3>삭제화면</h3>
<form action="deleteBoard.do">
	<table class="table">
		<tr>
			<th>정말 삭제하시겠습니까?</th>	
		</tr>
		<tr align="center">
			<td colspan="2"><input class="btn btn-danger" type="submit"
				value="삭제"></td>
		</tr>
	</table>
	<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>