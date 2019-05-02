import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLabelDraggingFrame extends JFrame {
	public ImageLabelDraggingFrame() {
		super("�̹��� ���̺� �巡�� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		ImageIcon icon = new ImageIcon("images/apple.jpg"); // �̹��� �ε�
		JLabel imageLabel = new JLabel(icon); // �̹��� ���̺� �����

		// �̹��� ���̺��� ũ��� ��ġ ����
		imageLabel.setSize(icon.getIconHeight(), icon.getIconWidth());
		imageLabel.setLocation(100, 100);

		// ���콺 �����ʿ� ���콺��� ������ ��ü �ޱ�
		MyMouseListener ml = new MyMouseListener();
		imageLabel.addMouseListener(ml);
		imageLabel.addMouseMotionListener(ml);

		c.add(imageLabel); // ����Ʈ�ҿ� �̹��� ���̺� ����
		setSize(300, 300);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		private Point startP = null; // �巡�� ���� ��

		@Override
		public void mousePressed(MouseEvent e) {
			startP = e.getPoint();
		}

		// ���� mouseReleased()�� ����� �Ǵ� �ڵ���.
		// ������ �ǽ����� 4�� Ǯ�� ���ؼ��� �ݵ�� mouseReleased()�� �����Ͽ��� ��
		@Override
		public void mouseReleased(MouseEvent e) {
			Point endP = e.getPoint();
			Component la = (JComponent) (e.getSource());
			Point p = la.getLocation();
			la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
			la.getParent().repaint(); // ������ la�� ��ġ�� �ٽ� �׸���
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
