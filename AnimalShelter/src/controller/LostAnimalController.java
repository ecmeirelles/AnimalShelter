package controller;

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
		Person person = new Person();
		person.setPersonName(lostAnimalView.getOwnerNameField().getText());
		person.setPersonPhone(lostAnimalView.getOwnerTelephoneField().getText());
		person.setPersonEmail(lostAnimalView.getOwnerEmailField().getText());
		person.setPersonAddress(lostAnimalView.getOwnerAddressField().getText());
		
		Category category = new Category();
		category.setDate(lostAnimalView.getAnimalDateField().getValue());
		category.setEmergencyContact(person);
		
		Animal animal = new Animal();
		animal.setAnimalId(Integer.parseInt(lostAnimalView.getAnimalIdField().getText()));
		animal.setAnimalName(lostAnimalView.getAnimalNameField().getText());
		animal.setAnimalDescription(lostAnimalView.getAnimalDescriptionArea().getText());
		animal.setAnimalCategory(category);
		
		AnimalList animalList = new AnimalList();
		animalList.addAnimal(animal);
		
		LostAnimal lostAnimal = new LostAnimal(category.getDate(), category.getEmergencyContact());
		lostAnimal.setDate(lostAnimalView.getAnimalDateField().getValue());
		lostAnimal.setLostLocation(lostAnimalView.getAnimalLocationField().getText());
		
		clearButton();
		
		System.out.println("--------------- ANIMAL ---------------");
		System.out.println("ID: " + animal.getAnimalId());
		System.out.println("Name: " + animal.getAnimalName());
		System.out.println("Date: " + animal.getAnimalCategory().getDate());
		System.out.println("Location: " + lostAnimal.getLostLocation());
		System.out.println("Description: " + animal.getAnimalDescription());
		
		System.out.println("-------------- PERSON ----------------");
		System.out.println("Name: " + lostAnimal.getEmergencyContact().getPersonName());
		System.out.println("Telephone: " + lostAnimal.getEmergencyContact().getPersonPhone());
		System.out.println("E-mail: " + lostAnimal.getEmergencyContact().getPersonEmail());
		System.out.println("Address: " + lostAnimal.getEmergencyContact().getPersonAddress());
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
}
