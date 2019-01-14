//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package software1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainDocumentController implements Initializable{
    @FXML
    public TextField partFilterField;
    @FXML
    public TableView<Part> partTable;
    @FXML
    private TableColumn<Part, Number> partIDColumn;
    @FXML
    private TableColumn<Part, String> partNameColumn;
    @FXML
    private TableColumn<Part, Number> partInventoryColumn;
    @FXML
    private TableColumn<Part, Number> partPriceColumn;
    @FXML
    private TextField productFilterField;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Number> productIDColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Number> productInventoryColumn;
    @FXML
    private TableColumn<Product, Number> productPriceColumn;
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

    public MainDocumentController() {

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
    public void goToModPart(ActionEvent event) throws IOException {
        try{
            Part partSelected = partTable.getSelectionModel().getSelectedItem();
            Stage stage = (Stage) mainModPartButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("ModPartIn.fxml"));
            AnchorPane page = loader.load();
            PartController controllerTest = loader.getController();
            controllerTest.modifySelectedPart(partSelected);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            System.out.println("You must select a part before continuing");
        }

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
    private void goToModProd(ActionEvent event){
        try{
            Product productSelected = productTable.getSelectionModel().getSelectedItem();
            Stage stage = (Stage) mainModProductButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("ModProd.fxml"));
            AnchorPane page = loader.load();
            ModifyProductController controller = loader.getController();
            controller.modifySelectedProduct(productSelected);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            System.out.println("You must select a product before continuing");
        }

    }

    @FXML
    private void exitMain(ActionEvent event){
        Stage stage = (Stage) mainExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

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

        partTable.setItems(Inventory.getPartData());
        productTable.setItems(Inventory.getProductData());

        //Start Filtered List - searches for values in the Search box and filters them
        FilteredList<Part> filteredPartData = new FilteredList(software1.Inventory.partData, (p) -> {
            return true;
        });
        this.partFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPartData.setPredicate((part) -> {
                if (newValue != null && !newValue.isEmpty()) {
                    int partInv = part.getPartInventory();
                    double partPrice = part.getPartInventory();
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (String.valueOf(part.getPartID()).toLowerCase().contains(lowerCaseFilter)) {
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
        FilteredList<Product> filteredProductData = new FilteredList(Inventory.productData, (p) -> {
            return true;
        });
        this.productFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredProductData.setPredicate((product) -> {
                if (newValue != null && !newValue.isEmpty()) {
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (product.getProductName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    else {
                        return true;
                    }
                }
                    else{
                        return true;
                    }
            });
        });

        SortedList<Part> sortedData = new SortedList(filteredPartData);
        sortedData.comparatorProperty().bind(this.partTable.comparatorProperty());
        this.partTable.setItems(sortedData);
        SortedList<Product> productData = new SortedList(filteredProductData);
        productData.comparatorProperty().bind(this.productTable.comparatorProperty());
        this.productTable.setItems(productData);
    }

    @FXML
    public void deleteSelected(ActionEvent event){
        try{
            Part partSelected = partTable.getSelectionModel().getSelectedItem();
            Inventory.deletePart(partSelected);
        }catch(Exception e){
            System.out.println("You must select a part to delete");
        }
    }

    @FXML
    public void deleteSelectedProduct(ActionEvent event){
        try{
            Product productSelected = productTable.getSelectionModel().getSelectedItem();
            Inventory.deleteProduct(productSelected);
        }catch(Exception e){
            System.out.println("You must select a product to delete");
        }
    }
}
