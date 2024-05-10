package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.common.PageDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/board/boardList.jsp";
		
		String page = req.getParameter("page");
		
		// page 파리미터값이 없을때(처음 들어갈때) 1페이지로
		page = page == null ? "1" : page;
		
		BoardService boardService = new BoardServiceImpl();
		List<BoardVO> list = boardService.boardList(Integer.parseInt(page)); // 목록
		
//		System.out.println(boardService.getTotal() + "아아ㅏ아아아아ㅏㅇ");
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), boardService.getTotal()); // 건수
		
		//jsp 페이지에 정보 전달
		req.setAttribute("boardList", list);
		req.setAttribute("paging", pageDTO);
		
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
}
