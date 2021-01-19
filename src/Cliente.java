package src;
import java.net.*;
import java.io.*;

public class Cliente {
	public static void main(String argv[]) throws Exception {
		String sentence;
		System.out.println("CLIENTE INICIADO.... ");

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket socketNewClient = new Socket("localhost", 1234);

		DataOutputStream outputServer = new DataOutputStream(socketNewClient.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socketNewClient.getInputStream()));
        
        System.out.println(inFromServer.readLine());
        System.out.println(inFromServer.readLine());
        System.out.println(inFromServer.readLine());
        String msg;


        while(true){
            System.out.println(inFromServer.readLine());
            msg = inFromServer.readLine();
            System.out.println(msg);
            if(msg.equals("Parabens! Voce ganhou!") || msg.equals("Que pena! Voce perdeu!")){
                break;
            }

            sentence = inFromUser.readLine();

            outputServer.writeBytes(sentence + '\n');

            System.out.println(inFromServer.readLine());
        }

        inFromServer.close();
        outputServer.close();
        inFromUser.close();
        socketNewClient.close();
	}
}
