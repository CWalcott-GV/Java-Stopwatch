package projPack1;

import javax.swing.*;

public class StopWatchGUI {
	public static void main(String arg[]){

		JMenu fileMenu;
		 JMenuItem quitItem, suspendItem;
		JMenuBar menus;

		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("Quit");
		suspendItem = new JCheckBoxMenuItem("suspend");
		fileMenu.add(suspendItem);
		fileMenu.add(quitItem);
		menus = new JMenuBar();

		menus.add(fileMenu);

		JFrame gui = new JFrame("Stop Watch");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StopWatchPanelMain panel = new StopWatchPanelMain(quitItem);
		gui.getContentPane().add(panel);

		gui.setSize(700,500);
		gui.setJMenuBar(menus);
		gui.pack();
		gui.setVisible(true);
	}



}
