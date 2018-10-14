/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Aliaa Abbas
 */
public class Strategist implements Strategy{
    public View view;
    public SnapShot snapShot;
    public static Strategist strategist;
    
    private Strategist(){
        this.view = View.getInstance();
        this.snapShot = SnapShot.getInstance();
    }
    
    public static Strategist getInstance(){
        if(strategist == null){
            strategist = new Strategist();
        }
        return strategist;
    }
    
    @Override
    public void decideAction(ActionEvent e){
       JButton btn = (JButton)e.getSource();        
       if(btn.getText().equals("New Game")){
           this.view.newGame();
       }
       if(btn.getText().equals("Load Game")){
           this.view.loadGame();
       } 
       if(btn.getText().equals("Load Plugin")){
           this.view.plugin();
       } 
       if(btn.getText().equals("Exit")){
           this.view.setVisible(false);
       }
       if(btn.getText().equals("Save game")){
           this.view.saveGame();
       }
    }
}
