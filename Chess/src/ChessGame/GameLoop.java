package ChessGame;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameLoop {
	static final int UPDATE_RATE = 4;
	static final long UPDATE_PERIOD = 1000000000L / UPDATE_RATE;
	private static JFrame frame;

	
	public static void display(){
		frame = new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game.addBoard(frame);
		frame.setSize(640, 704);
		frame.setJMenuBar(getMenu());
		frame.addMouseListener(Game.getMouse(frame));
		frame.setVisible(true);
		
	}
	
 //game loop source:http://www3.ntu.edu.sg/home/ehchua/programming/java/J8d_Game_Framework.html
	public static void main(String[] args) {
		Game.initialize();
		display();
		
		long beginTime, timeTaken, timeLeft;
		while (true) {
			beginTime = System.nanoTime();
			
			// Refresh the display
			frame.repaint();
			
			// Delay timer to provide the necessary delay to meet the target rate
			timeTaken = System.nanoTime() - beginTime;
			timeLeft = (UPDATE_PERIOD - timeTaken) / 1000000;
			if (timeLeft < 10)
				timeLeft = 10;// set a minimum
			try {
				 // Provides the necessary delay and also yields control so that other thread can do work.
				Thread.sleep(timeLeft);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static JMenuBar getMenu() {
		JMenuBar menuBar;
		JMenu menu;
		ActionListener actionlistener = Game.getButtonListener(frame);
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		JMenuItem menuitem = new JMenuItem("Undo");
		menuitem.setActionCommand("Undo");
		menuitem.addActionListener(actionlistener);
		menu.add(menuitem);
		
		menuitem = new JMenuItem("Forfeit");
		menuitem.setActionCommand("Forfeit");
		menuitem.addActionListener(actionlistener);
		menu.add(menuitem);
		
		menuitem = new JMenuItem("Restart");
		menuitem.setActionCommand("Restart");
		menuitem.addActionListener(actionlistener);
		menu.add(menuitem);
		
		menuitem = new JMenuItem("Show scores");
		menuitem.setActionCommand("Scores");
		menuitem.addActionListener(actionlistener);
		menu.add(menuitem);
		menuBar.add(menu);
		
		menuBar.setSize(640, 10);
		return menuBar;
	}
}
