package backend;


public class Level {

    private Board boardData;
    private int gameTurnData;
    private SilkBag silkBag;
    private Player[] playerData;
    private int[] spawnPoints;
    private Profile[] profileArray;
    private Level[] newLevels;
    private Level[] savedLevels;


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

    public Profile[] getProfileArray() {
        return profileArray;
    }

    public void setProfileArray(Profile[] profileArray) {
        this.profileArray = profileArray;
    }

    public Level[] getNewLevels() {
        return newLevels;
    }

    public void setNewLevels(Level[] newLevels) {
        this.newLevels = newLevels;
    }

    public Level[] getSavedLevels() {
        return savedLevels;
    }

    public void setSavedLevels(Level[] savedLevels) {
        this.savedLevels = savedLevels;
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

}
