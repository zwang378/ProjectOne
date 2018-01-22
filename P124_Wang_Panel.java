package lab1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class P124_Wang_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int countingNumber = 0;
	private int ONE_SECOND = 1000;

	public P124_Wang_Panel(int pass) {
		JLabel msglabel = new JLabel("<html>Zachary<br/>Wang</html>", JLabel.CENTER);
		JLabel msglabel2 = new JLabel("", JLabel.CENTER);
		
		msglabel.setFont(new Font("Papyrus", Font.BOLD, 12));
		msglabel2.setFont(new Font("Papyrus", Font.BOLD, 12));

		if (pass % 2 == 0) {
			Timer timer = new Timer(ONE_SECOND, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					countingNumber += 1;
					if (countingNumber > 9) {
						countingNumber = 0;
					}
					Integer counterNumber = new Integer(countingNumber);
					msglabel2.setText(counterNumber.toString());
					msglabel2.repaint();
				}
			});
			msglabel2.setText("0");
			timer.start();
			setBackground(Color.white);
		} else {
			Timer timer = new Timer(ONE_SECOND, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					countingNumber -= 1;
					if (countingNumber < 0) {
						countingNumber = 9;
					}
					Integer counterNumber = new Integer(countingNumber);
					msglabel2.setText(counterNumber.toString());
					msglabel2.repaint();
				}
			});
			msglabel2.setText("9");
			timer.start();
			setBackground(Color.cyan);
		}

		setLayout(new FlowLayout());
		add(msglabel);
		add(msglabel2);
	}

	public static void main(String[] args) {
		P124_Wang_Panel p124 = new P124_Wang_Panel(122);

		JFrame mainFrame = new JFrame("mainFrame content");
		mainFrame.setSize(100, 100);
		mainFrame.setLayout(new GridLayout(1, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.add(p124);
		mainFrame.setVisible(true);
	}

}
