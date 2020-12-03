package layout;
import backend.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenu {

    private Stage primaryStage;

    Level level;

    public void setStage(Stage stage){

        this.primaryStage = stage;
    }

    //This will import the label from fxml
    @FXML
    private Label motdText;

    //this will import the borderpane from fxml
    @FXML
    private BorderPane rootPane;


    ArrayList<Level> newLevels = FileManager.readLevelDataFile("NewLevel.txt", "New Level");
    ArrayList<Level> savedLevels = FileManager.readLevelDataFile("SavedLevel.txt", "Saved Level");
    ArrayList<Profile> profiles = FileManager.readProfileDataFile("Profiles.txt");


    //when menu is launched, initialize motd and display it
    @FXML
    private void initialize(){
        Motd motd = new Motd();
        motdText.setText(motd.getMessage());
        System.out.println("Motd loaded");
    }

    //Opens new LaunchNewGame window
    public void launchNewGame(){
        ProfileSelectLoader loader = new ProfileSelectLoader(primaryStage, profiles);
        //Game game = new Game(primaryStage, savedLevels.get(0));
    }

    //Opens new launchLoadGame window
    public void launchLoadGame() {
        LoadMenuLoader loadMenuLoader = new LoadMenuLoader(primaryStage, savedLevels);

    }

    //Opens new launchLeaderBoards window
    public void launchLeaderBoards() {
//        BorderPane pane = FXMLLoader.load(getClass().getResource("Leaderboards.fxml"));
//        rootPane.getChildren().setAll(pane);
          LeaderboardLoader leaderboards = new LeaderboardLoader(primaryStage, profiles);

    }
    public void launchInventory() throws IOException{
        BorderPane pane = FXMLLoader.load(getClass().getResource("InventoryController.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
