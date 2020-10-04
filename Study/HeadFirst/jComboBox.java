import javax.swing.*;
import java.awt.*;

public class jComboBox {
	JFrame frame;

	public static void main (String [] args) {
		jComboBox gui = new jComboBox();
		gui.go();
 	}

	public void go() {
		frame = new JFrame();
		String country[] = {"India", "Australia", "USA", "England"};
		JComboBox <String> cb = new JComboBox <String> (country);
		cb.setBounds(50, 50, 90, 20);
		cb.addItem("NEW ZEALAND");
		frame.add(cb);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}	

