package src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ClienteThread implements Runnable{
    
    private Socket connectionSocket;
    private ArrayList <String> words = new ArrayList<>();
    private ArrayList <Character> letters= new ArrayList<>();;

    public ClienteThread(Socket s) {
        this.connectionSocket = s;
        words.add(0,"internet");
        words.add(1,"sockets");
        words.add(2,"roteador");
        words.add(3,"enlace");
        words.add(4,"ethernet");
        words.add(5,"cliente");
        words.add(6,"servidor");
        words.add(7,"proxy");
	}
    
    @Override
	public void run() {
        String readCliente;
        BufferedReader inFromGame;
        DataOutputStream outToGame;
        Random random = new Random();
        int rng = random.nextInt(7);
        String gameSentence = words.get(rng);
        int count_lifes = 0;
        int count_letters = gameSentence.length();
        char[] verify = gameSentence.toCharArray();

        try{
            inFromGame = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            outToGame = new DataOutputStream(connectionSocket.getOutputStream());
            outToGame.writeBytes("Jogo da Forca");
            outToGame.writeBytes("Tema: Redes de Computadores");
            outToGame.writeBytes("Numero de letras:"+ gameSentence.length());
            outToGame.writeInt(gameSentence.length());
            for (int i = 0 ; i < gameSentence.length(); i++){
                letters.add('_');
            }  
            while(count_lifes < 3){
                for (int i = 0 ; i < gameSentence.length(); i++){
                    outToGame.writeChar(letters.get(i));
                }    
                if(count_letters == 0)
                {
                    break;
                }
                else{
                    outToGame.writeUTF("Digite uma letra");
                    readCliente = inFromGame.readLine(); 
                    readCliente = readCliente.toLowerCase();
                    if (readCliente.trim().length() == 1){
                        if (gameSentence.contains(readCliente)){
                            outToGame.writeUTF("Letra correta");
                            for(int i = 0; i < verify.length; i++){
                                if(verify[i] == readCliente.charAt(0))
                                {
                                    letters.set(i, verify[i]);
                                    count_letters--;
                                }
                            }    
                        }
                        else{
                            outToGame.writeUTF("Letra incorreta");
                            count_lifes++;
                        }
                    }
                    else{
                        outToGame.writeUTF("Digite apenas uma letra");
                        count_lifes++;                  
                    }    
                }
            }
            String msg;
            if(count_lifes < 3) {
                msg = "Parabens! Voce ganhou!";
            }   
            else{
                msg = "Que pena! Voce perdeu!";
            }
            outToGame.writeUTF(msg);
        }
        catch (Exception e){
            e.printStackTrace();
        }		
	}
}
