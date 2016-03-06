package controller;

import java.util.Optional;

import application.LostAnimalView;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class LostAnimalController extends ActionEvent implements EventHandler<ActionEvent> {
	private static final long serialVersionUID = 1L;
	private String action;
	LostAnimalView lostAnimalView;
	
	public LostAnimalController(LostAnimalView lostAnimalView, String action) {
		this.lostAnimalView = lostAnimalView;
		this.action = action;
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(action.equalsIgnoreCase("Submit")) {
			submitButton();
		}
		
		else if(action.equalsIgnoreCase("Clear")) {
			clearButton();
		}
		
		else {
			cancelButton();
		}
	}

	public void submitButton() {
		
	}
	
	public void clearButton() {
		lostAnimalView.getAnimalIdField().setText("");
		lostAnimalView.getAnimalNameField().setText("");
		lostAnimalView.getAnimalDateField().setText("");
		lostAnimalView.getAnimalLocationField().setText("");
		lostAnimalView.getAnimalDescriptionArea().setText("");
		lostAnimalView.getOwnerNameField().setText("");
		lostAnimalView.getOwnerTelephoneField().setText("");
		lostAnimalView.getOwnerEmailField().setText("");
		lostAnimalView.getOwnerAddressField().setText("");
	}	
	
	public void cancelButton() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Cancelation");
		alert.setHeaderText("Cancelation");
		alert.setContentText("Attention: Information will not be kept!\nDo you want to proceed?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    Main.getStage().setScene(Main.getScene());
		} 
	}
}
