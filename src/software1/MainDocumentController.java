/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software1;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Chris
 */
public class MainDocumentController{
    
    @FXML
    private TextField partFilterField;
    @FXML
    private TableView<Part> partTable;
    @FXML
    private TableColumn<Part, String> partIDColumn;
     @FXML
    private TableColumn<Part, String> partNameColumn;
     @FXML
    private TableColumn<Part, String> partInventoryColumn;
     @FXML
    private TableColumn<Part, String> partPriceColumn;
      
    private ObservableList<Part> partData = FXCollections.observableArrayList();
     
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
      
    private ObservableList<Product> productData = FXCollections.observableArrayList();
   
    
public MainDocumentController(){
        
partData.add(new Part("1", "Musterd", "test", "also test"));
partData.add(new Part("2", "Musdfsdfster", "test 2", "test 3"));
partData.add(new Part("2", "Musdfsdfster", "test 2", "test 3"));
partData.add(new Part("2", "Musdfsdfster", "test 2", "test 3"));
partData.add(new Part("2", "Musdfsdfster", "test 2", "test 3"));
partData.add(new Part("2", "Musdfsdfster", "test 2", "test 3"));
partData.add(new Part("2", "Musdfsdfster", "test 2", "test 3"));

productData.add(new Product("1", "Musdfsdfster", "test 1", "30"));
productData.add(new Product("2", "joe", "test 2", "20"));
productData.add(new Product("3", "boring", "test 2", "203"));
productData.add(new Product("4", "Mufasa", "test 2", "3"));
productData.add(new Product("5", "Murderster", "test 2", "3"));
productData.add(new Product("6", "ster", "test 2", "39"));
productData.add(new Product("7", "er", "test 2", "301"));
    
}
// the initialize method is called once by the Doc Controller
@FXML
private void initialize() {
//sets individual cell values with the built in get value method in the getter/setter methods in the part/product class
    
partIDColumn.setCellValueFactory(cellData -> cellData.getValue().partIDProperty());
partNameColumn.setCellValueFactory(cellData -> cellData.getValue().partNameProperty());
partInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().partInventoryProperty());
partPriceColumn.setCellValueFactory(cellData -> cellData.getValue().partPriceProperty());

productIDColumn.setCellValueFactory(cellData -> cellData.getValue().productIDProperty());
productNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
productInventoryColumn.setCellValueFactory(cellData -> cellData.getValue().productInventoryProperty());
productPriceColumn.setCellValueFactory(cellData -> cellData.getValue().productPriceProperty());

//this intializes a filtered list for the parts data

FilteredList<Part> filteredPartData= new FilteredList<>(partData, p-> true);

//everything below this is for the search/filter bar

partFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
    filteredPartData.setPredicate(part -> {
        if (newValue==null || newValue.isEmpty()){
        return true;
}
 
    String lowerCaseFilter = newValue.toLowerCase();
        
if (part.getPartID().toLowerCase().contains(lowerCaseFilter)) {
return true;
}

if (part.getPartName().toLowerCase().contains(lowerCaseFilter)){
return true;
}

if (part.getPartInventory().toLowerCase().contains(lowerCaseFilter)) {
return true;
}

else if (part.getPartPrice().toLowerCase().contains(lowerCaseFilter)){
return true;
}

return false;

});
});

FilteredList<Product> filteredProductData= new FilteredList<>(productData, p-> true); 

productFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
    filteredProductData.setPredicate(product -> {
        if (newValue==null || newValue.isEmpty()){
        return true;
}
        String lowerCaseFilter = newValue.toLowerCase();
        
    if (product.getProductID().toLowerCase().contains(lowerCaseFilter)) {
    return true;
    }

    if (product.getProductName().toLowerCase().contains(lowerCaseFilter)){
    return true;
    }

    if (product.getProductInventory().toLowerCase().contains(lowerCaseFilter)) {
    return true;
    }

    else if (product.getProductPrice().toLowerCase().contains(lowerCaseFilter)){
    return true;
    }

    return false;

});
});
//this is a sorted list that's bound with the filtered list

SortedList<Part> sortedData = new SortedList<>(filteredPartData);
sortedData.comparatorProperty().bind(partTable.comparatorProperty());
partTable.setItems(sortedData);

SortedList<Product> productData = new SortedList<>(filteredProductData);
productData.comparatorProperty().bind(productTable.comparatorProperty());
productTable.setItems(productData);

}
}
