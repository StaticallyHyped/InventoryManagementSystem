package software1;

import javafx.collections.ObservableList;
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

public class ModifyProductController implements Initializable {

    //Start textField objects
    @FXML
    private TextField modProductID;
    @FXML
    private TextField modProductName;
    @FXML
    private TextField modProductQuantity;
    @FXML
    private TextField modProductPrice;
    @FXML
    private TextField modProductMin;
    @FXML
    private TextField modProductMax;

    //Start modPartTable objects

    @FXML
    public TableView<Part> modPartTable;
    @FXML
    private TableColumn<Part, Number> modPartIDColumn;
    @FXML
    private TableColumn<Part, String> modPartNameColumn;
    @FXML
    private TableColumn<Part, Number> modPartInventoryColumn; //quantity in stock - need to update to an int
    @FXML
    private TableColumn<Part, Number> modPartPriceColumn;


    //Start associatedPartTable objects
    @FXML
    public TableView<Part> associatedModPartTable;
    @FXML
    public TableColumn<Part, Number> associatedModPartIDColumn;
    @FXML
    public TableColumn<Part, String> associatedModPartNameColumn;
    @FXML
    public TableColumn<Part, Number> associatedModPartInventoryColumn;
    @FXML
    public TableColumn<Part, Number> associatedModPartPriceColumn;
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
    public Button modProductCancel;
    @FXML
    public Button modProdSaveButton;
    @FXML
    public Button addToAssociatedModPartsButton;

    public ObservableList parts;
    Product addProduct;
    Inventory test = new Inventory();

    @FXML
    private void modProductBackToMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) modProductCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.modPartIDColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partIDProperty();
        });
        this.modPartNameColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partNameProperty();
        });
        this.modPartInventoryColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partInventoryProperty();
        });
        this.modPartPriceColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partPriceProperty();
        });

        //Start associatedPartTable setCellValueFactory
        this.associatedModPartIDColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partIDProperty();
        });
        this.associatedModPartNameColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partNameProperty();
        });
        this.associatedModPartInventoryColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partInventoryProperty();
        });
        this.associatedModPartPriceColumn.setCellValueFactory((cellData) -> {
            return (cellData.getValue()).partPriceProperty();
        });

        modPartTable.setItems(Inventory.getPartData());
        associatedModPartTable.setItems(Inventory.getAssociatedPartData());
    }

    public void modPartSubmit(ActionEvent event){
        productID = modProductID.getText();
        productName = modProductName.getText();
        productQuantity = modProductQuantity.getText();
        productPrice = modProductPrice.getText();
        productMin = modProductMin.getText();
        productMax = modProductMax.getText();
        //parts = modPartInH_max.getText();
        Product modProd = new Product(Integer.parseInt(productID), productName, Integer.parseInt(productQuantity), Double.parseDouble(productPrice), Integer.parseInt(productMin),
                Integer.parseInt(productMax), parts);
        test.productData.set(test.productData.indexOf(addProduct), modProd);
    }


    public void modifySelectedProduct(Product product){
        addProduct = product;
        productID = Integer.toString(product.getProductID());
        productName = product.getProductName();
        productQuantity = Integer.toString(product.getProductInventory());
        productPrice = Double.toString(product.getProductPrice());
        productMax = Integer.toString(product.getProductMax());
        productMin = Integer.toString(product.getProductMin());
        parts = product.getAssociatedParts();

        modProductName.setText(productName);
        modProductID.setText(productID);
        modProductQuantity.setText(productQuantity);
        modProductPrice.setText(productPrice);
        modProductMin.setText(productMin);
        modProductMax.setText(productMax);
    }
    @FXML
    public void deleteSelectedPart(ActionEvent event){
        try{
            Part partSelected = associatedModPartTable.getSelectionModel().getSelectedItem();
            associatedModPartTable.getItems().remove(partSelected);;
        }catch(Exception e){
            System.out.println("You must select a part to delete");
        }
    }

    public void addToAssociatedModParts(ActionEvent event){
        try{
            Part partSelected = modPartTable.getSelectionModel().getSelectedItem();
            //addTest.listOfParts.add(partSelected);
            Inventory.acceptAssociatedPart(partSelected);
        }catch(Exception e){
            System.out.println("You must select a part to be added");
        }
    }

}
