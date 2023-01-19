package gui;
// import java.awt.Dimension;

import javax.swing.JOptionPane;


public class ChoosePawn {

    private String playerPawn;
    private String[] pawns = {"Dog","boat","car"};

    public ChoosePawn(){
        this.playerPawn = (String) JOptionPane.showInputDialog(null,"Please choose a pawns" ,this.pawns);

    }

    public String getPlayerPawn(){
        return this.playerPawn;
    }

   
}
