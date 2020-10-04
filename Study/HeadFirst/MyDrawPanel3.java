import java.awt.*;
import javax.swing.*;

public class MyDrawPanel3 extends JPanel {
	public void paintComponent (Graphics g) {
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int red = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);

		Color randomColor = new Color(red, blue, green);
		g.setColor(randomColor);
		g.fillOval(100, 100, 100, 100);
	}
	public static void main (String [] args) {
		JFrame f = new JFrame();
		f.setSize(700, 700);
		f.setTitle("Yellow By ColdPlay");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new MyDrawPanel3());
		f.setVisible(true);
	}
}
