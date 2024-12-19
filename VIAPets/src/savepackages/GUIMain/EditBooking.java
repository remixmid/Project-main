package savepackages.GUIMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditBooking {

    private AnchorPane anchorPane;
    private GridPane gridPane;
    private ColumnConstraints col1;
    private ColumnConstraints col2;
    private Label petLabel;
    private Label priceLabel;
    private Label dateInLabel;
    private Label dateOutLabel;
    private TextField petField;
    private TextField priceField;
    private DatePicker dateInPicker;
    private DatePicker dateOutPicker;
    private Label customerLabel;
    private TextField customerField;
    private Button saveButton;
    private Stage stage;
    private RowConstraints row;

    // Displays the Edit Booking form in a new window
    public void display() {
        // Initialize the AnchorPane and set the preferred size
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431, 242);

        // Initialize the GridPane and set its layout properties
        gridPane = new GridPane();
        gridPane.setLayoutX(1);
        gridPane.setLayoutY(8);
        gridPane.setPrefSize(429, 227);

        // Set up column constraints for GridPane
        col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        col1.setMinWidth(10);
        col1.setPrefWidth(100);

        col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);
        col2.setMinWidth(10);
        col2.setPrefWidth(100);

        gridPane.getColumnConstraints().addAll(col1, col2);

        // Set up row constraints for GridPane
        for (int i = 0; i < 6; i++) {
            row = new RowConstraints();
            row.setMinHeight(10);
            row.setPrefHeight(30);
            row.setVgrow(Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Create and add labels for the form fields
        petLabel = new Label("Pet");
        petLabel.setPrefSize(69, 25);
        gridPane.add(petLabel, 0, 0);

        priceLabel = new Label("Price");
        priceLabel.setPrefSize(45, 17);
        gridPane.add(priceLabel, 0, 1);

        dateInLabel = new Label("Date in");
        dateInLabel.setPrefSize(55, 17);
        gridPane.add(dateInLabel, 0, 4);

        dateOutLabel = new Label("Date out");
        dateOutLabel.setPrefSize(53, 17);
        gridPane.add(dateOutLabel, 0, 3);

        // Create and add text fields for user input
        petField = new TextField();
        gridPane.add(petField, 1, 0);

        priceField = new TextField();
        gridPane.add(priceField, 1, 1);

        // Create and add date pickers for the booking dates
        dateInPicker = new DatePicker();
        gridPane.add(dateInPicker, 1, 4);

        dateOutPicker = new DatePicker();
        gridPane.add(dateOutPicker, 1, 3);

        // Create and add a label and text field for customer input
        customerLabel = new Label("Customer");
        customerLabel.setPrefSize(70, 17);
        gridPane.add(customerLabel, 0, 2);

        customerField = new TextField();
        gridPane.add(customerField, 1, 2);

        // Create and add a Save button
        saveButton = new Button("Save");
        saveButton.setPrefSize(95, 25);
        gridPane.add(saveButton, 1, 5);

        // Add the GridPane to the AnchorPane
        anchorPane.getChildren().add(gridPane);

        // Set up and show the stage (window)
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Booking");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.showAndWait();
    }
}
