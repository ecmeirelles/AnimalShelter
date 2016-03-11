package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controller.LostAnimalController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

public class LostAnimalView extends Scene {
	private Pane actionPane;
	private HBox title;
    private HBox animalIdName;
    private HBox animalDateLocation;
    private HBox animalSearch;
    private HBox ownerName;
    private HBox ownerTelephoneEmail;
    private HBox ownerAddress;
    private HBox ownerDetails;
    private HBox allowOwnerDetails;
    private HBox actionButtons;
	
	private Label sectionTitle;
	private Label animalIdLabel;
	private Label animalNameLabel;
	private Label animalDateLabel;
	private Label animalLocationLabel;
	private Label animalDescriptionLabel;
	private Label personDetails;
	private Label ownerNameLabel;
	private Label ownerTelephoneLabel;
	private Label ownerEmailLabel;
    private Label ownerAddressLabel;
    private Label animalSearchLabel;
	
	private TextField animalIdField;
	private TextField animalNameField;
	private DatePicker animalDateField;
	private TextField animalLocationField;
	private TextField ownerNameField;
	private TextField ownerTelephoneField;
	private TextField ownerEmailField;
	private TextField ownerAddressField;
	private TextField animalSearchField;
	
	private TextArea animalDescriptionArea;
    
    private Button removeButton;
    private Button cancelButton;
    private Button submitButton;
    private Button clearButton;
    private Button exitButton;
    private Button searchButton;
    private Button editButton;
    
    private CheckBox allowOwnerDetailsCheckBox;
    private ScrollPane scrollPane;

	public LostAnimalView(BorderPane root, double width, double height, String action) {
		super(root, width, height);
		
		HBox adaptableBox = new HBox();
		
		DisplayMenu displayMenu = new DisplayMenu();
		displayMenu.menu();

		if(action.equalsIgnoreCase("ADD")) {
			actionPane = addLostAnimalAction();
		}
		
		else if(action.equalsIgnoreCase("Remove")) {
			actionPane = removeLostAnimalAction();
		}
		
		else {
			actionPane = displayLostAnimalAction();
		}
		
		root.setTop(displayMenu.getMenuBar());
		adaptableBox.getChildren().add(actionPane);
		root.setCenter(adaptableBox);
	}

