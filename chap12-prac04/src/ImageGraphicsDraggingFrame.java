import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageGraphicsDraggingFrame extends JFrame {
	public ImageGraphicsDraggingFrame() {
		super("�׷��� �̹��� �巡�� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(new MyPanel());
		setSize(300, 300);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple.jpg");
		private Image img = icon.getImage();
		private int width, height;
		private int x = 100, y = 100;

		public MyPanel() {
			width = img.getWidth(this);
			height = img.getHeight(this);

			// ���콺 �����ʿ� ���콺��� ������ �ޱ�
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);
			addMouseMotionListener(ml);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, x, y, width, height, this); // �гο� �̹��� �׸���
		}

		class MyMouseListener extends MouseAdapter {
			private Point startP = null; // �巡�� ���� ��
			private boolean bDrag = false; // �巡�� �Ǵ� ���� ��

			@Override
			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();
				if ((startP.x >= x && startP.x <= x + width) && (startP.y >= y && startP.y <= y + height)) {
					bDrag = true;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (bDrag == false)
					return;

				Point endP = e.getPoint();
				x = x + endP.x - startP.x;
				y = y + endP.y - startP.y;
				repaint();

				// ���콺�� ������ �Ŀ��� �ݵ�� ���� �ڵ尡 �ʿ���
				bDrag = false;
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (bDrag == false)
					return;

				Point endP = e.getPoint();
				x = x + endP.x - startP.x;
				y = y + endP.y - startP.y;

				startP = endP;
				repaint();
			}

		}
	}

	public static void main(String[] args) {
		new ImageGraphicsDraggingFrame();
		// TODO Auto-generated method stub

	}

}
