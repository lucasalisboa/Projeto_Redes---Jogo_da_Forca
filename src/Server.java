package src;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String argv[]) throws Exception {
		
		System.out.println("SERVIDOR INICIOU, ESPERANDO CONEXÃO NA PORTA 666!");
		
		ServerSocket socketServer = new ServerSocket(666);

		while (true) {
			Socket connectionSocket = socketServer.accept();
			Thread newThread = new Thread(new ClienteThread(connectionSocket));
			newThread.start();
		}
	}
}
