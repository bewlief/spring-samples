package com.adservio.tutu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.adservio.tutu.form.HelloWorldForm;

/**
 * The Action Controller
 * 
 * @author Skander.Bachouche
 *
 */
public class HelloWorldAction extends Action {

	/**
	 * overrided Execute method of Action
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HelloWorldForm helloWorldForm = (HelloWorldForm) form;
		helloWorldForm.setMessage("Hello world");
		return mapping.findForward("succes");
	}
}
