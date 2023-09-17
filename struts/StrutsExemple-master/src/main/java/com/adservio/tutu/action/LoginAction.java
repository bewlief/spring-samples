package com.adservio.tutu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.adservio.tutu.form.LoginForm;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class LoginAction extends Action {

	/*
	 * Constructor
	 */
	/**
	 * 
	 */
	public LoginAction() {
	}

	/**
	 * overrided Execute method of Action
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String resultat = null;
		LoginForm loginForm = ((LoginForm) form);
		String mdpUtilisateur = loginForm.getMdpUtilisateur();
		String nomUtilisateur = loginForm.getNomUtilisateur();

		if (("admin").equals(nomUtilisateur) && ("admin").equals(mdpUtilisateur)) {
			resultat = "succes";
		} else {
			resultat = "echec";
		}

		return mapping.findForward(resultat);
	}

}
