package com.douzone.mysite.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class SearchAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String kwd = request.getParameter("kwd");
		String box = request.getParameter("box");

		if (box.equals("tit")) {
			
			List<BoardVo> list = new BoardDao().searchbyTitle(kwd);
			request.setAttribute("list", list);
			MvcUtil.forward("board/searchedList", request, response);
			
		} else {
			
			List<BoardVo> list = new BoardDao().searchbyCont(kwd);
			request.setAttribute("list", list);
			MvcUtil.forward("board/searchedList", request, response);
			
		}

	}

}
