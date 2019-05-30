import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag = false; // 스레드의 종료 명령을 표시하는 플래그. true : 종료 지시

	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}

	void finish() { // 스레드 종료 명령을 flag에 표시
		flag = true;
	}

	@Override
	public void run() {
		while (true) {
			int x = ((int) (Math.random() * contentPane.getWidth()));
			int y = ((int) (Math.random() * contentPane.getHeight()));
			JLabel label = new JLabel("java"); // 새 레이블 생성
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();
			try {
				Thread.sleep(3); // 0.3초 동안 잠을 잔다.
				if (flag == true) {
					contentPane.removeAll();
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.repaint();
					return;
				}
			} catch (InterruptedException e) {
				return;
			}
			// TODO: handle exception
		}
	}
}

public class ThreadFinishFlagEx extends JFrame {
	private RandomThread th; // 스레드 레퍼런스

	public ThreadFinishFlagEx() {
		setTitle("ThreadFinishFlagEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				th.finish(); // RandomThread 스레드 종료 명령
			}
		});
		setSize(300, 200);
		setVisible(true);

		th = new RandomThread(c); // 스레드 생성
		th.start(); // 스레드 동작시킴
	}

	public static void main(String[] args) {
		new ThreadFinishFlagEx();

	}
}
