package board;

import pawn.Pawn;
import pawn.Position;

public class CommunityChest extends Tile {

    public final static  int COST = 0;
    public final  static String NAME = "COMMUNITY CHEST";

    public CommunityChest(int cost , String name,Position pos,Pawn pawn1,Pawn pawn2) {
        super(cost,name,pos,pawn1,pawn2);
       
    }
    
    
}