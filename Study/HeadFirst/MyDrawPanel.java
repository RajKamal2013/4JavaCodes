import java.awt.*;
import javax.swing.*;


class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
			g.setColor(Color.orange);
			g.fillRect(100, 100, 100, 100);
	}

	public static void main(String[] args) {
			JFrame f = new JFrame();
			f.setSize(700, 700);
			f.setTitle("Yellow By ColdPlay");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setContentPane(new MyDrawPanel());
			f.setVisible(true);
	}

}
