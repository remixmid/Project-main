package savepackages.GUIMain;

import Model.Customer;
import Model.Price;
import Model.Rodent;
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
import savepackages.PetListModelManager;

public class AddCustomerView
{
  private ColumnConstraints column2;
  private AnchorPane anchorPane;
  private GridPane gridPane;
  private ColumnConstraints column1;
  private Label nameLabel;
  private Label emailLabel;
  private Label phoneLabel;
  private Label addressLabel;
  private TextField addressField;
  private TextField nameField;
  private TextField emailField;
  private TextField phoneField;
  private Button saveButton;
  public Stage stage;
  private RowConstraints row;

  public void display()
  {
    // Create and set up the AnchorPane for the UI
    anchorPane = new AnchorPane();
    anchorPane.setPrefSize(431.0, 242.0);

    // Create and set up the GridPane for layout
    gridPane = new GridPane();
    gridPane.setPrefSize(429.0, 227.0);

    // Add column constraints to GridPane
    column1 = new ColumnConstraints();
    column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
    column1.setMinWidth(10.0);
    column1.setPrefWidth(100.0);

    column2 = new ColumnConstraints();
    column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
    column2.setMinWidth(10.0);
    column2.setPrefWidth(100.0);

    gridPane.getColumnConstraints().addAll(column1, column2);

    // Add row constraints to GridPane
    for (int i = 0; i < 8; i++)
    {
      row = new RowConstraints();
      row.setMinHeight(10.0);
      row.setPrefHeight(30.0);
      row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
      gridPane.getRowConstraints().add(row);
    }

    // Create and add labels for customer fields to GridPane
    nameLabel = new Label("Name");
    emailLabel = new Label("Email");
    phoneLabel = new Label("Phone number");
    addressLabel = new Label("Address");
    gridPane.add(nameLabel, 0, 0);
    gridPane.add(emailLabel, 0, 1);
    gridPane.add(phoneLabel, 0, 2);
    gridPane.add(addressLabel, 0, 3);

    // Create and add text fields for customer inputs to GridPane
    nameField = new TextField();
    emailField = new TextField();
    phoneField = new TextField();
    addressField = new TextField();
    gridPane.add(nameField, 1, 0);
    gridPane.add(emailField, 1, 1);
    gridPane.add(phoneField, 1, 2);
    gridPane.add(addressField, 1, 3);

    // Create and add the Save button to GridPane
    saveButton = new Button("Save");
    saveButton.setMnemonicParsing(false);
    saveButton.setPrefSize(95.0, 25.0);
    gridPane.add(saveButton, 1, 7);

    // Add the GridPane to the AnchorPane
    anchorPane.getChildren().add(gridPane);

    // Create and display the Stage (window) for the Add Customer form
    stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Add Customer");
    stage.setScene(new Scene(anchorPane));
    stage.setResizable(false);
    stage.show();

    // Set the action for the Save button
    saveButton.setOnAction(e -> {
      saveCustomer(); // Save the customer data
      stage.close();  // Close the window after saving
    });
  }

  private void saveCustomer()
  {
    // Create a new customer object with input data and save it using the model manager
    Customer customer = new Customer(nameField.getText(), emailField.getText(),
        phoneField.getText(), addressField.getText());
    CustomerListModelManager manager = new CustomerListModelManager();
    manager.addCustomer(customer); // Add the customer to the list
  }
}
