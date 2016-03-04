package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LostAnimalView extends Scene {
	private MenuBar menuBar;
	private Menu homepage;
	private Menu lostAnimal;
	private Menu foundAnimal;
	private Menu animalAdoption;
	private MenuItem addLostAnimal;
	private MenuItem removeLostAnimal;
	private MenuItem displayLostAnimal;
	private MenuItem addFoundAnimal;
	private MenuItem removeFoundAnimal;
	private MenuItem displayFoundAnimal;
	
	private Pane actionPane;

	public LostAnimalView(BorderPane root, double width, double height, String action) {
		super(root, width, height);
		
		HBox adaptableBox = new HBox();
		
		menuBar = new MenuBar();
		
		homepage = new Menu("");
		homepage.setGraphic(new ImageView(new Image("file:src\\images\\home-icon.png")));
		
		lostAnimal = new Menu("Lost Animal");
		foundAnimal = new Menu("Found Animal");
		animalAdoption = new Menu("Animal Adoption");
		
		addLostAnimal = new MenuItem("New");
		removeLostAnimal = new MenuItem("Remove");
		displayLostAnimal = new MenuItem("Display All");
		
		addFoundAnimal = new MenuItem("New");
		removeFoundAnimal = new MenuItem("Remove");
		displayFoundAnimal = new MenuItem("Display All");
		
		menuBar.getMenus().addAll(homepage, lostAnimal, foundAnimal, animalAdoption);
		lostAnimal.getItems().addAll(addLostAnimal, removeLostAnimal, displayLostAnimal);
		foundAnimal.getItems().addAll(addFoundAnimal, removeFoundAnimal, displayFoundAnimal);

		if(action.equalsIgnoreCase("ADD")) {
			actionPane = addLostAnimalAction();
		}
		
		else if(action.equalsIgnoreCase("Remove")) {
			actionPane = removeLostAnimalAction();
		}
		
		else {
			actionPane = displayLostAnimalAction();
		}
		
		root.setTop(menuBar);
		adaptableBox.getChildren().add(actionPane);
		root.setCenter(adaptableBox);
	}

	public Pane addLostAnimalAction() {
		GridPane addLostAnimalPane = new GridPane();
		addLostAnimalPane.setAlignment(Pos.CENTER);
		addLostAnimalPane.setHgap(30);
		addLostAnimalPane.setVgap(12);
		addLostAnimalPane.setPadding(new Insets(100));
		
		HBox title = new HBox();
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
		
	    Label sectionTitle = new Label("LOST ANIMAL");
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

	    Button submitButton = new Button("Submit");
	    submitButton.setStyle("-fx-background-color: darkGreen; -fx-text-fill: white");
	    Button clearButton = new Button("Clear");
	    Button exitButton = new Button("Cancel");
	    actionButtons.getChildren().addAll(submitButton, clearButton, exitButton);
	    actionButtons.setAlignment(Pos.CENTER);

	    addLostAnimalPane.add(title, 0, 0);
	    addLostAnimalPane.add(animalIdName, 0, 5, 2, 1);
	    addLostAnimalPane.add(animalDateLocation, 0, 6, 2, 1);
	    addLostAnimalPane.add(animalDescriptionLabel, 0, 7);
	    addLostAnimalPane.add(animalDescriptionArea, 0, 8);
	    addLostAnimalPane.add(personDetails, 0, 12);
	    addLostAnimalPane.add(ownerName, 0, 15);
	    addLostAnimalPane.add(ownerTelephoneEmail, 0, 16);
	    addLostAnimalPane.add(ownerAddress, 0, 17);
	    addLostAnimalPane.add(actionButtons, 0, 20);
		
        return addLostAnimalPane;
	}
	
	public Pane removeLostAnimalAction() {
		GridPane removeLostAnimalPane = new GridPane();
		removeLostAnimalPane.setAlignment(Pos.CENTER);
		removeLostAnimalPane.setHgap(30);
		removeLostAnimalPane.setVgap(12);
		removeLostAnimalPane.setPadding(new Insets(100));
		
		HBox title = new HBox();
		HBox animalSearch = new HBox();
		animalSearch.setSpacing(30);
	    HBox animalIdName = new HBox();
	    animalIdName.setSpacing(30);
	    HBox animalDateLocation = new HBox();
	    animalDateLocation.setSpacing(30);
	    HBox actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    Label sectionTitle = new Label("LOST ANIMAL");
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

	    Button removeButton = new Button("Remove");
	    removeButton.setStyle("-fx-background-color: red; -fx-text-fill: white");
	    Button cancelButton = new Button("Cancel");
	    actionButtons.getChildren().addAll(removeButton, cancelButton);
	    actionButtons.setAlignment(Pos.CENTER);

	    removeLostAnimalPane.add(title, 0, 0);
	    removeLostAnimalPane.add(animalSearch, 0, 5, 2, 1);
	    removeLostAnimalPane.add(animalIdName, 0, 10, 2, 1);
	    removeLostAnimalPane.add(animalDateLocation, 0, 11, 2, 1);
	    removeLostAnimalPane.add(animalDescriptionLabel, 0, 12);
	    removeLostAnimalPane.add(animalDescriptionArea, 0, 13);
	    removeLostAnimalPane.add(actionButtons, 0, 15);
		
        return removeLostAnimalPane;
	}
	
	public Pane displayLostAnimalAction() {
		GridPane displayLostAnimalPane = new GridPane();
		displayLostAnimalPane.setAlignment(Pos.CENTER);
		displayLostAnimalPane.setHgap(30);
		displayLostAnimalPane.setVgap(12);
		displayLostAnimalPane.setPadding(new Insets(100));
		
		HBox title = new HBox();
		HBox animalSearch = new HBox();
		animalSearch.setSpacing(30);
	    HBox actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    Label sectionTitle = new Label("LOST ANIMAL");
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
	    animalDescriptionArea.setMinSize(800, 350);
	    animalDescriptionArea.setEditable(false);
	    scrollPane.setContent(animalDescriptionArea);

	    Button editButton = new Button("Edit");
	    editButton.setStyle("-fx-background-color: orange; -fx-text-fill: white");
	    Button cancelButton = new Button("Cancel");
	    actionButtons.getChildren().addAll(editButton, cancelButton);
	    actionButtons.setAlignment(Pos.CENTER);

	    displayLostAnimalPane.add(title, 0, 0);
	    displayLostAnimalPane.add(animalSearch, 0, 5, 2, 1);
	    displayLostAnimalPane.add(animalDescriptionArea, 0, 10);
	    displayLostAnimalPane.add(actionButtons, 0, 13);
		
        return displayLostAnimalPane;
	}
}
