import javax.swing.*;
import java.awt.event.*;

public class simpleGui2 implements ActionListener {
	JButton button;
	public static void main (String [] args) {
		simpleGui2 gui = new simpleGui2();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("Click Me");

		button.addActionListener(this);

		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		button.setText("I have Been clicked");
	}
}
