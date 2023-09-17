package com.adservio.tutu.form;

import org.apache.struts.action.ActionForm;

/**
 * Form to hold Data
 * 
 * @author Skander.Bachouche
 *
 */
public class HelloWorldForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	/*
	 * Constructor
	 */
	/**
	 * 
	 */
	public HelloWorldForm() {
		super();
	}

	/*
	 * Getter and Setter
	 */
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
