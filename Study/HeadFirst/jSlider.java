import javax.swing.*;
import java.awt.*;

public class jSlider {
	JFrame frame;
	
	public static void main(String [] args) {
		jSlider gui = new jSlider();
		gui.go();
	}

	public void go() {
		JSlider slider = new JSlider (JSlider.HORIZONTAL, 0, 50, 10);
		slider.setMinorTickSpacing(2);  
		slider.setMajorTickSpacing(10);  
		  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true); 
		
		JPanel panel  = new JPanel();
		panel.add(slider);

		frame = new JFrame();
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(null);
		frame.pack();
	}
}
