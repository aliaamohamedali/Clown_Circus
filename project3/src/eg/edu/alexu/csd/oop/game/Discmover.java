/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.util.ArrayList;

/**
 *
 * @author abdullah
 */
public class Discmover implements Observer{
    
    ArrayList arr;
    //GameObject clown;
    public Discmover(){
    arr=new ArrayList();
    //this.clown=clown;
}
    @Override
    public void update(int x) {
        for(int i=0;i<arr.size();i++){
            GameObject go=(GameObject)arr.get(i);
            go.setX(go.getX()+x);
        }
    }
    public void addDiscs(GameObject go){
        arr.add(go);
    }    
}
