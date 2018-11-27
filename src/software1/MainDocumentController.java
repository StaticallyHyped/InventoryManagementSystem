//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package software1;

import java.util.function.Predicate;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
    private TextField partFilterField;
    @FXML
    private TableView<PartInhouse> partTable;
    @FXML
    private TableColumn<PartInhouse, String> partIDColumn;
    @FXML
    private TableColumn<PartInhouse, String> partNameColumn;
    @FXML
    private TableColumn<PartInhouse, String> partInventoryColumn; //quantity in stock - need to update to an int
    @FXML
    private TableColumn<PartInhouse, String> partPriceColumn;

    private ObservableList<PartInhouse> partData = FXCollections.observableArrayList();
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
    private Button mainExitButton;


    @FXML
    private void exitMain(ActionEvent event){
        Stage stage = (Stage) mainExitButton.getScene().getWindow();
        stage.close();
    }
    private ObservableList<Product> productData = FXCollections.observableArrayList();

    PartInhouse lineOne = new PartInhouse("partid","partname", "partinventory", "partprice", 20,400,12);


    public MainDocumentController() {


        this.partData.add(new PartInhouse("test", "Musterd", "test", "also test", 1, 2,26));
        this.partData.add(lineOne);
        this.productData.add(new Product("1", "Musterd", "test", "also test"));

    }

    @FXML
    private void initialize() {
        this.partIDColumn.setCellValueFactory((cellData) -> {
            return ((Part)cellData.getValue()).partIDProperty();
        });
        this.partNameColumn.setCellValueFactory((cellData) -> {
            return ((Part)cellData.getValue()).partNameProperty();
        });
        this.partInventoryColumn.setCellValueFactory((cellData) -> {
            return ((Part)cellData.getValue()).partInventoryProperty();
        });
        this.partPriceColumn.setCellValueFactory((cellData) -> {
            return ((Part)cellData.getValue()).partPriceProperty();
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
        FilteredList<Part> filteredPartData = new FilteredList(this.partData, (p) -> {
            return true;
        });
        this.partFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPartData.setPredicate((part) -> {
                if (newValue != null && !newValue.isEmpty()) {
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (part.getPartID().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (part.getPartName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (part.getPartInventory().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else {
                        return part.getPartPrice().toLowerCase().contains(lowerCaseFilter);
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
    }
}
