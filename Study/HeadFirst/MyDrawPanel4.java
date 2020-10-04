import javax.swing.*;
import java.awt.*;

public class MyDrawPanel4 extends JPanel {
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}
	
	public static void main(String [] args) {
		JFrame f = new JFrame();
		f.setSize(700, 700);
		f.setTitle("Yellow By ColdPlay");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new MyDrawPanel4());
		f.setVisible(true);
	}
}
