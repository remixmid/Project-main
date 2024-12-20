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

    public void display() {
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431, 242);

        gridPane = new GridPane();
        gridPane.setLayoutX(1);
        gridPane.setLayoutY(8);
        gridPane.setPrefSize(429, 227);

        col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        col1.setMinWidth(10);
        col1.setPrefWidth(100);

        col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);
        col2.setMinWidth(10);
        col2.setPrefWidth(100);

        gridPane.getColumnConstraints().addAll(col1, col2);

        for (int i = 0; i < 6; i++) {
            row = new RowConstraints();
            row.setMinHeight(10);
            row.setPrefHeight(30);
            row.setVgrow(Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

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

        petField = new TextField();
        gridPane.add(petField, 1, 0);

        priceField = new TextField();
        gridPane.add(priceField, 1, 1);

        dateInPicker = new DatePicker();
        gridPane.add(dateInPicker, 1, 4);

        dateOutPicker = new DatePicker();
        gridPane.add(dateOutPicker, 1, 3);

        customerLabel = new Label("Customer");
        customerLabel.setPrefSize(70, 17);
        gridPane.add(customerLabel, 0, 2);

        customerField = new TextField();
        gridPane.add(customerField, 1, 2);

        saveButton = new Button("Save");
        saveButton.setPrefSize(95, 25);
        gridPane.add(saveButton, 1, 5);

        anchorPane.getChildren().add(gridPane);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Booking");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.showAndWait();
    }

}