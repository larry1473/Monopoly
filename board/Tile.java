package board;

import java.util.ArrayList;

import pawn.Pawn;
import pawn.Position;
/**
 * @author Larry Fotso
 */
public class Tile {

    protected String name;
    protected Pawn pawn1;
    protected Pawn pawn2;
    protected ArrayList<Pawn> pawns;
    protected int cost;
    protected int reductionMoney; // money the player pays when going through a certain tile.


    private Position pos;

    public Tile(int cost , String name , Position pos,Pawn pawn1, Pawn pawn2){
        this.pos = pos;
        this.cost = cost;
        this.name = name;
        this.pawn1 = pawn1;
        this.pawn2 =pawn2;
        pawns = new ArrayList<>();
        insertPawns();

    }

    public Position getPos() {
        return pos;
    }
    
    public void insertPawns(){
        for(int i = 0; i<2; i++){
            if(pawn1 != null){
                pawns.add(pawn1);
            }
            if(pawn2 != null){
                pawns.add(pawn2);
            }
        }
    }
    

    public int getCost() {
        return cost;
    }

    public void placePawn(Pawn pawn1, Pawn pawn2 ){
        this.pawn1 = pawn1;
        this.pawn2 = pawn2;

    }

    public String getName() {
        return name;
    }

    public int getReductionMoney() {
        return reductionMoney;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Tile getTile(Position pos){
        if(this.pos == pos){
            return this;
        }

        return null;

    }

    public ArrayList<Pawn> getPawns() {
        return pawns;
    }
    public Pawn getPawn1() {
        return pawn1;
    }
    public Pawn getPawn2() {
        return pawn2;
    }

    public void setPawns(Pawn pawn) {
        this.pawns.add(pawn);
        System.out.println(pawns.size());

    }

    public String toString(){
        if(this.pawns.size() != 0 ) {
            return "x";
        }
        else{
            return "_";
        }
    }

}
