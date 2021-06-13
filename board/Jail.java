package board;

import pawn.Pawn;
import pawn.Position;

public class Jail extends Tile {

    public final static  int COST = 0;
    public final  static String NAME = "JAIL";

    public Jail(int cost , String name, Position pos, Pawn pawn1, Pawn pawn2) {
        super(cost,name,pos,pawn1,pawn2);
        
    }
    
}
