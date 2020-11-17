/**
 * @author Kane
 * @version 1.0
 */

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Player {

    public boolean hasBeenDoubled;
    private ArrayList<Integer> tilesVisited =  new ArrayList<>();
    private ArrayList<Tile> playerInventory = new ArrayList<>();
    private boolean hasBeenBackTracked;
    private boolean isPlayerTurn;
    private Profile name;


    public Player(Profile profile, int playercoordx,int playercoordy,int[] profileCoordHistory, ArrayList<Tile> heldPlayerTile, boolean backTrackCheck){

    }

    /**
     * This Method returns the players inventory
     *
     * @return Tiles held by player
     */
    public ArrayList<Tile> getPlayerInventory() {
        return playerInventory;
    }

    /**
     * This Method returns if it is the players turn
     *
     * @return boolean result for player turn
     */
    public boolean getPlayerTurn(){
        return  isPlayerTurn;
    }


    /**
     * This Method returns the players previous coordinates
     *
     * @return a array with the players previous x and y coords
     */

    public int[] getPrevCoordinates(){
        return new int[]{tilesVisited.get(tilesVisited.size()),tilesVisited.get(tilesVisited.size()-1)};

    }

    /**
     * This Method adds a tile to the inventory
     * @param pickedTile
     *
     */
    public void getFromSilkBag(Tile pickedTile){

        playerInventory.add(pickedTile);
    }

    /**
     * This Method check if player is at win coords and if so increments that players win stat
     * @param wincorords
     *
     */

    public void incPlayerWin(int[] wincorords){
        if (getPrevCoordinates() == wincorords)
            name.incrementWinCount();


    }
    /**
     * This Method flips player turn after they have finished their turn
     *
     * @return Boolean result
     */

    public void playerTurn(){
        isPlayerTurn = !isPlayerTurn;
    }

    /**
     * This Method returns the chosen tile from the inventory and removes it as its been used
     * @param index the place of the tile
     * @return the selected Tile
     */

    public Tile takeFromInventory(int index){
        if(index-1 > playerInventory.size()){
            System.out.println("out of bounds ");
            return null;
        }else
            {Tile x = playerInventory.get(index);
            playerInventory.remove(index);
            return x;
            }

    }

    public void draw(){}

}

