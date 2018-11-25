package software1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
    private final StringProperty productID;
    private final StringProperty productName;
    private final StringProperty productInventory;
    private final StringProperty productPrice;

    public Product(String productID, String productName, String productInventory, String productPrice) {
        this.productID = new SimpleStringProperty(productID);
        this.productName = new SimpleStringProperty(productName);
        this.productInventory = new SimpleStringProperty(productInventory);
        this.productPrice = new SimpleStringProperty(productPrice);
    }

    public String getProductID() {
        return (String)this.productID.get();
    }

    public void setProductID(String productID) {
        this.productID.set(productID);
    }

    public StringProperty productIDProperty() {
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

    public String getProductInventory() {
        return (String)this.productInventory.get();
    }

    public void setProductInventory(String productInventory) {
        this.productInventory.set(productInventory);
    }

    public StringProperty productInventoryProperty() {
        return this.productInventory;
    }

    public String getProductPrice() {
        return (String)this.productPrice.get();
    }

    public void setProductPrice(String productPrice) {
        this.productPrice.set(productPrice);
    }

    public StringProperty productPriceProperty() {
        return this.productPrice;
    }
}
