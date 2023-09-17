package com.trungtamjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;

public class UserAction extends MappingDispatchAction {


	public ActionForward addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		return mapping.findForward("addUser");
	}

	public ActionForward deleteUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

	
		return mapping.findForward("deleteUser");
	}
	public ActionForward viewUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	int id =Integer.valueOf(request.getParameter("userId"));
		UserService userService= new UserService();
		User user =userService.getUserById(id);
		request.setAttribute("u", user);
		return mapping.findForward("viewUser");
	}
	public ActionForward updateUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("updateUser");
	}
}
