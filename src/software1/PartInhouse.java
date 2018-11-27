package software1;



public class PartInhouse extends Part{
    public PartInhouse(String partID, String partName, String partInventory, String partPrice, int minValue, int maxValue, int machineID) {
        super(partID, partName, partInventory, partPrice, minValue, maxValue);
        this.machineID = machineID;
    }
    private final int machineID;

    public void setMachineID(int machineID){

    }

    public int getMachineID(){

        return 0;
    }

}
