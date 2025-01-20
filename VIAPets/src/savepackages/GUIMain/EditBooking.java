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

public class EditBooking {
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
    private Button saveButton;
    private Button deleteButton;
    private KennelPlace currentBooking;

    public EditBooking(KennelPlace booking) {
        this.currentBooking = booking;
    }

    public void display() {
        minDate = LocalDate.now();

        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431, 282);

        gridPane = new GridPane();
        gridPane.setLayoutX(1);
        gridPane.setLayoutY(8);
        gridPane.setPrefSize(429, 267);

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
        for (int i = 0; i < 7; i++) {
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

        // Set up date pickers
        dateInPicker = new DatePicker();
        dateOutPicker = new DatePicker();
        setupDatePickers();
        gridPane.add(dateInPicker, 1, 4);
        gridPane.add(dateOutPicker, 1, 5);

        // Create HBox for buttons
        HBox buttonBox = new HBox(10);
        saveButton = new Button("Save");
        deleteButton = new Button("Delete");
        buttonBox.getChildren().addAll(saveButton, deleteButton);
        gridPane.add(buttonBox, 1, 6);

        // Set button actions
        saveButton.setOnAction(event -> {
            if (saveBooking()) {
                stage.close();
            }
        });

        deleteButton.setOnAction(event -> {
            if (deleteBooking()) {
                stage.close();
            }
        });

        // Load current booking data
        loadBookingData();

        anchorPane.getChildren().add(gridPane);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Booking");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.show();
    }

    private void setupDatePickers() {
        dateInPicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(minDate));
            }
        });
        dateInPicker.getEditor().setDisable(true);

        dateOutPicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate checkInDate = dateInPicker.getValue();
                if (checkInDate != null) {
                    setDisable(empty || date.isBefore(checkInDate) || date.isEqual(checkInDate));
                }
            }
        });
        dateOutPicker.getEditor().setDisable(true);

        dateInPicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                LocalDate currentCheckOut = dateOutPicker.getValue();
                if (currentCheckOut == null || currentCheckOut.isBefore(newVal) || currentCheckOut.isEqual(newVal)) {
                    dateOutPicker.setValue(newVal.plusDays(1));
                }
                dateOutPicker.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(newVal) || date.isEqual(newVal));
                    }
                });
            }
        });
    }

    private void loadBookingData() {
        if (currentBooking != null) {
            petField.setValue(currentBooking.getPet());
            kennelPlaceField.setValue(currentBooking.getKennelPlaceId());
            priceField.setText(String.valueOf(currentBooking.getPrice()));
            customerField.setValue(currentBooking.getCustomerName()); // Load customer name
            dateInPicker.setValue(new java.sql.Date(currentBooking.getDateIn().getTime()).toLocalDate());
            dateOutPicker.setValue(new java.sql.Date(currentBooking.getDateOut().getTime()).toLocalDate());
        }
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

            // Delete old booking
            BookingListModelManager manager = new BookingListModelManager();
            manager.deleteBooking(currentBooking.getKennelPlaceId(), currentBooking.getDateIn());

            // Create updated booking
            Price bookingPrice = new Price(price);
            KennelPlace updatedBooking = new KennelPlace(bookingPrice);
            updatedBooking.setKennelPlaceId(kennelPlaceField.getValue());
            updatedBooking.setPet(petField.getValue());
            updatedBooking.setCustomerName(customerField.getValue()); // Save customer name
            updatedBooking.setDateIn(java.sql.Date.valueOf(dateInPicker.getValue()));
            updatedBooking.setDateOut(java.sql.Date.valueOf(dateOutPicker.getValue()));
            updatedBooking.setOccupied(true);

            // Save updated booking
            manager.addBooking(updatedBooking);
            return true;

        } catch (Exception e) {
            showError("Error", "An error occurred while saving the booking");
            e.printStackTrace();
            return false;
        }
    }

    private boolean deleteBooking() {
        try {
            Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDelete.setTitle("Confirm Delete");
            confirmDelete.setHeaderText("Delete Booking");
            confirmDelete.setContentText("Are you sure you want to delete this booking?");

            if (confirmDelete.showAndWait().get() == ButtonType.OK) {
                BookingListModelManager manager = new BookingListModelManager();
                manager.deleteBooking(currentBooking.getKennelPlaceId(), currentBooking.getDateIn());
                return true;
            }
            return false;
        } catch (Exception e) {
            showError("Error", "An error occurred while deleting the booking");
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