package software1;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PartInhouse extends Part{
    public PartInhouse(String partID, String partName, String partInventory, String partPrice, int minValue, int maxValue, int machineID) {
        super(partID, partName, partInventory, partPrice, minValue, maxValue);

    }
    @FXML
    private TextField machineID;

    @FXML
    private TextField partID;

    public void setMachineID(int machineID){

    }

    public int getMachineID(){

        return 0;
    }

}
