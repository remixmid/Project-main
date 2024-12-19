package savepackages.GUIMain;

import Model.*;
import com.sun.tools.javac.Main;
import javafx.scene.Node;
import savepackages.PetListModelManager;
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

import javax.print.attribute.standard.MediaSize;

public class EditPetView  {

    private ComboBox<String> comboBox = new ComboBox<>();
    private GridPane gridPane = new GridPane();

    private Label name = new Label("Name");
    private Label age = new Label("Age");
    private Label gender = new Label("Gender");
    private Label color = new Label("Color");
    private Label price = new Label("Price");
    private Label comment = new Label("Comment");
    private Label breed = new Label("Breed");
    private Label breeder = new Label("Breeder");
    private Button saveButtonDog = new Button("Save");
    private Button saveButton = new Button("Save");
    private Button saveButtonCat = new Button("Save");
    private TextField nameField = new TextField();
    private TextField ageField = new TextField();
    private TextField genderField = new TextField();
    private TextField colorField = new TextField();
    private TextField priceField = new TextField();
    private TextField commentField = new TextField();
    private TextField breedField = new TextField();
    private TextField breederField = new TextField();
    private Label prefFood;
    private TextField prefFoodField;
    private Label waterType;
    private TextField waterTypeField;
    private Label predatorStatus;
    private TextField predatorStatusField;
    private Button saveButtonBird;
    private Button saveButtonFish;
    private Label bittingTendency;
    private TextField bittingTendencyField;
    private Button saveButtonRodent;
    private Button saveButtonOther;
    private Label typeLabel;
    private TextField typeField;
    public Stage stage;
    private Pet pet;

    public EditPetView(Pet pet){
        this.pet = pet;
    }
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

        // Add Labels and TextFields
        gridPane.add(name, 0, 1);
        gridPane.add(age, 0, 2);
        gridPane.add(gender, 0, 3);
        gridPane.add(color, 0, 4);
        gridPane.add(price, 0, 5);
        gridPane.add(comment, 0, 6);
        gridPane.add(breed, 0, 7);
        gridPane.add(breeder, 0, 8);

        gridPane.add(nameField, 1, 1);
        gridPane.add(ageField, 1, 2);
        gridPane.add(genderField, 1, 3);
        gridPane.add(colorField, 1, 4);
        gridPane.add(priceField, 1, 5);
        gridPane.add(commentField, 1, 6);
        gridPane.add(breedField, 1, 7);
        gridPane.add(breederField, 1, 8);

        nameField.setText(pet.getName());
        ageField.setText(String.valueOf(pet.getAge()));
        genderField.setText(pet.getGender());
        colorField.setText(pet.getColor());
        priceField.setText(String.valueOf(pet.getPrice()));
        commentField.setText(pet.getComment());

        // Add Save Button
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefSize(95.0, 25.0);
        gridPane.add(saveButton, 1, 9);

        // Add GridPane to AnchorPane
        anchorPane.getChildren().add(gridPane);

        // Set Scene
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Pet");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(true);
        stage.show();

