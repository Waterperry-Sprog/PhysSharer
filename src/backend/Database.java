package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private String dbURL;
    private Connection conn = null;
    private Statement stmt = null;
	
	public Database(String ip) {
		dbURL = ip;
	}
	
	public void createConnection() {
        try {
            //Get a connection
            conn = DriverManager.getConnection(dbURL, "user", "pass"); 
            if(conn == null) {
            	System.out.println("Database cannot be accessed at this time :( Please try again later.");
            }
        }
        catch (Exception e) {
//        	e.printStackTrace();
        	System.out.println("ERROR [FATAL]: Application could not run at this time due to database error. Exiting...");
            System.exit(1);
        }
    }
	
	public ResultSet executeQuery(String sql) {
    	try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public void executeUpdate(String sql) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Statement executed successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyUserPassPair(String user, String pass) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PASSWORD FROM data WHERE USERNAME = '"+user+"'");
			if(rs.next()){
				if(rs.getString(1).equals(pass)) {
					return true;
				}
			};
			
		} catch (SQLException e) {
			// TODO: handle exception [DEBUG] MAYBE STATE INVALID OPERATION ON THE DATABASE
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean signup(String user, String pass) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PASSWORD FROM data WHERE USERNAME = '"+user+"'");
			if(rs.next()) {
				System.out.println("Sorry, username taken.");
				return false;
			}
			else {
				executeUpdate("INSERT INTO DATA VALUES ('"+user+"','"+pass+"')");
				System.out.println("Signed up successfully! Try clicking Sign In!");
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public void queryTables() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TABLENAME FROM SYS.SYSTABLES WHERE TABLETYPE = 'T'");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	 public void closeConnection() {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                DriverManager.getConnection(dbURL + ";shutdown=true");
	                conn.close();
	            }           
	        }
	        catch (SQLException sqlExcept) {
	            
	        }
	 }
	
}
