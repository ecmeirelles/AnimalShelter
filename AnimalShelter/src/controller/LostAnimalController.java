package controller;

import application.LostAnimalView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
		
	}
}
