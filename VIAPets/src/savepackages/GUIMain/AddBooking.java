package savepackages.GUIMain;

import Model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import savepackages.BookingListModelManager;
import savepackages.CustomerListModelManager;
import savepackages.KennelModelManager;
import savepackages.PetListModelManager;

import java.time.LocalDate;

public class AddBooking {

    private AnchorPane anchorPane;
    private GridPane gridPane;
    private ColumnConstraints col1;
    private ColumnConstraints col2;
    public Stage stage;
    private Label petLabel;
    private Label priceLabel;
    private Label dateInLabel;
    private Label dateOutLabel;
    private ComboBox petField;
    private TextField priceField;
    private DatePicker dateInPicker;
    private DatePicker dateOutPicker;
    private Label customerLabel;
    private ComboBox customerField;
    private Button saveButton;
    private RowConstraints row;
    private LocalDate minDate;

    public void display() {
        // Displays the booking window
        minDate = LocalDate.of(2024, 12, 19);

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

        Label kennelPlaceLabel = new Label("Kennel Place");
        kennelPlaceLabel.setPrefSize(100, 25);
        gridPane.add(kennelPlaceLabel, 0, 1);

        ComboBox<Integer> kennelPlaceField = new ComboBox<>();
        gridPane.add(kennelPlaceField, 1, 1);

        KennelModelManager kennelModelManager = new KennelModelManager();
        Kennel kennel = kennelModelManager.getKennel();

        for (KennelPlace kennelPlace : kennel.getAllKennelPlaces()) {
            kennelPlaceField.getItems().add(kennelPlace.getKennelPlaceId());
        }

        priceLabel = new Label("Price");
        priceLabel.setPrefSize(45, 17);
        gridPane.add(priceLabel, 0, 2);

        customerLabel = new Label("Customer");
        customerLabel.setPrefSize(70, 17);
        gridPane.add(customerLabel, 0, 3);

        dateOutLabel = new Label("Date In");
        dateOutLabel.setPrefSize(53, 17);
        gridPane.add(dateOutLabel, 0, 4);

        dateInLabel = new Label("Date Out");
        dateInLabel.setPrefSize(55, 17);
        gridPane.add(dateInLabel, 0, 5);

        petField = new ComboBox();
        petField.getItems().addAll("Dog", "Cat", "Bird");
        gridPane.add(petField, 1, 0);

        priceField = new TextField();
        gridPane.add(priceField, 1, 2);

        customerField = new ComboBox<>();
        gridPane.add(customerField, 1, 3);

        CustomerListModelManager customerListModelManager = new CustomerListModelManager();
        CustomerList customerList = customerListModelManager.getAllCustomers();

        for (Customer customer : customerList.getAllCustomers()) {
            customerField.getItems().add(customer.getName());
        }

        dateOutPicker = new DatePicker();
        dateOutPicker.setValue(LocalDate.now()); // Set current date
        dateOutPicker.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isBefore(minDate)) {
                    setDisable(true);
                }
            }
        });
        dateOutPicker.getEditor().setDisable(true); // Disable manual input
        gridPane.add(dateOutPicker, 1, 4);

        dateInPicker = new DatePicker();
        dateInPicker.setValue(LocalDate.now().plusDays(1)); // Set current date
        dateInPicker.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate nextDayDate = minDate.plusDays(1);
                if (date.isBefore(nextDayDate)) {
                    setDisable(true);
                }
            }
        });
        dateInPicker.getEditor().setDisable(true); // Disable manual input
        gridPane.add(dateInPicker, 1, 5);

        saveButton = new Button("Save");
        saveButton.setPrefSize(95, 25);
        gridPane.add(saveButton, 1, 6);

        anchorPane.getChildren().add(gridPane);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Booking");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.show();
        saveButton.setOnAction(event -> stage.close());
    }
}
