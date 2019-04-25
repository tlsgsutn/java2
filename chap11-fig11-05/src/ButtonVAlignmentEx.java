import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ButtonVAlignmentEx extends JFrame {
	public ButtonVAlignmentEx() {
		setTitle("��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		// 3���� �̹����� ���Ϸκ��� �о���δ�.
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif"); // normalIcon�� �̹���
		
		// normalIcon�� ���� ��ư ������Ʈ ����
		JButton btn = new JButton("call~~", normalIcon);
		btn.setVerticalAlignment(SwingConstants.TOP);
		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new ButtonVAlignmentEx();
		// TODO Auto-generated method stub

	}

}