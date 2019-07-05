package gui;

import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewAllSessionsController {
	@SuppressWarnings("rawtypes")
	@FXML TableView table;
	@SuppressWarnings("rawtypes")
	@FXML TableColumn durationCol;
	@SuppressWarnings("rawtypes")
	@FXML TableColumn intensityCol;
	@SuppressWarnings("rawtypes")
	@FXML TableColumn descriptionCol;
	@SuppressWarnings("rawtypes")
	@FXML TableColumn typeCol;
	@SuppressWarnings("rawtypes")
	@FXML TableColumn authorCol;
	
	Vector<Session> sessions = new Vector<Session>();
	private ObservableList<Session> data = FXCollections.observableArrayList();
	
	@FXML
	void updateTable() {
		System.out.println("Updating table.");
		table.setEditable(false);
		durationCol.setCellValueFactory(new PropertyValueFactory<Session, Integer>("duration"));
		intensityCol.setCellValueFactory(new PropertyValueFactory<Session, Integer>("intensity"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Session, String>("description"));
		typeCol.setCellValueFactory(new PropertyValueFactory<Session, String>("type"));
//		authorCol.setCellValueFactory(new PropertyValueFactory<Session, String>("author"));
		sessions = backend.Driver.getLogic().getAllSessions();
		table.setItems(data);
		for(Session s : sessions) {
			System.out.println("Found a session.");
			data.add(s);
		}
	}
	
	@FXML
	void switchBack() {
		backend.Driver.getLogic().switchToStage("launchpad");
	}
}
