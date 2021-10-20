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

public class UserRecognition implements Action {

	public void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		String userNo = Long.toString(authUser.getNo());
		
		String no = request.getParameter("user_no");
		
		if(userNo != no){
			
			System.out.println("작성자가 틀립니다.");
			MvcUtil.redirect(request.getContextPath() + "/board", request, response);
			
		} else {
			MvcUtil.forward("board/modify", request, response);
		}
		
	}
}
