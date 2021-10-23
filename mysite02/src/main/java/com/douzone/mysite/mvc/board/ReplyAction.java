package com.douzone.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class ReplyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션인증
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			
			MvcUtil.redirect(request.getContextPath(), request, response);
			
		} else {
			
			String title = request.getParameter("title"); //작성 폼에서 제목 가져오기
			String content = request.getParameter("content"); //작성 폼에서 내용 가져오기
			int no = Integer.parseInt(request.getParameter("no")); // 작성 인덱스 가져오기
			
			int userNo = authUser.getNo(); //현재 사용자의 사용자 no를 userNO에 담기
		
			//BoardVo vo = new BoardDao().findByID(no); // 인덱스로 글 찾기
			
			BoardVo board = new BoardDao().boardInfo(no); //인덱스로 보드 정보 가져오기
			
			int group_No = board.getGroupNo();
			int order_No = board.getOrderNo();
			int depth = board.getDepth();
			
			BoardVo boardVo = new BoardVo();
			
			boardVo.setTitle(title);
			boardVo.setContents(content);
			boardVo.setGroupNo(group_No);
			boardVo.setOrderNo(order_No);
			boardVo.setDepth(depth);
			boardVo.setUserNo(userNo);
			
			new BoardDao().replyUpdate(boardVo);
			new BoardDao().replyInsert(boardVo);
			
			MvcUtil.redirect(request.getContextPath() + "/board", request, response);
		}
		
	}
	
}
