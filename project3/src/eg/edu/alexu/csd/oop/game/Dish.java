
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Dish implements Shape{

    private Color colour = Color.black;
    
    public Dish(Color colour){
    this.colour=colour;
    }

    @Override
    public void draw(Graphics2D g,int x,int y, int length, int height) {
        Random rand=new Random();
        int xx=rand.nextInt(600);
        //g.setColor(Color.RED);
       // g.fillOval(xx,y, 100, 20);
        g.setColor(colour);
        g.drawLine(x, y, length, height);
      //  g.drawOval(x, y*3, length, height);
        //g.drawOval(x, y*3, length, height);
        //g.fillOval(x, y, length, height);
        //g.fillRect(xx,y,20,5);
        //System.out.println(length);
        //g.fillRect(, upperY, lowerX, lowerY);

    }
    
    
    
}