	public Pane addLostAnimalAction() {
		GridPane addLostAnimalPane = new GridPane();
		addLostAnimalPane.setAlignment(Pos.CENTER);
		addLostAnimalPane.setHgap(30);
		addLostAnimalPane.setVgap(12);
		addLostAnimalPane.setPadding(new Insets(100));
		
		title = new HBox();
	    animalIdName = new HBox();
	    animalIdName.setSpacing(30);
	    animalDateLocation = new HBox();
	    animalDateLocation.setSpacing(30);
	    ownerName = new HBox();
	    ownerName.setSpacing(30);
	    ownerTelephoneEmail = new HBox();
	    ownerTelephoneEmail.setSpacing(30);
	    ownerAddress = new HBox();
	    ownerAddress.setSpacing(30);
	    actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    sectionTitle = new Label("LOST ANIMAL");
	    sectionTitle.setFont(Font.font("Berlin Sans FB", 20));
	    title.getChildren().add(sectionTitle);
	    title.setAlignment(Pos.CENTER);
	    
		animalIdLabel = new Label("ID:");
	    animalIdField = new TextField();
	    animalIdField.setMinWidth(50);
	    animalNameLabel = new Label("Full name:");
	    animalNameField = new TextField();
	    animalNameField.setMinWidth(443);
	    animalIdName.getChildren().addAll(animalIdLabel, animalIdField, animalNameLabel, animalNameField);
	    
	    animalDateLabel = new Label("Date:");
	    animalDateField = new DatePicker();
	    animalDateField.setMinWidth(20);
	    animalDateField.setPromptText("dd-MM-yyyy");
	    animalDateField.setConverter(new StringConverter<LocalDate>() {
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        @Override 
	        public String toString(LocalDate date) {
	            if (date != null) {
	                return dateFormatter.format(date);
	            } 
	            else {
	                return "";
	            }
	        }

	        @Override 
	        public LocalDate fromString(String string) {
	            if (string != null && !string.isEmpty()) {
	                return LocalDate.parse(string, dateFormatter);
	            } 
	            else {
	                return null;
	            }
	        }
	    });
	    animalLocationLabel = new Label("Location:");
	    animalLocationField = new TextField();
	    animalLocationField.setMinWidth(430);
	    animalDateLocation.getChildren().addAll(animalDateLabel, animalDateField, animalLocationLabel, animalLocationField);
	    
	    animalDescriptionLabel = new Label("Description:");
	    animalDescriptionArea = new TextArea();
	    animalDescriptionArea.setMinSize(800, 100);
	    
	    personDetails = new Label("OWNER DETAILS:");
	    personDetails.setFont(Font.font("Berlin Sans FB", 15));
	    
	    ownerNameLabel = new Label("Full Name:");
	    ownerNameField = new TextField();
	    ownerNameField.setMinWidth(700);
	    ownerName.getChildren().addAll(ownerNameLabel, ownerNameField);
	    
	    ownerTelephoneLabel = new Label("Telephone:");
	    ownerTelephoneField = new TextField();
	    ownerTelephoneField.setMinWidth(70);
	    ownerEmailLabel = new Label("Email:");
	    ownerEmailField = new TextField();
	    ownerEmailField.setMinWidth(410);
	    ownerTelephoneEmail.getChildren().addAll(ownerTelephoneLabel, ownerTelephoneField, ownerEmailLabel, ownerEmailField);
	     
	    ownerAddressLabel = new Label("Address:");
	    ownerAddressField = new TextField();
	    ownerAddressField.setMinWidth(710);
	    ownerAddress.getChildren().addAll(ownerAddressLabel, ownerAddressField);

	    submitButton = new Button("Submit");
	    submitButton.setStyle("-fx-background-color: darkGreen; -fx-text-fill: white");
	    submitButton.setOnAction(new LostAnimalController(this, "Submit"));
	    clearButton = new Button("Clear");
	    clearButton.setOnAction(new LostAnimalController(this, "Clear"));
	    exitButton = new Button("Cancel");
	    exitButton.setOnAction(new LostAnimalController(this, "Cancel"));
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
		
		title = new HBox();
		animalSearch = new HBox();
		animalSearch.setSpacing(30);
	    animalIdName = new HBox();
	    animalIdName.setSpacing(30);
	    animalDateLocation = new HBox();
	    animalDateLocation.setSpacing(30);
	    actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    sectionTitle = new Label("LOST ANIMAL");
	    sectionTitle.setFont(Font.font("Berlin Sans FB", 20));
	    title.getChildren().add(sectionTitle);
	    title.setAlignment(Pos.CENTER);
	    
	    animalSearchLabel = new Label("ID:");
	    animalSearchField = new TextField();
	    animalSearchField.setMinWidth(400);
	    searchButton = new Button("Search");
	    searchButton.setOnAction(new LostAnimalController(this, "SearchToDelete"));
	    animalSearch.getChildren().addAll(animalSearchLabel, animalSearchField, searchButton);
	    animalSearch.setAlignment(Pos.CENTER);
	    
		animalIdLabel = new Label("ID:");
		animalIdField = new TextField();
	    animalIdField.setMinWidth(50);
	    animalIdField.setEditable(false);
	    animalNameLabel = new Label("Full name:");
	    animalNameField = new TextField();
	    animalNameField.setMinWidth(443);
	    animalNameField.setEditable(false);
	    animalIdName.getChildren().addAll(animalIdLabel, animalIdField, animalNameLabel, animalNameField);
	    
	    animalDateLabel = new Label("Date:");
	    animalDateField = new DatePicker();
	    animalDateField.setMinWidth(20);
	    animalDateField.setPromptText("dd-MM-yyyy");
	    animalDateField.setConverter(new StringConverter<LocalDate>() {
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        @Override 
	        public String toString(LocalDate date) {
	            if (date != null) {
	                return dateFormatter.format(date);
	            } 
	            else {
	                return "";
	            }
	        }

	        @Override 
	        public LocalDate fromString(String string) {
	            if (string != null && !string.isEmpty()) {
	                return LocalDate.parse(string, dateFormatter);
	            } 
	            else {
	                return null;
	            }
	        }
	    });
	    animalDateField.setMinWidth(20);
	    animalDateField.setEditable(false);
	    animalLocationLabel = new Label("Location:");
	    animalLocationField = new TextField();
	    animalLocationField.setMinWidth(430);
	    animalLocationField.setEditable(false);
	    animalDateLocation.getChildren().addAll(animalDateLabel, animalDateField, animalLocationLabel, animalLocationField);
	    
	    animalDescriptionLabel = new Label("Description:");
	    animalDescriptionArea = new TextArea();
	    animalDescriptionArea.setMinSize(800, 100);
	    animalDescriptionArea.setEditable(false);

	    removeButton = new Button("Remove");
	    removeButton.setStyle("-fx-background-color: red; -fx-text-fill: white");
	    cancelButton = new Button("Cancel");
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
		
		title = new HBox();
		animalSearch = new HBox();
		animalSearch.setSpacing(30);
		allowOwnerDetails = new HBox();
		allowOwnerDetails.setSpacing(20);
		ownerDetails = new HBox();
		ownerDetails.setSpacing(30);
	    actionButtons = new HBox();
	    actionButtons.setSpacing(20);
		
	    sectionTitle = new Label("LOST ANIMAL");
	    sectionTitle.setFont(Font.font("Berlin Sans FB", 20));
	    title.getChildren().add(sectionTitle);
	    title.setAlignment(Pos.CENTER);
	    
	    animalSearchLabel = new Label("ID:");
	    animalSearchField = new TextField();
	    animalSearchField.setMinWidth(400);
	    searchButton = new Button("Search");
	    searchButton.setOnAction(new LostAnimalController(this, "SearchToDisplay"));
	    animalSearch.getChildren().addAll(animalSearchLabel, animalSearchField, searchButton);
	    animalSearch.setAlignment(Pos.CENTER);

	    scrollPane = new ScrollPane();
	    animalDescriptionArea = new TextArea();
	    animalDescriptionArea.setMinSize(800, 150);
	    animalDescriptionArea.setEditable(false);
	    scrollPane.setContent(animalDescriptionArea);
	    
	    allowOwnerDetailsCheckBox = new CheckBox("Allow Owner Details");
	    allowOwnerDetails.getChildren().addAll(allowOwnerDetailsCheckBox);
	    
	    ownerNameLabel = new Label("Full Name:");
	    ownerNameField = new TextField();
	    ownerNameField.setMinWidth(300);
	    ownerNameField.setEditable(false);
	    ownerEmailLabel = new Label("Email:");
	    ownerEmailField = new TextField();
	    ownerEmailField.setMinWidth(300);
	    ownerEmailField.setEditable(false);
	    ownerDetails.getChildren().addAll(ownerNameLabel, ownerNameField, ownerEmailLabel, ownerEmailField);
	    ownerDetails.setVisible(false);
	    
	    editButton = new Button("Edit");
	    editButton.setStyle("-fx-background-color: orange; -fx-text-fill: white");
	    cancelButton = new Button("Cancel");
	    actionButtons.getChildren().addAll(editButton, cancelButton);
	    actionButtons.setAlignment(Pos.CENTER);

	    displayLostAnimalPane.add(title, 0, 0);
	    displayLostAnimalPane.add(animalSearch, 0, 5, 2, 1);
	    displayLostAnimalPane.add(animalDescriptionArea, 0, 10);
	    displayLostAnimalPane.add(allowOwnerDetails, 0, 13);
	    displayLostAnimalPane.add(ownerDetails, 0, 15);
	    
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
	    
	    displayLostAnimalPane.add(actionButtons, 0, 18);
		
        return displayLostAnimalPane;
	}

