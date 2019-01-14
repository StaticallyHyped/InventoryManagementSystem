package software1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ProductDocumentController implements Initializable {

    @FXML
    public TableView<Part> partTable;
    @FXML
    private TableColumn<Part, Number> partIDColumn;
    @FXML
    private TableColumn<Part, String> partNameColumn;
    @FXML
    private TableColumn<Part, Number> partInventoryColumn; //quantity in stock - need to update to an int
    @FXML
    private TableColumn<Part, Number> partPriceColumn;

    //Start associatedPartTable in add product

    @FXML
    public TableView<Part> associatedPartTable;
    @FXML
    public TableColumn<Part, Number> associatedPartIDColumn;
    @FXML
    public TableColumn<Part, String> associatedPartNameColumn;
    @FXML
    public TableColumn<Part, Number> associatedPartInventoryColumn;
    @FXML
    public TableColumn<Part, Number> associatedPartPriceColumn;


    //Start Add Product Objects
    @FXML
    public Button addProductCancel;
    @FXML
    private TextField addProductID;
    @FXML
    private TextField addProductName;
    @FXML
    private TextField addProductQuantity;
    @FXML
    private TextField addProductPrice;
    @FXML
    private TextField addProductMin;
    @FXML
    private TextField addProductMax;
    /*@FXML
    private Button saveButton;*/
    @FXML
    public String productID;
    @FXML
    public String productName;
    @FXML
    public String productQuantity;
    @FXML
    public String productPrice;
    @FXML
    public String productMin;
    @FXML
    public String productMax;



    @FXML
    private void addProductBackToMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) addProductCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    Inventory test = new Inventory();

    public void addProductSubmit(ActionEvent event){
        try {
            productID = addProductID.getText();
            productName = addProductName.getText();
            productQuantity = addProductQuantity.getText();
            productPrice = addProductPrice.getText();
            productMin = addProductMin.getText();
            productMax = addProductMax.getText();
            Product addProduct = new Product(Integer.parseInt(productID), productName, Integer.parseInt(productQuantity), Double.parseDouble(productPrice), Integer.parseInt(productMin),
                    Integer.parseInt(productMax), Inventory.listOfParts);
            test.productData.add(addProduct);
        }catch (Exception e){
            System.out.println("You have entered an invalid value. Please enter a valid value.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.partIDColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partIDProperty();
        });
        this.partNameColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partNameProperty();
        });
        this.partInventoryColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partInventoryProperty();
        });
        this.partPriceColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partPriceProperty();
        });

        //Start associatedPartTable setCellValueFactory
        this.associatedPartIDColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partIDProperty();
        });
        this.associatedPartNameColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partNameProperty();
        });
        this.associatedPartInventoryColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partInventoryProperty();
        });
        this.associatedPartPriceColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partPriceProperty();
        });

        partTable.setItems(Inventory.getPartData());
        associatedPartTable.setItems(Inventory.getAssociatedPartData());

    }
    public void addToAssociatedPartsButton(ActionEvent event){
        try{
            Part partSelected = partTable.getSelectionModel().getSelectedItem();
            Inventory.acceptAssociatedPart(partSelected);

        }catch(Exception e){
            System.out.println("You must select a part to be added");
        }
    }
    @FXML
    public void deleteSelectedPart(ActionEvent event){
        try{
            Part partSelected = associatedPartTable.getSelectionModel().getSelectedItem();
            associatedPartTable.getItems().remove(partSelected);;
        }catch(Exception e){
            System.out.println("You must select a part to delete");
        }
    }

}
