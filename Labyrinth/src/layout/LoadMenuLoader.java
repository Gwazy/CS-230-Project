package layout;

import backend.Level;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

/**
 * this class IDK
 * @author
 * @version 1.0
 */


public class LoadMenuLoader {
    public LoadMenuLoader(Stage stage, ArrayList<Level> level){
        Stage primaryStage = stage;
        try {
            FXMLLoader loader = new FXMLLoader();
            LoadGame controller = new LoadGame(stage, level);
            loader.setController(controller);
            Parent root = loader.load(getClass().getClassLoader().getResource("layout/LoadGame.fxml").openStream());
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
