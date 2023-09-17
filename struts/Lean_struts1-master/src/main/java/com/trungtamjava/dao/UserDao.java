package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.model.User;
import com.trungtamjava.utils.JDBCConnection;

public class UserDao {

	public User getUserById(int id) {
		String sql = "select * from product where id=?";
		Connection connection = JDBCConnection.getJDBCConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setAbout(rs.getString("about"));
				user.setPhone(rs.getString("phone"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFavourites(rs.getString("favourites"));

				return user;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "select * from product";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setAbout(rs.getString("about"));
				user.setPhone(rs.getString("phone"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFavourites(rs.getString("favourites"));
				users.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void addUser(User user) {

		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = " insert into product(phone ,username, password, about, role ,favourites, avarta, name) value(?, ? ,? ,? ,? ,? ,? ,? ) where id ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPhone());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getAbout());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getFavourites());
			preparedStatement.setString(7, user.getAvatar());
			preparedStatement.setString(8, user.getName());

			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void updateUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "update product set phone?, username?, password?, about?, role?, favourites?, avarta?, name? where id?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPhone());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getAbout());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getFavourites());
			preparedStatement.setString(7, user.getAvatar());
			preparedStatement.setString(8, user.getName());

			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
