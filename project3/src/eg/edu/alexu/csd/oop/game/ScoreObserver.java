
package eg.edu.alexu.csd.oop.game;

public class ScoreObserver {
    View v;
    int score;
    int level=1;
    private static ScoreObserver so;
    private ScoreObserver(){
        v=View.getInstance();
        
    }
    public static ScoreObserver getinstance(){
        if(so==null)
            so=new ScoreObserver();
        return so;
    }
    public void updatescore(int score){
        this.score=score;
        //System.out.println(score);
        if(score==5&&level!=3){
            score=0;
            updatelevel();
            //System.out.println("workibng");
            v.updategame(level);
        }
    }
    private void updatelevel(){
        level++;
    }
    
}
