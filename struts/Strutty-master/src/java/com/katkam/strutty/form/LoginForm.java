package com.katkam.strutty.form;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author nitin
 */
public class LoginForm extends ActionForm{
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
