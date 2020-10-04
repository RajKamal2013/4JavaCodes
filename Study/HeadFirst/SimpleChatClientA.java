import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class SimpleChatClientA {
	JTextField outgoing;
	JTextArea incomming;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;

	public void go() {
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainpanel = new JPanel();

		incomming = new JTextArea(15, 50);
		incomming.setLineWrap(true);
		incomming.setWrapStyleWord(true);
		incomming.setEditable(false);
		JScrollPane qscrol = new JScrollPane(incomming);
		qscrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qscrol.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		outgoing = new JTextField(20);
		JButton sendbutton = new JButton("Send");
		sendbutton.addActionListener(new SendButtonListener());

		mainpanel.add(qscrol);
		mainpanel.add(outgoing);
		mainpanel.add(sendbutton);
		frame.getContentPane().add(BorderLayout.CENTER, mainpanel);

		setupNetworking();

		Thread readerThread = new Thread(new IncommingReader());
		readerThread.start();

		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setupNetworking() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking is set up ");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev ) {
			try {
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
	
	public class IncommingReader implements Runnable {
		public void run() {
			String message;
			try {
				while((message = reader.readLine()) != null) {
					System.out.println("read" + message);
					incomming.append(message + "\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main (String [] args) {
		SimpleChatClientA client = new SimpleChatClientA();
		client.go();
	}
}
