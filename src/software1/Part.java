package software1;

import javafx.beans.property.*;


public abstract class Part {
    private StringProperty partID;
    private StringProperty partName;
    private IntegerProperty partInventory;
    private DoubleProperty partPrice;
    private int minValue;
    private int maxValue;

    public Part(String partID, String partName, int partInventory, double partPrice, int minValue, int maxValue) {
        this.partID = new SimpleStringProperty(partID);
        this.partName = new SimpleStringProperty(partName);
        this.partInventory = new SimpleIntegerProperty(partInventory);
        this.partPrice = new SimpleDoubleProperty(partPrice);
        this.minValue = minValue;
        this.maxValue = maxValue;

    }

    public String getPartID() {
        return this.partID.get();
    }

    public void setPartID(String partID) {
        this.partID.set(partID);
    }

    public StringProperty partIDProperty() {
        return this.partID;
    }

    public String getPartName() {
        return this.partName.get();
    }

    public void setPartName(String partName) {
        this.partName.set(partName);
    }

    public StringProperty partNameProperty() {
        return this.partName;
    }

    public int getPartInventory() {
        return this.partInventory.get();
    }

    public void setPartInventory(int partInventory) {
        this.partInventory.set(partInventory);
    }

    public IntegerProperty partInventoryProperty() {
        return this.partInventory;
    }

    public double getPartPrice() {
        return this.partPrice.get();
    }

    public void setPartPrice(double partPrice) {
        this.partPrice.set(partPrice);
    }

    public DoubleProperty partPriceProperty() {
        return this.partPrice;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
