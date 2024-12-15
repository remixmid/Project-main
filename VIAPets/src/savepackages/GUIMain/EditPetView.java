package savepackages.GUIMain;

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

public class EditPetView {

    private ComboBox<String> comboBox = new ComboBox<>();
    private GridPane gridPane = new GridPane();
    private AnchorPane anchorPane;
    private ColumnConstraints column1;
    private ColumnConstraints column2;
    private RowConstraints row;
    private Label name = new Label("Name");
    private Label age = new Label("Age");
    private Label gender = new Label("Gender");
    private Label color = new Label("Color");
    private Label price = new Label("Price");
    private Label comment = new Label("Comment");
    private Label breed = new Label("Breed");
    private Label breeder = new Label("Breeder");
    private TextField nameField = new TextField();
    private TextField ageField = new TextField();
    private TextField genderField = new TextField();
    private TextField colorField = new TextField();
    private TextField priceField = new TextField();
    private TextField commentField = new TextField();
    private TextField breedField = new TextField();
    private TextField breederField = new TextField();
    private Button saveButton;
    private Button saveButtonOther;
    private Stage stage;
    private Button saveButtonDog;
    private Button saveButtonCat;
    private Button saveButtonRodent;
    private Button saveButtonFish;
    private Button saveButtonHamster;

    public void display() {
        // Create AnchorPane
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431.0, 242.0);

        // Create GridPane
        gridPane.setPrefSize(429.0, 227.0);

        // Add Column Constraints
        column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10.0);
        column1.setPrefWidth(100.0);

        column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10.0);
        column2.setPrefWidth(100.0);

        gridPane.getColumnConstraints().addAll(column1, column2);

        // Add Row Constraints
        for (int i = 0; i < 9; i++) {
            row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Add Labels
        comboBox.getItems().addAll("Dog", "Cat", "Rodent", "Fish","Bird","Other");
        comboBox.getSelectionModel().selectFirst();
        gridPane.add(comboBox, 0, 0);
        gridPane.add(name, 0, 1);
        gridPane.add(age, 0, 2);
        gridPane.add(gender, 0, 3);
        gridPane.add(color, 0, 4);
        gridPane.add(price, 0, 5);
        gridPane.add(comment, 0, 6);
        gridPane.add(breed, 0, 7);
        gridPane.add(breeder, 0, 8);

        // Add TextFields
        gridPane.add(nameField, 1, 1);
        gridPane.add(ageField, 1, 2);
        gridPane.add(genderField, 1, 3);
        gridPane.add(colorField, 1, 4);
        gridPane.add(priceField, 1, 5);
        gridPane.add(commentField, 1, 6);
        gridPane.add(breedField, 1, 7);
        gridPane.add(breederField,1,8);


        // Add Button
        saveButton = new Button("Save");
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefSize(95.0, 25.0);
        gridPane.add(saveButton, 1, 9);

        // Add GridPane to AnchorPane
        anchorPane.getChildren().add(gridPane);

        // Set Scene
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Pet");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.showAndWait();
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

            switch (animalType) {
                case "Dog":
                    gridPane.add(new Label("Breed"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    gridPane.add(new Label("Breeder"), 0, 8);
                    gridPane.add(new TextField(), 1, 8);
                    saveButtonDog = new Button("Save");
                    saveButtonDog.setMnemonicParsing(false);
                    saveButtonDog.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonDog, 1, 9);
                    break;
                case "Cat":
                    gridPane.add(new Label("Breed"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    gridPane.add(new Label("Breeder"), 0, 8);
                    gridPane.add(new TextField(), 1, 8);
                    saveButtonCat = new Button("Save");
                    saveButtonCat.setMnemonicParsing(false);
                    saveButtonCat.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonCat, 1, 9);
                    break;
                case "Bird":
                    gridPane.add(new Label("Prefered food"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    saveButtonHamster = new Button("Save");
                    saveButtonHamster.setMnemonicParsing(false);
                    saveButtonHamster.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonHamster, 1, 8);
                    break;
                case "Fish":
                    gridPane.add(new Label("Water type"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    gridPane.add(new Label("Predator status"), 0, 8);
                    gridPane.add(new TextField(), 1, 8);
                    saveButtonFish = new Button("Save");
                    saveButtonFish.setMnemonicParsing(false);
                    saveButtonFish.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonFish, 1, 9);
                    break;
                case "Rodent":
                    gridPane.add(new Label("Biting tendency"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    saveButtonRodent = new Button("Save");
                    saveButtonRodent.setMnemonicParsing(false);
                    saveButtonRodent.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonRodent, 1, 8);
                    break;
                case "Other":
                    gridPane.add(new Label("Other"), 0, 7);
                    gridPane.add(new TextField(), 1, 7);
                    saveButtonOther = new Button("Save");
                    saveButtonOther.setMnemonicParsing(false);
                    saveButtonOther.setPrefSize(95.0, 25.0);
                    gridPane.add(saveButtonOther, 1, 8);
                    break;
            }
        }
    }
}