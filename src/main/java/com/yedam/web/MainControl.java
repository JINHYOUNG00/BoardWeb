package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchVO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/board/boardList.jsp";
		path = "board/boardList.tiles";
		
		SearchVO search = new SearchVO();
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		
		// page 파리미터값이 없을때(처음 들어갈때) 1페이지로
		page = page == null ? "1" : page;
		
		search.setPage(Integer.parseInt(page));
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		
		
		BoardService boardService = new BoardServiceImpl();
//		List<BoardVO> list = boardService.boardList(Integer.parseInt(page)); // 목록
		List<BoardVO> list = boardService.boardList(search); // 목록
		
//		System.out.println(boardService.getTotal() + "아아ㅏ아아아아ㅏㅇ");
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), boardService.getTotal(search)); // 건수
		
		//jsp 페이지에 정보 전달
		req.setAttribute("boardList", list);
		req.setAttribute("paging", pageDTO);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
}
