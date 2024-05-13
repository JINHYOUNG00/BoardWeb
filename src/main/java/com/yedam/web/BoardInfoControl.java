package com.yedam.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.SearchVO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/board/board.jsp";
		path = "board/board.tiles";
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		SearchVO search = new SearchVO();
		search.setPage(Integer.parseInt(page));
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo = svc.getBoard(Integer.parseInt(bno)); // 상세 조회
		svc.addViewCnt(Integer.parseInt(bno)); // 조회수 증가
		
		req.setAttribute("result", vo);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}

}
