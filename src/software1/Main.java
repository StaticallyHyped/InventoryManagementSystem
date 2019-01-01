package software1;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;



public class Main extends Application {
    public Main() {

    }
    Stage window;

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //window.setTitle("Parts and Products Home");
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        //FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));

            //creates a new anchorpane class instance called page
         //   AnchorPane page = loader.load();

            //creates a new Scene instance called scene
            Scene scene = new Scene(root);

            window.setScene(scene);
            window.show();
           /* window.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    Platform.exit();
                }
            });*/
//        } catch (IOException var5) {
//            var5.printStackTrace();
//        }
//        FXMLLoader loadModPartIn = new FXMLLoader(Main.class.getResource("ModPartIn.fxml"));
//        AnchorPane modPartInPage = (AnchorPane)loadModPartIn.load();




    }

    public static void main(String[] args) {
        launch(args);

    }
}
