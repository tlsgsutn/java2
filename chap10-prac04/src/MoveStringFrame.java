import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoveStringFrame extends JFrame {
	public MoveStringFrame() {
		super("Left Ű�� ���ڿ� �̵�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel label = new JLabel("Love Java");
		c.add(label);

		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					JLabel la = (JLabel) e.getSource();
					String text = la.getText();
					String front = text.substring(0, 1);
					String last = text.substring(1);
					la.setText(last.concat(front));
				}
			}
		});

		setSize(250, 100);
		setVisible(true);

		label.setFocusable(true); // ���̺��� ��Ŀ���� ���� �� �ֵ��� ����
		label.requestFocus(); // ���̺� Ű �̺�Ʈ ��Ŀ�� ����
	}

	static public void main(String[] args) {
		new MoveStringFrame();
	}
}
