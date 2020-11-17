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
    private Color playercolor;
    private boolean isPlayerTurn;
    private Profile name;


    public Player(Profile profile, int playercoordx,int playercoordy,int[] profileCoordHistory, Tile[] heldPlayerTile, boolean backTrackCheck){

    }

    public void setPlayercolor(Color playercolor) {
        this.playercolor = playercolor;
    }

    public Color getPlayercolor(){
        return playercolor;
    }

    public ArrayList<Tile> getPlayerInventory() {
        return playerInventory;
    }
    public boolean getPlayerTurn(){
        return  isPlayerTurn;
    }


    public int[] getPrevCoordinates(){
        return new int[]{tilesVisited.get(tilesVisited.size()),tilesVisited.get(tilesVisited.size()-1)};

    }
    public void getFromSilkBag(Tile pickedTile){

        playerInventory.add(pickedTile);
    }

    public void incPlayerWin(int[] wincorords){
        if (getPrevCoordinates() == wincorords)
            name.incrementWinCount();


    }

    public void playerTurn(){
        isPlayerTurn = !isPlayerTurn;
    }

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

