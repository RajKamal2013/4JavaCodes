import javax.swing.*;
import java.awt.*;

public class jTable {
	JFrame frame;

	public static void main(String[]args) {
		jTable gui = new jTable();
	       	gui.go();
	}

	public void go() {
		frame = new JFrame();
		
		String data[][] = {{"101", "Amit", "68000"}, {"102", "Jai", "70000"}};
		String column[] = {"ID", "Name", "Salary"};

		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 400);
		JScrollPane sp = new JScrollPane(jt);
		
		frame.add(sp);
		frame.setSize(600, 600);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
