package HeadFirst;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatServer {
	ArrayList clientList;

	public class ClientHandler implements Runnable {
		BufferedReader reader;
		Socket sock;

		public ClientHandler(Socket clientSocket) {
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}

		public void run() {
			String message;
			try {
				while((message = reader.readLine())!=null) {
					System.out.println("read" + message);
					tellEveryone(message);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void go() {
		clientList = new ArrayList();
		try {
			ServerSocket serversock = new ServerSocket(5000);
			
			while(true) {
				Socket clientsocket = serversock.accept();
				PrintWriter writer = new PrintWriter(clientsocket.getOutputStream());
				clientList.add(writer);
				Thread t = new Thread(new ClientHandler(clientsocket));
				t.start();
				System.out.println("Got a connection");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void tellEveryone(String message) {
		Iterator it = clientList.iterator();
		while(it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String [] args) {
		SimpleChatServer server = new SimpleChatServer();
		server.go();
	}
}

