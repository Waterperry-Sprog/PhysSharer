package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FrontpageController {
	
	@FXML TextField username;
	@FXML PasswordField password;
	
	@FXML
	private void signup(ActionEvent event) {
		backend.Driver.getLogic().signup(username.getText(),password.getText());
		event.consume();
	}
	
	@FXML
	private void login(ActionEvent event) {
		backend.Driver.getLogic().login(username.getText(),password.getText());
		event.consume();
	}
}