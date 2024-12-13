package com.GUIMain;

import Model.Pet;
import Model.PetList;
import com.PetListModelManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainView extends Application {

    private PetListModelManager petListModelManager;

    @Override
    public void start(Stage primaryStage) {
        petListModelManager = new PetListModelManager();

        // Create TabPane
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(600, 400);
        tabPane.setMaxSize(600, 400);
        tabPane.setMinSize(600, 400);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Tab 1
        Tab tab1 = new Tab("Shop");
        VBox tab1Content = new VBox();
        tab1Content.setPrefSize(590, 390);
        tab1Content.setMaxSize(590, 390);
        tab1Content.setMinSize(590, 390);

        FlowPane flowPane1 = new FlowPane();
        flowPane1.setPrefSize(590, 371);
        flowPane1.setMaxSize(590, 371);
        flowPane1.setMinSize(590, 371);

        TableView<Object> tableView1 = new TableView<>();
        tableView1.setPrefSize(590, 338);
        tableView1.setMaxSize(590, 338);
        tableView1.setMinSize(590, 338);
        tableView1.getColumns().add(new TableColumn<>("Name"));
        tableView1.getColumns().add(new TableColumn<>("Age"));
        tableView1.getColumns().add(new TableColumn<>("Gender"));
        tableView1.getColumns().add(new TableColumn<>("Color"));
        tableView1.getColumns().add(new TableColumn<>("Price"));

        ObservableList<Pet> listOfPets = FXCollections.observableArrayList();
        PetList petList = petListModelManager.getAllPets();
        for (Pet pet: petList.getAllPetsForSale()) {
            listOfPets.add(pet);
        }

        HBox hbox1 = new HBox(20);
        hbox1.setPrefSize(290, 32);
        hbox1.setMaxSize(290, 32);
        hbox1.setMinSize(290, 32);

        Button addPetButton = new Button("Add Pet");
        Button editPetButton = new Button("Edit Pet");
        Button deletePetButton = new Button("Delete Pet");
        hbox1.getChildren().addAll(addPetButton, editPetButton, deletePetButton);

        flowPane1.getChildren().addAll(tableView1, hbox1, new StackPane());
        tab1Content.getChildren().add(flowPane1);
        tab1.setContent(tab1Content);
        addPetButton.setOnAction(e -> openAddPetView());
        editPetButton.setOnAction(e -> openEditPetView());

        // Tab 2
        Tab tab2 = new Tab("Kennel");
        AnchorPane anchorPane2 = new AnchorPane();
        HBox hBox2 = new HBox(20);
        hBox2.setPrefSize(600, 374);
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(855, 271);
        for (int i = 0; i < 2; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(48));
        }
        for (int i = 0; i < 10; i++) {
            gridPane.getRowConstraints().add(new RowConstraints(30));
        }
        for (int i = 1; i <= 10; i++) {
            gridPane.add(new Label("Room" + i), 0, i - 1);
            gridPane.add(new TextField(), 1, i - 1);
        }
        VBox vBox2 = new VBox();
        vBox2.setPrefSize(391, 374);
        TableView tableView2 = new TableView();
        tableView2.setPrefSize(391, 327);
        tableView2.getColumns().add(new TableColumn<>("Customer"));
        tableView2.getColumns().add(new TableColumn<>("Pet"));
        tableView2.getColumns().add(new TableColumn<>("Date In"));
        tableView2.getColumns().add(new TableColumn<>("Date Out"));
        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setPrefSize(391, 79);
        Button addBookingButton = new Button("Add Booking");
        addBookingButton.setLayoutX(122);
        addBookingButton.setLayoutY(13);
        Button editBookingButton = new Button("Edit Booking");
        editBookingButton.setLayoutX(219);
        editBookingButton.setLayoutY(13);
        Button deleteBookingButton = new Button("Delete Booking");
        deleteBookingButton.setLayoutX(317);
        deleteBookingButton.setLayoutY(13);
        Button addKenelPlaceButton = new Button("Add Kenel Place");
        addKenelPlaceButton.setLayoutY(13);
        anchorPane3.getChildren().addAll(addBookingButton, editBookingButton, deleteBookingButton, addKenelPlaceButton);
        vBox2.getChildren().addAll(tableView2, anchorPane3);
        hBox2.getChildren().addAll(gridPane, vBox2);
        anchorPane2.getChildren().add(hBox2);
        tab2.setContent(anchorPane2);
        addBookingButton.setOnAction(e -> openAddBookView());
        editBookingButton.setOnAction(e -> openEditBooking());

        // Tab 3
        Tab tab3 = new Tab("Customers");
        VBox tab3Content = new VBox();
        tab3Content.setPrefSize(600, 390);
        tab3Content.setMaxSize(600, 390);
        tab3Content.setMinSize(600, 390);

        FlowPane flowPane3 = new FlowPane();
        flowPane3.setPrefSize(604, 364);
        flowPane3.setMaxSize(604, 364);
        flowPane3.setMinSize(604, 364);

        TableView<Object> tableView3 = new TableView<>();
        tableView3.setPrefSize(601, 308);
        tableView3.setMaxSize(601, 308);
        tableView3.setMinSize(601, 308);
        tableView3.getColumns().add(new TableColumn<>("Name"));
        tableView3.getColumns().add(new TableColumn<>("Phone Number"));
        tableView3.getColumns().add(new TableColumn<>("Email"));
        tableView3.getColumns().add(new TableColumn<>("Address"));

        HBox hbox3 = new HBox(20);
        hbox3.setPrefSize(221, 65);
        hbox3.setMaxSize(221, 65);
        hbox3.setMinSize(221, 65);

        Button addCustomerButton = new Button("Add Customer");
        Button editCustomerButton = new Button("Edit Customer");
        hbox3.getChildren().addAll(addCustomerButton, editCustomerButton);
        addCustomerButton.setOnAction(event -> openAddCustomerWindow());
        editCustomerButton.setOnAction(event -> openEditCustomerWindow());

        flowPane3.getChildren().addAll(tableView3, hbox3);
        tab3Content.getChildren().add(flowPane3);
        tab3.setContent(tab3Content);

        // Add tabs to TabPane
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        // Set Scene
        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void openAddCustomerWindow() {
        AddCustomerView addCustomerView = new AddCustomerView();
        addCustomerView.display(); // Display the Add Customer View
    }
    private void openEditCustomerWindow() {
        EditCustomerView editCustomerView = new EditCustomerView();
        editCustomerView.display();
    }
    private void openAddPetView(){
        AddPetView addPetView = new AddPetView();
        addPetView.display();

    }

    private void openEditPetView(){
        EditPetView editPetView = new EditPetView();
        editPetView.display();
    }

    private void openAddBookView(){
        AddBooking addBooking = new AddBooking();
        addBooking.display();
    }
    private void openEditBooking(){
        EditBooking editBooking = new EditBooking();
        editBooking.display();
    }


    public static void main(String[] args) {
        launch(args);
    }


}