package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Properties prop=null;
		
		try {
			prop=loadPropertiesFile();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		final String driver=prop.getProperty("driver");
		final String url=prop.getProperty("url");
		final String username=prop.getProperty("username");
		final String password=prop.getProperty("password");
		
		// Registering the driver class
		Class.forName(driver);
		
		// Creating connection object
		Connection con=null;
		con=DriverManager.getConnection(url,username,password);
		
		if(con!=null)
			System.out.println("Connection Established");
		else
			System.out.println("Check your connection");
		
		return con;
	}
	
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}