        // Call addAnimalSpecificFields after the scene is set
        addAnimalSpecificFields();
    }

    private void addAnimalSpecificFields() {
        // Clear previous animal-specific fields
        gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) > 6);

        Stage currentStage = (Stage) gridPane.getScene().getWindow();

        if(pet instanceof Dog){
            gridPane.add(breed, 0, 7);
            gridPane.add(breedField, 1, 7);
            gridPane.add(breeder, 0, 8);
            gridPane.add(breederField, 1, 8);
            breedField.setText(((Dog) pet).getBreed());
            breederField.setText(((Dog) pet).getBreed());

            saveButtonDog.setMnemonicParsing(false);
            saveButtonDog.setPrefSize(95.0, 25.0);
            gridPane.add(saveButtonDog, 1, 9);
            saveButtonDog.setOnAction(event -> {
                saveDog();
                currentStage.close();
            });} else if (pet instanceof Cat) {
            gridPane.add(breed, 0, 7);
            gridPane.add(breedField, 1, 7);
            gridPane.add(breeder, 0, 8);
            gridPane.add(breederField, 1, 8);
            breedField.setText(((Cat) pet).getBreed());
            breederField.setText(((Cat) pet).getBreed());

            saveButtonCat.setMnemonicParsing(false);
            saveButtonCat.setPrefSize(95.0, 25.0);
            gridPane.add(saveButtonCat, 1, 9);
            saveButtonCat.setOnAction(event -> {
                saveCat();
                currentStage.close();
            });
        } else if (pet instanceof Bird) {
            prefFood = new Label("Preferred Food");
            gridPane.add(prefFood, 0, 7);
            prefFoodField = new TextField();
            gridPane.add(prefFoodField, 1, 7);
            saveButtonBird = new Button("Save");
            saveButtonBird.setMnemonicParsing(false);
            saveButtonBird.setPrefSize(95.0, 25.0);
            gridPane.add(saveButtonBird, 1, 8);
            prefFoodField.setText(((Bird) pet).getPreferredFood());

            saveButtonBird.setOnAction(event -> {
                saveBird();
                currentStage.close();
            });
        } else if (pet instanceof Fish) {
            waterType = new Label("Water type");
            gridPane.add(waterType, 0, 7);
            waterTypeField = new TextField();
            gridPane.add(waterTypeField, 1, 7);
            predatorStatus = new Label("Predator status");
            gridPane.add(predatorStatus, 0, 8);
            predatorStatusField = new TextField();
            gridPane.add(predatorStatusField, 1, 8);
            saveButtonFish = new Button("Save");
            saveButtonFish.setMnemonicParsing(false);
            saveButtonFish.setPrefSize(95.0, 25.0);
            gridPane.add(saveButtonFish, 1, 9);
            waterTypeField.setText(((Fish) pet).getWaterType());
            predatorStatus.setText(((Fish) pet).getPredatorStatus());
            saveButtonFish.setOnAction(event -> {
                saveFish();
                currentStage.close();
            });
        } else if (pet instanceof Rodent) {
            bittingTendency = new Label("Biting tendency");
            gridPane.add(bittingTendency, 0, 7);
            bittingTendencyField = new TextField();
            gridPane.add(bittingTendencyField, 1, 7);
            saveButtonRodent = new Button("Save");
            saveButtonRodent.setMnemonicParsing(false);
            saveButtonRodent.setPrefSize(95.0, 25.0);
            gridPane.add(saveButtonRodent, 1, 8);
            bittingTendencyField.setText(((Rodent) pet).getBitingTendency());
            saveButtonRodent.setOnAction(event -> {
                saveRodent();
                currentStage.close();
            });
        } else if (pet instanceof OtherPets) {
            typeLabel = new Label("Type");
            gridPane.add(typeLabel, 0, 7);
            typeField = new TextField();
            gridPane.add(typeField, 1, 7);
            gridPane.add(breed, 0, 8);
            gridPane.add(breedField, 1, 8);
            typeField.setText(((OtherPets) pet).getType());
            breedField.setText(((OtherPets) pet).getBreed());
            saveButtonOther = new Button("Save");
            saveButtonOther.setMnemonicParsing(false);
            saveButtonOther.setPrefSize(95.0, 25.0);
            gridPane.add(saveButtonOther, 1, 9);
            saveButtonOther.setOnAction(event -> {
                saveOther();
                currentStage.close();
            });
        }




    }



    private void saveRodent() {
        try {
        Price price1 = new Price(Integer.parseInt(priceField.getText()));
        Rodent rodent = new Rodent(nameField.getText(), Integer.parseInt(ageField.getText()) , genderField.getText(), colorField.getText(), commentField.getText(), true , price1 ,bittingTendencyField.getText());
        PetListModelManager petListModelManager = new PetListModelManager();
        petListModelManager.editPet(pet,rodent);
            Stage currentStage = (Stage) gridPane.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            // Show an error dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Error");
            alert.setHeaderText("Failed to edit pet");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            e.printStackTrace();
        }
    }

    private void saveOther() {
        try {
        Price price1 = new Price(Integer.parseInt(priceField.getText()));
        OtherPets other = new OtherPets(nameField.getText(), Integer.parseInt(ageField.getText()) , genderField.getText(), colorField.getText(), commentField.getText(), true , price1 , typeField.getText(), breedField.getText());
        PetListModelManager petListModelManager = new PetListModelManager();
        petListModelManager.editPet(pet,other);
        Stage currentStage = (Stage) gridPane.getScene().getWindow();
        currentStage.close();
    } catch (Exception e) {
        // Show an error dialog
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Edit Error");
        alert.setHeaderText("Failed to edit pet");
        alert.setContentText(e.getMessage());
        alert.showAndWait();

        e.printStackTrace();
    }
    }

    private void saveFish() {
        try {
            Price price1 = new Price(Integer.parseInt(priceField.getText()));
            Fish fish = new Fish(nameField.getText(), Integer.parseInt(ageField.getText()) , genderField.getText(), colorField.getText(), commentField.getText(), true , price1 , waterTypeField.getText(), predatorStatusField.getText());
            PetListModelManager petListModelManager = new PetListModelManager();
            petListModelManager.editPet(pet,fish);
            Stage currentStage = (Stage) gridPane.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            // Show an error dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Error");
            alert.setHeaderText("Failed to edit pet");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            e.printStackTrace();
        }
    }

    public void saveDog() {
        try {
            Price price1 = new Price(Integer.parseInt(priceField.getText()));
            Dog dog = new Dog(nameField.getText(), Integer.parseInt(ageField.getText()), genderField.getText(), colorField.getText(), commentField.getText(), true, price1, breedField.getText(), breederField.getText());
            PetListModelManager petListModelManager = new PetListModelManager();
            // Print out details for debugging
            System.out.println("Original Pet: " + pet);
            System.out.println("New Pet: " + dog);
            petListModelManager.editPet(pet, dog);
            // Close the window after successful edit
            Stage currentStage = (Stage) gridPane.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            // Show an error dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Error");
            alert.setHeaderText("Failed to edit pet");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            e.printStackTrace();
        }
    }
    public void saveCat() {
        try {
            Price price1 = new Price(Integer.parseInt(priceField.getText()));
            Cat cat = new Cat(nameField.getText(), Integer.parseInt(ageField.getText()) , genderField.getText(), colorField.getText(), commentField.getText(), true , price1 , breedField.getText(), breederField.getText());
            PetListModelManager petListModelManager = new PetListModelManager();
            petListModelManager.editPet(pet,cat);
            Stage currentStage = (Stage) gridPane.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            // Show an error dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Error");
            alert.setHeaderText("Failed to edit pet");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            e.printStackTrace();
        }
    }
    public void saveBird() {
        try {
            Price price1 = new Price(Integer.parseInt(priceField.getText()));
            Bird bird = new Bird(nameField.getText(), Integer.parseInt(ageField.getText()) , genderField.getText(), colorField.getText(), commentField.getText(), true , price1 , prefFoodField.getText() );
            PetListModelManager petListModelManager = new PetListModelManager();
            petListModelManager.editPet(pet,bird);
            Stage currentStage = (Stage) gridPane.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            // Show an error dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Error");
            alert.setHeaderText("Failed to edit pet");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            e.printStackTrace();
        }
    }
}