package software1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public abstract class Part {
    private final StringProperty partID;
    private final StringProperty partName;
    private final StringProperty partInventory;
    private final StringProperty partPrice;
    private final int minValue;
    private final int maxValue;

    public Part(String partID, String partName, String partInventory, String partPrice, int minValue, int maxValue) {
        this.partID = new SimpleStringProperty(partID);
        this.partName = new SimpleStringProperty(partName);
        this.partInventory = new SimpleStringProperty(partInventory);
        this.partPrice = new SimpleStringProperty(partPrice);
        this.minValue = minValue;
        this.maxValue = maxValue;

    }

    public String getPartID() {
        return (String)this.partID.get();
    }

    public void setPartID(String partID) {
        this.partID.set(partID);
    }

    public StringProperty partIDProperty() {
        return this.partID;
    }

    public String getPartName() {
        return (String)this.partName.get();
    }

    public void setPartName(String partName) {
        this.partName.set(partName);
    }

    public StringProperty partNameProperty() {
        return this.partName;
    }

    public String getPartInventory() {
        return (String)this.partInventory.get();
    }

    public void setPartInventory(String partInventory) {
        this.partInventory.set(partInventory);
    }

    public StringProperty partInventoryProperty() {
        return this.partInventory;
    }

    public String getPartPrice() {
        return (String)this.partPrice.get();
    }

    public void setPartPrice(String partPrice) {
        this.partPrice.set(partPrice);
    }

    public StringProperty partPriceProperty() {
        return this.partPrice;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
