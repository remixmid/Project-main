package savepackages.GUIMain;

import Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import savepackages.PetListModelManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainView extends Application {

    private PetListModelManager petListModelManager;
    private ObservableList<Pet> listOfPets;
    private TabPane tabPane;
    private Tab tab1;
    private VBox tab1Content;
    private FlowPane flowPane1;
    private TableView<Pet> tableView1;
    private TableColumn<Pet, String> nameColumn;
    private TableColumn<Pet, Integer> ageColumn;
    private HBox hbox1;
    private Button addPetButton;
    private Button editPetButton;
    private Button deletePetButton;
    private Tab tab2;
    private AnchorPane anchorPane2;
    private HBox hBox2;
    private GridPane gridPane;
    private Label label1 = new Label("Room 1");
    private Label label2 = new Label("Room 2");
    private Label label3 = new Label("Room 3");
    private Label label4 = new Label("Room 4");
    private Label label5 = new Label("Room 5");
    private Label label6 = new Label("Room 6");
    private Label label7 = new Label("Room 7");
    private Label label8 = new Label("Room 8");
    private Label label9 = new Label("Room 9");
    private Label label10 = new Label("Room 10");
    private TextField roomfield1 = new TextField();
    private TextField roomfield2 = new TextField();
    private TextField roomfield3 = new TextField();
    private TextField roomfield4 = new TextField();
    private TextField roomfield5 = new TextField();
    private TextField roomfield6 = new TextField();
    private TextField roomfield7 = new TextField();
    private TextField roomfield8 = new TextField();
    private TextField roomfield9 = new TextField();
    private TextField roomfield10 = new TextField();
    private VBox vBox2;
    private TableView tableView2;
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

    @Override
    public void start(Stage primaryStage) {
        petListModelManager = new PetListModelManager();
        listOfPets = FXCollections.observableArrayList(
                new Dog("1",1,"1","1","1",true,new Price(1),"12","12")
        );
        PetList petList = petListModelManager.getAllPets();
        for (Pet pet: petList.getAllPetsForSale()) {
            listOfPets.add(pet);
        }
        // Create TabPane
        tabPane = new TabPane();
        tabPane.setPrefSize(600, 400);
        tabPane.setMaxSize(600, 400);
        tabPane.setMinSize(600, 400);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Tab 1
        tab1 = new Tab("Shop");
        tab1Content = new VBox();
        tab1Content.setPrefSize(590, 390);
        tab1Content.setMaxSize(590, 390);
        tab1Content.setMinSize(590, 390);

        flowPane1 = new FlowPane();
        flowPane1.setPrefSize(590, 371);
        flowPane1.setMaxSize(590, 371);
        flowPane1.setMinSize(590, 371);

        tableView1 = new TableView<>();
        tableView1.setItems(listOfPets);
        tableView1.setPrefSize(590, 338);
        tableView1.setMaxSize(590, 338);
        tableView1.setMinSize(590, 338);
        nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableView1.getColumns().setAll(nameColumn,ageColumn);



        hbox1 = new HBox(20);
        hbox1.setPrefSize(290, 32);
        hbox1.setMaxSize(290, 32);
        hbox1.setMinSize(290, 32);

        addPetButton = new Button("Add Pet");
        editPetButton = new Button("Edit Pet");
        deletePetButton = new Button("Delete Pet");
        hbox1.getChildren().addAll(addPetButton, editPetButton, deletePetButton);

        flowPane1.getChildren().addAll(tableView1, hbox1, new StackPane());
        tab1Content.getChildren().add(flowPane1);
        tab1.setContent(tab1Content);
        addPetButton.setOnAction(e -> openAddPetView());
        editPetButton.setOnAction(e -> openEditPetView());

        // Tab 2
        tab2 = new Tab("Kennel");
        anchorPane2 = new AnchorPane();
        hBox2 = new HBox(20);
        hBox2.setPrefSize(600, 374);
        gridPane = new GridPane();
        gridPane.setPrefSize(855, 271);
        for (int i = 0; i < 2; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(48));
        }
        for (int i = 0; i < 10; i++) {
            gridPane.getRowConstraints().add(new RowConstraints(30));
        }
        gridPane.add(label1,0,0);
        gridPane.add(roomfield1,1,0);
        gridPane.add(label2,0,1);
        gridPane.add(roomfield2,1,1);
        gridPane.add(label3,0,2);
        gridPane.add(roomfield3,1,2);
        gridPane.add(label4,0,3);
        gridPane.add(roomfield4,1,3);
        gridPane.add(label5,0,4);
        gridPane.add(roomfield5,1,4);
        gridPane.add(label6,0,5);
        gridPane.add(roomfield6,1,5);
        gridPane.add(label7,0,6);
        gridPane.add(roomfield7,1,6);
        gridPane.add(label8,0,7);
        gridPane.add(roomfield8,1,7);
        gridPane.add(label9,0,8);
        gridPane.add(roomfield9,1,8);
        gridPane.add(label10,0,9);
        gridPane.add(roomfield10,1,9);
        

        vBox2 = new VBox();
        vBox2.setPrefSize(391, 374);
        tableView2 = new TableView();
        tableView2.setPrefSize(391, 327);
        tableView2.getColumns().add(new TableColumn<>("Customer"));
        tableView2.getColumns().add(new TableColumn<>("Pet"));
        tableView2.getColumns().add(new TableColumn<>("Date In"));
        tableView2.getColumns().add(new TableColumn<>("Date Out"));
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
        hBox2.getChildren().addAll(gridPane, vBox2);
        anchorPane2.getChildren().add(hBox2);
        tab2.setContent(anchorPane2);
        addBookingButton.setOnAction(e -> openAddBookView());
        editBookingButton.setOnAction(e -> openEditBooking());

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
        tableView3.getColumns().add(new TableColumn<>("Name"));
        tableView3.getColumns().add(new TableColumn<>("Phone Number"));
        tableView3.getColumns().add(new TableColumn<>("Email"));
        tableView3.getColumns().add(new TableColumn<>("Address"));

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


 //   private class MyTabListener implements ChangeListener<Tab>
  //  {
   //     public void changed(ObservableValue<? extends Tab> tab, Tab oldTab, Tab newTab)
   //     {
   //         if (newTab == tab1)
    //        {
    //            updateStudentArea();
    //        }
    //        else if (newTab == changeCountryTab)
    //        {
   //             updateStudentBox();
   //         }
  //      }
  //  }


    public static void main(String[] args) {
        launch(args);
    }


}