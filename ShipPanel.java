// Matt Fishman
// Partner: Matthew Cucuzza
// SER 210
// Version 1.0 
// Creates a panel in which a ship is displayed and painted 

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer; 

public class ShipPanel extends javax.swing.JPanel {

	// Variables 
	private final MoveableShape shape; 
	private final MoveableShape shape2; 
	private final int DELAY = 50; 
	private static final int SHIP_WIDTH = 250;
	private static final int PANEL_WIDTH = 750;
	private static final int PANEL_HEIGHT = 550;
	
	// Constructor creating the JPanel 
	public ShipPanel() { 
		super(); 
		this.setBackground(java.awt.Color.white); 
		this.setPreferredSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		
		// Creates the two spaceship objects 
		shape = new SpaceShip(10, 50, SHIP_WIDTH, this);
		shape2 = new SpaceShip(50, 10, SHIP_WIDTH, this);
		
		// Creates the timer and how the ship will translate across the screen 
		Timer t = new Timer (DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				shape.translate(5, 5);
				shape2.translate(10, 10);
				repaint();
			}
		});
		
		// starts the timer 
		t.start();
	}
	
	// Method to paint the spaceship onto the screen 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;
		shape.draw(brush);
		shape2.draw(brush);
	}
}
