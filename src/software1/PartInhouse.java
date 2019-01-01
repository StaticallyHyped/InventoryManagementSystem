package software1;


import javafx.beans.property.IntegerProperty;

public class PartInhouse extends Part {

//    private String partID;
//    private String partName;
//    private int partInventory;
//    private double partPrice;
    private String machineID;
//    private int minValue;
//    private int maxValue;

    public PartInhouse(String partID, String partName, int partInventory, double partPrice, int minValue, int maxValue, String machineID) {
        super(partID, partName, partInventory, partPrice, minValue, maxValue);
        this.machineID = machineID;
//        this.partID = partID;
//        this.maxValue = maxValue;
//        this.minValue = minValue;
//        this.partName = partName;
//        this.partInventory = partInventory;
//        this.partPrice = partPrice;

    }

}