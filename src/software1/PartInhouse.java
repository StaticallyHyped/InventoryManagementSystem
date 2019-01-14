package software1;


import javafx.beans.property.IntegerProperty;

public class PartInhouse extends Part {

    private int machineID;

    public PartInhouse(int partID, String partName, int partInventory, double partPrice, int minValue, int maxValue, int machineID) {
        super(partID, partName, partInventory, partPrice, minValue, maxValue);
        this.machineID = machineID;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}