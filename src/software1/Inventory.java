package software1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory{

    public static ObservableList<Part> partData = FXCollections.observableArrayList();

    public static void acceptPart(Part part){
        partData.add(part);
    }

    public static ObservableList<Part> getPartData() {
        return partData;
    }

    //call this method, pass it the part you want to remove, and it will remove that part
    public static void deletePart(Part part){
        partData.remove(part);
    }

    public static ObservableList<Product> productData = FXCollections.observableArrayList();

    public static void acceptProduct(Product product){
        productData.add(product);
    }

    public static ObservableList<Product> getProductData(){
        return productData;
    }
    public static void deleteProduct(Product product){
        productData.remove(product);
    }

    public static ObservableList<Part> listOfParts = FXCollections.observableArrayList();

    public static void acceptAssociatedPart(Part part){
        listOfParts.add(part);
    }

    public static ObservableList<Part> getAssociatedPartData() {
        return listOfParts;
    }



}