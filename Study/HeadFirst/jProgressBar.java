import javax.swing.*;
import java.awt.*;

public class jProgressBar {
	JFrame frame;
	JProgressBar jb;
	int i = 0, num = 0;

	public static void main(String [] args) {
		jProgressBar gui = new jProgressBar();
		gui.go();
	}

	public void go() {
		jb = new JProgressBar(0, 2000);
		jb.setBounds(40, 40, 200, 30);
		jb.setValue(0);
		jb.setStringPainted(true);

		frame = new JFrame();
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(jb);
		iterate();
	}

	private void iterate() {
		while (i <=  2000) {
			jb.setValue(i);
			i = i + 20;
			try {
				Thread.sleep(150);
			} catch (Exception e) { }
		}
	}
}


