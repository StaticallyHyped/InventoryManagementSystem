package software1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    public ObservableList test =  FXCollections.observableArrayList();
    public Main() {
        //Experimental dummy data

        /*Inventory.getPartData().add(new PartInhouse(1, "truss", 10, 14, 1, 2, 26));
        Inventory.getPartData().add(new PartInhouse(2, "shear", 16, 14, 1, 2, 26));
        Inventory.getPartData().add(new PartInhouse(3, "partnametest", 10, 14, 1, 2, 56));*/

        Inventory.getProductData().add(new Product(1, "test two", 10, 34, 10, 10, (test)));
    }
    Stage window;

    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Parts and Products Home");
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
