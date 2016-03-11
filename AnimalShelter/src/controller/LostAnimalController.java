package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import application.LostAnimalView;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.Animal;
import model.AnimalList;
import model.Category;
import model.LostAnimal;
import model.Person;

public class LostAnimalController extends ActionEvent implements EventHandler<ActionEvent> {
	private static final long serialVersionUID = 1L;
	private String action;
	File file = new File();
	AnimalList animalList = new AnimalList();
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
		
		else if(action.equalsIgnoreCase("Cancel")){
			cancelButton();
		}
		
		else if(action.equalsIgnoreCase("SearchToDelete")){
			searchToDeleteButton();
		}
	}

	public void submitButton() {

		try {
			file.writeInFile("lostAnimal.txt", lostAnimalView.getAnimalIdField().getText() + "\t" + lostAnimalView.getAnimalNameField().getText() 
			                 + "\t" + lostAnimalView.getAnimalDateField().getValue() + "\t" + lostAnimalView.getAnimalLocationField().getText()
			                 + "\t" + lostAnimalView.getAnimalDescriptionArea().getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		clearButton();
	}
	
	public void clearButton() {
		lostAnimalView.getAnimalIdField().setText("");
		lostAnimalView.getAnimalNameField().setText("");
		lostAnimalView.getAnimalDateField().setValue(null);
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
	
	public void searchToDeleteButton() {
		try {
			animalList = file.readFile("lostAnimal.txt");
			int index = animalList.getIndexBySearch(Integer.parseInt(lostAnimalView.getAnimalSearchField().getText()));
			
			lostAnimalView.getAnimalIdField().setText(String.valueOf(animalList.getAnimalList().get(index).getAnimalId()));
			lostAnimalView.getAnimalNameField().setText(animalList.getAnimalList().get(index).getAnimalName());
			lostAnimalView.getAnimalDateField().setValue(animalList.getAnimalList().get(index).getAnimalCategory().getDate());
			lostAnimalView.getAnimalLocationField().setText("");
			lostAnimalView.getAnimalDescriptionArea().setText(animalList.getAnimalList().get(index).getAnimalDescription());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
