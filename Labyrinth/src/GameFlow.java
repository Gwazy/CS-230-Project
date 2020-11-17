/**
 * @author Ben Dodd
 * @version 1.0.0
 */

import java.util.ArrayList;

public class GameFlow {
    private Level level;
    private Player[] players;

    /**
     * New Game
     * @param level Level to play.
     * @param profiles Profiles to create players from.
     */
    public GameFlow(Level level, Profile[] profiles) {
        this.level = level;
        this.initiatePlayers(profiles);
    }

    /**
     * Continue Level
     * @param level Level to play.
     */
    public GameFlow(Level level) {
        this.level = level;
        this.players = level.getPlayerData();
    }

    /**
     * Create players based on level data and profiles.
     * @param profiles Profiles to initialise players from.
     */
    private void initiatePlayers(Profile[] profiles) {
        this.players = new Player[profiles.length];
        int[] spawnPoints = this.level.getSpawnPoints();
        for (int i = 0; i < profiles.length; i++) {
            this.players[i] = new Player(profiles[i], spawnPoints[i*2], spawnPoints[(i*2) + 1], new int[6], new ArrayList<Tile>(), false);
        }
        this.level.setPlayerArray(this.players);
    }

    /**
     * Insert a tile onto the board at the specified coordinates.
     * The tile that is taken off the board will be returned to be inserted into the silk bag.
     * @param gameBoard     The board that the tile is being added to.
     * @param tile          The tile to add to the board.
     * @param x             The x-coordinate to insert the tile into.
     * @param y             The y-coordinate to insert the tile into.
     * @return              The tile that was removed from the board.
     */
    public Tile playerSlotFloorTile(Board gameBoard, Tile tile, int x, int y) {
        return null;
    }

    /**
     * Place an action tile at the given coordinates on the board.
     * @param gameBoard The board to place the tile on.
     * @param tile The tile to place on the board.
     * @param x The x-coordinate to insert the action tile.
     * @param y The y-coordinate to insert the action tile.
     * @return True if the tile was placed.
     */
    public Boolean playerPlaceActionTile(Board gameBoard, Tile tile, int x, int y) {
        return false;
    }

    /**
     * Checks if the player is standing on a point where they want to place an action tile.
     * @param tile The tile the player wants to place.
     * @param player The player requesting the placement.
     * @return True if the tile can be placed.
     */
    public Boolean checkActionCardValid(Tile tile, Player player) {
        return false;
    }

    /**
     * Go to the next turn of the board.
     */
    public void incGameTurn() {
    }

    /**
     * Prepare the game to finish, either for saving or at a win.
     * @return True if the game could end
     */
    public Boolean endGame() {
        return false;
    }

    /**
     * Pass data from the game to be saved.
     * @return True if the game could be saved.
     */
    public Boolean saveGame() {
        return false;
    }

    /**
     * Announces that a player has won.
     * @return Player that won.
     */
    public Player declareWinner() {
        return null;
    }

    /**
     * Check if the board is in a state where a player has won.
     * @return True if there is a winning situation.
     */
    public Boolean checkWin() {
        return false;
    }
}
