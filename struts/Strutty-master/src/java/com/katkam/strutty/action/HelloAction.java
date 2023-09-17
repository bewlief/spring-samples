package com.katkam.strutty.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.katkam.strutty.form.HelloForm;

/**
 *
 * @author nitin
 */
public class HelloAction extends Action {
    public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
        
        HelloForm frm = (HelloForm) form;
        frm.setMessage("Ola Mundo");
        return mapping.findForward("cool");
    }
}
