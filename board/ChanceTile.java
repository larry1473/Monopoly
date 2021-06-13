package board;

import pawn.Pawn;
import pawn.Position;
/**
 * @author Larry Fotso
 */
public class ChanceTile extends Tile {

    public final static  int COST = 0;
    public final  static String NAME = "CHANCE";

    public ChanceTile(int cost , String name ,Position pos,Pawn pawn1, Pawn pawn2) {
        super(cost,name,pos,pawn1, pawn2);
       
    }
    
}
