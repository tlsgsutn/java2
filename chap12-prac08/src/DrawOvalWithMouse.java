import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawOvalWithMouse extends JFrame {
	public DrawOvalWithMouse(){
		super("���콺�� �� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(700,350);
		setVisible(true);
	}
	
	class Circle {
		private int x, y; // ���� �߽�
		private int radius;
		
		public Circle(int x, int y, int radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;			
		}
		
		public Point getLeftTopPoint() {
			return new Point(x-radius, y-radius);
		}
		public int getHeight() {
			return radius*2;
		}		
		
	}
	
	class MyPanel extends JPanel {
		private Vector<Circle> cv = new Vector<Circle>();
		private Circle circleDragged = null;
		
		public MyPanel() {
			MyMouseListener ml = new MyMouseListener();
			this.addMouseListener(ml);		
			this.addMouseMotionListener(ml);
		}
			
		private class MyMouseListener extends  MouseAdapter {
			private Point startP = null;
			
			@Override
			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();	
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				Point endP = e.getPoint();
				double pow = (endP.x-startP.x)*(endP.x-startP.x) +
						(endP.y-startP.y)*(endP.y-startP.y);
				int radius = (int)Math.sqrt(pow);
				cv.add(new Circle(startP.x, startP.y, radius));
				repaint();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				Point endP = e.getPoint();
				double pow = (endP.x-startP.x)*(endP.x-startP.x) +
						(endP.y-startP.y)*(endP.y-startP.y);
				int radius = (int)Math.sqrt(pow);
	
				// ���� �巡������ �׷����� �ִ� ��. �� ���� paintComponent()���� �׸� ��
				circleDragged = new Circle(startP.x, startP.y, radius);
				repaint();
			}
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			
			// cv�� ��� �ִ� ��� �� �׸���
			for(int i=0; i<cv.size(); i++) {
				Circle c = cv.get(i);
				Point p = c.getLeftTopPoint();
				g.drawOval(p.x, p.y, c.getHeight(), c.getHeight());
			}
			
			if(circleDragged != null) { // mouseDragged() ���� ���� �׷����� �ִ� �� �׸���
				Point p = circleDragged.getLeftTopPoint();
				g.drawOval(p.x, p.y, circleDragged.getHeight(), circleDragged.getHeight());				
			}
		}
	}
	
	static public void main(String[] args) {
		new DrawOvalWithMouse();
	}
}