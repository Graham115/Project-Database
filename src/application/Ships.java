package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Ships extends Tab {

	// ---------------GridPane
	GridPane gp = new GridPane();
	
	// ---------------TAB
	// BUTTONS--------------------------------------------------------------------------------
	Button insert = new Button();
	Button update = new Button();
	Button delete = new Button();

	// ---------------TAB
	// TextFields--------------------------------------------------------------------------------
	TextField insertField = new TextField();
	TextField insertField2 = new TextField();
	TextField insertField3 = new TextField();
//	TextField insertField4 = new TextField();
	
	// Label-----------------------------------------------------------------------------------
	Label labelNoOfShip = new Label();
	Label labelShipName = new Label();
	Label labelNationID = new Label();
	
	ArrayList<String> array = new ArrayList<String>();
	
	Alert alert2 = new Alert(AlertType.CONFIRMATION, "", ButtonType.OK);

	public Ships() throws SQLException {

		setClosable(false);
		setText("Ships Table");
		
		gp.setPadding(new Insets(10, 10, 10, 10));
	    gp.setVgap(8);
	    gp.setHgap(10);
		
		insert.setText("INSERT");
		update.setText("UPDATE");
		delete.setText("DELETE");
		
		labelNoOfShip.setText("No. Of The Ship: ");
		labelShipName.setText("Name of Ship: ");
		labelNationID.setText("NationID: "); 
		
//---------------------------------------------------------------------------------------------------------------------------		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?user=Alexander_Graham&password=&useUnicode=true&false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" );
        System.out.println ("Database connection established");
        Statement s = con.createStatement ();
		
		ResultSet result = s.executeQuery("SELECT * FROM Ships");
		while(result.next()) 
		{	
			array.add(result.getString("noOfShip") + result.getString("nameOfShip") + result.getString("nationID"));
		}
	    
//---------------------------------------------------------------------------------------------------------------------------		
		
		insert.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent insertToDB) {

				try {
		            // insert         
		            String insertSQL = "INSERT INTO Ships (noOfShip, nameOfShip, nationID)VALUES (?,?,?)";
		            PreparedStatement pstmt = con.prepareStatement(insertSQL);
		            
		            pstmt.setString(1, insertField.getText());
		            pstmt.setString(2, insertField2.getText());
		            pstmt.setString(3, insertField3.getText());
		            int i = pstmt.executeUpdate();
		            
		            System.out.println(insertField.getText() + "\t" + insertField2.getText() + "\t" + insertField3);
		            System.out.println("The number of records inserted is: " + i);
		            pstmt.close();
		       }catch (Exception io) {
		                System.out.println("error"+io);
		       }; 
				
			}

		});

		update.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent updateDB) {

				try {
					//update
					 	String updateSQL = "UPDATE Ships SET noOfShip=?, nameOfShip=? WHERE nationID=?";
			            PreparedStatement updatepstmt = con.prepareStatement(updateSQL);
			            
		
			            updatepstmt.setString(1, insertField.getText());
			            updatepstmt.setString(2, insertField2.getText());
			            updatepstmt.setString(3, insertField3.getText());
			            System.out.println(insertField.getText() + "\t" + insertField2.getText() + "\t" + insertField3.getText());
			            int u = updatepstmt.executeUpdate();
			            
			            
			            System.out.println("The number of records updated is: " + u);
			            updatepstmt.close();
					
				}catch(Exception io) {
					System.out.println("error " +io);
				};
				
			}

		});

		delete.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent deleteDB) {
				
				try {
					//delete
				 	String deleteSQL = "DELETE FROM Ships WHERE (noOfShip=? AND nameOfShip=? AND nationID=?)";
		            PreparedStatement deletepstmt = con.prepareStatement(deleteSQL);
		            
		            deletepstmt.setString(1, insertField.getText());
		            deletepstmt.setString(2, insertField2.getText());
		            deletepstmt.setString(3, insertField3.getText());
		            System.out.println(insertField.getText() + "\t" + insertField2.getText() + "\t" + insertField3.getText());
		            int d = deletepstmt.executeUpdate();
		            
		            System.out.println("The number of records deleted is: " + d);
		            deletepstmt.close();
				
			}catch(Exception io) {
				System.out.println("error" +io);
			};
				
			}

		});
		
		ListView<String> listView = new ListView<String>();
		ObservableList<String> obList = FXCollections.observableArrayList(array);
		listView.setItems(obList);
		
		
						//Col, Row
		GridPane.setConstraints(insert, 1, 7);
		GridPane.setConstraints(update, 2, 7);
		GridPane.setConstraints(delete, 3, 7);
		
		GridPane.setConstraints(insertField, 2, 1);
		GridPane.setConstraints(insertField2, 2, 2);
		GridPane.setConstraints(insertField3, 2, 3);
//		GridPane.setConstraints(insertField4, 3, 9);
		
		GridPane.setConstraints(labelNoOfShip, 1, 1);
		GridPane.setConstraints(labelShipName, 1, 2);
		GridPane.setConstraints(labelNationID, 1, 3);
		
		GridPane.setConstraints(listView, 3, 0);
		
		gp.getChildren().addAll(insert, update, delete, insertField, insertField2, insertField3, listView , labelNoOfShip, labelShipName, labelNationID);
		
		
		setContent(gp);
	}


}

