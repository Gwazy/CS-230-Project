package layout;
import javafx.fxml.FXML;
import backend.Motd;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;

public class MainMenu {

    //This will import the label from fxml
    @FXML
    private Label motdText;

    //this will import the borderpane from fxml
    @FXML
    private BorderPane rootPane;


    //when menu is launched, initialize motd and display it
    @FXML
    private void initialize(){
        Motd motd = new Motd();
        motdText.setText(motd.getMessage());
        System.out.println("Motd loaded");
        //rootPane.setStyle("-fx-background-color: #202020;");
    }

    //Opens new LaunchNewGame window
    public void launchNewGame(javafx.event.ActionEvent actionEvent) throws IOException {
//        BorderPane pane = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
//        rootPane.getChildren().setAll(pane);
        BorderPane pane = FXMLLoader.load(getClass().getResource("TestBoard2.fxml")); //testing board
        rootPane.getChildren().setAll(pane);

    }

    //Opens new launchLoadGame window
    public void launchLoadGame(javafx.event.ActionEvent actionEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    //Opens new launchLeaderBoards window
    public void launchLeaderBoards(javafx.event.ActionEvent actionEvent) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("Leaderboards.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    public void launchInventory(javafx.event.ActionEvent actionEvent) throws IOException{
        BorderPane pane = FXMLLoader.load(getClass().getResource("InventoryController.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
