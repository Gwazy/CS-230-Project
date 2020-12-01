package layout;

import Tiles.*;
import backend.*;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.net.URL;

import java.util.ArrayList;
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

    //create new board 5x5
    private Level level;
    private GameFlow flow;

    int size = 100;
    Image road = new Image(getClass().getResourceAsStream("/resources/roadDown.jpeg")); //testing image from internet

    Image straight_0 = new Image(getClass().getResourceAsStream("/resources/STRAIGHT_PLACEHOLDER_0.png"));
    Image straight_90 = new Image(getClass().getResourceAsStream("/resources/STRAIGHT_PLACEHOLDER_90.png"));

    Image goal = new Image(getClass().getResourceAsStream("/resources/GOAL_PLACEHOLDER.png"));

    Image corner_0 = new Image(getClass().getResourceAsStream("/resources/CORNER_PLACEHOLDER_0.png"));
    Image corner_90 = new Image(getClass().getResourceAsStream("/resources/CORNER_PLACEHOLDER_90.png"));
    Image corner_180 = new Image(getClass().getResourceAsStream("/resources/CORNER_PLACEHOLDER_180.png"));
    Image corner_270 = new Image(getClass().getResourceAsStream("/resources/CORNER_PLACEHOLDER_270.png"));

    Image tshaped_0 = new Image(getClass().getResourceAsStream("/resources/T_SHAPE_PLACEHOLDER_0.png"));
    Image tshaped_90 = new Image(getClass().getResourceAsStream("/resources/T_SHAPE_PLACEHOLDER_90.png"));
    Image tshaped_180 = new Image(getClass().getResourceAsStream("/resources/T_SHAPE_PLACEHOLDER_180.png"));
    Image tshaped_270 = new Image(getClass().getResourceAsStream("/resources/T_SHAPE_PLACEHOLDER_270.png"));

    Image arrowDown = new Image(getClass().getResourceAsStream("/resources/arrowDOWN.png"));
    Image arrowUp = new Image(getClass().getResourceAsStream("/resources/arrowUP.png"));
    Image arrowLeft = new Image(getClass().getResourceAsStream("/resources/arrowLeft.png"));
    Image arrowRight = new Image(getClass().getResourceAsStream("/resources/arrowRight.png"));

    public BoardController(Level level){
        this.level = level;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupBoard();
        setupArrows();
        refreshBoard();
//        ArrayList<Level> newLevel = FileManager.readLevelDataFile("NewLevel.txt", "New Level");
//        ArrayList<Level> savedLevels = FileManager.readLevelDataFile("SavedLevel.txt", "Saved Level");
//        ArrayList<Profile> profiles = FileManager.readProfileDataFile("Profiles.txt");
//        Player[] player = savedLevels.get(0).getPlayerData();
//        System.out.println(savedLevels.get(0).getPlayerData());
//        System.out.println(player[3].getPlayerInventory());

    }

    private void setupBoard(){
        Tile tile = FileManager.createPlayerInventoryTiles("TShaped", 0);
//        board.getBoardData().insertTile(1,1, (FloorTile)tile);
//        tile = FileManager.createPlayerInventoryTiles("TShaped", 90);
//        board.getBoardData().insertTile(1,2, (FloorTile)tile);
//        tile = FileManager.createPlayerInventoryTiles("TShaped", 180);
//        board.getBoardData().insertTile(1,3, (FloorTile)tile);
//        tile = FileManager.createPlayerInventoryTiles("TShaped", 270);
//        board.getBoardData().insertTile(1,4, (FloorTile)tile);
//
//        tile = FileManager.createPlayerInventoryTiles("Corner", 0);
//        board.getBoardData().insertTile(2,1, (FloorTile)tile);
//        tile = FileManager.createPlayerInventoryTiles("Corner", 90);
//        board.getBoardData().insertTile(2,2, (FloorTile)tile);
//        tile = FileManager.createPlayerInventoryTiles("Corner", 180);
//        board.insertTile(2,3, (FloorTile)tile);
//        tile = FileManager.createPlayerInventoryTiles("Corner", 270);
//        board.insertTile(2,4, (FloorTile)tile);
//
//        tile = FileManager.createPlayerInventoryTiles("Straight", 0);
//        board.insertTile(3,0, (FloorTile)tile);
//        tile = FileManager.createPlayerInventoryTiles("Straight", 90);
//        board.insertTile(3,1, (FloorTile)tile);
        for (int x = 0; x < level.getBoardData().getColumnSize(); x++) { //creates 5x5 board with selected image (need to put random images)
            for (int y = 0; y < level.getBoardData().getRowSize(); y++) {
                level.getBoardData().insertTile(x, y, (FloorTile) tile);
            }
        }
    }

    //show the board based on Board model
    public void refreshBoard(){
        tileGrid.getChildren().removeAll();

        for (int x = 0; x < level.getBoardData().getColumnSize(); x++) { //creates 5x5 board with selected image (need to put random images)
            for (int y = 0; y < level.getBoardData().getRowSize(); y++) {
                ImageView tileImg = new ImageView();
                tileImg.setFitHeight(size);
                tileImg.setFitWidth(size);
                //get a tile at (x,y) on board
                Tile aTile = level.getBoardData().getTileFromBoard(x, y);
                if (aTile instanceof TShapedTile){ //TShaped
                    TShapedTile TShapedTile = (TShapedTile)aTile;
                    if (!TShapedTile.isAccessFromTop()){
                        tileImg.setImage(tshaped_0);
                    }else if (!TShapedTile.isAccessFromRight()){
                        tileImg.setImage(tshaped_90);
                    }else if (!TShapedTile.isAccessFromBottom()){
                        tileImg.setImage(tshaped_180);
                    }else{
                        tileImg.setImage(tshaped_270);
                    }
                }else if (aTile instanceof CornerTile){ //Corner
                    CornerTile aCornerTile = (CornerTile)aTile;
                    if (aCornerTile.isAccessFromLeft() && aCornerTile.isAccessFromTop()){
                        tileImg.setImage(corner_0);
                    }else if (aCornerTile.isAccessFromTop() && aCornerTile.isAccessFromRight()){
                        tileImg.setImage(corner_90);
                    }else if (aCornerTile.isAccessFromRight() && aCornerTile.isAccessFromBottom()){
                        tileImg.setImage(corner_180);
                    }else{
                        tileImg.setImage(corner_270);
                    }
                }else if (aTile instanceof StraightTile){ //Straight
                    StraightTile aStraightTile = (StraightTile)aTile;
                    if (aStraightTile.isAccessFromLeft() && aStraightTile.isAccessFromRight()){
                        tileImg.setImage(straight_0);
                    }else {
                        tileImg.setImage(straight_90);
                    }
                }else {
                    tileImg.setImage(road); //get images from save file here
                }
                tileGrid.add(tileImg, x,y);
            }
        }
    }

    private void movePlayer(){

    }

    /**
     * the arrow is clicked
     */
    private void onClickArrow(int x, int y, Image arrow){
        Board.Cardinals c = Board.Cardinals.BOTTOM;
        if (arrow == arrowRight){
            c = Board.Cardinals.LEFT;
        }else if (arrow == arrowLeft){
            c = Board.Cardinals.RIGHT;
        }else if (arrow == arrowDown){
            c = Board.Cardinals.TOP;
        }

        System.out.println(x + "," + y);

        //FloorTile newTile = (FloorTile)F("TShaped", 0); //TODO, replace it later

        FloorTile newTile = (FloorTile)FileManager.createPlayerInventoryTiles("TShaped", 0); //TODO, replace it later
        FloorTile tile = level.getBoardData().placeOnNewTile(c, x, y, newTile);

        //show the board based on Board model
        refreshBoard();
    }

    //Need to set arrows depending if tile is fixed or not
    //also need to create clickable arrows.
    public void setupArrows() {
        topGrid.setTranslateX(size);
        bottomGrid.setTranslateX(size);
        for (int x = 0; x < level.getBoardData().getRowSize(); x++) {
            for (int y = 0; y < level.getBoardData().getColumnSize(); y++) {
                if (x == 0) {
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowRight);
                    leftGrid.add(tileImg, x, y);

                    final int xx = x, yy = y;

                    tileImg.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {
                            System.out.println("arrowRight pressed ");
                            onClickArrow(xx, yy, arrowRight);
                            level.setTempX(xx);
                            level.setTempY(yy);
                            level.setTempCardinal(Board.Cardinals.RIGHT);
                            event.consume();
                        }
                    });

                } else if (x == level.getBoardData().getRowSize() - 1) { //4 is the board size, we will get board size from save files, this is just for testing right now.
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowLeft);
                    rightGrid.add(tileImg, x, y);

                    final int xx = x, yy = y;

                    tileImg.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {
                            System.out.println("arrowLeft pressed ");
                            onClickArrow(xx, yy, arrowLeft);
                            level.setTempX(xx);
                            level.setTempY(yy);
                            level.setTempCardinal(Board.Cardinals.LEFT);
                            event.consume();
                        }
                    });

                }
                if (y == 0) {
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowUp);
                    bottomGrid.add(tileImg, x, y);

                    final int xx = x, yy = y;

                    tileImg.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {
                            System.out.println("arrowUp pressed ");
                            onClickArrow(xx, yy, arrowUp);
                            level.setTempX(xx);
                            level.setTempY(yy);
                            level.setTempCardinal(Board.Cardinals.TOP);
                            event.consume();
                        }
                    });

                } else if (y == level.getBoardData().getColumnSize() - 1) { //4 is the board size, we will get board size from save files, this is just for testing right now.
                    ImageView tileImg = new ImageView();
                    tileImg.setFitHeight(size);
                    tileImg.setFitWidth(size);
                    tileImg.setImage(arrowDown);
                    topGrid.add(tileImg, x, y);

                    final int xx = x, yy = y;

                    tileImg.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {
                            System.out.println("arrowDown pressed ");
                            onClickArrow(xx, yy, arrowDown);
                            level.setTempX(xx);
                            level.setTempY(yy);
                            level.setTempCardinal(Board.Cardinals.BOTTOM);
                            event.consume();
                        }
                    });
                }
            }
        }
    }

}

