package pawn;

import board.Board;
import board.Tile;
/**
 * @author Larry Fotso
 */
public class Pawn {

    private Position loc;
    private String name;
    private Board board;
    private final String image;

   public Pawn( String name , Position loc, String image){
       this.image = image;
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

  public String getImage(){
    return this.image;
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
