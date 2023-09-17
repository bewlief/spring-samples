package com.joseoliveros.textboxexample;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class UserForm extends ActionForm {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        System.out.println("dentro del validate");
        if (getUserName() == null || (getUserName().equals(""))) {
            errors.add("elerror", new ActionMessage("error.common.name.required"));
        }
        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, ServletRequest request) {
        userName = "";
    }
}
