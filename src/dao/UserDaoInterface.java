package dao;

import java.sql.SQLException;

import model.User;

public interface UserDaoInterface{
	
	int signUp(User user) throws ClassNotFoundException, SQLException;
	boolean loginUser(User user) throws ClassNotFoundException, SQLException;
}