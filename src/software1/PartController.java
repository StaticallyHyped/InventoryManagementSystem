package software1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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


    public ObservableList<Part> addPartInData = FXCollections.observableArrayList();

    public PartController() {
        this.addPartInData.add(new PartInhouse("14", "Musterd", "test",
                "also test", 1, 2,45));

    }
    public String thisIsATest(){
        String test = "this is a test";

        return test;
    }

    public void setAddPartID(TextField addPartID) {
        this.addPartID = addPartID;
    }
}