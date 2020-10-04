import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleAnimation0 {
	JFrame frame;
	JLabel label;
	int x = 70;
	int y = 70;
	MyDrawPanel5 DrawPanel;

	public static void main(String[] args) {
		SimpleAnimation0 a = new SimpleAnimation0();
		a.go();
	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Yellow");
	
		DrawPanel = new MyDrawPanel5();
		label = new JLabel();

		JButton LabelButton = new JButton("Change Label");
		LabelButton.addActionListener(new LabelListener());

		JButton ColorButton = new JButton("Start Animation");
		ColorButton.addActionListener(new ColorListener());

//		frame.getContentPane().add(DrawPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, ColorButton);
		frame.getContentPane().add(BorderLayout.CENTER, DrawPanel);
		frame.getContentPane().add(BorderLayout.EAST, LabelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(700, 700);
		frame.setVisible(true);
	}

	class ColorListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			for(int i = 1; i < 130; i++) {
				DrawPanel.repaint();
				x++;
				y++;
				try {
					Thread.sleep(50);
				} catch (Exception ex) { }
			}
		}
	}

	class LabelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			label.setText("See the Animation ");
		}
	}


	public class MyDrawPanel5 extends JPanel {
		public void paintComponent(Graphics g) {
		//	g.setColor(Color.white);
		//	g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//	g.setColor(Color.green);
		//	g.fillOval(x, y, 40, 40);
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(Color.white);
			g2D.fillRect(0, 0, this.getWidth(),this.getHeight());

			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			Color startColor = new Color(red, blue, green);

			red = (int) (Math.random() * 256);
			blue = (int) (Math.random() * 256);
			green = (int) (Math.random() * 256);
			Color endColor = new Color(red, blue, green);

			GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
			g2D.setPaint(gradient);
			g2D.fillOval(x, y, 60, 60);
				
		}
	}
}
