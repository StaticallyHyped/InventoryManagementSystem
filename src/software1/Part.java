package software1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author Chris Shisler
 */
public class Part {
// This section declares variables that I will use in my constructor. Each variable
    //is a column in my Parts tables
	private final StringProperty partID;
	private final StringProperty partName;
        private final StringProperty partInventory;
        private final StringProperty partPrice;
        //private final StringProperty partMachID;

	public Part(String partID, String partName, String partInventory, String partPrice) {
		this.partID = new SimpleStringProperty(partID);
		this.partName = new SimpleStringProperty(partName);
                this.partInventory = new SimpleStringProperty(partInventory);
                this.partPrice = new SimpleStringProperty(partPrice);
                //this.partMachID = new SimpleStringProperty(partMachID);
	}
	
	public String getPartID() {
		return partID.get();
	}

	public void setPartID(String partID) {
		this.partID.set(partID);
	}
	
	public StringProperty partIDProperty() {
		return partID;
	}

	public String getPartName() {
		return partName.get();
	}

	public void setPartName(String partName) {
		this.partName.set(partName);
	}
	
	public StringProperty partNameProperty() {
		return partName;
	}
        public String getPartInventory() {
		return partInventory.get();
	}

	public void setPartInventory(String partInventory) {
		this.partInventory.set(partInventory);
	}
	
	public StringProperty partInventoryProperty() {
		return partInventory;
	}

	public String getPartPrice() {
		return partPrice.get();
	}

	public void setPartPrice(String partPrice) {
		this.partPrice.set(partPrice);
	}
	
	public StringProperty partPriceProperty() {
		return partPrice;
	}
        
//        public String getPartMachID(){
//            return partMachID.get();
//        }
//        
//        public void setPartMachID(String partMachID){
//            this.partMachID.set(partMachID);
//        }
//        
//        public StringProperty partMachIDProperty(){
//            return partMachID;
//        }
        
}