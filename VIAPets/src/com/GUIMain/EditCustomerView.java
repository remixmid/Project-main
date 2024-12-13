package com.GUIMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditCustomerView  {

    public void display() {
        // Create AnchorPane
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431.0, 242.0);

        // Create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(429.0, 227.0);

        // Add Column Constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10.0);
        column1.setPrefWidth(100.0);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10.0);
        column2.setPrefWidth(100.0);

        gridPane.getColumnConstraints().addAll(column1, column2);

        // Add Row Constraints
        for (int i = 0; i < 8; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Add Labels
        gridPane.add(new Label("Name"), 0, 0);
        gridPane.add(new Label("Email"), 0, 1);
        gridPane.add(new Label("Phone number"), 0, 2);
        gridPane.add(new Label("Address"), 0, 3);

        // Add TextFields
        for (int i = 0; i < 4; i++) {
            gridPane.add(new TextField(), 1, i);
        }

        // Add Button
        Button saveButton = new Button("Save");
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefSize(95.0, 25.0);
        gridPane.add(saveButton, 1, 7);

        // Add GridPane to AnchorPane
        anchorPane.getChildren().add(gridPane);

        // Set Scene
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Customer");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.showAndWait();
    }


}
