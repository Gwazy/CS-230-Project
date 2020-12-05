package layout;

import backend.Leaderboard;
import backend.Profile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import backend.Leaderboard;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * this class handles the leaderboard UI and allows users to switch between leaderboards
 * @author
 * @version 1.0
 */
public class Leaderboards implements Initializable {

    @FXML private Button backToMenuBtn;
    @FXML private MenuItem sortWins;
    @FXML private MenuItem sortLoss;
    @FXML private MenuItem sortGamesPlayed;
    @FXML private ListView<String> profileList;

    private Leaderboard leaderboard;
    private Stage stage;
    private ArrayList<Profile> profiles;

    private ArrayList<Profile> sortedWins;
    private ArrayList<Profile> sortedLosses;
    private ArrayList<Profile> sortedGamesPlayed;

    public Leaderboards(Stage stage, ArrayList<Profile> profiles){
        this.profiles = profiles;
        this.stage = stage;
        sortedWins = new Leaderboard(profiles, 0, true).getLeaderboard();
        sortedLosses = new Leaderboard(profiles, 1, true).getLeaderboard();
        sortedGamesPlayed = new Leaderboard(profiles, 3, true).getLeaderboard();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backToMenuBtn.setOnAction(e -> {
            goBackToMenu();
        });

        sortWins.setOnAction(e -> {
            sortByWins();
        });

        sortLoss.setOnAction(event -> {
            sortByLoss();
        });

        sortGamesPlayed.setOnAction(e -> {
            sortGamesPlayed();
        });

        refreshLeaderboard();
    }

    private void refreshLeaderboard(){
        profileList.getItems().clear();
        for(Profile i : profiles){
            profileList.getItems().add(i.getProfileName());
        }
    }

    public void displayProfiles() {

    }

    public void sortByWins() {
        profileList.getItems().clear();
        System.out.println("Sorting by wins");
        for (Profile i : sortedWins){
            profileList.getItems().add(i.getProfileName());
        }
    }

    private void sortGamesPlayed() {
        profileList.getItems().clear();
        System.out.println("Sorting by games played");
        for (Profile i : sortedGamesPlayed)
            profileList.getItems().add(i.getProfileName());
    }

    private void sortByLoss() {
        profileList.getItems().clear();
        System.out.println("Sorting by losses");
        for (Profile i : sortedLosses)
            profileList.getItems().add(i.getProfileName());
    }

    public void goBackToMenu() {
        try {
            Main main = new Main();
            main.start(stage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}