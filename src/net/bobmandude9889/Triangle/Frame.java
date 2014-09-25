package net.bobmandude9889.Triangle;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Frame();
	}

	public Frame(){
		
		new JFrame();
		
		this.setSize(800,600);
		this.setTitle("Cube Solver");
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Display display = new Display(this);
		this.add(display);
		this.addMouseListener(display);
	}
	
}
