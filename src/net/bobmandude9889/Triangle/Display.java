package net.bobmandude9889.Triangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Display extends JPanel implements Runnable, MouseListener {
	private static final long serialVersionUID = 1L;

	Frame frame;

	Thread thread = new Thread(this);

	Triangle t;

	List<Triangle> triangles = new ArrayList<Triangle>();
	List<Point> points = new ArrayList<Point>();

	private int trianglePoint = 0;

	public Display(Frame frame) {
		this.frame = frame;

		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
		g.setColor(Color.MAGENTA);
		for (Triangle t : triangles) {
			t.render(g, Color.BLACK);
			t.renderMidsegment(g, Color.BLUE);
		}
		for (Point p : points) {
			g.fillOval(p.x - 5, p.y - 5, 10, 10);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			if (trianglePoint == 0) {
				Point p = e.getPoint();
				p.setLocation(p.x - 8, p.y - 30);
				t = new Triangle(p);
				points.add(p);
				trianglePoint = 1;
			} else if (trianglePoint == 1) {
				Point p = e.getPoint();
				p.setLocation(p.x - 8, p.y - 30);
				t.setP2(p);
				points.add(p);
				trianglePoint = 2;
			} else if (trianglePoint == 2) {
				Point p = e.getPoint();
				p.setLocation(p.x - 8, p.y - 30);
				t.setP3(p);
				triangles.add(t);
				t = null;
				trianglePoint = 0;
				points.clear();
			}
		} else if (e.getButton() == 3) {
			if (triangles.size() > 0) {
				triangles.remove(triangles.size() - 1);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
