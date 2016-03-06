package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class DisplayMenu {
	private MenuBar menuBar;
	private Menu homepage;
	private Menu lostAnimal;
	private Menu foundAnimal;
	private Menu animalAdoption;
	private MenuItem goToHomepage;
	private MenuItem addLostAnimal;
	private MenuItem removeLostAnimal;
	private MenuItem displayLostAnimal;
	private MenuItem addFoundAnimal;
	private MenuItem removeFoundAnimal;
	private MenuItem displayFoundAnimal;
	
	public void menu() {
		menuBar = new MenuBar();
		
		homepage = new Menu("");
		homepage.setGraphic(new ImageView(new Image("file:src\\images\\home-icon.png")));
		
		goToHomepage = new MenuItem("Go to Homepage");
		goToHomepage.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Main.getStage().setScene(Main.getScene());
			}
		});
		
		lostAnimal = new Menu("Lost Animal");
		foundAnimal = new Menu("Found Animal");
		animalAdoption = new Menu("Animal Adoption");
		
		addLostAnimal = new MenuItem("New");
		addLostAnimal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				LostAnimalView lostAnimalScene = new LostAnimalView(new BorderPane(), 1000, 800, "ADD");
				Main.getStage().setScene(lostAnimalScene);
				
			}
		});
		removeLostAnimal = new MenuItem("Remove");
		removeLostAnimal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				LostAnimalView lostAnimalScene = new LostAnimalView(new BorderPane(), 1000, 800, "Remove");
				Main.getStage().setScene(lostAnimalScene);			
			}
		});
		displayLostAnimal = new MenuItem("Display All");
		displayLostAnimal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				LostAnimalView lostAnimalScene = new LostAnimalView(new BorderPane(), 1000, 800, "Display");
				Main.getStage().setScene(lostAnimalScene);
				
			}
		});
		
		addFoundAnimal = new MenuItem("New");
		addFoundAnimal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				FoundAnimalView foundAnimalScene = new FoundAnimalView(new BorderPane(), 1000, 800, "ADD");
				Main.getStage().setScene(foundAnimalScene);
				
			}
		});
		
		removeFoundAnimal = new MenuItem("Remove");
		removeFoundAnimal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				FoundAnimalView foundAnimalScene = new FoundAnimalView(new BorderPane(), 1000, 800, "Remove");
				Main.getStage().setScene(foundAnimalScene);
				
			}
		});
		
		displayFoundAnimal = new MenuItem("Display All");
		displayFoundAnimal.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				FoundAnimalView foundAnimalScene = new FoundAnimalView(new BorderPane(), 1000, 800, "Display");
				Main.getStage().setScene(foundAnimalScene);
				
			}
		});
					
		menuBar.getMenus().addAll(homepage, lostAnimal, foundAnimal, animalAdoption);
		homepage.getItems().add(goToHomepage);
		lostAnimal.getItems().addAll(addLostAnimal, removeLostAnimal, displayLostAnimal);
		foundAnimal.getItems().addAll(addFoundAnimal, removeFoundAnimal, displayFoundAnimal);
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}
}
