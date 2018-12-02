package software1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PartController {

    @FXML
    private TextField addPartID;
    @FXML
    private TextField addPartName;
    @FXML
    private TextField addPartMin;
    @FXML
    private TextField addPartMax;
    @FXML
    private TextField addPartQuantity;
    @FXML
    private TextField addPartPrice;
    @FXML
    private Button modPartInCancel;
    @FXML
    private Button addPartInCancel;
    @FXML
    private Button addProductCancel;
    @FXML
    private Button modProductCancel;

//    public ObservableList<PartInhouse> addPartInData = FXCollections.observableArrayList();

//    public PartController() {
//        this.addPartInData.add(new PartInhouse("14", "Musterd", "test",
//                "also test", 1, 2,45));
//
//    }
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

    public void setAddPartID(TextField addPartID) {
        this.addPartID = addPartID;
    }
    @FXML
    public void setAddPartInfoIn(){

    }

}