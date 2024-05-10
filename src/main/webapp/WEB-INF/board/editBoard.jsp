<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>수정화면</h3>
<form action="updateBoard.do">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${result.boardNo}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${result.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="30" rows="4">${result.content }></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${result.writer }</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<c:choose>
					<c:when test="${result.writer == logId}">
						<input class="btn btn-primary" type="submit" value="수정">
					</c:when>
					<c:otherwise>
						<input class="btn btn-primary" type="submit" disabled value="수정">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	<input type="hidden" name="bno" value="${result.boardNo}">
	<input type="hidden" name="page" value="${page}">
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>