/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

/**
 *
 * @author abdullah
 */
public interface Observable {
    void add(Observer o);
    void remove(Observer o);
    void notify(Observer o,int x);
}
