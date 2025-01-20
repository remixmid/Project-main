package savepackages.GUIMain;

import Model.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import savepackages.BookingListModelManager;
import savepackages.CustomerListModelManager;
import savepackages.KennelModelManager;

import java.time.LocalDate;

public class AddBooking {
    private AnchorPane anchorPane;
    private GridPane gridPane;
    public Stage stage;
    private ComboBox<String> petField;
    private TextField priceField;
    private DatePicker dateInPicker;
    private DatePicker dateOutPicker;
    private ComboBox<String> customerField;
    private ComboBox<Integer> kennelPlaceField;
    private LocalDate minDate;

    public void display() {
        minDate = LocalDate.now(); // Set minimum date to today

        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431, 242);

        gridPane = new GridPane();
        gridPane.setLayoutX(1);
        gridPane.setLayoutY(8);
        gridPane.setPrefSize(429, 227);

        // Set up grid constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        col1.setMinWidth(10);
        col1.setPrefWidth(100);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);
        col2.setMinWidth(10);
        col2.setPrefWidth(100);

        gridPane.getColumnConstraints().addAll(col1, col2);

        // Set up row constraints
        for (int i = 0; i < 6; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10);
            row.setPrefHeight(30);
            row.setVgrow(Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Add labels
        gridPane.add(new Label("Pet"), 0, 0);
        gridPane.add(new Label("Kennel Place"), 0, 1);
        gridPane.add(new Label("Price"), 0, 2);
        gridPane.add(new Label("Customer"), 0, 3);
        gridPane.add(new Label("Check-in Date"), 0, 4);
        gridPane.add(new Label("Check-out Date"), 0, 5);

        // Initialize and set up fields
        petField = new ComboBox<>();
        petField.getItems().addAll("Dog", "Cat", "Bird");
        gridPane.add(petField, 1, 0);

        kennelPlaceField = new ComboBox<>();
        KennelModelManager kennelModelManager = new KennelModelManager();
        Kennel kennel = kennelModelManager.getKennel();
        for (KennelPlace kennelPlace : kennel.getAllKennelPlaces()) {
            kennelPlaceField.getItems().add(kennelPlace.getKennelPlaceId());
        }
        gridPane.add(kennelPlaceField, 1, 1);

        priceField = new TextField();
        gridPane.add(priceField, 1, 2);

        customerField = new ComboBox<>();
        CustomerListModelManager customerListModelManager = new CustomerListModelManager();
        CustomerList customerList = customerListModelManager.getAllCustomers();
        for (Customer customer : customerList.getAllCustomers()) {
            customerField.getItems().add(customer.getName());
        }
        gridPane.add(customerField, 1, 3);

        // Set up check-in date picker
        dateInPicker = new DatePicker();
        dateInPicker.setValue(LocalDate.now());
        dateInPicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                // Disable dates before today
                setDisable(empty || date.isBefore(minDate));
            }
        });
        dateInPicker.getEditor().setDisable(true);
        gridPane.add(dateInPicker, 1, 4);

        // Set up check-out date picker
        dateOutPicker = new DatePicker();
        dateOutPicker.setValue(LocalDate.now().plusDays(1));
        dateOutPicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate checkInDate = dateInPicker.getValue();
                if (checkInDate != null) {
                    // Disable dates before or equal to check-in date
                    setDisable(empty || date.isBefore(checkInDate) || date.isEqual(checkInDate));
                }
            }
        });
        dateOutPicker.getEditor().setDisable(true);
        gridPane.add(dateOutPicker, 1, 5);

        // Update check-out picker's disabled dates when check-in date changes
        dateInPicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // If current check-out date is invalid with new check-in date, update it
                LocalDate currentCheckOut = dateOutPicker.getValue();
                if (currentCheckOut == null || currentCheckOut.isBefore(newVal) || currentCheckOut.isEqual(newVal)) {
                    dateOutPicker.setValue(newVal.plusDays(1));
                }

                // Update disabled dates for check-out picker
                dateOutPicker.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(newVal) || date.isEqual(newVal));
                    }
                });
            }
        });

        Button saveButton = new Button("Save");
        saveButton.setPrefSize(95, 25);
        gridPane.add(saveButton, 1, 6);
        saveButton.setOnAction(event -> {
            if (saveBooking()) {
                stage.close();
            }
        });

        anchorPane.getChildren().add(gridPane);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Booking");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.show();
    }

    private boolean saveBooking() {
        try {
            // Validate all required fields
            if (petField.getValue() == null ||
                    priceField.getText().isEmpty() ||
                    dateInPicker.getValue() == null ||
                    dateOutPicker.getValue() == null ||
                    kennelPlaceField.getValue() == null ||
                    customerField.getValue() == null) {
                showError("Input Error", "Please fill in all fields");
                return false;
            }

            // Validate price
            int price;
            try {
                price = Integer.parseInt(priceField.getText());
                if (price <= 0) {
                    showError("Price Error", "Price must be greater than 0");
                    return false;
                }
            } catch (NumberFormatException e) {
                showError("Price Error", "Please enter a valid price");
                return false;
            }

            // Create booking with all required properties
            Price bookingPrice = new Price(price);
            KennelPlace kennelPlaceToAdd = new KennelPlace(bookingPrice);
            kennelPlaceToAdd.setKennelPlaceId(kennelPlaceField.getValue());
            kennelPlaceToAdd.setPet(petField.getValue());
            kennelPlaceToAdd.setDateIn(java.sql.Date.valueOf(dateInPicker.getValue()));
            kennelPlaceToAdd.setDateOut(java.sql.Date.valueOf(dateOutPicker.getValue()));
            kennelPlaceToAdd.setOccupied(true);

            // Save booking and verify it was saved
            BookingListModelManager bookingListModelManager = new BookingListModelManager();
            bookingListModelManager.addBooking(kennelPlaceToAdd);

            System.out.println("Saved booking: ID=" + kennelPlaceToAdd.getKennelPlaceId() +
                    ", Pet=" + kennelPlaceToAdd.getPet() +
                    ", DateIn=" + kennelPlaceToAdd.getDateIn());

            return true;

        } catch (IllegalStateException e) {
            showError("Booking Error", e.getMessage());
            return false;
        } catch (Exception e) {
            showError("Error", "An error occurred while saving the booking");
            e.printStackTrace();
            return false;
        }

    }


    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}