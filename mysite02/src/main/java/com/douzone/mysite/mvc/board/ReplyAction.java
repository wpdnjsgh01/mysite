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
			
			System.out.println("reply action 진입");
			
			int id = Integer.parseInt(request.getParameter("no"));
		
			BoardVo vo = new BoardDao().findByID(id);
		
			request.setAttribute("vo", vo);
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int user_no = authUser.getNo();
			
			vo.setTitle(title);
			vo.setContents(content);
			vo.setUserNo(user_no);
			
			new BoardDao().replyInsert(vo);
			
			MvcUtil.redirect(request.getContextPath() + "/board", request, response);
		}
		
	}
	
}
