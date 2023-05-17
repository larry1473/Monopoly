package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
//import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

import board.Board;
import board.Tile;
//import board.Utility;

public class Graphical extends JFrame implements ItemListener{

    private Tile[][] board;
    private Board b;
    private GridBagConstraints c;
    private GridBagConstraints c2;
    private Dimension TileSize = new Dimension(55, 55);
    //private Dimension basePanelDimension = new Dimension(500, 500);
    private Dimension windowDimension = new Dimension(100, 100);
    private static final long serialVersionUID = 1L;
    private String name;
    private String selectedPawn = "";
    private static final String player1Pawn = "";
    private static final String player2Pawn = "";
    private JComboBox jComboBox;
    private JFrame frame; 

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
        c2 = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.setSize(windowDimension);
        this.getContentPane().setBackground(Color.gray);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGuiBoard(); // Creates the board when this class is called.
        this.setLocationRelativeTo(null);
        this.pack();
        this.selectPawnFrame();
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
                else{
                    JPanel tile = new JPanel();
                    tile.setBackground(Color.ORANGE);
                    c2.fill = GridBagConstraints.BOTH;
                    
                    tile.setPreferredSize(TileSize);
                    c2.gridx = i;
                    c2.gridy = j;
                    c2.insets = new Insets(0,0,0,0);
                    this.add(tile,c2);
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

    

    private JFrame selectPawnFrame(){
        String[] pawns = {" ","Dog","boat","car"};
        this.frame = new JFrame();
        JPanel panel = new JPanel();
        this.frame.setSize(400,300);
        JLabel promptMessage = new JLabel("Please select a pawn");
         jComboBox = new JComboBox<>(pawns);
        jComboBox.addItemListener(this);
        panel.add(promptMessage);
        panel.add(jComboBox);
        this.selectedPawn =(String) jComboBox.getSelectedItem();
        this.frame.add(panel);
        this.frame.show();
        return this.frame;


    }

    //private void re

    private class TileMaker extends JPanel implements MouseListener{

        private JLabel name;

        private  TileMaker(Tile tile){

            if(tile.getPawn1() == null && tile.getPawn2() == null){
                this.name = new JLabel(tile.getName());
                this.add(name);
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == jComboBox){
            this.selectedPawn = (String) jComboBox.getSelectedItem();
            
        }
        // closes the pawn selection frame after the selection of the pawn
        if(! this.selectedPawn.equals(" ")){
            this.frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        
    }
    
    
}
