package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardMapper {
	// 게시판 목록조회
	public List<BoardVO> boardList();
	// 페이징
	public List<BoardVO> boardListPaging(int pageNo);
	// 전체건수계산
	public int getTotalCnt();
	
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
	// 사용자 id, pw 확인 (로그인)
	public MemberVO selectMember(@Param("id") String id,@Param("pw") String pw);
	// 사용자 확인
	public MemberVO selectMember2(String id);
}
