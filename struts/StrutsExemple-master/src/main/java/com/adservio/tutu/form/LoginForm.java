package com.adservio.tutu.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomUtilisateur;
	private String mdpUtilisateur;

	/*
	 * Constructor
	 */
	/**
	 * 
	 */
	public LoginForm() {
	}

	/**
	 * Validate Login Form
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();
		return actionErrors;
	}

	/**
	 * Reset Login info
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		nomUtilisateur = null;
		mdpUtilisateur = null;
	}

	/*
	 * Getter and setter
	 */

	/**
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * @param nomUtilisateur
	 *            the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * @return the mdpUtilisateur
	 */
	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	/**
	 * @param mdpUtilisateur
	 *            the mdpUtilisateur to set
	 */
	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}
}
