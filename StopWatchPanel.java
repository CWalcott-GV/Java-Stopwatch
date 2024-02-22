package projPack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description  here.
 * 
 * @author Corey & Wilson
 * @version January 31, 2021
 */
public class StopWatchPanel extends JPanel{
	
	private StopWatch watch;
    private Timer javaTimer;
	
	private JButton startButton, stopButton;
	private JTextField minField, secField, milliField, addField, subField, newField;
	private JButton saveButton, loadButton, addButton, subButton, newButton, continueButton;


	JLabel lblTime;

	public StopWatchPanel(){ 


		watch = new StopWatch();
		javaTimer = new Timer(5, new TimerListener());

		setLayout(new GridLayout(10,2));
		setBackground(Color.lightGray);


		add(new JLabel("Minutes:"));
		minField = new JTextField("0", 3);
		add(minField);

		add(new JLabel("Seconds:"));
		secField = new JTextField("0", 3);
		add(secField);

		add(new JLabel("Miliseconds:"));
		milliField = new JTextField("0", 3);
		add(milliField);
		startButton = new JButton("Start");
		add(startButton);

		stopButton = new JButton("Stop");
		add(stopButton);

		saveButton = new JButton("Save");
		add(saveButton);

		loadButton = new JButton("Load");
		add(loadButton);

		addButton = new JButton("Add");
		add(addButton);

		addField = new JTextField("0");
		add(addField);

		subButton = new JButton("Subtract");
		add(subButton);

		subField = new JTextField("0");
		add(subField);

		newButton = new JButton("New");
		add(newButton);

		newField = new JTextField("0:00:000");
		add(newField);

		continueButton = new JButton("Continue");
		add(continueButton);

		add (new JLabel(" "));

		add(new JLabel("Time:"));
		lblTime = new JLabel();
		lblTime.setText(watch.toString());
		add(lblTime);


		startButton.addActionListener(new ButtonListener());
		stopButton.addActionListener(new ButtonListener());
		saveButton.addActionListener(new ButtonListener());
		loadButton.addActionListener(new ButtonListener());
		addButton.addActionListener(new ButtonListener());
		subButton.addActionListener(new ButtonListener());
		newButton.addActionListener(new ButtonListener());
		continueButton.addActionListener(new ButtonListener());


	}

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent event){

			int mins, sec, milli;

			if (event.getSource() == startButton){
				try{
					mins = Integer.parseInt(minField.getText());
					sec = Integer.parseInt(secField.getText());
					milli = Integer.parseInt(milliField.getText());
					watch = new StopWatch(mins,sec,milli);
					javaTimer.start();
				}catch(NumberFormatException io){
					JOptionPane.showMessageDialog(null,"Enter an integer in all fields");
				}catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,"Error in field");
				}
			}

			if(event.getSource() == stopButton){
				javaTimer.stop();
			}
			if (event.getSource() == saveButton) {
				try {
					String fileNameSave = JOptionPane.showInputDialog("Enter File Name");
					watch.save(fileNameSave);

				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Invalid File Name");
				}
			}

			if (event.getSource() == loadButton){
				try{
					String fileNameLoad = JOptionPane.showInputDialog("Enter File Name");
					watch.load(fileNameLoad);
				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,"Invalid File Name");
				}
			}

			if (event.getSource() == addButton){
				try {
					StopWatch s1 = new StopWatch(addField.getText());

					watch.add(s1);
				}
				catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Math Error");
				}
			}

			if (event.getSource() == subButton){

				try {
					StopWatch s1 = new StopWatch(subField.getText());

					watch.sub(s1);
				}
				catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Math Error");
				}
			}

			if (event.getSource() == newButton){

				try {
					watch = new StopWatch(newField.getText());
				}
				catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Please enter valid StopWatch input");
				}
			}

			if (event.getSource() == continueButton){
				javaTimer.start();
			}


			lblTime.setText(watch.toString());
		}

	}
	
	private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	watch.add(5);

        	lblTime.setText(watch.toString());
        }
	}
}
