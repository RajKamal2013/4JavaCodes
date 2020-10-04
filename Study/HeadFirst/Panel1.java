import javax.swing.*;
import java.awt.*;

public class Panel1 extends JPanel {
	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JButton button1 = new JButton();

		panel1.setBackground(Color.darkGray);
		panel1.setForeground(Color.red);

		frame.getContentPane().add(BorderLayout.EAST, panel1);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

