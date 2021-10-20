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

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			
			MvcUtil.forward("user/loginform", request, response);
			return;
			
		} if(request.getAttribute(user_no) = 1){
			
		} else {
	
		BoardVo vo = new BoardVo();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long no = Long.parseLong(request.getParameter("no"));

		vo.setTitle(title);
		vo.setContents(content);
		vo.setNo(no);

		new BoardDao().update(vo);

		MvcUtil.redirect(request.getContextPath() + "/board", request, response);
		
		}
		
	}

}