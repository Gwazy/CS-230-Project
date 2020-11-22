import Tiles.ActionTile;
import Tiles.FireTile;
import Tiles.FloorTile;
import Tiles.IceTile;
import Tiles.Tile;

/**
 * @author Ben Dodd
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameFlow {
    private Level level;
    private Player[] players;
    private int playerTurn;

    /**
     * New Game
     * @param level Level to play.
     * @param profiles Profiles to create players from.
     */
    public GameFlow(Level level, Profile[] profiles) {
        this.level = level;
        this.initiatePlayers(profiles);
        // Randomly select a player to have the first turn.
        Random r = new Random();
        this.playerTurn = r.nextInt(this.players.length);
        this.players[this.playerTurn].playerTurn();
    }

    /**
     * Continue Level
     * @param level Level to play.
     */
    public GameFlow(Level level) {
        this.level = level;
        this.players = level.getPlayerData();
        // Set the player turn to whichever player had the last turn in the previous save.
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].getPlayerTurn()) {
                this.playerTurn = i;
                break;
            }
        }
    }

    /**
     * Create players based on level data and profiles.
     * @param profiles Profiles to initialise players from.
     */
    private void initiatePlayers(Profile[] profiles) {
        this.players = new Player[profiles.length];
        int[] spawnPoints = this.level.getSpawnPoints();
        for (int i = 0; i < profiles.length; i++) {
            this.players[i] = new Player(profiles[i], spawnPoints[i*2], spawnPoints[(i*2) + 1], new int[6], new ArrayList<Tile>(), false, false);
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
    public FloorTile playerSlotFloorTile(Board.Cardinals direction, FloorTile tile, int x, int y) {
        this.level.getBoardData().movePlayerFromEndTile(x, y, direction);
        return this.level.getBoardData().placeOnNewTile(direction, x, y, tile);
    }

    /**
     * Place an action tile at the given coordinates on the board.
     * @param tile The tile to place on the board.
     * @param x The x-coordinate to insert the action tile.
     * @param y The y-coordinate to insert the action tile.
     * @return True if the tile was placed.
     */
    public Boolean playerPlaceActionTile(ActionTile tile, int x, int y) {
        // If the player of the current turn is trying to place an action tile
        // on themselves, we deny it.
        if (!checkActionCardValid(this.players[playerTurn], x, y)) {
            return false;
        }
        // check type of tile
        if (tile instanceof FireTile) {
            this.level.getBoardData().setTilesOnFire(x, y);
            return true;
        } else if (tile instanceof IceTile) {
            this.level.getBoardData().setTilesFrozen(x, y);
            return true;
        }
        return false;
    }

    /**
     * Checks if the player is standing on a point where they want to place an action tile.
     * @param player The player requesting the placement.
     * @return True if the tile can be placed.
     */
    public Boolean checkActionCardValid(Player player, int x, int y) {
        return Arrays.equals(this.level.getBoardData().playerLocationOnBoard(x, y, player), new int[] {x, y});
    }

    /**
     * This method will discard tiles from the board to the SilkBag.
     * @param tile The tile being discarded.
     */
    public void discardTileToSilkBag(String tile) {
        this.level.getSilkBagObject().insertTileToBag(tile);
    }

    /**
     * Go to the next turn of the board.
     */
    public void incGameTurn() {
        // set the next player's turn to true (playerTurn method)
        // set the previous player's turn to false (playerTurn method)
        this.players[this.playerTurn].playerTurn(); // set current players turn to false
        this.playerTurn ++; // increment which players turn it is
        if (this.playerTurn == this.players.length) { // loop back to first player if at end of player array
            this.playerTurn = 0;
        }
        this.players[this.playerTurn].playerTurn(); // set next players turn to true
    }

    public void flow() {
        // play through each player, until game win or save
        // use checks to ensure player can move, otherwise try again
        // once player has performed all tasks, incGameTurn()
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
