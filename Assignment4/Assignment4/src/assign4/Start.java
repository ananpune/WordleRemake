package assign4;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Start extends Application {

    public static void main (String [] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(("GUI.fxml")));
        primaryStage.setScene(new Scene(root, 500, 1000));
        primaryStage.show();
        
    }
    
}
