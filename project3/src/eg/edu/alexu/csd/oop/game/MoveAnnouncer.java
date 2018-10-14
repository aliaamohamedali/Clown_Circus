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
public class MoveAnnouncer implements Observable{
    
    private ArrayList arr;
    public MoveAnnouncer(Observer o){
        arr=new ArrayList();
        arr.add(o);
    }
    
    
    
    @Override
    public void add(Observer o) {
        
        arr.add(o);
        
    }

    @Override
    public void remove(Observer o) {
        arr.remove(o);
    }

    @Override
    public void notify(Observer o,int x) {
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==o){
                o.update(x);
                break;
            }
        }
        
    }
    
}
