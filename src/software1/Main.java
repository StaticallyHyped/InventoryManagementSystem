package software1;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
    public Main() {
    }
    Scene main, addPartIn, addPartOut, addProd, modPartIn,
            modPartOut, modProd;
    public void start(Stage primaryStage) throws Exception{

        //sets the title
        primaryStage.setTitle("Parts and Products Home");
        //doesn't throw an exception, uses try
//        try {
            //getting into formatting - load the XML formatting doc
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));

            //creates a new anchorpane class instance called page
            AnchorPane page = (AnchorPane)loader.load();

            //creates a new Scene instance called scene
            Scene scene = new Scene(page);

            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    Platform.exit();
                }
            });
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
