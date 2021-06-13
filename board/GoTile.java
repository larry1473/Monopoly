package board;

import pawn.Pawn;
import pawn.Position;
/**
 * @author Larry Fotso
 */
public class GoTile extends Tile {

    public final static  int COST = 0;
    public final  static String NAME = "GO";

    private int money = 200; // Money the player recieves went on this tile.

    public GoTile(int cost, String name,Position pos,Pawn pawn1, Pawn pawn2) {
        super(cost , name,pos,pawn1, pawn2);
        
    }

    public int getMoney() {
        return money;
    }
    


    
}
