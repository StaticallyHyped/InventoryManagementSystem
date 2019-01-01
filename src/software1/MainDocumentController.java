//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package software1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.fxml.Initializable;
import software1.Inventory;
import software1.PartInhouse;
import software1.PartController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainDocumentController {
    @FXML
    public TextField partFilterField;
    @FXML
    public TableView<PartInhouse> partTable;
    @FXML
    private TableColumn<PartInhouse, String> partIDColumn;
    @FXML
    private TableColumn<PartInhouse, String> partNameColumn;
    @FXML
    private TableColumn<PartInhouse, Number> partInventoryColumn; //quantity in stock - need to update to an int
    @FXML
    private TableColumn<PartInhouse, Number> partPriceColumn;
    @FXML
    private TextField productFilterField;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productIDColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, String> productInventoryColumn;
    @FXML
    private TableColumn<Product, String> productPriceColumn;
    @FXML
    private Button mainModPartButton;
    @FXML
    private Button mainExitButton;
    @FXML
    private Button mainAddPartButton;
    @FXML
    private Button mainAddProductButton;
    @FXML
    private Button mainModProductButton;
    @FXML
    private Button addPartIn;


    public Inventory testTwo = new Inventory();
    public PartController testThree = new PartController();
    ObservableList<PartInhouse> partInventory = FXCollections.observableArrayList();


    public MainDocumentController() {
        //partInventory = testTwo.partData;
//        addToPartInventory(partInventory);
//        System.out.println("this is from inside the main doc controller");
    }

    @FXML
    private void goToAddPart(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainAddPartButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("addPartIn.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToModPart(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainModPartButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ModPartIn.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToAddProd(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainAddProductButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AddProd.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToModProd(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainModProductButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ModProd.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void exitMain(ActionEvent event){
        Stage stage = (Stage) mainExitButton.getScene().getWindow();
        stage.close();
    }
    public ObservableList<Product> productData = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

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
        this.productIDColumn.setCellValueFactory((cellData) -> {
            return ((Product)cellData.getValue()).productIDProperty();
        });
        this.productNameColumn.setCellValueFactory((cellData) -> {
            return ((Product)cellData.getValue()).productNameProperty();
        });
        this.productInventoryColumn.setCellValueFactory((cellData) -> {
            return ((Product)cellData.getValue()).productInventoryProperty();
        });
        this.productPriceColumn.setCellValueFactory((cellData) -> {
            return ((Product)cellData.getValue()).productPriceProperty();
        });
        FilteredList<Part> filteredPartData = new FilteredList(partInventory, (p) -> {
            return true;
        });
        this.partFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPartData.setPredicate((part) -> {
                if (newValue != null && !newValue.isEmpty()) {
                    int partInv = part.getPartInventory();
                    double partPrice = part.getPartInventory();
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (part.getPartID().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (part.getPartName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (String.valueOf(partInv).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else {
                        return (String.valueOf(partPrice).toLowerCase().contains(lowerCaseFilter));
                    }
                } else {
                    return true;
                }
            });
        });
        FilteredList<Product> filteredProductData = new FilteredList(this.productData, (p) -> {
            return true;
        });
        this.productFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredProductData.setPredicate((product) -> {
                if (newValue != null && !newValue.isEmpty()) {
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (product.getProductID().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (product.getProductName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (product.getProductInventory().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else {
                        return product.getProductPrice().toLowerCase().contains(lowerCaseFilter);
                    }
                } else {
                    return true;
                }
            });
        });
        SortedList<PartInhouse> sortedData = new SortedList(filteredPartData);
        sortedData.comparatorProperty().bind(this.partTable.comparatorProperty());
        this.partTable.setItems(sortedData);
        SortedList<Product> productData = new SortedList(filteredProductData);
        productData.comparatorProperty().bind(this.productTable.comparatorProperty());
        this.productTable.setItems(productData);

    /*    partTable.setItems(updatePartInfo());*/
        //partTable.setItems(testThree.addPartSubmit());
    }


    /*public ObservableList<PartInhouse> updatePartInfo(){

        partInventory.add(new PartInhouse("25", "bolt", 23, 67,
                123, 23, "ID Number"));
       // partInventory.add(testTwo.acceptPart());
        return partInventory;
    }
*/
    @FXML
    public void deleteSelected(ActionEvent event){
        partInventory.removeAll(partTable.getSelectionModel().getSelectedItems());
        System.out.println("Test 123");
    }

    @FXML
    public void deleteSelectedProduct(ActionEvent event){
        productData.removeAll(productTable.getSelectionModel().getSelectedItems());
        System.out.println("Test 123");
    }


}
