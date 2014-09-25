package net.bobmandude9889.Triangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle {
	
	Point p1;
	Point p2;
	Point p3;
	
	public Triangle(Point p1, Point p2, Point p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public Triangle(Point p1){
		this.p1 = p1;
	}
	
	public void setP1(Point p){
		this.p1 = p;
	}
	
	public void setP2(Point p){
		this.p2 = p;
	}
	
	public void setP3(Point p){
		this.p3 = p;
	}
	
	public void render(Graphics g, Color c){
		Color s = g.getColor();
		g.setColor(c);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
		g.drawLine(p2.x, p2.y, p3.x, p3.y);
		g.drawLine(p3.x, p3.y, p1.x, p1.y);
		g.setColor(s);
	}
	
	public void renderMidsegment(Graphics g, Color c){
		Color s = g.getColor();
		g.setColor(c);
		g.drawLine(findMidpoint(p1,p2).x, findMidpoint(p1,p2).y, findMidpoint(p2,p3).x, findMidpoint(p2,p3).y);
		g.drawLine(findMidpoint(p2,p3).x, findMidpoint(p2,p3).y, findMidpoint(p3,p1).x, findMidpoint(p3,p1).y);
		g.drawLine(findMidpoint(p3,p1).x, findMidpoint(p3,p1).y, findMidpoint(p1,p2).x, findMidpoint(p1,p2).y);
		g.setColor(s);
	}
	
	private Point findMidpoint(Point p1, Point p2){
		Point p = new Point(0,0);
		p.setLocation((p1.x > p2.x ? p1.x : p2.x) - (Math.abs(p1.x - p2.x) / 2),(p1.y > p2.y ? p1.y : p2.y) - (Math.abs(p1.y - p2.y) / 2));
		return p;
	}
	
}
