package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardService {
		// 게시판 목록조회
//		public List<BoardVO> boardList();
//		public List<BoardVO> boardList(int page);
		public List<BoardVO> boardList(SearchVO search);
		
		public int getTotal(SearchVO search);
		
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
		
		// 로그인
		MemberVO login(String id, String pw);
		
		// 유효한 아이디 체크 
		MemberVO chechMember(String id);

}
