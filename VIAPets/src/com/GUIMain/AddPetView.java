package com.GUIMain;

import Model.Dog;
import Model.Price;
import com.PetListModelManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddPetView {

    ComboBox<String> comboBox = new ComboBox<>();
    GridPane gridPane = new GridPane();

    Label name = new Label("Name");
    Label age = new Label("Age");
    Label gender = new Label("Gender");
    Label color = new Label("Color");
    Label price = new Label("Price");
    Label comment = new Label("Comment");
    Label breed = new Label("Breed");
    Label breeder = new Label("Breeder");


    public void display() {
        // Create AnchorPane
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431.0, 242.0);

        // Create GridPane
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
        for (int i = 0; i < 9; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Add Labels
        comboBox.getItems().addAll("Dog", "Cat", "Rodent", "Fish","Bird","Other");
        comboBox.getSelectionModel().selectFirst();
        comboBox.setOnAction(new MyListener());
        gridPane.add(comboBox, 0, 0);
        gridPane.add(name, 0, 1);
        gridPane.add(age, 0, 2);
        gridPane.add(gender, 0, 3);
        gridPane.add(color, 0, 4);
        gridPane.add(price, 0, 5);
        gridPane.add(comment, 0, 6);
        gridPane.add(breed, 0, 7);
        gridPane.add(new TextField(), 1, 7);
        gridPane.add(breeder, 0, 8);
        gridPane.add(new TextField(), 1, 8);


        // Add TextFields
        for (int i = 1; i < 7; i++) {
            gridPane.add(new TextField(), 1, i);
        }

        // Add Button
        // Add Button
        Button saveButton = new Button("Save");
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefSize(95.0, 25.0);
        gridPane.add(saveButton, 1, 9);
        saveButton.setOnAction(event -> saveDog());

        // Add GridPane to AnchorPane
        anchorPane.getChildren().add(gridPane);

        // Set Scene
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Pet");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(true);
        stage.show();

        saveButton.setOnAction(event -> stage.close());
    }

    private class MyListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == comboBox) {
                String selected = comboBox.getSelectionModel().getSelectedItem();
                addAnimalSpecificFields(selected);
            }
        }

        private void addAnimalSpecificFields(String animalType) {
            // Clear previous animal-specific fields
            gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) > 5);

            Stage currentStage = (Stage) gridPane.getScene().getWindow();

            switch (animalType) {
                case "Dog":
                    gridPane.add(breed, 0, 6);
                    gridPane.add(new TextField(), 1, 6);
                    gridPane.add(breeder, 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    Button saveButtonDog = new Button("Save");
                    saveButtonDog.setMnemonicParsing(false);
                    saveButtonDog.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonDog, 1, 8);
                    saveButtonDog.setOnAction(event -> saveDog());
                    saveButtonDog.setOnAction(event -> currentStage.close());
                    break;
                case "Cat":
                    gridPane.add(new Label("Breed"), 0, 6);
                    gridPane.add(new TextField(), 1, 6);
                    gridPane.add(new Label("Breeder"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    Button saveButtonCat = new Button("Save");
                    saveButtonCat.setMnemonicParsing(false);
                    saveButtonCat.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonCat, 1, 8);
                    break;
                case "Bird":
                    gridPane.add(new Label("Prefered food"), 0, 6);
                    gridPane.add(new TextField(), 1, 6);
                    Button saveButtonHamster = new Button("Save");
                    saveButtonHamster.setMnemonicParsing(false);
                    saveButtonHamster.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonHamster, 1, 7);
                    break;
                case "Fish":
                    gridPane.add(new Label("Water type"), 0, 6);
                    gridPane.add(new TextField(), 1, 6);
                    gridPane.add(new Label("Predator status"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    Button saveButtonFish = new Button("Save");
                    saveButtonFish.setMnemonicParsing(false);
                    saveButtonFish.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonFish, 1, 8);
                    break;
                case "Rodent":
                    gridPane.add(new Label("Biting tendency"), 0, 6);
                    gridPane.add(new TextField(), 1, 6);
                    Button saveButtonRodent = new Button("Save");
                    saveButtonRodent.setMnemonicParsing(false);
                    saveButtonRodent.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonRodent, 1, 7);
                    break;
                case "Other":
                    gridPane.add(new Label("Other"), 0, 6);
                    gridPane.add(new TextField(), 1, 6);
                    Button saveButtonOther = new Button("Save");
                    saveButtonOther.setMnemonicParsing(false);
                    saveButtonOther.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonOther, 1, 7);
                    break;
            }
        }
    }

    public void saveDog() {
        Dog dog = new Dog(name.getText(), Integer.parseInt(age.getText()), gender.getText(), color.getText(), comment.getText(), true, new Price(Integer.parseInt(price.getText())), breed.getText(), breeder.getText());
        System.err.println( dog.toString() );
        PetListModelManager petListModelManager = new PetListModelManager();
        petListModelManager.addPetForSale(dog);
    }
}