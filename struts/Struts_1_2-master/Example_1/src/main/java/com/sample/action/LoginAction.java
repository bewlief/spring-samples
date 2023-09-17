package com.sample.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sample.form.LoginForm;
import com.sample.pojo.Contact;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm helloWorldForm = (LoginForm) form;

		List<Contact> players = new ArrayList<Contact>();
		players.add(new Contact("Virat", 1, "Mohali"));
		players.add(new Contact("Mahendara", 2, "Ranchi"));
		players.add(new Contact("Virender", 3, "Delhi"));
		players.add(new Contact("Ajinkya", 4, "Jaipur"));
		players.add(new Contact("Gautam", 5, "Delhi"));
		players.add(new Contact("Rohit", 6, "Mumbai"));
		players.add(new Contact("Ashok", 7, "Kolkata"));
		players.add(new Contact("Ravi", 8, "Chennai"));

		request.getSession().setAttribute("players", players);

		List<Contact> stars = new ArrayList<Contact>();
		stars.add(new Contact("Shahrukh", 98273633, "Delhi"));
		stars.add(new Contact("Sallu", 98273634, "Ranchi"));
		stars.add(new Contact("Roshan", 98273635, "Delhi"));
		stars.add(new Contact("Devgan", 98273636, "Jaipur"));
		stars.add(new Contact("Hashmi", 98273637, "Delhi"));
		stars.add(new Contact("Abraham", 98273638, "Mumbai"));
		stars.add(new Contact("Kumar", 98273639, "Kolkata"));
		stars.add(new Contact("Shetty", 98273640, "Chennai"));

		request.getSession().setAttribute("stars", stars);

		/*
		 * Map<String, Boolean> map = new HashMap<String, Boolean>(); for (int i
		 * = 0; i < userProductData.size(); i++) { String productSubCategoryName
		 * = userProductData.get(i).getProductSubCategory();
		 * System.out.println(productSubCategoryName);
		 * map.put(productSubCategoryName, true); }
		 */
		// request.setAttribute("productSubCategoryMap", map);

		/*
		 * User user; List<User> users=new ArrayList<>(); for(int i=0;i<10;i++)
		 * { user=new User(); user.setName("name "+i); user.setPwd("pwd: "+i);
		 * user.setIsAdmin(false); users.add(user); }
		 * helloWorldForm.setUserList(users);
		 * request.getSession().setAttribute("user", users);
		 * System.out.println("HelloWorldAction.execute()");
		 */
		return mapping.findForward("success");
	}

	public int getContact() {
		return 5;
	}
}
