import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineMouseEx extends JFrame {
	private MyPanel panel = new MyPanel();

	public GraphicsDrawLineMouseEx() {
		setTitle("drawing Line by Mouse ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
		// TODO Auto-generated method stub

	}

	// ���� �׸� �� �ִ� �г��� �����Ѵ�.
	// �� �гο� Mouse �����ʸ� �����ϴ�.
	class MyPanel extends JPanel {
		// �׷��� ���� ��� �����ϱ� ���� �������� vStart��
		// ������ vEnd ���Ϳ� ���� �����Ѵ�.
		private Vector<Point> vStart = new Vector<Point>(); // Point�� �����ϴ� ���׸�
															// ����
		private Vector<Point> vEnd = new Vector<Point>(); // Point�� �����ϴ� ���׸� ����

		public MyPanel() {
			// Mouse �����ʸ� ����Ѵ�.
			// �� �����ʴ� ���콺 ��ư�� �������� ���콺 ������(������)�� vStart ���Ϳ� �����ϰ�
			// ���콺 ��ư�� �������� ���콺 ������(����)�� vEnd ���Ϳ� ����Ѵ�.
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point startP = e.getPoint(); // ���콺 �����͸� �˾Ƴ���.
					vStart.add(startP); // �������� vStart�� �����Ѵ�.
				}

				public void mouseReleased(MouseEvent e) {
					Point endP = e.getPoint(); // ���콺 �����͸� �˾Ƴ���.
					vEnd.add(endP); // ������ vEnd�� �����Ѵ�.

					// �г��� �ٽ� �׸��⸦ ��û�Ѵ�.
					repaint();
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE); // �Ķ����� �����Ѵ�.

			// ������ ũ�⸸ŭ ������ŭ ���� ���鼭 ���� �׸���.
			for (int i = 0; i < vStart.size(); i++) { // vStart ������ ũ��� ������� ����
														// ������ ����
				Point s = vStart.elementAt(i); // ���Ϳ� ��� �ִ� �������� �˾Ƴ���.
				Point e = vEnd.elementAt(i); // ���Ϳ� ��� �ִ� ������ �˾Ƴ���.

				// ���������� �������� ���� �׸���.
				g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());

			}
		}
	}
}