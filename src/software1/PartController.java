package software1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PartController {


    @FXML
    private Button modPartInCancel;
    @FXML
    private Button addPartInCancel;
    @FXML
    private Button addProductCancel;
    @FXML
    private Button modProductCancel;
    @FXML
    private RadioButton goToAddPartOutButton;
    @FXML
    private RadioButton goToAddPartInButton;
    @FXML
    private Button addPartOutCancel;
    @FXML
    private RadioButton goToModPartOutButton;
    @FXML
    private RadioButton goToModPartInButton;
    @FXML
    private Button modPartOutCancel;
    @FXML
    private TextField addPartID;
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
    private Button saveButton;
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
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void addProductBackToMain(ActionEvent event) throws IOException{

        Stage stage = (Stage) addProductCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void modProductBackToMain(ActionEvent event) throws IOException{

        Stage stage = (Stage) modProductCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToAddPartOutsourced(ActionEvent event) throws IOException{

        Stage stage = (Stage) goToAddPartOutButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("addPartOut.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToAddPartIn(ActionEvent event) throws IOException{

        Stage stage = (Stage) goToAddPartInButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("addPartIn.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void addPartOutBackToMain(ActionEvent event) throws IOException{

        Stage stage = (Stage) addPartOutCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToModPartOutsourced(ActionEvent event) throws IOException{

        Stage stage = (Stage) goToModPartOutButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ModPartOut.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToModPartIn(ActionEvent event) throws IOException{
        Stage stage = (Stage) goToModPartInButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ModPartIn.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void modPartOutBackToMain(ActionEvent event) throws IOException{

        Stage stage = (Stage) modPartOutCancel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }
    public void setAddPartID(TextField addPartID) {
        this.addPartID = addPartID;
    }



    public PartInhouse addPartSubmit(ActionEvent event){
        partID = addPartID.getText();
        partName = addPartName.getText();
        partQuantity = addPartQuantity.getText();
        partMachineID = addPartMachineID.getText();
        partPrice = addPartPrice.getText();
        partMin = addPartMin.getText();
        partMax = addPartMax.getText();
        System.out.println(partID + ", part name" + partName );
//        addPart = (partID, partName, Integer.parseInt(partQuantity), (Double.parseDouble(partPrice)), Integer.parseInt(partMin), Integer.parseInt(partMax), partMachineID);
        PartInhouse addPart = new PartInhouse((partID), (partName), Integer.parseInt(partQuantity), (Double.parseDouble(partPrice)), Integer.parseInt(partMin), Integer.parseInt(partMax), partMachineID);
        return addPart;
    }


}