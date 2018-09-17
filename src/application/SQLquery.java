package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class SQLquery extends Tab {

	// ---------------GridPane
	GridPane gp = new GridPane();

	// ---------------TAB
	// BUTTONS--------------------------------------------------------------------------------
	Button innerJoin = new Button();
	Button selectDistinct = new Button();
	Button selectCount = new Button();

	// ---------------TAB
	// TextFields--------------------------------------------------------------------------------
	TextField insertField = new TextField();
	TextField insertField2 = new TextField();
	TextField insertField3 = new TextField();
	// TextField insertField4 = new TextField();

	// Label-----------------------------------------------------------------------------------
	Label labelGunFireControl = new Label();
	Label labelEngineMod = new Label();
	Label labelMainBattery = new Label();

	ArrayList<String> array = new ArrayList<String>();

	Alert alert2 = new Alert(AlertType.CONFIRMATION, "", ButtonType.OK);

	public SQLquery() throws SQLException {

		setClosable(false);
		setText("3 Queries");

		gp.setPadding(new Insets(10, 10, 10, 10));
		gp.setVgap(8);
		gp.setHgap(10);

		innerJoin.setText("Inner Join");
		selectDistinct.setText("Select Distinct");
		selectCount.setText("Select Count");

		labelGunFireControl.setText("Gun Fire Control: ");
		labelEngineMod.setText("Engine Mod: ");
		labelMainBattery.setText("Main Battery: ");

		// ---------------------------------------------------------------------------------------------------------------------------
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/test?user=Alexander_Graham&password=&useUnicode=true&false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		System.out.println("Database connection established");
		Statement s = con.createStatement();

		ResultSet result = s.executeQuery("SELECT * FROM Weapons");
		while (result.next()) {
			array.add(result.getString("MainBattery") + result.getString("hull") + result.getString("torpedos")
					+ result.getString("nameOfShip"));
		}

		// ---------------------------------------------------------------------------------------------------------------------------

		innerJoin.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent insertToDB) {

				try {
					// insert
					String insertSQL = "SELECT Nations.typeOfShip, Ships.nameOfShip FROM Nations INNER JOIN Ships ON Nations.nationID = Ships.nationID";
					PreparedStatement pstmt = con.prepareStatement(insertSQL);

				//  pstmt.setString(1, insertField.getText());
				//	pstmt.setString(2, insertField2.getText());
	//				pstmt.setString(3, insertField3.getText());
					ResultSet i = pstmt.executeQuery();
					while (i.next()) {
						array.add(i.getString("typeOfShip") + i.getString("nameOfShip"));
						System.out.println(i.getString("typeOfShip") + " " + i.getString("nameOfShip"));
					}

					System.out.println("The records selected is: " + "Nations.typeOfShip, Ships.nameOfShip");
					pstmt.close();
				} catch (Exception io) {
					System.out.println("error" + io);
				}
				;

			}

		});

		selectDistinct.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent updateDB) {

				try {
					// update
					String updateSQL = "SELECT DISTINCT GunFireControl, MainBattery FROM WeaponSystems WHERE GunFireControl = 'Mk5 mod.1'";
					PreparedStatement updatepstmt = con.prepareStatement(updateSQL);

				//	updatepstmt.setString(1, insertField.getText());
				//	updatepstmt.setString(2, insertField2.getText());
				//	updatepstmt.setString(3, insertField3.getText());
				//	System.out.println(insertField.getText() + "\t" + insertField2.getText() + "\t" + insertField3.getText());
					ResultSet u = updatepstmt.executeQuery();
					while (u.next()) {
						array.add(u.getString("GunFireControl") + u.getString("MainBattery"));
						System.out.println(u.getString("GunFireControl") + " " + u.getString("MainBattery"));
					}
					
					System.out.println("The number of records updated is: " + u);
					updatepstmt.close();

				} catch (Exception io) {
					System.out.println("error " + io);
				}
				;

			}

		});

		selectCount.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent deleteDB) {

				try {
					// delete
					String distinctSQL = "SELECT COUNT(noOfShip), nameOfShip FROM Ships GROUP BY nameOfShip";
					PreparedStatement distinctpstmt = con.prepareStatement(distinctSQL);

				//	deletepstmt.setString(1, insertField.getText());
				//	deletepstmt.setString(2, insertField2.getText());
				//	deletepstmt.setString(3, insertField3.getText());
				//	System.out.println(insertField.getText() + "\t" + insertField2.getText() + "\t" + insertField3.getText());
					ResultSet d = distinctpstmt.executeQuery();
					while (d.next()) {
						array.add(d.getString(1) + d.getString("nameOfShip"));
						System.out.println(d.getString(1) + " " + d.getString("nameOfShip"));
					}
					
					System.out.println("The selected count is: " + d);
					distinctpstmt.close();

				} catch (Exception io) {
					System.out.println("error" + io);
				}
				;

			}

		});

		ListView<String> listView = new ListView<String>();
		ObservableList<String> obList = FXCollections.observableArrayList(array);
		listView.setItems(obList);

		// Col, Row
		GridPane.setConstraints(innerJoin, 1, 7);
		GridPane.setConstraints(selectDistinct, 2, 7);
		GridPane.setConstraints(selectCount, 3, 7);

		GridPane.setConstraints(insertField, 2, 1);
		GridPane.setConstraints(insertField2, 2, 2);
		GridPane.setConstraints(insertField3, 2, 3);
		// GridPane.setConstraints(insertField4, 3, 9);

		GridPane.setConstraints(labelGunFireControl, 1, 1);
		GridPane.setConstraints(labelEngineMod, 1, 2);
		GridPane.setConstraints(labelMainBattery, 1, 3);

		GridPane.setConstraints(listView, 3, 0);

		gp.getChildren().addAll(innerJoin, selectDistinct, selectCount, listView);

		setContent(gp);

	}

}
