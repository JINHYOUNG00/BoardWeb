package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	// 게시판 목록조회
	public List<BoardVO> boardList();
	// 게시판 등록
	public int insertBoard(BoardVO board);
	// 게시판 상세조회
	public BoardVO selectBoard(int boardNo);
	// 조회수 증가
	public int updateViewCnt(int boardNo);
	// 게시판 수정
	public int updateBoard(BoardVO board);
	// 게시판 삭제
	public int deleteBoard(int boardNo);
}
