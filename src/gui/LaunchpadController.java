package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class LaunchpadController {
	
	@FXML Button logout;
	@FXML Button addASession;
	@FXML Button viewAllSessions;
	@FXML Button ph1;
	@FXML Button ph2;
	@FXML Text msg;
	
	@FXML
	public void initialize() {
		try {
			msg.setText("Welcome, "+backend.Driver.getLogic().getUsername()+"!");
		}catch(NullPointerException n) {
		}
	}
	
	@FXML
	void addSessionClicked() {
		backend.Driver.getLogic().switchToStage("addsession");
		System.out.println("click");
	}
	
	@FXML
	void viewSessionsClicked() {
		backend.Driver.getLogic().switchToStage("viewallsessions");
		System.out.println("click");
	}
	
	@FXML
	void addScoreClicked() {
		backend.Driver.getLogic().switchToStage("addscore");
	}
	
	@FXML
	void logout(ActionEvent event) {
		backend.Driver.getLogic().switchToStage("frontpage");
	}
	
}
