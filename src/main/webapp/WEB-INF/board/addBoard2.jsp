<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
 <%
  		String logId = (String)session.getAttribute("logId");
  		String msg = (String)request.getAttribute("message");
 %>

 <% if (msg != null)  {%>
 	<p><%=msg%></p>
 <%} %>
<form action="addBoard.do">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="30" rows="4" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="<%=logId%>" readonly></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" class="btn btn-primary" value="입력"></td>
		</tr>
	</table>
</form>


<jsp:include page="../includes/footer.jsp"></jsp:include>