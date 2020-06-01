package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.User;
import utility.ConnectionManager;


public class UserDAO implements UserDaoInterface{

	@Override
	public int signUp(User user) throws ClassNotFoundException, SQLException {
		
		String email=user.getEmail();
		String password=user.getPassword();
		LocalDate date=user.getDate();
		
		//inserting details into data base
		String sql="insert into PROJECT2(EMAIL,PASSWORD,DATE_NOW)VALUES(?,?,?)";
		// create statement object
		PreparedStatement st=ConnectionManager.getConnection().prepareStatement(sql);
		
	java.sql.Date date_now=java.sql.Date.valueOf(date);
		st.setString(1, email);
		st.setString(2, password);
		st.setDate(3, date_now);
	
		st.executeUpdate();
		
		ConnectionManager.getConnection().close();
		return 0;
		
	}

	@Override
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {

	String email=user.getEmail();
	String password=user.getPassword();
	Statement st=ConnectionManager.getConnection().createStatement();
	ResultSet rs=st.executeQuery("SELECT * from PROJECT2");
	
	while(rs.next())
	{
		if(email.equals(rs.getString("EMAIL")) && password.equals(rs.getString("PASSWORD")))
		{
			ConnectionManager.getConnection().close();
			return true;
		}
		else {
			ConnectionManager.getConnection().close();
			return true;
		}
	}
	return false;
		
	}
	
}