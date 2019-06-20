package kakaotalk;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class kakaot extends JFrame {
	private JTextField startTf = new JTextField(7);
	private JButton calcBtn = new JButton("전송");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;

	public kakaot() {
		super("뽀빠이돼지(S.P)");
		setSize(410, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(startTf);
		//c.add(operatorTf);
		//c.add(endTf);
		//c.add(new JLabel("="));
		//c.add(resTf);
		c.add(calcBtn);

		setVisible(true);
		setupConnection();

		calcBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String startText = startTf.getText().trim();
					//String operatorText = operatorTf.getText().trim();
					//String endText = endTf.getText().trim();

					if (startText.length() == 0 /*|| operatorText.length() == 0 
							||endText.length() == 0*/) 
							return;
					
						out.write("뽀빠이돼지(S.P) : " + startText + "\n");
						//out.write(operatorText + "\n");
						//out.write(endText + "\n");
						out.flush();

						String result = in.readLine();
						//resTf.setText(result);
					
				} catch (IOException e) {
					// TODO: handle exception
					System.out.println("클라이언트12번 : 띵고서버로부터 연결 종료");
					return;
					// e.printStactTeace();
				}
			}
		});
	}

	public void setupConnection() {
		try {
			socket = new Socket("localhost", 9998);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new kakaot();
	}

}