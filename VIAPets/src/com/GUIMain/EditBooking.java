package com.GUIMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditBooking   {


    public void display() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431, 242);

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(1);
        gridPane.setLayoutY(8);
        gridPane.setPrefSize(429, 227);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        col1.setMinWidth(10);
        col1.setPrefWidth(100);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);
        col2.setMinWidth(10);
        col2.setPrefWidth(100);

        gridPane.getColumnConstraints().addAll(col1, col2);

        for (int i = 0; i < 6; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10);
            row.setPrefHeight(30);
            row.setVgrow(Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        Label petLabel = new Label("Pet");
        petLabel.setPrefSize(69, 25);
        gridPane.add(petLabel, 0, 0);

        Label priceLabel = new Label("Price");
        priceLabel.setPrefSize(45, 17);
        gridPane.add(priceLabel, 0, 1);

        Label dateInLabel = new Label("Date in");
        dateInLabel.setPrefSize(55, 17);
        gridPane.add(dateInLabel, 0, 4);

        Label dateOutLabel = new Label("Date out");
        dateOutLabel.setPrefSize(53, 17);
        gridPane.add(dateOutLabel, 0, 3);

        TextField petField = new TextField();
        gridPane.add(petField, 1, 0);

        TextField priceField = new TextField();
        gridPane.add(priceField, 1, 1);

        DatePicker dateInPicker = new DatePicker();
        gridPane.add(dateInPicker, 1, 4);

        DatePicker dateOutPicker = new DatePicker();
        gridPane.add(dateOutPicker, 1, 3);

        Label customerLabel = new Label("Customer");
        customerLabel.setPrefSize(70, 17);
        gridPane.add(customerLabel, 0, 2);

        TextField customerField = new TextField();
        gridPane.add(customerField, 1, 2);

        Button saveButton = new Button("Save");
        saveButton.setPrefSize(95, 25);
        gridPane.add(saveButton, 1, 5);

        anchorPane.getChildren().add(gridPane);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Booking");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.showAndWait();
    }

}