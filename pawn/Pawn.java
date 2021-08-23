package pawn;

import board.Board;
import board.Tile;
/**
 * @author Larry Fotso
 */
public class Pawn {

    Position loc;
    String name;
    Board board;

   public Pawn( String name , Position loc){
       this.loc = loc;
       this.name = name;
       this.board = new Board();
   }

   public Position getLoc() {
       return loc;
   }

   public String getName() {
       return name;
   }

   public void setLoc(Position loc) {
       this.loc = loc;
   }


   /**
    * 
    * @return current tile on which the pawn is on.
    */
   public Tile getCurrentTile(){
       return board.getTile(loc);

   }


   /**
    * changes the position of a pawn on the grid.
    */
   public void move(Position pos){
       Tile currentTile = getCurrentTile();
       
       if(this.board.getTile(pos) != currentTile){
           setLoc(pos);
           this.board.getTile(pos).placePawn(this,null);
       }


   }
    
}
