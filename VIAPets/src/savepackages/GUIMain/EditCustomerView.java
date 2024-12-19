package savepackages.GUIMain;

import Model.Customer;
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
import savepackages.CustomerListModelManager;

public class EditCustomerView {

    private AnchorPane anchorPane;
    private GridPane gridPane;
    private ColumnConstraints column1;
    private ColumnConstraints column2;
    private RowConstraints row;
    private Label nameLabel;
    private Label emailLabel;
    private Label phoneLabel;
    private Label addressLabel;
    private TextField nameField;
    private TextField emailField;
    private TextField phoneField;
    private TextField addressField;
    private Button saveButton;
    public Stage stage;
    private Customer customer;

    // Constructor that accepts the customer to be edited
    public EditCustomerView(Customer customer) {
        this.customer = customer;
    }

    // Method to display the Edit Customer window
    public void display() {
        // Create AnchorPane and set its size
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431.0, 242.0);

        // Create GridPane and set its size
        gridPane = new GridPane();
        gridPane.setPrefSize(429.0, 227.0);

        // Add Column Constraints to GridPane
        column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10.0);
        column1.setPrefWidth(100.0);

        column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10.0);
        column2.setPrefWidth(100.0);

        gridPane.getColumnConstraints().addAll(column1, column2);

        // Add Row Constraints to GridPane
        for (int i = 0; i < 8; i++) {
            row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Add Labels for the form fields
        nameLabel = new Label("Name");
        emailLabel = new Label("Email");
        phoneLabel = new Label("Phone number");
        addressLabel = new Label("Address");

        // Add labels to specific grid positions
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(phoneLabel, 0, 2);
        gridPane.add(addressLabel, 0, 3);

        // Add TextFields and set them with existing customer data
        nameField = new TextField(customer.getName());
        emailField = new TextField(customer.getEmail());
        phoneField = new TextField(customer.getPhoneNumber());
        addressField = new TextField(customer.getAddress());

        // Add text fields to grid positions
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailField, 1, 1);
        gridPane.add(phoneField, 1, 2);
        gridPane.add(addressField, 1, 3);

        // Add Save Button
        saveButton = new Button("Save");
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefSize(95.0, 25.0);

        // Set the action for the save button
        saveButton.setOnAction((event) -> {
            saveCustomer();  // Save the updated customer information
            stage.close();   // Close the window
        });

        // Add the Save button to the grid
        gridPane.add(saveButton, 1, 7);

        // Add GridPane to AnchorPane
        anchorPane.getChildren().add(gridPane);

        // Set up the Stage (window)
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);  // Makes the window modal
        stage.setTitle("Edit Customer");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);  // Prevent resizing the window
        stage.show();  // Display the window
    }

    // Method to save the customer information
    private void saveCustomer() {
        // Create a new customer object with the updated details
        Customer newCustomer = new Customer(
            nameField.getText(),
            emailField.getText(),
            phoneField.getText(),
            addressField.getText()
        );

        // Use the CustomerListModelManager to edit the customer
        CustomerListModelManager manager = new CustomerListModelManager();
        manager.editCustomer(customer, newCustomer);  // Update the customer in the list
    }
}
