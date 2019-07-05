package gui;

import javafx.fxml.FXML;

public class AddScoreController {

	@FXML
	void switchToLaunchpad() {
		backend.Driver.getLogic().switchToStage("launchpad");
	}
	
}
