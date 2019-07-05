package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewController extends Application {
	
	private static Stage stage;
	Parent root;
	String usernameString = "";
	
	public String getUsernameString() {
		return usernameString;
	}
	
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource("frontpage.fxml"));
			stage = primaryStage;
			Scene scene = new Scene(root, 600, 400);
//			scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("PhysSharer");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}

	public void switchToStage(String stageName) {
		if(stageName.contentEquals("frontpage")) {
			this.usernameString = "";
		}
		try {
			root = FXMLLoader.load(getClass().getResource(""+stageName+".fxml"));
			stage.setScene(new Scene(root, 600, 400));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showUI() {
	   	launch(); 
	}
}
