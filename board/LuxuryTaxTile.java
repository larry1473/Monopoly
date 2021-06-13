package board;

import pawn.Pawn;
import pawn.Position;
/**
 * @author Larry Fotso
 */
public class LuxuryTaxTile extends Tile {

    public final static  int COST = 0;
    public final  static String NAME = "LUXURY TAX";

    public LuxuryTaxTile(int cost , String name ,Position pos, Pawn pawn1, Pawn pawn2) {
        super(cost, name, pos,pawn1, pawn2);
       this.cost = 0;
       
    }

	
    
}
