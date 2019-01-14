package software1;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
    private final IntegerProperty productID;
    private final StringProperty productName;
    private final IntegerProperty productInventory;
    private final DoubleProperty productPrice;
    private final IntegerProperty productMin;
    private final IntegerProperty productMax;
    private ObservableList associatedParts = FXCollections.observableArrayList();

    //A Product object will take strings, ints, and an array of Part objects

    public Product(int productID, String productName, int productInventory, double productPrice, int productMin, int productMax, ObservableList associatedParts) {
        this.productID = new SimpleIntegerProperty(productID);
        this.productName = new SimpleStringProperty(productName);
        this.productInventory = new SimpleIntegerProperty(productInventory);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.productMin = new SimpleIntegerProperty(productMin);
        this.productMax = new SimpleIntegerProperty(productMax);
        this.associatedParts = associatedParts;
    }

    public int getProductID() {
        return this.productID.get();
    }

    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public IntegerProperty productIDProperty() {
        return this.productID;
    }

    public String getProductName() {
        return (String)this.productName.get();
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public StringProperty productNameProperty() {
        return this.productName;
    }

    public int getProductInventory() {
        return this.productInventory.get();
    }

    public void setProductInventory(int productInventory) {
        this.productInventory.set(productInventory);
    }

    public IntegerProperty productInventoryProperty() {
        return this.productInventory;
    }

    public double getProductPrice() {
        return this.productPrice.get();
}

    public void setProductPrice(double productPrice) {
        this.productPrice.set(productPrice);
    }

    public DoubleProperty productPriceProperty() {
        return this.productPrice;
    }

    public int getProductMin() {
        return productMin.get();
    }

    public IntegerProperty productMinProperty() {
        return productMin;
    }

    public int getProductMax() {
        return productMax.get();
    }

    public IntegerProperty productMaxProperty() {
        return productMax;
    }

    public ObservableList getAssociatedParts() {
        return associatedParts;
    }
}
