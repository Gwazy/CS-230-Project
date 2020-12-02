package backend;


import java.util.ArrayList;

public class Level {


    private static ArrayList<Profile>  profileArray;
    private static ArrayList<Level> newLevels;
    private static ArrayList<Level>  savedLevels;

    public boolean saveButtonFlag;
    public boolean wantToSaveOpportunityFlag;
    public boolean movementFlag;
    public boolean pressLeftFlag;
    public boolean pressRightFlag;
    public boolean pressDownFlag;
    public boolean pressUpFlag;
    public boolean drawTileFlag;
    public boolean arrowFlagPressedVert;
    public boolean arrowFlagPressedHorz;
    public boolean endTurnButton;

    private int tempX;
    private int tempY;
    private Board.Cardinals tempCardinal;

    private Board boardData;
    private int gameTurnData;
    private SilkBag silkBag;
    private Player[] playerData;
    private int[] spawnPoints;




    /**
     * Template for a Saved Level
     * @param tempBoard contains the Board Object
     * @param gameTurn contains information regarding what turn it is
     * @param SilkBag contains information regarding the Tiles which are in the Silk Bag
     * @param players contains information of the players, and the profiles associated with them.
     */

    public Level(Board tempBoard, int gameTurn, SilkBag SilkBag, Player[] players) {
        this.boardData = tempBoard;
        this.gameTurnData = gameTurn;
        this.silkBag = SilkBag;
        this.playerData = players;
        this.spawnPoints = null;
    }

    /**
     *  Template for a New Level
     * @param tempBoard contains the Board Object
     * @param gameTurn contains information regarding what turn it is
     * @param SilkBag contains information regarding the Tiles which are in the Silk Bag
     * @param spawnPoints contains information of the player spawn points.
     */

    public Level(Board tempBoard, int gameTurn, SilkBag SilkBag, int[] spawnPoints) {
        this.boardData = tempBoard;
        this.gameTurnData = gameTurn;
        this.spawnPoints = spawnPoints;
        this.silkBag = SilkBag;
        this.playerData = null;
    }




    public Board getBoardData() {
        return boardData;
    }

    public int getGameTurnData() {
        return gameTurnData;
    }

    public Player[] getPlayerData() {
        return playerData;
    }

    public SilkBag getSilkBag() {
        return silkBag;
    }

    public int[] getSpawnPoints() {
        return spawnPoints;
    }

    public void setPlayerArray (Player[] Players) {
        this.playerData = Players;
    }

    public void setBoardData (Board board) {this.boardData = board; }

    public void setSilkBag (SilkBag silkBag) {this.silkBag = silkBag;}

    public void setGameTurn (int gameTurn) {this.gameTurnData = gameTurn;}



    public static ArrayList<Profile> getProfileArray() {
        return profileArray;
    }

    public static ArrayList<Level> getNewLevels() {
        return newLevels;
    }

    public static ArrayList<Level> getSavedLevels() {
        return savedLevels;
    }

    public int getTempX() {
        return tempX;
    }

    public void setTempX(int tempX) {
        this.tempX = tempX;
    }

    public int getTempY() {
        return tempY;
    }

    public void setTempY(int tempY) {
        this.tempY = tempY;
    }

    public Board.Cardinals getTempCardinal() {
        return tempCardinal;
    }

    public void setTempCardinal(Board.Cardinals tempCardinal) {
        this.tempCardinal = tempCardinal;
    }
}
