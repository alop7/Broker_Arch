package Broker;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    protected Socket clientSocket;
    Broker brok;

    public ClientThread(Socket clientSocket, Broker brok){
        this.clientSocket = clientSocket;
        this.brok = brok;
    }

    public void run(){
        handleCon();
    }
    
    private void handleCon(){
        try{
            PrintWriter outC = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader inC = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Socket socket = new Socket("localhost",8888);
            PrintWriter outS = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader inS = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            outC.println("Hola, cliente");
            System.out.println(inS.readLine());
            String fromClient, fromServer;
            
            while(true){
                fromClient = inC.readLine();
                if(fromClient.equals("end"))
                    break;
                if(brok.getService(fromClient.split("\\|")[0])){ // Caso: se tiene el servicio
                    outC.println("Ok");
                    outS.println(fromClient);
                    System.out.println(inS.readLine());
                }else{
                    outC.println("Error: No such service");
                }
            }
            clientSocket.close();
        }catch(IOException e){
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}