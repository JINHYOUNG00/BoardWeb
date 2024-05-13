<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
div.reply div {
	margin: auto;
}

div.reply ul {
	list-style-type: none;
	margin-top: 5px;
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
}
</style>

<h3>상세화면</h3>
<c:choose>
	<c:when test="${empty result}">
		<p>조회된 결과가 없습니다.</p>
	</c:when>
	<c:otherwise>
		<form name="myFrm">
			<input type="hidden" name="bno" value="${result.boardNo}"> <input
				type="hidden" name="page" value="${page}"> <input
				type="hidden" name="searchCondition" value="${searchCondition}">
			<input type="hidden" name="keyword" value="${keyword}">
		</form>
		<table class="table">
			<tr>
				<th>게시글번호</th>
				<td>${result.boardNo}</td>
				<th>조회수</th>
				<td>${result.viewCnt }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${result.title }</td>
				<th>작성자</th>
				<td>${result.writer }</td>
			</tr>
			<tr>
				<td colspan="4"><pre>${result.content }</pre> <c:if
						test="${result.img != null }">
						<img alt="test1" src="images\/${result.img}"
							class="view_context_img">
					</c:if></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td colspan="3">${result.createDate }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">${result.img }</td>
			</tr>
			<tr align="center">
				<td colspan="4"><button class="btn btn-primary" id="modBtn">수정</button>
					<button class="btn btn-danger">삭제</button></td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>
<!-- 댓글목록 -->
<div class="container reply">
	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-3" id="addReply">댓글등록</button>
	</div>
	<div class="content">
		<ul>
			<li><span class="col-sm-2">글번호</span> <span class="col-sm-5">댓글내용</span>
				<span class="col-sm-2">작성자</span></li>
			<li>
				<hr />
			</li>
			<li style="display: none;"><span class="col-sm-2">3</span> <span
				class="col-sm-5">3댓글내용</span> <span class="col-sm-2">3작성자</span> <span
				class="col-sm-2"><button onclick="deleteRow(event)"
						class="btn btn-warning">삭제</button></span></li>

		</ul>
	</div>
	<!-- end of contant class -->
</div>
<!-- end of container class -->
<script>
	const bno = '${result.boardNo}';
	const writer = '${logId}';
</script>

<script src="js/board.js" type="text/javascript">
	
</script>