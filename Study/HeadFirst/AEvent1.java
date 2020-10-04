import java.awt.*;
import java.awt.event.*;

class AEvent1 extends Frame implements ActionListener {
	TextField tf;
	AEvent1() {
		tf = new TextField();
		tf.setBounds(60, 50, 170,20);

		Button b = new Button("Click Me");
		b.setBounds(100, 120, 80, 30);

		b.addActionListener(this);

		add(b);
		add(tf);

		setSize(500, 500);
		setLayout(null);
		setVisible(true);
		//setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent a) {
		tf.setText("Welcome");
	}

	public static void main(String [] args) {
		new AEvent1();
	}
}
