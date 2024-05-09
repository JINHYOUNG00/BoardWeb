package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	// 게시판 목록조회
		public List<BoardVO> boardList();
		// 게시판 등록
		public boolean addBoard(BoardVO board);
		// 게시판 상세조회
		public BoardVO getBoard(int boardNo);
		// 조회수 증가
		public int addViewCnt(int boardNo);
		// 게시판 수정
		public boolean modifyBoard(BoardVO board);
		// 게시판 삭제
		public boolean removeBoard(int boardNo);
}
