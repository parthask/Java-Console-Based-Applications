package javaapp;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class DigitalClock extends JFrame {
	WatchPanel watch= new WatchPanel();
	public DigitalClock(){
		super("Digital Clock By PARTHA_SARATHI");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane= new JPanel();
		pane.setLayout(new GridLayout(1,1,15,15));
		pane.add(watch);
		setContentPane(pane);
		extracted();
	}


	private void extracted() {
		show();
	}
	public static void main(String[] args) {
		new DigitalClock();
	}
}

class WatchPanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	Thread runner;
	public WatchPanel() {
		if(runner==null){
			runner= new Thread(this);
			runner.start();
		}
	}
	public void run (){
		While (true);{
			repaint();
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	private void While(boolean b) {
		// TODO Auto-generated method stub		
	}
	public void paintComponent(Graphics component){
		Graphics2D component2D=(Graphics2D)component;
		Font type = new Font ("Serif", Font.CENTER_BASELINE, 24);
		component2D.setFont(type);
		component2D.setColor(getBackground());
		component2D.fillRect(100, 500, getSize().width,getSize().height );
		GregorianCalendar day = new GregorianCalendar();
		String time = day.getTime().toString();
		component2D.setColor(Color.BLUE);
		component2D.drawString(time, 10, 50);


	}



}