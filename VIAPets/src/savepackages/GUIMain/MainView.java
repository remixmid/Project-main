package savepackages.GUIMain;

import Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import savepackages.BookingListModelManager;
import savepackages.CustomerListModelManager;
import savepackages.KennelModelManager;
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
import java.util.Arrays;

public class MainView extends Application {

    private PetListModelManager petListModelManager;
    private ObservableList<Pet> listOfPets;
    private ObservableList<Customer> listOfCustomers;
    private ObservableList<KennelPlace> listOfKennelPlaces;
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
    private KennelModelManager kennelModelManager;
    private VBox vBox3;
    private Kennel kennel;
    private TableColumn<Customer, String> customerNameBooking;

    @Override
    public void start(Stage primaryStage) {
        //Declaration of models Managers
        petListModelManager = new PetListModelManager();
        customerListModelManager = new CustomerListModelManager();
        bookingListModelManager = new BookingListModelManager();
        kennelModelManager = new KennelModelManager();
        //Declaration list for Tables
        listOfPets = FXCollections.observableArrayList();
        listOfCustomers = FXCollections.observableArrayList();
        listOfBookings = FXCollections.observableArrayList();
        listOfKennelPlaces = FXCollections.observableArrayList();

        //Creating Main Pane
        tabPane = new TabPane();
        tabPane.setPrefSize(1000, 400);
        tabPane.setMaxSize(1000, 400);
        tabPane.setMinSize(1000, 400);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        //Reading files and importing them to tables
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

        kennel = kennelModelManager.getKennel();
        for (KennelPlace kennelPlace: kennel.getAllKennelPlaces()) {
            listOfKennelPlaces.add(kennelPlace);
        }

        // Creating Shop Tab
        tab1 = new Tab("Shop");
        tab1Content = new VBox();
        tab1Content.setPrefSize(990, 390);
        tab1Content.setMaxSize(990, 390);
        tab1Content.setMinSize(990, 390);

        flowPane1 = new FlowPane();
        flowPane1.setPrefSize(990, 371);
        flowPane1.setMaxSize(990, 371);
        flowPane1.setMinSize(990, 371);
        //Declaration of Pets Table
        tableView1 = new TableView<>();
        tableView1.setItems(listOfPets);
        tableView1.setPrefSize(990, 338);
        tableView1.setMaxSize(990, 338);
        tableView1.setMinSize(990, 338);
        //Adding all Columns and importing all the necessary info to Columns
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
        //Set an action for Delete pet button
        deletePetButton.setOnAction(event -> openDeletePetView());
        //Set an action for Edit pet button
        editPetButton.setOnAction(e -> openEditPetView());
        //Set an action for Add pet button
        addPetButton.setOnAction(e -> openAddPetView());


        hbox1.getChildren().addAll(addPetButton, editPetButton, deletePetButton);

        flowPane1.getChildren().addAll(tableView1, hbox1, new StackPane());
        tab1Content.getChildren().add(flowPane1);
        tab1.setContent(tab1Content);


        //Creating Kennel Tab
        tab2 = new Tab("Kennel");
        anchorPane2 = new AnchorPane();
        hBox2 = new HBox(20);
        hBox2.setPrefSize(900, 374);






        vBox2 = new VBox();
        vBox2.setPrefSize(391, 374);
        vBox3 = new VBox();
        vBox3.setPrefSize(391, 374);
        tableView2 = new TableView();
        tableView4 = new TableView();
        tableView2.setPrefSize(391, 327);
        tableView2.setItems(listOfBookings);
        tableView4.setItems(listOfKennelPlaces);
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
        addKenelPlaceButton.setOnAction(event -> addKennelButton());
        kennelPlaceIdColumn2 = new TableColumn<>("Id");
        kennelPlaceIdColumn2.setCellValueFactory(new PropertyValueFactory<>("kennelPlaceId"));
        kennelIsOccupied = new TableColumn<>("Is occupied");
        kennelIsOccupied.setCellValueFactory(new PropertyValueFactory<>("isOccupied"));
        kennelPlaceIdColumn = new TableColumn<>("Id");
        kennelPlaceIdColumn.setCellValueFactory(new PropertyValueFactory<>("kennelPlaceId"));
        tableView4.getColumns().addAll(kennelPlaceIdColumn2, kennelIsOccupied);

        kennelPlaceIdColumn = new TableColumn<>("Kennel ID");
        kennelPlaceIdColumn.setCellValueFactory(new PropertyValueFactory<>("kennelPlaceId"));

        dateInColumn = new TableColumn<>("Check In");
        dateInColumn.setCellValueFactory(new PropertyValueFactory<>("dateIn"));

        dateOutColumn = new TableColumn<>("Check Out");
        dateOutColumn.setCellValueFactory(new PropertyValueFactory<>("dateOut"));

        kennelPriceColumn = new TableColumn<>("Price");
        kennelPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        kennelHasThisPetColumn = new TableColumn<>("Pet");
        kennelHasThisPetColumn.setCellValueFactory(new PropertyValueFactory<>("pet"));
        kennelHasThisPetColumn.setPrefWidth(94);
        customerNameBooking = new TableColumn<>("Customer Name");
        customerNameBooking.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView2.getColumns().addAll(kennelPlaceIdColumn,dateInColumn,dateOutColumn,kennelPriceColumn,kennelHasThisPetColumn,customerNameBooking);
        refreshBookingList();

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
        editCustomerButton.setOnAction(event -> openEditCustomerView());

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

    private void openDeletePetView() {
        //Get the currently selected pet from the table view
        Pet selectedPet = tableView1.getSelectionModel().getSelectedItem();
        if (selectedPet != null) {
            //If pet selected delete it
            petListModelManager.deletePet(selectedPet);
            //Refresh the pet list to reflect the changes
            refreshPetList();
        } else {
            //Showing an alert if no pet is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Pet Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a pet to delete.");
            alert.showAndWait();
        }
    }

    private void addKennelButton() {
        try {
            Price price = new Price(0);  // Default price
            kennelModelManager.addKennelPlace(price);
            System.out.println("Refreshing kennel view...");
            refreshKennel();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to Add Kennel Place");
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    private void openAddCustomerWindow() {
        AddCustomerView addCustomerView = new AddCustomerView();
        addCustomerView.display();// Display the Add Customer View
        addCustomerView.stage.setOnHidden(event -> {refreshCustomerList();});

    }

    private void openEditCustomerView(){
        Customer selectedCustomer = tableView3.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            EditCustomerView editCustomerView = new EditCustomerView(selectedCustomer);
            editCustomerView.display();
            editCustomerView.stage.setOnHidden(event -> {refreshCustomerList();});
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Customer Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a customer to edit.");
            alert.showAndWait();
        }
        refreshCustomerList();
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
    private void openEditBooking() {
        KennelPlace selectedBooking = (KennelPlace) tableView2.getSelectionModel().getSelectedItem();
        if (selectedBooking != null) {
            EditBooking editBooking = new EditBooking(selectedBooking);
            editBooking.display();
            editBooking.stage.setOnHidden(event -> {
                refreshBookingList();
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Booking Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a booking to edit.");
            alert.showAndWait();
        }
    }

    private void refreshBookingList() {
        try {
            listOfBookings.clear();
            BookingList bookingList = bookingListModelManager.getAllBookings();
            if (bookingList != null && bookingList.getBookingList() != null) {
                for (KennelPlace booking : bookingList.getBookingList()) {
                    System.out.println("Adding to table: ID=" + booking.getKennelPlaceId() +
                            ", Pet=" + booking.getPet() +
                            ", DateIn=" + booking.getDateIn());
                    listOfBookings.add(booking);
                }
            }

            tableView2.setItems(listOfBookings);
            tableView2.refresh();

            // Verify the IDs in the table
            for (KennelPlace booking : listOfBookings) {
                System.out.println("Booking in table: ID=" + booking.getKennelPlaceId() +
                        ", Pet=" + booking.getPet() +
                        ", DateIn=" + booking.getDateIn());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error refreshing booking list: " + e.getMessage());
        }
    }

    private void refreshKennel(){
        listOfKennelPlaces.clear();
        Kennel kennel = kennelModelManager.getKennel();
        listOfKennelPlaces.addAll(kennel.getAllKennelPlaces());
        tableView4.setItems(listOfKennelPlaces);
        tableView4.refresh();
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
            editPetView.stage.setOnHidden(event -> {refreshPetList();});
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Pet Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a pet to edit.");
            alert.showAndWait();
        }
        refreshPetList();
    }



    public static void main(String[] args) {
        launch(args);
    }
}