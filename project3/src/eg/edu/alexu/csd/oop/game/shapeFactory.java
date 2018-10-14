
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;


public class shapeFactory {
    private static final HashMap<Color, Shape> rectsByColor = new HashMap<Color, Shape>();
    private static Color color;
    public static Shape getShape(Color color, String name) {
        
        Shape sh = (Shape)rectsByColor.get(color);
        if(sh == null&&name.equals("Dish")) {
            sh = new Dish(color);
            rectsByColor.put(color, sh);
        }
        return sh;
    }
    public void setColor(Color color){
        this.color=color;
    }

}
