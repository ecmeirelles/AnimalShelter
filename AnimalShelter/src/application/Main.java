package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage stage;
	private static Scene scene;

	private BorderPane root;
	
	private Label shelterIcon;
	private Label shelterDescription;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = new BorderPane();
			scene = new Scene(root, 1000, 800);
			
			DisplayMenu displayMenu = new DisplayMenu();
			displayMenu.menu();
			root.setTop(displayMenu.getMenuBar());

			shelterIcon = new Label("");
			shelterIcon.setGraphic(new ImageView(new Image("file:src\\images\\shelter-icon.png")));
			root.setCenter(shelterIcon);
			
			shelterDescription = new Label("What are you looking for? Choose between lost, found and adopted animals.");
			shelterDescription.setPrefHeight(150);
			shelterDescription.setFont(Font.font("Berlin Sans FB", 20));
			BorderPane.setAlignment(shelterDescription, Pos.TOP_CENTER);
			root.setBottom(shelterDescription);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			stage = primaryStage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Main.stage = stage;
	}

	public static Scene getScene() {
		return scene;
	}

	public static void setScene(Scene scene) {
		Main.scene = scene;
	}
}