package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	// 목록
	public List<ReplyVO> replyList(int boardNo);
	// 한건 삭제
	public boolean removeReply(int replyNo);
	// 한건 등록
	public boolean addReply(ReplyVO reply);
}
