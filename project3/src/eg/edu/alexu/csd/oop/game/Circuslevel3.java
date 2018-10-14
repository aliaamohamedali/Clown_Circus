package eg.edu.alexu.csd.oop.game;


import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class Circuslevel3 implements World{
    private static int MAX_TIME = 1 * 60 * 1000;
    ArrayList arr1=new ArrayList();
    ArrayList arr2=new ArrayList();
   private static Color[] shapeColor = {Color.orange, Color.red, Color.yellow,
            Color.blue, Color.pink, Color.cyan, Color.magenta,
            Color.black, Color.gray};
    private int count=0;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private int screenwidth;
    private int screenheight;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private final List<GameObject> shapecontrol1 = new LinkedList<GameObject>();
    private final List<GameObject> shapecontrol2 = new LinkedList<GameObject>();
    private ScoreCalculator st1;
    private ScoreCalculator st2;
    private Color RandColor;
    private Observable ob;
    private Discmover observer;
    int clownposition;
     private ScoreObserver so;
     private final int level3=3;
    
    public Circuslevel3(int screenwidth, int screenheight){
        observer=new Discmover();
        ob= new MoveAnnouncer(observer);
        st1=new ScoreCalculator();
        st2=new ScoreCalculator();
        this.screenwidth=screenwidth;
        this.screenheight=screenheight;
        control.add(new ImageObject(screenwidth/3, (int)(screenheight*0.7), "clown.png"));
        ImageObject stick1=new ImageObject(250, (int)(screenheight*0.6), "stick.png");
        ImageObject stick2=new ImageObject(330, (int)(screenheight*0.6), "stick.png");
        observer.addDiscs(stick1);
        observer.addDiscs(stick2);
        clownposition=control.get(0).getX();
        Random randomGenerator = new Random();
        for(int i=0; i<30; i++){
            RandColor=this.getRandColor();
            moving.add(new ShapeObject(0, 0, "Dish", 50,5,RandColor ));
           moving.get(i).setY(-1 * (int)(Math.random() * screenwidth));
            moving.get(i).setX((int)(Math.random() * screenheight));
            
        }
       constant.add(new ImageObject(0, 0, "stage.png"));
       constant.add(stick1);
       constant.add(stick2);
       shapecontrol1.add(constant.get(1));
         shapecontrol2.add(constant.get(2));
         so=ScoreObserver.getinstance();
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return screenwidth;
    }

    @Override
    public int getHeight() {
        return screenheight;
    }

    @Override
    public boolean refresh() {
        GameObject clown= control.get(0);
        GameObject stick1= constant.get(1);
         GameObject stick2= constant.get(2);
        for(int i=0;i<moving.size();i++){
         
			moving.get(i).setY((moving.get(i).getY() + 1));
			if(moving.get(i).getY()==getHeight()){
				
                                moving.remove(moving.get(i));
			}
		}
        for(int i=0;i<moving.size();i++){
            for(int j=1;j<constant.size();j++){
                        if(intersect(moving.get(i), constant.get(j))&&shapecontrol1.contains(constant.get(j))){
                            observer.addDiscs(moving.get(i));
                            arr1.add(moving.get(i));
                            if(constant.get(j)==stick1){
                            moving.get(i).setX(constant.get(j).getX()-20);
                                    break;
                            }
                            else{
                                moving.get(i).setX(constant.get(j).getX());
                            }
			}
                        if(intersect(moving.get(i), constant.get(j))&&shapecontrol2.contains(constant.get(j))){
                            observer.addDiscs(moving.get(i));        
                            arr2.add(moving.get(i));
                            if(constant.get(j)==stick2){
                            moving.get(i).setX(constant.get(j).getX()-20);
                            }
                            else{
                                moving.get(i).setX(constant.get(j).getX());
                            }
                                    break;
			}
            }
                        }
   
        
        int value=control.get(0).getX()-clownposition;
        clownposition=control.get(0).getX();
        ob.notify(observer, value);
        
        for(int i=0;i<arr1.size();i++){
            moving.remove((GameObject)arr1.get(i));
            shapecontrol1.add((GameObject)arr1.get(i));
            constant.add((GameObject)arr1.get(i));
            
        }
        for(int i=0;i<arr2.size();i++){
            moving.remove((GameObject)arr2.get(i));
            shapecontrol2.add((GameObject)arr2.get(i));
            constant.add((GameObject)arr2.get(i));
        }
        arr1.clear();
        arr2.clear();
        for(int i=moving.size(); i<30; i++){
            RandColor=this.getRandColor();
            moving.add(new ShapeObject(0, 0, "Dish", 50,5,RandColor ));
            moving.get(i).setY(-1 * (int)(Math.random() * getHeight()));
            moving.get(i).setX((int)(Math.random() * getWidth()));
        }
        boolean t1=false,t2=false;
        
        Iterator iter=shapecontrol1.iterator();
        Iterator iter2=shapecontrol2.iterator();
        if(shapecontrol1.size()>=4){
        //System.out.print("shit");
        //Iterator iter=shapecontrol1.iterator();
        t1=st1.checkResult(iter);
        } 
        if(shapecontrol2.size()>=4){
        //System.out.print("two");
        t2=st2.checkResult(iter2);
        } 
        if(t1){
            int size=shapecontrol1.size();
            constant.remove(shapecontrol1.get(size-1));
            constant.remove(shapecontrol1.get(size-2));
            constant.remove(shapecontrol1.get(size-3));
            shapecontrol1.remove(shapecontrol1.get(size-1));
            shapecontrol1.remove(shapecontrol1.get(size-2));
            shapecontrol1.remove(shapecontrol1.get(size-3));
            score++;
            so.updatescore(score);
        }
        if(t2){
            int size=shapecontrol2.size();
            constant.remove(shapecontrol2.get(size-1));
            constant.remove(shapecontrol2.get(size-2));
            constant.remove(shapecontrol2.get(size-3));
            shapecontrol2.remove(shapecontrol2.get(size-1));
            shapecontrol2.remove(shapecontrol2.get(size-2));
            shapecontrol2.remove(shapecontrol2.get(size-3));
            score++;
            so.updatescore(score);
            //shapecontrol2.remove(shapecontrol2.get(shapecontrol2.size()-3));
        }
        return st1.checkCondition(shapecontrol1.size())&&st2.checkCondition(shapecontrol2.size());
        
    }


    @Override
    public String getStatus() {
    return "Score="+score+" | Level="+level3;   
// return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis()-startTime))/1000);
    }

    @Override
    public int getSpeed() {
        return 5;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }
    private boolean intersect(GameObject o1, GameObject o2){
        
        Rectangle src1 = new Rectangle(o1.getX(), o1.getY(), o1.getWidth(), o1.getHeight());
        Rectangle src2 = new Rectangle(o2.getX(), o2.getY(), o2.getWidth(), 2);
        Rectangle dest = new Rectangle();
        Rectangle.intersect(src1, src2, dest);
        if(dest.getWidth() > 0 && dest.getHeight() > 0){
            return true;
        
        }
        return false;
}
    private static Color getRandColor(){
        Random randomGenerator = new Random();
        int randInt = randomGenerator.nextInt(9);
        return shapeColor[randInt];

    }
}
