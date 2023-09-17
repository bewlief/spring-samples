package com.katkam.strutty.form;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author nitin
 */
public class HelloForm extends ActionForm {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
