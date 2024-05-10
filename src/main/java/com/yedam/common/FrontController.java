package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.AddBoardControl;
import com.yedam.web.AddFormControl;
import com.yedam.web.BoardInfoControl;
import com.yedam.web.LoginControl;
import com.yedam.web.LoginFormControl;
import com.yedam.web.LogoutControl;
import com.yedam.web.MainControl;
import com.yedam.web.ModifyControl;
import com.yedam.web.ModifyFormControl;
import com.yedam.web.RemoveControl;
import com.yedam.web.RemoveFormControl;

public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		this.map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// url패턴과 실행할 Control 구현 클래스 정의
		map.put("/main.do", new MainControl());
		// 글등록
		map.put("/addForm.do", new AddFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/boardInfo.do", new BoardInfoControl());
		// 수정관련
		map.put("/modBoardForm.do", new ModifyFormControl());
		map.put("/updateBoard.do", new ModifyControl());
		// 삭제관련
		map.put("/removeBoardForm.do", new RemoveFormControl());
		map.put("/deleteBoard.do", new RemoveControl());
		// 로그인
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		// 로그아웃
		map.put("/logout.do", new LogoutControl());
		
		
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8"); // 요청 처리의 한글처리
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri = " + uri + ", context = " + context);
		String path = uri.substring(context.length());
		System.out.println("path = " + path);

		Control control = map.get(path);
		control.exec(req, resp);
	}

	@Override
	public void destroy() {

	}
}
