package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Homepage extends Application {
	private MenuBar menuBar;
	private Menu homepage;
	private Menu lostAnimal;
	private Menu foundAnimal;
	private Menu animalAdoption;
	
	private Label shelterIcon;
	private Label shelterDescription;
	
	@Override
	public void start(Stage homeStage) throws Exception {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,800);
			
			menuBar = new MenuBar();
			
			homepage = new Menu("");
			homepage.setGraphic(new ImageView(new Image("file:src\\images\\home-icon.png")));
			
			lostAnimal = new Menu("Lost Animal");
			foundAnimal = new Menu("Found Animal");
			animalAdoption = new Menu("Animal Adoption");
			
			menuBar.getMenus().addAll(homepage, lostAnimal, foundAnimal, animalAdoption);
			root.setTop(menuBar);

			shelterIcon = new Label("");
			shelterIcon.setGraphic(new ImageView(new Image("file:src\\images\\shelter-icon.png")));
			root.setCenter(shelterIcon);
			
			shelterDescription = new Label("What are you looking for? Choose between lost, found and adopted animals.");
			shelterDescription.setPrefHeight(150);
			shelterDescription.setFont(Font.font("Berlin Sans FB", 20));
			BorderPane.setAlignment(shelterDescription, Pos.TOP_CENTER);
			root.setBottom(shelterDescription);
			
			homeStage.setScene(scene);
			homeStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}