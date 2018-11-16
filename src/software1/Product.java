package software1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Simple model class for the person table.
 * 
 * @author Marco Jakob
 */
public class Product {
// This section declares variables that I will use in my constructor. Each variable
    //is a column in my Product tables
	private final StringProperty productID;
	private final StringProperty productName;
        private final StringProperty productInventory;
        private final StringProperty productPrice;
        
        
        // Here's my constructor, same name as my class
        //I'll need to add 
	public Product(String productID, String productName, String productInventory, String productPrice) {
		this.productID = new SimpleStringProperty(productID);
		this.productName = new SimpleStringProperty(productName);
                this.productInventory = new SimpleStringProperty(productInventory);
                this.productPrice = new SimpleStringProperty(productPrice);
	}
	
	public String getProductID() {
		return productID.get();
	}

	public void setProductID(String productID) {
		this.productID.set(productID);
	}
	
	public StringProperty productIDProperty() {
		return productID;
	}

	public String getProductName() {
		return productName.get();
	}

	public void setProductName(String productName) {
		this.productName.set(productName);
	}
	
	public StringProperty productNameProperty() {
		return productName;
	}
        
        public String getProductInventory() {
		return productInventory.get();
	}

	public void setProductInventory(String productInventory) {
		this.productInventory.set(productInventory);
	}
	
	public StringProperty productInventoryProperty() {
		return productInventory;
	}

	public String getProductPrice() {
		return productPrice.get();
	}

	public void setProductPrice(String productPrice) {
		this.productPrice.set(productPrice);
	}
	
	public StringProperty productPriceProperty() {
		return productPrice;
	}
}