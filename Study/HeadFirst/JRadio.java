import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JRadio extends JFrame implements ActionListener{
	JFrame frame;
	JButton button;
	JRadioButton r1;
	JRadioButton r2;
	Font font;

	public static void main (String []args) {
		JRadio gui = new JRadio();
		gui.go();
	}

	public void go() {
		frame = new JFrame();
		r1 = new JRadioButton("A) Yes");
		r2 = new JRadioButton("B) No");

		r1.setBounds(50, 100, 70, 30);
		r2.setBounds(50, 150, 70, 30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		font = new Font("Serif", Font.BOLD, 28);
		button = new JButton("Click Me");
		button.setBounds(200, 250, 80, 30);
		button.setFont(font);
		button.setForeground(Color.RED);
		button.setBackground(Color.YELLOW);
		button.setOpaque(true);
		button.addActionListener(this);


		frame.add(r1);
		frame.add(r2);
		frame.add(button);

		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setTitle("Yellow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (r1.isSelected()) {
			JOptionPane.showMessageDialog(this, "This is Yes");
		}
		if (r2.isSelected()) {
			JOptionPane.showMessageDialog(this, "This is No");
		}
	}
}

