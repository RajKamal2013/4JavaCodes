import javax.swing.*;
import java.awt.*;

public class MyCanvas extends Canvas {
	public void painit(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage("b.JPG");
		g.drawImage(i, 400, 400, this);
	}

	public static void main(String [] args) {
		MyCanvas m = new MyCanvas();
		JFrame frame = new JFrame();
		frame.add(m);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
