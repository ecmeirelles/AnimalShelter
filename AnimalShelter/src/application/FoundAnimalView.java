package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class FoundAnimalView extends Scene {
	
	private Pane actionPane;

	public FoundAnimalView(BorderPane root, double width, double height, String action) {
		super(root, width, height);
		
		HBox adaptableBox = new HBox();
		
		DisplayMenu displayMenu = new DisplayMenu(new Main());
		displayMenu.menu();

		if(action.equalsIgnoreCase("ADD")) {
			actionPane = addFoundAnimalAction();
		}
		
		else if(action.equalsIgnoreCase("Remove")) {
			actionPane = removeFoundAnimalAction();
		}
		
		else {
			actionPane = displayFoundAnimalAction();
		}
		
		root.setTop(displayMenu.getMenuBar());
		adaptableBox.getChildren().add(actionPane);
		root.setCenter(adaptableBox);
	}

	public Pane addFoundAnimalAction() {
		GridPane addFoundAnimalPane = new GridPane();
		addFoundAnimalPane.setAlignment(Pos.CENTER);
		addFoundAnimalPane.setHgap(30);
		addFoundAnimalPane.setVgap(12);
		addFoundAnimalPane.setPadding(new Insets(100));
		
		HBox title = new HBox();
	    HBox animalIdName = new HBox();
	    animalIdName.setSpacing(30);
	    HBox animalDateLocation = new HBox();
	    animalDateLocation.setSpacing(30);
	    HBox actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    Label sectionTitle = new Label("FOUND ANIMAL");
	    sectionTitle.setFont(Font.font("Berlin Sans FB", 20));
	    title.getChildren().add(sectionTitle);
	    title.setAlignment(Pos.CENTER);
	    
		Label animalIdLabel = new Label("ID:");
	    TextField animalIdField = new TextField();
	    animalIdField.setMinWidth(50);
	    Label animalNameLabel = new Label("Full name:");
	    TextField animalNameField = new TextField();
	    animalNameField.setMinWidth(443);
	    animalIdName.getChildren().addAll(animalIdLabel, animalIdField, animalNameLabel, animalNameField);
	    
	    Label animalDateLabel = new Label("Date:");
	    TextField animalDateField = new TextField();
	    animalDateField.setMinWidth(20);
	    Label animalLocationLabel = new Label("Location:");
	    TextField animalLocationField = new TextField();
	    animalLocationField.setMinWidth(430);
	    animalDateLocation.getChildren().addAll(animalDateLabel, animalDateField, animalLocationLabel, animalLocationField);
	    
	    Label animalDescriptionLabel = new Label("Description:");
	    TextArea animalDescriptionArea = new TextArea();
	    animalDescriptionArea.setMinSize(800, 100);

	    Button submitButton = new Button("Submit");
	    submitButton.setStyle("-fx-background-color: darkGreen; -fx-text-fill: white");
	    Button clearButton = new Button("Clear");
	    Button exitButton = new Button("Cancel");
	    actionButtons.getChildren().addAll(submitButton, clearButton, exitButton);
	    actionButtons.setAlignment(Pos.CENTER);

	    addFoundAnimalPane.add(title, 0, 0);
	    addFoundAnimalPane.add(animalIdName, 0, 5, 2, 1);
	    addFoundAnimalPane.add(animalDateLocation, 0, 6, 2, 1);
	    addFoundAnimalPane.add(animalDescriptionLabel, 0, 7);
	    addFoundAnimalPane.add(animalDescriptionArea, 0, 8);
	    addFoundAnimalPane.add(actionButtons, 0, 20);
		
        return addFoundAnimalPane;
	}
	
	public Pane removeFoundAnimalAction() {
		GridPane removeFoundAnimalPane = new GridPane();
		removeFoundAnimalPane.setAlignment(Pos.CENTER);
		removeFoundAnimalPane.setHgap(30);
		removeFoundAnimalPane.setVgap(12);
		removeFoundAnimalPane.setPadding(new Insets(100));
		
		HBox title = new HBox();
		HBox animalSearch = new HBox();
		animalSearch.setSpacing(30);
	    HBox animalIdName = new HBox();
	    animalIdName.setSpacing(30);
	    HBox animalDateLocation = new HBox();
	    animalDateLocation.setSpacing(30);
	    HBox ownerName = new HBox();
	    ownerName.setSpacing(30);
	    HBox ownerTelephoneEmail = new HBox();
	    ownerTelephoneEmail.setSpacing(30);
	    HBox ownerAddress = new HBox();
	    ownerAddress.setSpacing(30);
	    HBox actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    Label sectionTitle = new Label("FOUND ANIMAL");
	    sectionTitle.setFont(Font.font("Berlin Sans FB", 20));
	    title.getChildren().add(sectionTitle);
	    title.setAlignment(Pos.CENTER);
	    
	    Label animalSearchLabel = new Label("ID:");
	    TextField animalSearchField = new TextField();
	    animalSearchField.setMinWidth(400);
	    Button searchButton = new Button("Search");
	    animalSearch.getChildren().addAll(animalSearchLabel, animalSearchField, searchButton);
	    animalSearch.setAlignment(Pos.CENTER);
	    
		Label animalIdLabel = new Label("ID:");
		TextField animalIdField = new TextField();
	    animalIdField.setMinWidth(50);
	    animalIdField.setEditable(false);
	    Label animalNameLabel = new Label("Full name:");
	    TextField animalNameField = new TextField();
	    animalNameField.setMinWidth(443);
	    animalNameField.setEditable(false);
	    animalIdName.getChildren().addAll(animalIdLabel, animalIdField, animalNameLabel, animalNameField);
	    
	    Label animalDateLabel = new Label("Date:");
	    TextField animalDateField = new TextField();
	    animalDateField.setMinWidth(20);
	    animalDateField.setEditable(false);
	    Label animalLocationLabel = new Label("Location:");
	    TextField animalLocationField = new TextField();
	    animalLocationField.setMinWidth(430);
	    animalLocationField.setEditable(false);
	    animalDateLocation.getChildren().addAll(animalDateLabel, animalDateField, animalLocationLabel, animalLocationField);
	    
	    Label animalDescriptionLabel = new Label("Description:");
	    TextArea animalDescriptionArea = new TextArea();
	    animalDescriptionArea.setMinSize(800, 100);
	    animalDescriptionArea.setEditable(false);
	    
	    Label personDetails = new Label("OWNER DETAILS:");
	    personDetails.setFont(Font.font("Berlin Sans FB", 15));
	    
	    Label ownerNameLabel = new Label("Full Name:");
	    TextField ownerNameField = new TextField();
	    ownerNameField.setMinWidth(700);
	    ownerName.getChildren().addAll(ownerNameLabel, ownerNameField);
	    
	    Label ownerTelephoneLabel = new Label("Telephone:");
	    TextField ownerTelephoneField = new TextField();
	    ownerTelephoneField.setMinWidth(70);
	    Label ownerEmailLabel = new Label("Email:");
	    TextField ownerEmailField = new TextField();
	    ownerEmailField.setMinWidth(410);
	    ownerTelephoneEmail.getChildren().addAll(ownerTelephoneLabel, ownerTelephoneField, ownerEmailLabel, ownerEmailField);
	    
	    Label ownerAddressLabel = new Label("Address:");
	    TextField ownerAddressField = new TextField();
	    ownerAddressField.setMinWidth(710);
	    ownerAddress.getChildren().addAll(ownerAddressLabel, ownerAddressField);
	    
	    Button removeButton = new Button("Remove");
	    removeButton.setStyle("-fx-background-color: red; -fx-text-fill: white");
	    Button cancelButton = new Button("Cancel");
	    actionButtons.getChildren().addAll(removeButton, cancelButton);
	    actionButtons.setAlignment(Pos.CENTER);

	    removeFoundAnimalPane.add(title, 0, 0);
	    removeFoundAnimalPane.add(animalSearch, 0, 3, 2, 1);
	    removeFoundAnimalPane.add(animalIdName, 0, 8, 2, 1);
	    removeFoundAnimalPane.add(animalDateLocation, 0, 9, 2, 1);
	    removeFoundAnimalPane.add(animalDescriptionLabel, 0, 10);
	    removeFoundAnimalPane.add(animalDescriptionArea, 0, 11);
	    removeFoundAnimalPane.add(personDetails, 0, 14);
	    removeFoundAnimalPane.add(ownerName, 0, 15);
	    removeFoundAnimalPane.add(ownerTelephoneEmail, 0, 16);
	    removeFoundAnimalPane.add(ownerAddress, 0, 17);
	    removeFoundAnimalPane.add(actionButtons, 0, 20);
		
        return removeFoundAnimalPane;
	}
	
	public Pane displayFoundAnimalAction() {
		GridPane displayFoundAnimalPane = new GridPane();
		displayFoundAnimalPane.setAlignment(Pos.CENTER);
		displayFoundAnimalPane.setHgap(30);
		displayFoundAnimalPane.setVgap(12);
		displayFoundAnimalPane.setPadding(new Insets(100));
		
		HBox title = new HBox();
		HBox animalSearch = new HBox();
		animalSearch.setSpacing(30);
		HBox allowOwnerDetails = new HBox();
		allowOwnerDetails.setSpacing(20);
		HBox ownerDetails = new HBox();
		ownerDetails.setSpacing(30);
	    HBox actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    Label sectionTitle = new Label("FOUND ANIMAL");
	    sectionTitle.setFont(Font.font("Berlin Sans FB", 20));
	    title.getChildren().add(sectionTitle);
	    title.setAlignment(Pos.CENTER);
	    
	    Label animalSearchLabel = new Label("ID:");
	    TextField animalSearchField = new TextField();
	    animalSearchField.setMinWidth(400);
	    Button searchButton = new Button("Search");
	    animalSearch.getChildren().addAll(animalSearchLabel, animalSearchField, searchButton);
	    animalSearch.setAlignment(Pos.CENTER);

	    ScrollPane scrollPane = new ScrollPane();
	    TextArea animalDescriptionArea = new TextArea();
	    animalDescriptionArea.setMinSize(800, 150);
	    animalDescriptionArea.setEditable(false);
	    scrollPane.setContent(animalDescriptionArea);
	    
	    CheckBox allowOwnerDetailsCheckBox = new CheckBox("Allow Owner Details");
	    allowOwnerDetails.getChildren().addAll(allowOwnerDetailsCheckBox);
	    
	    Label ownerNameLabel = new Label("Full Name:");
	    TextField ownerNameField = new TextField();
	    ownerNameField.setMinWidth(300);
	    ownerNameField.setEditable(false);
	    Label ownerEmailLabel = new Label("Email:");
	    TextField ownerEmailField = new TextField();
	    ownerEmailField.setMinWidth(300);
	    ownerEmailField.setEditable(false);
	    ownerDetails.getChildren().addAll(ownerNameLabel, ownerNameField, ownerEmailLabel, ownerEmailField);
	    ownerDetails.setVisible(false);
	    
	    Button editButton = new Button("Edit");
	    editButton.setStyle("-fx-background-color: orange; -fx-text-fill: white");
	    Button cancelButton = new Button("Cancel");
	    actionButtons.getChildren().addAll(editButton, cancelButton);
	    actionButtons.setAlignment(Pos.CENTER);

	    displayFoundAnimalPane.add(title, 0, 0);
	    displayFoundAnimalPane.add(animalSearch, 0, 5, 2, 1);
	    displayFoundAnimalPane.add(animalDescriptionArea, 0, 10);
	    displayFoundAnimalPane.add(allowOwnerDetails, 0, 13);
	    displayFoundAnimalPane.add(ownerDetails, 0, 15);
	    
	    allowOwnerDetailsCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(allowOwnerDetailsCheckBox.isSelected()) {
					ownerDetails.setVisible(true);
				}
				
				else {
					ownerDetails.setVisible(false);
				}
			}
		});
	    
	    displayFoundAnimalPane.add(actionButtons, 0, 18);
		
        return displayFoundAnimalPane;
	}
}
