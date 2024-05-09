package com.yedam.common;

import java.util.List;

import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
		BoardServiceImpl svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
//		vo.setTitle("등록제목");
//		vo.setContent("등록내용");
//		vo.setWriter("user00");
//		
//		if(svc.addBoard(vo)) {
//			System.out.println("등록성공");
//		} else {
//			System.out.println("등록실패");
//		}
//		
//		List<BoardVO> list = svc.boardList();
//		for (BoardVO boardVO : list) {
//			System.out.println(boardVO.toString());
//		}
		
		vo = svc.getBoard(1);
		
		if(vo != null) {
			System.out.println(vo.toString());
		} else {
			System.out.println("조회결과 없음");
		}
	}
}
