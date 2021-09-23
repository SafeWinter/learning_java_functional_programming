package ch3.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo13_ConnProperties {
	
	private static String dbms = "oracle";
	private static String serverName = "localhost";
	private static int portNumber = 1521;
    
    @SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
        
    	ConnectionProperties cp = new ConnectionProperties()
        		.user("user")
        		.password("password");
        
        Connection conn = DriverManager.getConnection(
    		"jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" 
    		, cp.properties()  // hide Properties instance
        );
    }
}

class ConnectionProperties {
	
	@SuppressWarnings("unused")
	private String user;
	
	@SuppressWarnings("unused")
	private String password;
	
	private Properties properties = new Properties();
	
	public ConnectionProperties user(String user) {
		this.user = user;
		this.properties.setProperty("user", user);
		return this;
	}
	
	public ConnectionProperties password(String password) {
		this.password = password;
		this.properties.setProperty("password", password);
		return this;
	}
	
	public Properties properties() {
		return this.properties;  // hide Properties instance
	}
}