package savepackages.GUIMain;

import Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import savepackages.BookingListModelManager;
import savepackages.CustomerListModelManager;
import savepackages.PetListModelManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends Application {

    private PetListModelManager petListModelManager;
    private ObservableList<Pet> listOfPets;
    private ObservableList<Customer> listOfCustomers;
    private BookingListModelManager bookingListModelManager;
    private ObservableList<KennelPlace> listOfBookings;
    private TabPane tabPane;
    private Tab tab1;
    private VBox tab1Content;
    private FlowPane flowPane1;
    private TableView<Pet> tableView1;
    private TableColumn<Pet, String> nameColumn;
    private TableColumn<Pet, Integer> ageColumn;
    private TableColumn<Pet, String> genderColumn;
    private TableColumn<Pet, String> colorColumn;
    private TableColumn<Pet, String> commentColumn;
    private TableColumn<Pet, Price> priceColumn;
    private TableColumn<Pet, String> breedColumn;
    private TableColumn<Pet, String> breederColumn;
    private TableColumn<Pet, String> bitingTendencyColumn;
    private TableColumn<Pet, String> waterTypeColumn;
    private TableColumn<Pet, String> predatorStatusColumn;
    private TableColumn<Pet, String> preferedFoodColumn;
    private TableColumn<Pet, String> typeColumn;
    private TableColumn<KennelPlace, Date> dateInColumn;
    private TableColumn<KennelPlace, Date> dateOutColumn;
    private TableColumn<KennelPlace, Integer> kennelPlaceIdColumn;
    private TableColumn<KennelPlace , Pet> kennelHasThisPetColumn;
    private TableColumn<KennelPlace , Price> kennelPriceColumn;
    private TableColumn<KennelPlace, Integer> kennelPlaceIdColumn2;
    private TableColumn<KennelPlace , Boolean> kennelIsOccupied;
    private TableColumn<Customer, String> customerNameColumn;
    private TableColumn<Customer, String> customerPhoneNumberColumn;
    private TableColumn<Customer, String> customerAddressColumn;
    private TableColumn<Customer, String> customerEmailColumn;
    private HBox hbox1;
    private Button addPetButton;
    private Button editPetButton;
    private Button deletePetButton;
    private Tab tab2;
    private AnchorPane anchorPane2;
    private HBox hBox2;
    private VBox vBox2;
    private TableView tableView2;
    private TableView tableView4;
    private AnchorPane anchorPane3;
    private Button addBookingButton;
    private Scene scene;
    private Button editBookingButton;
    private Button deleteBookingButton;
    private Button addKenelPlaceButton;
    private Tab tab3;
    private VBox tab3Content;
    private FlowPane flowPane3;
    private TableView<Customer> tableView3;
    private HBox hbox3;
    private Button addCustomerButton;
    private Button editCustomerButton;
    private PetList petList;
    private BookingList bookingList;
    private CustomerList customerList;
    private CustomerListModelManager customerListModelManager;
    private VBox vBox3;

    @Override
    public void start(Stage primaryStage) {
        petListModelManager = new PetListModelManager();
        customerListModelManager = new CustomerListModelManager();
        bookingListModelManager = new BookingListModelManager();

        listOfPets = FXCollections.observableArrayList();
        listOfCustomers = FXCollections.observableArrayList();
        listOfBookings = FXCollections.observableArrayList();


        tabPane = new TabPane();
        tabPane.setPrefSize(1000, 400);
        tabPane.setMaxSize(1000, 400);
        tabPane.setMinSize(1000, 400);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        bookingList = bookingListModelManager.getAllBookings();
        for (KennelPlace kennelPlace : bookingList.getBookingList()) {
            listOfBookings.add(kennelPlace);
        }

        petList = petListModelManager.getAllPets();
        for (Pet pet: petList.getAllPetsForSale()) {
            listOfPets.add(pet);
        }
        customerList = customerListModelManager.getAllCustomers();
        for (Customer customer: customerList.getAllCustomers()) {
            listOfCustomers.add(customer);
        }

        // Tab 1
        tab1 = new Tab("Shop");
        tab1Content = new VBox();
        tab1Content.setPrefSize(990, 390);
        tab1Content.setMaxSize(990, 390);
        tab1Content.setMinSize(990, 390);

        flowPane1 = new FlowPane();
        flowPane1.setPrefSize(990, 371);
        flowPane1.setMaxSize(990, 371);
        flowPane1.setMinSize(990, 371);

        tableView1 = new TableView<>();
        tableView1.setItems(listOfPets);
        tableView1.setPrefSize(990, 338);
        tableView1.setMaxSize(990, 338);
        tableView1.setMinSize(990, 338);
        nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colorColumn = new TableColumn<>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        commentColumn = new TableColumn<>("Comment");
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
        priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        breederColumn = new TableColumn<>("Breeder");
        breederColumn.setCellValueFactory(new PropertyValueFactory<>("breeder"));
        breedColumn = new TableColumn<>("Breeder");
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breeder"));
        bitingTendencyColumn = new TableColumn<>("Biting Tendency");
        waterTypeColumn = new TableColumn<>("Water Type");
        predatorStatusColumn = new TableColumn<>("Predator Status");
        preferedFoodColumn = new TableColumn<>("Prefered Food");
        typeColumn = new TableColumn<>("Type");
        waterTypeColumn.setCellValueFactory(new PropertyValueFactory<>("waterType"));
        predatorStatusColumn.setCellValueFactory(new PropertyValueFactory<>("predatorStatus"));
        preferedFoodColumn.setCellValueFactory(new PropertyValueFactory<>("preferedFood"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        bitingTendencyColumn.setCellValueFactory(new PropertyValueFactory<>("bitingTendency"));

        tableView1.getColumns().setAll(typeColumn,nameColumn, ageColumn,genderColumn,colorColumn,commentColumn,priceColumn,breederColumn,breedColumn,bitingTendencyColumn,waterTypeColumn,predatorStatusColumn,preferedFoodColumn);




        hbox1 = new HBox(20);
        hbox1.setPrefSize(290, 32);
        hbox1.setMaxSize(290, 32);
        hbox1.setMinSize(290, 32);

        addPetButton = new Button("Add Pet");
        editPetButton = new Button("Edit Pet");
        deletePetButton = new Button("Delete Pet");
        deletePetButton.setOnAction(event -> {
            Pet selectedPet = tableView1.getSelectionModel().getSelectedItem();
            if (selectedPet != null) {
                petListModelManager.deletePet(selectedPet);
                refreshPetList();
            } else {
                // Optional: Show an alert if no pet is selected
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Pet Selected");
                alert.setHeaderText(null);
                alert.setContentText("Please select a pet to delete.");
                alert.showAndWait();
            }
        });
        editPetButton.setOnAction(e -> openEditPetView());


        hbox1.getChildren().addAll(addPetButton, editPetButton, deletePetButton);

        flowPane1.getChildren().addAll(tableView1, hbox1, new StackPane());
        tab1Content.getChildren().add(flowPane1);
        tab1.setContent(tab1Content);
        addPetButton.setOnAction(e -> openAddPetView());

        // Tab 2
        tab2 = new Tab("Kennel");
        anchorPane2 = new AnchorPane();
        hBox2 = new HBox(20);
        hBox2.setPrefSize(900, 374);






        vBox2 = new VBox();
        vBox2.setPrefSize(391, 374);
        vBox3 = new VBox();
        vBox3.setPrefSize(391, 374);
        tableView2 = new TableView();
        tableView2.setPrefSize(391, 327);
        tableView4 = new TableView();
        tableView4.setPrefSize(391, 311);
        anchorPane3 = new AnchorPane();
        anchorPane3.setPrefSize(391, 79);
        addBookingButton = new Button("Add Booking");
        addBookingButton.setLayoutX(122);
        addBookingButton.setLayoutY(13);
        editBookingButton = new Button("Edit Booking");
        editBookingButton.setLayoutX(219);
        editBookingButton.setLayoutY(13);
        deleteBookingButton = new Button("Delete Booking");
        deleteBookingButton.setLayoutX(317);
        deleteBookingButton.setLayoutY(13);
        addKenelPlaceButton = new Button("Add Kenel Place");
        addKenelPlaceButton.setLayoutY(13);
        anchorPane3.getChildren().addAll(addBookingButton, editBookingButton, deleteBookingButton, addKenelPlaceButton);
        vBox2.getChildren().addAll(tableView2, anchorPane3);
        vBox3.getChildren().addAll(tableView4);
        hBox2.getChildren().addAll(vBox3,vBox2);
        anchorPane2.getChildren().add(hBox2);
        tab2.setContent(anchorPane2);
        addBookingButton.setOnAction(e -> openAddBookView());
        editBookingButton.setOnAction(e -> openEditBooking());
        kennelPlaceIdColumn2 = new TableColumn<>("Id");
        kennelPlaceIdColumn2.setCellValueFactory(new PropertyValueFactory<>("kennelPlaceId"));
        kennelIsOccupied = new TableColumn<>("Is occupied");
        kennelIsOccupied.setCellValueFactory(new PropertyValueFactory<>("isOccupied"));
        kennelPlaceIdColumn = new TableColumn<>("Id");
        kennelPlaceIdColumn.setCellValueFactory(new PropertyValueFactory<>("kennelPlaceId"));
        tableView4.getColumns().addAll(kennelPlaceIdColumn2, kennelIsOccupied);

        dateInColumn = new TableColumn<>("Date in ");
        dateInColumn.setCellValueFactory(new PropertyValueFactory<>("dateIn"));
        dateOutColumn = new TableColumn<>("Date out ");
        dateOutColumn.setCellValueFactory(new PropertyValueFactory<>("dateOut"));
        kennelPriceColumn = new TableColumn<>("Price");
        kennelPriceColumn.setCellValueFactory(new PropertyValueFactory<>("kennelPrice"));
        kennelHasThisPetColumn = new TableColumn<>("Pet");
        kennelHasThisPetColumn.setPrefWidth(94);
        kennelHasThisPetColumn.setCellValueFactory(new PropertyValueFactory<>("pet"));
        tableView2.getColumns().addAll(kennelPlaceIdColumn,dateInColumn,dateOutColumn,kennelPriceColumn,kennelHasThisPetColumn);

        // Tab 3
        tab3 = new Tab("Customers");
        tab3Content = new VBox();
        tab3Content.setPrefSize(600, 390);
        tab3Content.setMaxSize(600, 390);
        tab3Content.setMinSize(600, 390);

        flowPane3 = new FlowPane();
        flowPane3.setPrefSize(604, 364);
        flowPane3.setMaxSize(604, 364);
        flowPane3.setMinSize(604, 364);

        tableView3 = new TableView<>();
        tableView3.setPrefSize(601, 308);
        tableView3.setMaxSize(601, 308);
        tableView3.setMinSize(601, 308);

        customerNameColumn = new TableColumn<>("Name");
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerPhoneNumberColumn = new TableColumn<>("Phone Number");
        customerPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        customerEmailColumn = new TableColumn<>("Email");
        customerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerAddressColumn = new TableColumn<>("Address");
        customerAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableView3.getColumns().setAll(customerNameColumn,customerPhoneNumberColumn,customerEmailColumn,customerAddressColumn);
        tableView3.setItems(listOfCustomers);

        hbox3 = new HBox(20);
        hbox3.setPrefSize(221, 65);
        hbox3.setMaxSize(221, 65);
        hbox3.setMinSize(221, 65);

        addCustomerButton = new Button("Add Customer");
        editCustomerButton = new Button("Edit Customer");
        hbox3.getChildren().addAll(addCustomerButton, editCustomerButton);
        addCustomerButton.setOnAction(event -> openAddCustomerWindow());
        editCustomerButton.setOnAction(event -> openEditCustomerWindow());

        flowPane3.getChildren().addAll(tableView3, hbox3);
        tab3Content.getChildren().add(flowPane3);
        tab3.setContent(tab3Content);

        // Add tabs to TabPane
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        // Set Scene
        scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void openAddCustomerWindow() {
        AddCustomerView addCustomerView = new AddCustomerView();
        addCustomerView.display();// Display the Add Customer View
        addCustomerView.stage.setOnHidden(event -> {refreshCustomerList();});

    }
    private void openEditCustomerWindow() {
        Customer selectedCustomer = tableView3.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            EditCustomerView editCustomerView = new EditCustomerView(selectedCustomer);
            editCustomerView.display();
            editCustomerView.stage.setOnHidden(event -> {refreshCustomerList();});// Обновите список после редактирования
        } else {
            // Показать предупреждение, если животное не выбрано
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Не выбрано");
            alert.setHeaderText("Животное не выбрано");
            alert.setContentText("Пожалуйста, выберите животное для редактирования.");
            alert.showAndWait();
        }
        refreshPetList();
    }
    private void openAddPetView(){
        AddPetView addPetView = new AddPetView();
        addPetView.display();
        addPetView.stage.setOnHidden(event -> {refreshPetList();});
    }

    private void openAddBookView(){
        AddBooking addBooking = new AddBooking();
        addBooking.display();
        addBooking.stage.setOnHidden(event -> {refreshBookingList();});
    }
    private void openEditBooking(){
        EditBooking editBooking = new EditBooking();
        editBooking.display();
    }

    private void refreshBookingList(){

    }

    private void refreshPetList() {
        listOfPets.clear();
        PetList petList = petListModelManager.getAllPets();
        listOfPets.addAll(petList.getAllPetsForSale());
        tableView1.setItems(listOfPets);
        tableView1.refresh();
    }

    private void refreshCustomerList(){
        listOfCustomers.clear();
        CustomerList customerList = customerListModelManager.getAllCustomers();
        listOfCustomers.addAll(customerList.getAllCustomers());
        tableView3.setItems(listOfCustomers);
        tableView3.refresh();
    }

    private void openEditPetView() {
        Pet selectedPet = tableView1.getSelectionModel().getSelectedItem();
        if (selectedPet != null) {
            EditPetView editPetView = new EditPetView(selectedPet);
            editPetView.display();
            editPetView.stage.setOnHidden(event -> {refreshPetList();});// Обновите список после редактирования
        } else {
            // Показать предупреждение, если животное не выбрано
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Не выбрано");
            alert.setHeaderText("Животное не выбрано");
            alert.setContentText("Пожалуйста, выберите животное для редактирования.");
            alert.showAndWait();
        }
        refreshPetList();
    }



    public static void main(String[] args) {
        launch(args);
    }


}