package layout;

import backend.Board;
import backend.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;

import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private GridPane topGrid;
    @FXML
    private GridPane rightGrid;
    @FXML
    private GridPane bottomGrid;
    @FXML
    private GridPane leftGrid;
    @FXML
    private GridPane tileGrid;

    private int rowSize = 7;
    private int columnSize =7;
    private Image currentImage;

    private int boardSize = rowSize * columnSize;

    private Player player;

    int size = 80;
    Image road = new Image(getClass().getResourceAsStream("/resources/amongusUP.png")); //testing image from internet
    Image arrowDown = new Image(getClass().getResourceAsStream("/resources/arrowDOWN.png"));
    Image arrowUp = new Image(getClass().getResourceAsStream("/resources/arrowUP.png"));
    Image arrowLeft = new Image(getClass().getResourceAsStream("/resources/arrowLeft.png"));
    Image arrowRight = new Image(getClass().getResourceAsStream("/resources/arrowRight.png"));


//    public BoardController(Board board){
//        rowSize = board.getRowSize();
//        columnSize = board.getColumnSize();
//        //this.player = player;
//    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupBoard();
        setupArrows();
    }


    public void rotateTile(){

    }

    public void setupBoard(){
        for (int x = 0; x < rowSize; x++) { //creates 5x5 board with selected image (need to put random images)
            for (int y = 0; y < columnSize; y++) {
                ImageView tileImg = new ImageView();
                tileImg.setFitHeight(size);
                tileImg.setFitWidth(size);
                tileImg.setImage(road); //get images from save file here
                tileGrid.add(tileImg, x,y);
            }
        }
    }


    //Need to set arrows depending if tile is fixed or not
    //also need to create clickable arrows.
    public void setupArrows() {
        topGrid.setTranslateX(size);
        bottomGrid.setTranslateX(size);
        for (int x = 0; x < rowSize; x++) {
            for (int y = 0; y < columnSize; y++){
                if (x==0) {
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowRight);
                    leftGrid.add(tileImg, x,y);

                } else if (x == boardSize-1){ //4 is the board size, we will get board size from save files, this is just for testing right now.
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowLeft);
                    rightGrid.add(tileImg, x,y);
                }
                if (y==0){
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowUp);
                    bottomGrid.add(tileImg, x,y);
                } else if (y==boardSize-1){ //4 is the board size, we will get board size from save files, this is just for testing right now.
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowDown);
                    topGrid.add(tileImg, x,y);
                }
            }
        }
    }

    public void getRandomTile(){

    }

}
