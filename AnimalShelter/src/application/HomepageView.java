package application;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class HomepageView extends Scene {
	private MenuBar menuBar;
	private Menu homepage;
	private Menu lostAnimal;
	private Menu foundAnimal;
	private Menu animalAdoption;
	
	private Label shelterIcon;
	private Label shelterDescription;
	
	public HomepageView(Parent root, double width, double height) {
		super(root, width, height);
		
		menuBar = new MenuBar();
		
		homepage = new Menu("");
		homepage.setGraphic(new ImageView(new Image("file:src\\images\\home-icon.png")));
		
		lostAnimal = new Menu("Lost Animal");
		foundAnimal = new Menu("Found Animal");
		animalAdoption = new Menu("Animal Adoption");
		
		menuBar.getMenus().addAll(homepage, lostAnimal, foundAnimal, animalAdoption);
		((BorderPane) root).setTop(menuBar);

		shelterIcon = new Label("");
		shelterIcon.setGraphic(new ImageView(new Image("file:src\\images\\shelter-icon.png")));
		((BorderPane) root).setCenter(shelterIcon);
		
		shelterDescription = new Label("What are you looking for? Choose between lost, found and adopted animals.");
		shelterDescription.setPrefHeight(150);
		shelterDescription.setFont(Font.font("Berlin Sans FB", 20));
		BorderPane.setAlignment(shelterDescription, Pos.TOP_CENTER);
		((BorderPane) root).setBottom(shelterDescription);
	}
}
