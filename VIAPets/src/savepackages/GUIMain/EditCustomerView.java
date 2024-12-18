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

public class EditCustomerView  {

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

    public EditCustomerView(Customer customer) {
        this.customer = customer;
    }

    public void display() {
        // Create AnchorPane
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(431.0, 242.0);

        // Create GridPane
        gridPane = new GridPane();
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
        for (int i = 0; i < 8; i++) {
            row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Add Labels
        nameLabel = new Label("Name");
        emailLabel = new Label("Email");
        phoneLabel = new Label("Phone number");
        addressLabel = new Label("Address");
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(phoneLabel, 0, 2);
        gridPane.add(addressLabel, 0, 3);

        // Add TextFields
        nameField = new TextField(customer.getName());
        emailField = new TextField(customer.getEmail());
        phoneField = new TextField(customer.getPhoneNumber());
        addressField = new TextField(customer.getAddress());
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailField, 1, 1);
        gridPane.add(phoneField, 1, 2);
        gridPane.add(addressField, 1, 3);

        // Add Button
        saveButton = new Button("Save");
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefSize(95.0, 25.0);
        gridPane.add(saveButton, 1, 7);
        saveButton.setOnAction((event) -> {
            stage.close();
            saveCustomer();
        });

        // Add GridPane to AnchorPane
        anchorPane.getChildren().add(gridPane);

        // Set Scene
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Customer");
        stage.setScene(new Scene(anchorPane));
        stage.setResizable(false);
        stage.show();
    }
    private void saveCustomer() {
        Customer newCustomer = new Customer(nameField.getText(), emailField.getText(), phoneField.getText(), addressField.getText());
        CustomerListModelManager manager = new CustomerListModelManager();
        manager.editCustomer(customer,newCustomer);
    }


}