	public TextField getAnimalIdField() {
		return animalIdField;
	}

	public void setAnimalIdField(TextField animalIdField) {
		this.animalIdField = animalIdField;
	}

	public TextField getAnimalNameField() {
		return animalNameField;
	}

	public void setAnimalNameField(TextField animalNameField) {
		this.animalNameField = animalNameField;
	}

	public DatePicker getAnimalDateField() {
		return animalDateField;
	}

	public void setAnimalDateField(DatePicker animalDateField) {
		this.animalDateField = animalDateField;
	}

	public TextField getAnimalLocationField() {
		return animalLocationField;
	}

	public void setAnimalLocationField(TextField animalLocationField) {
		this.animalLocationField = animalLocationField;
	}

	public TextField getOwnerNameField() {
		return ownerNameField;
	}

	public void setOwnerNameField(TextField ownerNameField) {
		this.ownerNameField = ownerNameField;
	}

	public TextField getOwnerTelephoneField() {
		return ownerTelephoneField;
	}

	public void setOwnerTelephoneField(TextField ownerTelephoneField) {
		this.ownerTelephoneField = ownerTelephoneField;
	}

	public TextField getOwnerEmailField() {
		return ownerEmailField;
	}

	public void setOwnerEmailField(TextField ownerEmailField) {
		this.ownerEmailField = ownerEmailField;
	}

	public TextField getOwnerAddressField() {
		return ownerAddressField;
	}

	public void setOwnerAddressField(TextField ownerAddressField) {
		this.ownerAddressField = ownerAddressField;
	}

	public TextField getAnimalSearchField() {
		return animalSearchField;
	}

	public void setAnimalSearchField(TextField animalSearchField) {
		this.animalSearchField = animalSearchField;
	}

	public TextArea getAnimalDescriptionArea() {
		return animalDescriptionArea;
	}

	public void setAnimalDescriptionArea(TextArea animalDescriptionArea) {
		this.animalDescriptionArea = animalDescriptionArea;
	}
}
