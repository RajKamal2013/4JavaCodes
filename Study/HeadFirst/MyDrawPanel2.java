import java.awt.*;
import javax.swing.*;


class MyDrawPanel2 extends JPanel {
	public void paintComponent(Graphics g) {
			Image image = new ImageIcon("tumblr.jpg").getImage();
			g.drawImage(image, 3, 4, this);
	}

	public static void main(String[] args) {
			JFrame f = new JFrame();
			f.setSize(1000, 1000);
			f.setTitle("Yellow By ColdPlay");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setContentPane(new MyDrawPanel2());
			f.setVisible(true);
	}
}
