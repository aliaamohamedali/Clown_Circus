/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Aliaa Abbas
 */
public class View extends JFrame implements ActionListener{
//    World world;
    private static View view;
    public static Strategist strategist;
    public static JButton newGameBtn;
    public static JButton loadGameBtn;
    public static JButton pluginsBtn;
    public static JButton exitBtn;
    public static JButton saveGameBtn;
    //public static SnapShot snapShot;
//    private static ArrayList<World> worlds;
//    private static ArrayList<GameObject> shapes; 
    private int level=0;
    private int score=0;
    private Strategist s;
    GameEngine.GameController gc;
    private View(){
        view = this;
        view.setSize(400,400);
        view.setLayout(new BorderLayout(1, 1));
        s=Strategist.getInstance();
        //this.snapShot = SnapShot.getInstance();
        //this.strategist = Strategist.getInstance();
//        worlds = new ArrayList<>();
//        worlds.add();     // add our World
//        shapes = new arrayList<>()'
//        shapes.add();     // add any shapes we currently have
//        shapes.add();     // add any shapes we currently have
    }
    public static View getInstance(){
        if(view==null){
            view = new View();
        }
        return view;
    }
    
    public void mainMenu(){
        JPanel mainMenu = new JPanel(new GridLayout(4, 1));
        newGameBtn = new JButton("New Game");
        newGameBtn.addActionListener(this);
        loadGameBtn = new JButton("Load Game");
        loadGameBtn.addActionListener(this);
        pluginsBtn = new JButton("Load Plugin");
        pluginsBtn.addActionListener(this);
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(this);
        mainMenu.add(newGameBtn, 0);
       // mainMenu.add(Box.createVerticalStrut(15));
        mainMenu.add(loadGameBtn, 1);
       // mainMenu.add(Box.createVerticalStrut(15));
        mainMenu.add(pluginsBtn, 2);
       // mainMenu.add(Box.createVerticalStrut(15));
        mainMenu.add(exitBtn, 3);
        view.add(mainMenu, BorderLayout.CENTER);
        view.add(new JLabel(), BorderLayout.NORTH);
        view.add(new JLabel(), BorderLayout.EAST);
        view.add(new JLabel(), BorderLayout.SOUTH);
        view.add(new JLabel(), BorderLayout.WEST);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void newGame(){
        JMenuBar  menuBar = new JMenuBar();
	JMenu menu = new JMenu("File");
	JMenuItem newMenuItem = new JMenuItem("New");
	JMenuItem pauseMenuItem = new JMenuItem("Pause");
	JMenuItem resumeMenuItem = new JMenuItem("Resume");
	menu.add(newMenuItem);
	menu.addSeparator();
	menu.add(pauseMenuItem);
	menu.add(resumeMenuItem);
	menuBar.add(menu);
        World cir=new Circuslevel1(700, 486);
        gc = GameEngine.start("Circus On plates", cir, menuBar, Color.BLACK);
	newMenuItem.addActionListener(new ActionListener() {
	@Override public void actionPerformed(ActionEvent e) {
			gc.changeWorld(new Circuslevel1(700, 486));
		}
	});
	pauseMenuItem.addActionListener(new ActionListener() {
	@Override public void actionPerformed(ActionEvent e) {
			gc.pause();
		}
	});
	resumeMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
			gc.resume();
		}
	});
        
    }
    public void updategame(int level){
        if(level==2){
            gc.changeWorld(new Circuslevel2(700,486));
        }
        if(level==3){
            gc.changeWorld(new Circuslevel3(700,486));
        }
    }
    public void loadGame(){
//         SnapShot.load(); 

    }
    
    public void plugin(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Jar files", "jar");
        JFileChooser jFileChooser1 = new JFileChooser();
        jFileChooser1.setFileFilter(filter);
        jFileChooser1.showOpenDialog(null);
        File f = jFileChooser1.getSelectedFile();
        String name = javax.swing.JOptionPane.showInputDialog("Enter Qualified Name: ");
        
        try{
            URL url = f.toURL();
            URL[] urls = new URL[]{url};
            ClassLoader loader = new URLClassLoader(urls); 
            Class myClass = Class.forName(name, true, loader);
//            if(myClass.instanceOf(World){
//               worlds.add(myClass);
//            }
//            else{
//               shapes.add(myClass);
//            }        
        }
        catch (MalformedURLException ex){ Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex); }
        catch (ClassNotFoundException ex){ Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex); }
    }

    public void saveGame(){
//           snapShot.save();
    }

    public void showWorlds(){ 
        int result;
        JPanel panel = new JPanel();
        JLabel msgLbl = new JLabel("Please choose world to load");
        JComboBox worldList = new JComboBox();
//        for(World w : worlds){
//             worldList.addItem(w.getClassName());
//        }
        panel.add(msgLbl);
        panel.add(Box.createVerticalStrut(15));
        panel.add(worldList);
        panel.add(Box.createVerticalStrut(15));
        result = JOptionPane.showConfirmDialog(null, panel, 
               "Available Worlds", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
//           try{
//            Class class = worlds.get(worldList.getSelectedIndex());  
//            Constructor constructor = class.getDeclaredConstructor();
//            constructor.setAccessible(false);
//            world = (World)constructor.newInstance();
//           } catch (NoSuchMethodException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//           } catch (SecurityException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//           } catch (InstantiationException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//           } catch (IllegalAccessException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//           } catch (IllegalArgumentException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//           } catch (InvocationTargetException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//           }
  
///////////// OK IDK HOW TO LINK THIS WITH THE ENGINE CUZ IDK WHAT PARAMETERS IT
//// TAKES BUT THE IDEA IS : THIS.SETVISIBLE(FALSE); AND THEN START THE GAME WITH
//// WHATEVER PARAMETERS
///////////// ALSO I WANT TO ADD THE "SAVE" BUTTON TO THE GAME FRAME ITSELF
///////////// SO MAYBE IF GAME IS ON A FRAME WE CAN INSTEAD REMOVE THE "MAINMENU"
//// PANE;, ADD THE GAME FRAME TO THE "VIEW" FRAME AND ADD THE BUTTON ON IT


//           GameEngine.start();
       }
    }
    @Override
   public void actionPerformed(ActionEvent e){
       s=Strategist.getInstance();
       s.decideAction(e);
   }

}
