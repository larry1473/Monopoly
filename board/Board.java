package board;

import java.util.ArrayList;


import pawn.Pawn;
import pawn.Position;


/**
 * @author Fotso Larry 
 * This class handels all the logic behind the board.
 */

public class Board {

    ArrayList<Pawn> pawns = new ArrayList<>();
    private  Tile[][] board; 
    //public static int NUMPawns;
    //private static int  NUMPAWNS;
    public static Board instance;    


    public Board(){
        this.board = makeBoard();
        
    }

    public static Board getInstance(){
        Board result = instance;
        if(result != null){
            return result;
        }
        synchronized(Board.class){
            if(instance == null){
                instance = new Board();
                return instance; 
            }
            return instance;
        }

    }

    public Tile[][] makeBoard(){
        Tile[][] board = new Tile[11][11];
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length;j++){
                if(i == 0 || i == board.length-1){
                    if(i == 0 && j == (((board[i].length)-1) - ((board[i].length)-1))){
                        board[i][j] = new FreeParkingTile(FreeParkingTile.COST,FreeParkingTile.NAME,new Position(i,j),null,null);

                    }
                    else if(i == 0 && j == (board[i].length)-9){
                        board[i][j] = new ChanceTile(ChanceTile.COST,ChanceTile.NAME,new Position(i,j),null,null);

                    }

                    else if( i == 0 &&  j == (board[i].length)-3 ){
                        board[i][j] = new WaterWorkTile(WaterWorkTile.COST,WaterWorkTile.NAME,new Position(i,j),null,null);

                    }
                    else if(i == board.length-1 && j == (((board[i].length)-1) - ((board[i].length)-1))){
                        board[i][j] = new Jail(Jail.COST,Jail.NAME,new Position(i,j),null,null);

                    }
                    else if(i == board.length-1 && j == (board[i].length)-8){
                        board[i][j] = new ChanceTile(ChanceTile.COST,ChanceTile.NAME,new Position(i,j),null,null);

                    }
                    else if(i == board.length-1 && j == (board[i].length)-5){
                        board[i][j] = new TaxTile(TaxTile.COST,TaxTile.NAME,new Position(i,j),null,null);

                    }
                    else if(i == board.length-1 && j == (board[i].length)-3){
                        board[i][j] = new CommunityChest(CommunityChest.COST,CommunityChest.NAME,new Position(i,j),null,null);

                    }

                    else if(i == board.length-1 && j == (board[i].length)-1 ){
                        board[i][j] = new GoTile(GoTile.COST,GoTile.NAME,new Position(i,j),null,null);

                    }

                    else{

                        
                        board[i][j] = new Tile(0,"",new Position(i,j),null,null);
                        this.setCost_N_Name(board[i][j]);


                    }


                   

                }
                else{

                     if(i == 3 && (j == 0 || j == board[i].length -1)){
                        board[i][j] = new CommunityChest(CommunityChest.COST,CommunityChest.NAME,new Position(i,j),null,null);

                    }
                    else if( i == 6 && j == board[i].length -1 ){
                        board[i][j] = new LuxuryTaxTile(LuxuryTaxTile.COST,LuxuryTaxTile.NAME,new Position(i,j),null,null);

                    }

                    board[i][j-j]= new Tile(0,"",new Position(i,j-j),null,null);
                    this.setCost_N_Name(board[i][j-j]);
                    board[i][board[i].length-1 ]= new Tile(0,"",new Position(i,board[i].length-1),null,null);
                    this.setCost_N_Name(board[i][board[i].length-1 ]);
                }
            }
        }

        return board;
    }

    

    /**
     * Creating the string representation of the board.
     */

    public String toString(){

        String res = "";
        

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != null){
                        res += board[i][j].toString();
                        res += " ";

                    
                }
                if(j == (board[i].length-1)){
                    res += "\n";

                }
                else if(board[i][j] == null){
                    res += "  ";
                }

            }
        }
        return res;




    }
    public ArrayList<Pawn> getPawns() {
        return pawns;
    }

    public Pawn getSpecificPawn(){
        return null;

    }
    public Tile[][] getBoard() {
        return board;
    }

    private void setCost_N_Name(Tile t){
        Utility.fillCities1();

        t.setName(Utility.CITIES.get(0));
        t.setCost(Utility.COSTS.get(0));

        Utility.CITIES.remove(0);
        Utility.COSTS.remove(0);


    }



    public void SetPawnPostion(){
        for(int i = 0; i < pawns.size(); i++){
            board[10][10].setPawns(pawns.get(i)); 
            
        }
        
    }

    public void createPawn(int num){
        for(int i = 0; i < num; i++){
            Pawn p = new Pawn("dog",new Position(10, 10));
            pawns.add(p);
        }
    }

    public Tile getTile(Position pos){
        return board[pos.getX()][pos.getY()];
    }


    
}
