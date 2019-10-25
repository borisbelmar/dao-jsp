package com.dobleb.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.dobleb.login.model.User;
import com.dobleb.login.model.Database;


public class UserDAO {
	private Database db;
	private Connection connection;
 
	public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		db = new Database(jdbcURL, jdbcUsername, jdbcPassword);
	}
 
	// Insert
	public boolean insert(User user) throws SQLException {
		String sql = "INSERT INTO users (username, pass, firstname, lastname, rut) VALUES (?, ?, ?, ?, ?)";
		System.out.println(user.getUsername());
		db.connect();
		connection = db.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPass());
		statement.setString(3, user.getFirstname());
		statement.setString(4, user.getLastname());
		statement.setString(5, user.getRut());
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		db.disconnect();
		
		return rowInserted;
	}
 
	// Read All
	public List<User> findAll() throws SQLException {
 
		List<User> users = new ArrayList<User>();
		String sql = "SELECT id, username, pass, firstname, lastname, rut FROM users";
		db.connect();
		connection = db.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String username = resulSet.getString("username");
			String pass = resulSet.getString("pass");
			String firstname = resulSet.getString("firstname");
			String lastname = resulSet.getString("lastname");
			String rut = resulSet.getString("rut");
			User user = new User(id, username, pass, firstname, lastname, rut);
			users.add(user);
		}
		db.disconnect();
		return users;
	}
 
	// Find by ID
	public User findById(int id) throws SQLException {
		User user = null;
 
		String sql = "SELECT id, username, pass, firstname, lastname, rut FROM users WHERE id=?";
		db.connect();
		connection = db.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
 
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			user = new User(
				res.getInt("id"), 
				res.getString("username"), 
				res.getString("pass"), 
				res.getString("firstname"), 
				res.getString("lastname"), 
				res.getString("rut")
			);
		}
		res.close();
		db.disconnect();
 
		return user;
	}
	
	// Checkear Usuarios
	public User checkUser(String username, String pass) throws SQLException {
		User user = null;
 
		String sql = "SELECT id, username, pass, firstname, lastname, rut FROM users WHERE username=? AND pass=?";
		db.connect();
		connection = db.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, pass);
 
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			user = new User(
				res.getInt("id"), 
				res.getString("username"), 
				res.getString("pass"), 
				res.getString("firstname"), 
				res.getString("lastname"), 
				res.getString("rut")
			);
		}
		res.close();
		db.disconnect();
 
		return user;
	}
 
	// Update
	public boolean update(User user) throws SQLException {
		boolean rowUpdate = false;
		String sql = "UPDATE users SET username=?, pass=?, firstname=?, lastname=?, rut=? WHERE id=?";
		db.connect();
		connection = db.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPass());
		statement.setString(3, user.getFirstname());
		statement.setString(4, user.getLastname());
		statement.setString(5, user.getRut());
		statement.setInt(6, user.getId());
		rowUpdate = statement.executeUpdate() > 0;
		statement.close();
		db.disconnect();
		return rowUpdate;
	}
	
	// Delete by ID
	public boolean delete(User user) throws SQLException {
		boolean rowDelete = false;
		String sql = "DELETE FROM users WHERE ID=?";
		db.connect();
		connection = db.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, user.getId());
 
		rowDelete = statement.executeUpdate() > 0;
		statement.close();
		db.disconnect();
 
		return rowDelete;
	}
}
