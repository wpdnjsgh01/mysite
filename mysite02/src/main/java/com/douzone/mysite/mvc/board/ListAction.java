package com.douzone.mysite.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.mvc.dto.BoardDto;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.PageVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cur;
		if(request.getParameter("cur") == null) {
			cur = 1;
		}else {
			cur = Integer.parseInt(request.getParameter("cur"));	
		}
		
		int curPage = Integer.parseInt(request.getParameter("cur"));
		
		List<BoardDto> list2 = new BoardDao().findAllbyDto();
		int total = new BoardDao().getCount();
		
		
		// 현재 페이지, 총 개수
		PageVo page = new PageVo(cur, total);
		List<BoardVo> list = new BoardDao().findAllbyVo(page);
		
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
		MvcUtil.forward("board/list", request, response);

	}

}