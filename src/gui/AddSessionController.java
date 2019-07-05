package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddSessionController {

	@FXML TextField duration;
	@FXML TextField intensity;
	@FXML TextArea description;
	@FXML Button submit;
	@FXML Button clear;
	String type = "";
	
	@FXML
	void submit() {
		//create db connection and submit workout
		if(duration.getText().contentEquals("") || intensity.getText().contentEquals("") || description.getText().contentEquals("") || type.contentEquals("")) {
			
		}
		else {
			backend.Driver.getLogic().addWorkout(duration.getText(), intensity.getText(), description.getText(), type);
		}
		
	}
	
	@FXML
	void circ() {
		type = "circuit";
	}
	@FXML
	void run() {
		type = "run";
	}
	@FXML 
	void wei() {
		type = "weights";
	}
	@FXML
	void spr() {
		type = "sprints";
	}
	@FXML
	void cro() {
		type = "crossfit";
	}
	@FXML
	void oth() {
		type = "other";
	}
	
	@FXML
	void clear() {
		//clear fields and return to launchpad
		System.out.println("clear.");
		duration.setText("");
		intensity.setText("");
		backend.Driver.getLogic().switchToStage("launchpad");
	}
	
}
