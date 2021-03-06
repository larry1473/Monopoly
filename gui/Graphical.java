package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
//import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

import board.Board;
import board.Tile;
//import board.Utility;

public class Graphical extends JFrame {

    private Tile[][] board;
    private Board b;
    GridBagConstraints c;
    private Dimension TileSize = new Dimension(90, 90);
    //private Dimension basePanelDimension = new Dimension(500, 500);
    private Dimension windowDimension = new Dimension(350, 350);
    private static final long serialVersionUID = 1L;

    /**
     * @author Fotso Larry
     * this class will take care of all the graphics of the game.
     */

    public Graphical() {

        this.b = Board.getInstance();
        this.board = b.getBoard();
        System.out.print(b);
        //testBoardEmptyness();
        this.setTitle("MONOPOLY");
        c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.setSize(windowDimension);
        this.getContentPane().setBackground(Color.gray);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGuiBoard(); // Creates the board when this class is called.
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        
        
    }



    /**
     * This method creats the Gui board.
     *  
     * */ 
    public void  createGuiBoard(){



        for (int i = 0; i< board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                

                if(board[i][j] != null){
                    

                    //JPanel tile = new JPanel();
                    TileMaker graphicTile = new TileMaker(board[i][j]); // creates the graphic representation of  a object.
                    JPanel tile = graphicTile.getTilePanel(); // Getting the graphic tile. 
                    //tile.setPreferredSize(TileSize);
                    c.gridx = i; // Helps to specify the x position  of every tile on the frame.
                    c.gridy = j; // Helps to specify the x position  of every tile on the frame.
                    c.insets = new Insets(0,2,3,2); // Creates space between the tiles on the frame. 
                    this.add(tile,c); // adds the tiles "JPanel" to the frame 
                    
                    
                }

                

            }
        }


    }

    /**
     * Create a tile representation.
     * @return a graphical tile 
     */

    public JPanel createTile(){
        JPanel tile = new JPanel();
        tile.setForeground(Color.white);
        tile.setBackground(Color.gray);
        tile.setPreferredSize(TileSize);
        
       

        return tile;
    }

    public void testBoardEmptyness(){
        for (int i = 0; i < this.board.length;i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != null && board[i][j].getPawns().size() != 0 ){
                    System.out.println("a pawn is prensent on tile "+ i + "" + j);
                }
            }
        }
    }

    //private void re

    private class TileMaker extends JPanel{

        private  TileMaker(Tile tile){

            if(tile.getPawn1() == null && tile.getPawn2() == null){
                this.setPreferredSize(TileSize);
                this.setBackground(Color.white);
                this.setForeground(Color.white);
            }
            else if(tile.getPawns().size() != 0){
                this.setPreferredSize(TileSize);
                this.setBackground(Color.blue);
                this.setForeground(Color.blue);

            }


        }

        private JPanel getTilePanel(){
            return this;
        }


    }
    
    
}
