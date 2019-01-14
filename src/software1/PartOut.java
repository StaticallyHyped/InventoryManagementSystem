package software1;


import javafx.beans.property.IntegerProperty;

public class PartOut extends Part {

    private String companyName;

    public PartOut(int partID, String partName, int partInventory, double partPrice, int minValue, int maxValue, String companyName) {
        super(partID, partName, partInventory, partPrice, minValue, maxValue);
        this.companyName = companyName;

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}