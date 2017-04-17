/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiboclock;

/**
 *
 * @author sourav
 */

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FibonacciClock {
	private final JFrame frame;
	private final JPanel panel;
	private final JLabel labelFive;
	private final JLabel labelThree;
	private final JLabel labelTwo;
	private final JLabel labelOneUp;
	private final JLabel labelOneDown;
        private final JLabel labelForShadow;
	
	private Color colorForMinitue;
	private Color colorForHour;
	private Color colorForMinitueAndHour;
	private Color neutralColor;
	
	FibonacciClock() {
            frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panel = (JPanel) frame.getContentPane();
	    panel.setLayout(null);
            
            frame.setTitle("Fibonacci Clock");
            javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
            frame.setResizable(false);
	    
	    labelFive = new JLabel();
            labelFive.setBorder(border);
	    labelThree = new JLabel();
            labelThree.setBorder(border);
	    labelTwo = new JLabel();
            labelTwo.setBorder(border);
	    labelOneUp = new JLabel();
            labelOneUp.setBorder(border);
	    labelOneDown = new JLabel();
            labelOneDown.setBorder(border);
            
            labelForShadow = new JLabel();

	    frame.setSize(800,750);
	    frame.setVisible(true);
            
            colorForHour = new Color(128,0,0); //maroon
            colorForMinitue = new Color(0,128,64); //moss 
            colorForMinitueAndHour = new Color(0,64,128); //ocean
            neutralColor = Color.LIGHT_GRAY;
	}
	
	public void createTheClock() {
	    createBox(labelFive,new Rectangle(300, 0, 500, 500),Color.red);
	    createBox(labelThree,new Rectangle(0, 200, 300, 300),Color.blue);
	    createBox(labelTwo,new Rectangle(0, 0, 200, 200),Color.cyan);
	    createBox(labelOneUp,new Rectangle(200, 0, 100, 100),Color.gray);
	    createBox(labelOneDown,new Rectangle(200, 100, 100, 100),Color.black);
            
            createShadow(labelForShadow,new Rectangle(350, 500, 250, 100),Color.black);
	}
	
	public void startRunning() {
		Timer timer = new Timer();

		timer.schedule( new TimerTask() {
		    public void run() {
		    	colorTheBoxes(new Date());
                        repositionTheShadow(new Date());
		    }
		 }, 0, 1000);
	}
	
        @SuppressWarnings("empty-statement")
	private void colorTheBoxes(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR);
		hour = hour==0 ? 12:hour;
		int minitue = calendar.get(Calendar.MINUTE)/5;
                //calendar.get(Calendar.SECOND)/5;
                
                System.out.println("************************");
                System.out.println("hour "+hour);
		System.out.println("minute "+minitue);
                
                changeColorOfBox(labelFive,neutralColor);
                changeColorOfBox(labelThree,neutralColor);
                changeColorOfBox(labelTwo,neutralColor);
                changeColorOfBox(labelOneUp,neutralColor);
                changeColorOfBox(labelOneDown,neutralColor);
                
                //hour = minitue;
//                hour = 1;
                
                if(hour>=5){
                    changeColorOfBox(labelFive,colorForHour);
                    hour -= 5;
                }
                if(hour>=3){
                    changeColorOfBox(labelThree,colorForHour);
                    hour -= 3;
                }
                if(hour>=2){
                    changeColorOfBox(labelTwo,colorForHour);
                    hour -= 2;
                }
                if(hour>=1){
                    changeColorOfBox(labelOneUp,colorForHour);
                    hour -= 1;
                }
                if(hour>=1){
                    changeColorOfBox(labelOneDown,colorForHour);
                    hour -= 1;
                }
                
                ArrayList al = new ArrayList();
                
                if(minitue>=5 ){
                    if(minitue<8 && labelFive.getBackground() == colorForHour){
                        ;
                    }
                    else if(labelFive.getBackground() == colorForHour){
                        changeColorOfBox(labelFive,colorForMinitueAndHour); 
                        minitue -= 5;
                        al.add(5);
                    }
                    else {
                        changeColorOfBox(labelFive,colorForMinitue);
                        minitue -= 5;
                        al.add(5);
                    }
                    
                }
                if(minitue>=3){
                    if(minitue<5 && labelThree.getBackground() == colorForHour){
                        ;
                    }
                    else if(labelThree.getBackground() == colorForHour){
                        changeColorOfBox(labelThree,colorForMinitueAndHour);
                        minitue -= 3;
                        al.add(3);
                    }
                    else {
                        changeColorOfBox(labelThree,colorForMinitue);
                        minitue -= 3;
                        al.add(3);
                    }
                    
                }
                if(minitue>=2){
                    if(minitue < 3 && labelTwo.getBackground() == colorForHour){
                        ;
                    }
                    else if(labelTwo.getBackground() == colorForHour){
                        changeColorOfBox(labelTwo,colorForMinitueAndHour);
                        minitue -= 2;
                        al.add(2);
                    }
                    else {
                        changeColorOfBox(labelTwo,colorForMinitue);
                        minitue -= 2;
                        al.add(2);
                    }
                    
                }
                if(minitue>=1){
                    if(minitue < 2){
                        ;
                    }
                    else if(labelOneUp.getBackground() == colorForHour){
                        changeColorOfBox(labelOneUp,colorForMinitueAndHour);
                        minitue -= 1;
                        al.add(1);
                    }
                    else {
                        changeColorOfBox(labelOneUp,colorForMinitue);
                        minitue -= 1;
                        al.add(1);
                    }
                    
                }
                if(minitue>=1){
                    if(labelOneDown.getBackground() == colorForHour){
                        changeColorOfBox(labelOneDown,colorForMinitueAndHour);
                        minitue -= 1;
                        al.add(1);
                    }
                    else {
                        changeColorOfBox(labelOneDown,colorForMinitue);
                        minitue -= 1;
                        al.add(1);
                    }
                    
                }
                System.out.print(al);
	}
        
        private void repositionTheShadow(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR);
		hour = hour==0 ? 12:hour;
		int minute = calendar.get(Calendar.MINUTE);
                float second = (float) (calendar.get(Calendar.SECOND)*1.0/5);
                int hour_of_day = calendar.get(Calendar.HOUR_OF_DAY);
                hour_of_day = 11;
                //minute = 1;
                
                if(hour_of_day<6 || hour_of_day >=18) {
                    changeTheShadow(labelForShadow,new Rectangle(0, 500, 250, 800),new Color(0,0,0,255));
                    return;
                }
                
                
                //Time var 6PM = 0 to 6AM = 12
                float time_var = hour_of_day - 6 + (float)1.0*minute/60;
                float sun_multiplier =   (float) ((float) Math.log(Math.abs(6-time_var)+2.0)/Math.log(2));
                
                System.out.println("------------------------------------");
                System.out.println("time_var "+time_var);
                System.out.println("sun_multiplier "+sun_multiplier);
                
                changeTheShadow(labelForShadow,new Rectangle((int) ((660/12)*time_var), 500, 250, (int) (sun_multiplier*50)),new Color(0,0,0, (int) (255 - 70*(sun_multiplier-1))));
        }
	
	private void createBox(JLabel label,Rectangle bounds,Color color) {
	    panel.add(label);
	    label.setBounds(bounds.x, bounds.y, bounds.height, bounds.width);
	    label.setBackground(color);
	    label.setOpaque(true);
	}
        
        private void createShadow(JLabel label,Rectangle bounds,Color color) {
	    panel.add(label);
	    label.setBounds(bounds.x, bounds.y, bounds.height, bounds.width);
	    label.setBackground(color);
	    label.setOpaque(true);
	}
	
	private void changeColorOfBox(JLabel label,Color color) {
		label.setBackground(color);
	}
        
        private void changeTheShadow(JLabel label,Rectangle bounds,Color color) {
            label.setBounds(bounds.x, bounds.y, bounds.height, bounds.width);
	    label.setBackground(color);
        }
}

