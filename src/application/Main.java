package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	Alert alert = new Alert(AlertType.CONFIRMATION,"",ButtonType.OK);
	
	@Override
	public void start(Stage primaryStage) throws SQLException{
		
//----------------------TabPane-----------------------------------------------------------------
		TabPane tabPane = new TabPane();

		tabPane.getTabs().add(new Nations());
		tabPane.getTabs().add(new Ships());
		tabPane.getTabs().add(new Staff());
		tabPane.getTabs().add(new Weapons());
		tabPane.getTabs().add(new WeaponSystems());
		tabPane.getTabs().add(new SQLquery());
		
////-------------------------BorderPane-----------------------------------------------------------
//		BorderPane borderPane = new BorderPane();
//
//		borderPane.setCenter(tabPane);
//		
//		borderPane.setBackground(new Background(new BackgroundFill(Color.web("#F38B02"),CornerRadii.EMPTY,Insets.EMPTY)));
//		
//--------------------Scene---------------------------------------------------------------------
//		Scene scene = new Scene(borderPane); 
		Scene scene2 = new Scene(tabPane, 500, 400);
		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.getIcons().add(new Image("C:\\Users\\Alexander Graham\\Desktop\\YouTube_Thumbnails\\Completed\\World_Warships\\wows_logo.jpg"));
		primaryStage.setTitle("World of Warships Database"); 
		primaryStage.setMaxWidth(600);
		primaryStage.setMinWidth(600);
		primaryStage.setMaxHeight(400);
		primaryStage.setMinHeight(400);
		
		primaryStage.setScene(scene2);
		primaryStage.show();
	
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
