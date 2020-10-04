import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class jTextArea {
	JTextArea area;
	JFrame frame;

	public static void main(String [] args) {
		jTextArea gui = new jTextArea();
		gui.go();
	}

	public void go() {
		area = new JTextArea();
		frame = new JFrame();

		area.setBounds(10, 30, 300, 300);
		area.setBackground(Color.BLACK);
		area.setForeground(Color.WHITE);

		frame.add(area);
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
