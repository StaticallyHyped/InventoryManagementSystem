package software1;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PartController implements Initializable {


    @FXML
    private Button modPartInCancel;
    @FXML
    private Button addPartInCancel;
    @FXML
    public TextField addPartID;
    @FXML
    private TextField addPartName;
    @FXML
    private TextField addPartQuantity;
    @FXML
    private TextField addPartMachineID;
    @FXML
    private TextField addPartPrice;
    @FXML
    private TextField addPartMin;
    @FXML
    private TextField addPartMax;
    @FXML
    public String partID;
    @FXML
    public String partName;
    @FXML
    public String partQuantity;
    @FXML
    public String partPrice;
    @FXML
    public String partMin;
    @FXML
    public String partMax;
    @FXML
    public String partMachineID;

    //Begin modPartInHouse declarations
    @FXML
    public TextField modPartInH_ID;
    @FXML
    public TextField modPartInH_name;
    @FXML
    public TextField modPartInH_Inventory;
    @FXML
    public TextField modPartInH_price;
    @FXML
    public TextField modPartInH_max;
    @FXML
    public TextField modPartInH_min;
    @FXML
    public TextField modPartInH_MachID;
    @FXML
    public String modPartName;
    @FXML
    public int modPartID;
    @FXML
    public int modPartInventory;
    @FXML
    public int modPartMin;
    @FXML
    public int modPartMax;
    @FXML
    public double modPartPrice;
    @FXML
    public String modPartMachID;
    @FXML
    public Label labelMachOrCompany;
    @FXML
    public Label modPartLabel;
    @FXML
    public Label addPartMachIDOrCompanyLabel;
    @FXML
    public Label addPartLabel;
    @FXML
    public RadioButton addPartInRB;
    @FXML
    public RadioButton addPartOutRB;
    @FXML
    public RadioButton goToModPartInButton;
    @FXML
    public RadioButton goToModPartOutButton;


    Part modPart;
    public PartController(){

    }

    @FXML
    private void modPartInBackToMain(ActionEvent event) throws IOException{

        Stage stage = (Stage) modPartInCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void addPartInBackToMain(ActionEvent event) throws IOException{

        Stage stage = (Stage) addPartInCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToModPartOutsourced(ActionEvent event) throws IOException{
        labelMachOrCompany.setText("Company Name");
        modPartLabel.setText("Modify Outsourced Part");
    }
    @FXML
    private void goToModPartIn(ActionEvent event) throws IOException{
        labelMachOrCompany.setText("Machine ID");
        modPartLabel.setText("Modify In-House Part");
    }
    @FXML
    private void addPartIn(ActionEvent event) throws IOException{
        addPartMachIDOrCompanyLabel.setText("Machine ID");
        addPartLabel.setText("Add In-House Part");
    }
    @FXML
    private void addPartOut(ActionEvent event) throws IOException{
        addPartMachIDOrCompanyLabel.setText("Company Name");
        addPartLabel.setText("Add Outsourced Part");
    }
    Inventory test = new Inventory();
    Part addPart;

    public void addPartSubmit(ActionEvent event){

        try {
            partID = addPartID.getText();
            partName = addPartName.getText();
            partQuantity = addPartQuantity.getText();
            partMachineID = addPartMachineID.getText();
            partPrice = addPartPrice.getText();
            partMin = addPartMin.getText();
            partMax = addPartMax.getText();

            //If RB1 = selected, addPart = new PartInHouse
            if(addPartInRB.isSelected()) {
                addPart = new PartInhouse(Integer.parseInt(partID), partName, Integer.parseInt(partQuantity), (Double.parseDouble(partPrice)), Integer.parseInt(partMin),
                        Integer.parseInt(partMax), Integer.parseInt(partMachineID));
            } //else addPart = new PartOut
            else {addPart = new PartOut(Integer.parseInt(partID), partName, Integer.parseInt(partQuantity), (Double.parseDouble(partPrice)), Integer.parseInt(partMin),
                    Integer.parseInt(partMax), partMachineID);
            }

            test.partData.add(addPart);

        }catch(Exception e) {
            System.out.println("You have entered an invalid value. Please enter a valid value.");
        }
    }
    public void modPartSubmit(ActionEvent event){
        try {
            partID = modPartInH_ID.getText();
            partName = modPartInH_name.getText();
            partQuantity = modPartInH_Inventory.getText();
            partMachineID = modPartInH_MachID.getText();
            partPrice = modPartInH_price.getText();
            partMin = modPartInH_min.getText();
            partMax = modPartInH_max.getText();
            if(goToModPartInButton.isSelected()) {
                modPart = new PartInhouse(Integer.parseInt(partID), partName, Integer.parseInt(partQuantity), (Double.parseDouble(partPrice)), Integer.parseInt(partMin),
                        Integer.parseInt(partMax), Integer.parseInt(partMachineID));
            } //else addPart = new PartOut
            else {
                modPart = new PartOut(Integer.parseInt(partID), partName, Integer.parseInt(partQuantity), (Double.parseDouble(partPrice)), Integer.parseInt(partMin),
                    Integer.parseInt(partMax), partMachineID);
            }
            test.partData.set(test.partData.indexOf(addPart), modPart);

        }catch(Exception e) {

            System.out.println("You have entered an invalid value. Please enter a valid value.");
        }
    }

    public void initialize(URL url, ResourceBundle rb) {

    }

    public void modifySelectedPart(Part part) {
        addPart = part;
        if(part instanceof PartInhouse) {
            PartInhouse partIn = (PartInhouse) part;
            modPartMachID = Integer.toString(partIn.getMachineID());
            labelMachOrCompany.setText("Machine ID");
        }
        else   {

            goToModPartOutButton.setSelected(true);
            PartOut partOut = (PartOut) part;
            modPartMachID = partOut.getCompanyName();
            labelMachOrCompany.setText("Company Name");
        }
            modPartName = part.getPartName();
            modPartID = part.getPartID();
            modPartInventory = part.getPartInventory();
            modPartMin = part.getMinValue();
            modPartMax = part.getMaxValue();
            modPartPrice = part.getPartPrice();
            modPartInH_name.setText(modPartName);
            modPartInH_Inventory.setText(Integer.toString(modPartInventory));
            modPartInH_ID.setText(Integer.toString(modPartID));
            modPartInH_price.setText(Double.toString(modPartPrice));
            modPartInH_max.setText(Integer.toString(modPartMax));
            modPartInH_min.setText(Integer.toString(modPartMin));
            modPartInH_MachID.setText(modPartMachID);
    }

}