package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.model.User;

public class UserService {
	private UserDao userDao;
public UserService() {
	userDao= new UserDao();
}
public List<User> getUsers(){
	return userDao.getAllUsers();
}
public User getUserById(int id) {
	return userDao.getUserById(id);
	
}
public void addUser(User user) {
	userDao.addUser(user);
	
}

}
