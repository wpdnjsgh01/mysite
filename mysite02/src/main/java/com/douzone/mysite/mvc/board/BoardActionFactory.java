package com.douzone.mysite.mvc.board;

import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action = null;

		if("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if("write".equals(actionName)) {
			action = new WriteAction();
		} else if("replyform".equals(actionName)) {
			action = new ReplyFormAction();
		} else if("reply".equals(actionName)) {
			action = new ReplyAction();
		} else if("search".equals(actionName)) {
			action = new ListAction();
		} else if("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if("view".equals(actionName)) {
			action = new ViewAction();
		} else if("updateform".equals(actionName)) {
			action = new UpdateFormAction();
		} else if("update".equals(actionName)) {
			action = new UpdateAction();
		} else {
			action = new ListAction();
		}
		
		return action;
	}

}