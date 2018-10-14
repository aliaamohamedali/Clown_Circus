/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Aliaa Abbas
 */
public class SnapShot {
    private View view;
    private static SnapShot snapShot;

	private SnapShot() {
		// TODO Auto-generated constructor stub
		this.view = View.getInstance();
	}

	public static SnapShot getInstance() {
		if (snapShot == null){
			snapShot = new SnapShot();
                }        
                return snapShot;
	}

public void save() {
    try {
	String name = JOptionPane.showInputDialog(null,
			"Enter your full name: ");
	File file = new File("c:\\" + name + ".ser");
	if (!file.exists()) {
            file.createNewFile();
	}
	FileOutputStream fileOut = new FileOutputStream(file);
	ObjectOutputStream out = new ObjectOutputStream(fileOut);
//	out.writeObject(view.world);
//      int i = view.shapes.size();
//      out.writeObject(i);
//      for(GameObject o : view.shapes){
//      out.writeObject(o);
//      }
	out.close();
	fileOut.close();
	} catch (IOException i) {
		i.printStackTrace();
	}
}

public void load() {
                    
       int result;
       JPanel loadPanel = new JPanel();
       JLabel msgLbl = new JLabel("Please Enter your username."); 
       JTextField userNameField = new JTextField(30);
       loadPanel.add(msgLbl);
       loadPanel.add(Box.createVerticalStrut(15));
       loadPanel.add(userNameField);
       loadPanel.add(Box.createVerticalStrut(15));
       result = JOptionPane.showConfirmDialog(null, loadPanel, 
               "Load Game", JOptionPane.OK_CANCEL_OPTION);
       if(result==JOptionPane.OK_OPTION){
           // Search for file
           // If Found: load Game
           // else: Show error message
           
            try {
		String name = JOptionPane.showInputDialog(null,
					"Enter your full name: ");
		File file = new File("c:\\" + name + ".ser");
		if (!file.exists()) {
		    return;
		}
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fileIn);
/*		try {
		    this.view.world= (World)in.readObject();
                  int i = (Integer)in.readObject();
                  for(int k =0; k<i; k++){
                     view.shapes.add((GameObject)in.readObject());
	        }catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		in.close();
		fileIn.close();
		} catch (IOException i) {
		i.printStackTrace();
		}
       }
	}
}
