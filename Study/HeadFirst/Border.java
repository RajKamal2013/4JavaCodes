import javax.swing.*;
import java.awt.*;

public class Border {
	JFrame frame;
	public static void main(String [] args) {
		Border gui = new Border();
		gui.go();
	}

	public void go() {
		frame = new JFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JButton button1 = new JButton("North");
		JButton button2 = new JButton("South");
		JButton button3 = new JButton("Center");
		JButton button4 = new JButton("East");
		JButton button5 = new JButton("West");

		frame.add(button1, BorderLayout.NORTH);
		frame.add(button2, BorderLayout.SOUTH);
		frame.add(button3, BorderLayout.CENTER);
		frame.add(button4, BorderLayout.EAST);
		frame.add(button5, BorderLayout.WEST);
	}
}
