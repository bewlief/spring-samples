package com.katkam.strutty.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.katkam.strutty.form.LoginForm;

/**
 *
 * @author nitin
 */
public class LoginAction {
    public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
        LoginForm frm = (LoginForm) form;
        
        String username = frm.getUsername();
        String password = frm.getPassword();
        
        if (username == null || password == null || username != "nitin" || password != "nitin") {
            return mapping.findForward("failure");
        } else {
            return mapping.findForward("success");
        }
    }
}
