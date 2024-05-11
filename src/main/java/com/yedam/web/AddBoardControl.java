package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// title, content, writer
		String path = "WEB-INF/board/addBoard.jsp";
		// mutipart 요청처리를 위한 처리 
		// 생성자 매개변수(1.request 정보 2.저장 경로 3.max사이즈 4.인코딩 5.리네임정책(동일이름파일처리))
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 5 * 1024 * 1024; // 5MB
		MultipartRequest mr =  new MultipartRequest(
				req,
				savePath,
				maxSize,
				"utf-8" //
				, new DefaultFileRenamePolicy() // 서버 디렉토리 폴더안에 이미 같은이름의 파일이 있다면 뒤에 번호를 써서 구분함
				); 
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("myImg");
		
		BoardService svc = new BoardServiceImpl();
		
		MemberVO member = svc.chechMember(writer);
		if(member == null) {
			req.setAttribute("message", "권한이 없습니다.");
			req.getRequestDispatcher(path).forward(req, resp);
			return;
		}
		
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setImg(img);
		
		if(svc.addBoard(vo)) {
			System.out.println("등록성공");
			resp.sendRedirect("main.do");
		} else {
			System.out.println("등록실패");
			resp.sendRedirect("addForm.do");
		}
	}

}

