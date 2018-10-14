
package eg.edu.alexu.csd.oop.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ScoreCalculator {
    private static ScoreCalculator iter;
    private GameObject so;
   
    public static ScoreCalculator getInstance(){
        if(iter==null)
            return iter;
        return iter;
    }
    public boolean checkResult(Iterator iter){
        Iterator itt=iter;
        GameObject go=null;
        GameObject go2=null;
        GameObject go3=null;
        while(iter.hasNext()){
            go=(GameObject)iter.next();
            if(iter.hasNext()){
                go2=(GameObject)iter.next();
                if(iter.hasNext()){
                    go3=(GameObject)iter.next();
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        BufferedImage bf[]=go.getSpriteImages();
        BufferedImage bf2[]=go2.getSpriteImages();
        BufferedImage bf3[]=go3.getSpriteImages();
        int red1,red2,red3;
        int green1,green2,green3;
        int blue1,blue2,blue3;
        int clr=  bf[0].getRGB(0,0); 
            red1   = (clr & 0x00ff0000) >> 16;
            green1 = (clr & 0x0000ff00) >> 8;
            blue1  =  clr & 0x000000ff;
            //System.out.println(red1+"   "+green1+"    "+blue1);
            clr=  bf2[0].getRGB(0,0); 
            red2   = (clr & 0x00ff0000) >> 16;
            green2 = (clr & 0x0000ff00) >> 8;
            blue2  =  clr & 0x000000ff;
            //System.out.println(red2+"   "+green2+"    "+blue2);
            clr=  bf3[0].getRGB(0,0); 
            red3   = (clr & 0x00ff0000) >> 16;
            green3 = (clr & 0x0000ff00) >> 8;
            blue3  =  clr & 0x000000ff;
            if(red1==red2&&red2==red3&&green1==green2&&green2==green3&&blue1==blue2&&blue2==blue3){
               // System.out.println("hell yeah");
                return true;
            }
 
    return false;
    }
    public boolean checkCondition(int size){
        //System.out.println(count);
        if(size==25){
            //System.out.println("good");
            return false;
        }
        return true;
        
        
        
        
    }
    
    
    
}
