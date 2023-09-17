package br.com.struts.forms;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm{

	/**
	 * @param args
	 */
	
	public static final long serialVersionUID = 7352021000623040587L;
	public String hello = null;
	
	public HelloWorldForm(){
		super();
		hello = "Hello Word Struts";
	}
	
	public String getHello(){
		return hello;
	}
	
	public void setHello(String hello){
		this.hello = hello;
	}
	
}
