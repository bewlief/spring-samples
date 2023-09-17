package com.sample.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.sample.pojo.User;

public class LoginForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String msg;
	private List<User> userList = new ArrayList<>();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
