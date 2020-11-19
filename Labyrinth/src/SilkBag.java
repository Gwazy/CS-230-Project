
import java.util.Random;

import jdk.javadoc.internal.doclets.formats.html.markup.StringContent;

public class SilkBag {

    int fire;
    int ice;
    int straight;
    int corner;
    int tShaped;
    int backtrack;
    int doublemove;
    Random rand;
    private int[] silkBagContent;

    public SilkBag(int[] silkBagContent) {
        this.silkBagContent = silkBagContent;
        this.straight = silkBagContent[0];
        this.corner = silkBagContent[1];
        this.tShaped = silkBagContent[2];
        this.fire = silkBagContent[3];
        this.ice = silkBagContent[4];
        this.backtrack = silkBagContent[5];
        this.doublemove = silkBagContent[6];
    }

    public static Tile getTile() {
        int randomNum = rand.nextInt(silkBagContent.length);

        if (silkBagContent[randomNum] <= 0) {
            getTile();
        } else {
            silkBagContent[randomNum] = silkBagContent[randomNum] - 1;
            switch (randomNum) {
                case 0:
                    Tile StraightTile = new StraightTile(randomNum, null);
                    return StraightTile;
                case 1:
                    Tile CornerTile = new CornerTile(randomNum, null);
                    return CornerTile;
                case 2:
                    Tile TShapedTile = new TShapedTile(randomNum, null);
                    return TShapedTile;
                case 3:
                    Tile FireTile = new FireTile(randomNum, null);
                    return FireTile;
                case 4:
                    Tile IceTile = new IceTile(randomNum, null);
                    return IceTile;
                case 5:
                    Tile BackTrackTile = new BacktrackTile(randomNum, null);
                    return BackTrackTile;
                case 6:
                    Tile DoubleMoveTile = new DoubleMoveTile(randomNum, null);
                    return DoubleMoveTile;
            }
        }

    }

    public static void insertTileToBag(Tile tile) {
        if (tile instanceof StraightTile) {
            this.straight ++;
        }
        else if (tile instanceof CornerTile){
            this.corner ++;
        }
        else if (tile instanceof FireTile){
            this.fire ++;
        }
        else if (tile instanceof IceTile){
            this.ice ++;
        }
        else if (tile instanceof TShapedTile){
            this.tShaped ++;
        }
        else if (tile instanceof DoubleMoveTile){
            this.doublemove ++;
        }
        else {
            this.backtrack ++;
        }
        
    }

>>>>>>> main
}
