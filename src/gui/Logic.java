package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import backend.Database;

public class Logic {
	
	ViewController vc;
	protected backend.Database logins = new Database("jdbc:derby://localhost:1527/logins;create=true");
	protected backend.Database workouts = new Database("jdbc:derby://localhost:1527/workouts;create=true");
	
	public Logic(ViewController vc) {
		this.vc = vc;
	}
	
	public void switchToStage(String stageName) {
		vc.switchToStage(stageName);
	}
	
	public String getUsername() {
		return vc.getUsernameString();
	}
	
	protected void signup(String username, String password) {
		logins.createConnection();
		logins.signup(username, password);
		logins.closeConnection();
		
	}
	
	protected void login(String username, String password) {
		vc.setUsernameString(username);
		logins.createConnection();
		if(username.equals("")||password.equals("")) {
			System.out.println("empty field somewhere.");
		}
		else if(logins.verifyUserPassPair(username, password)){
			vc.switchToStage("launchpad");
		}
		logins.closeConnection();
		
	}
	
	protected void addWorkout(String duration, String intensity, String description, String type) {
		workouts.createConnection();
		System.out.println("INSERT INTO SESSIONS VALUES ("+duration+","+intensity+",'"+description+"','"+type+"','"+backend.Driver.getLogic().getUsername()+"')");
		workouts.executeUpdate("INSERT INTO SESSIONS VALUES ("+duration+","+intensity+",'"+description+"','"+type+"','"+backend.Driver.getLogic().getUsername()+"')");
		workouts.closeConnection();
	}
	
	protected Vector<Session> getAllSessions(){
		Vector<Session> ses = new Vector<Session>();
		workouts.createConnection();
		ResultSet rs = workouts.executeQuery("SELECT * FROM SESSIONS");
		try {
			do {
				ses.add(new Session(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			} while(rs.next());
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ses;
	}
}
