package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 원본글, 댓글작성자, 댓글내용
		String reply = req.getParameter("reply");
		String replier = req.getParameter("replier");
		String boardNo = req.getParameter("bno");
		
		ReplyVO rvo = new ReplyVO();
		
		ReplyService replyService = new ReplyServiceImpl();
		
		rvo.setReply(reply);
		rvo.setReplier(replier);
		rvo.setBoardNo(Integer.parseInt(boardNo));
		
		if(replyService.addReply(rvo)) {
			// {"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			// {"retCode": "NG"}
			resp.getWriter().print("{\"retCode\": \"NG\"}");			
		};
		
	}

}
