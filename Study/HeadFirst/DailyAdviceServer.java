import java.io.*;
import java.net.*;

public class DailyAdviceServer {
	String [] adviceList = {"Take Small Bites", "Go for Tight Jeans", " Get Slim", "Drink Beer", "Get HairCut"};

	public void go() {
		try {
			ServerSocket serversock = new ServerSocket(4242);

			while(true) {
				Socket sock = serversock.accept();

				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getadvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private String getadvice() {
		int random = (int) (Math.random() * adviceList.length);
		return (adviceList[random]);
	}

	public static void main(String [] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
}
