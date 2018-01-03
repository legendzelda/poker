package com.zelda.fightlandords.servers;

import com.zelda.fightlandords.frame.MainFrame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BoomTheard extends Thread{

	
	public void run() {
		JLabel boom=new JLabel();
		boom.setIcon(new ImageIcon(MainFrame.class.getClassLoader().getResource("image/boom400.gif")));
		boom.setBounds(210, 50, 400, 400);
		MainFrame.mainFrame.add(boom);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			MainFrame.mainFrame.remove(boom);
		}
		MainFrame.mainFrame.remove(boom);
		MainFrame.mainFrame.repaint();
	}

}
