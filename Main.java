
import board.Board;
import gui.ChoosePawn;
import gui.Graphical;
/**
 * @author Larry Fotso
 */
public class Main{

    public static void main(String[] args) {
        
        Board board = Board.getInstance();
        board.createPawn(2); // Creates the number of wanted pawns.
        board.SetPawnPostion();
        //ChoosePawn choosePawn = new ChoosePawn();
        new Graphical();
       // System.out.println(board);
        //System.out.println(board.toString());

        for(int i = 0; i< board.getBoard().length; i++){
           for(int j = 0; j < board.getBoard()[i].length; j++){
                if(board.getBoard()[i][j] != null && board.getBoard()[i][j].getPawn1() != null || board.getBoard()[i][j] != null && board.getBoard()[i][j].getPawn2() != null ){
                    System.out.println("x");
                    

                }

            }
        }
       
 
     }
}