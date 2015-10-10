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
         /* Socket socket = new Socket("",8888);
            PrintWriter outS = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader inS = new BufferedReader(new InputStreamReader(socket.getInputStream()));*/
            
            outC.println("Hola");
            //System.out.println(inS.readLine());
            String fromClient /*, fromServer*/;
            
            while(true){
                fromClient = inC.readLine();
                if(fromClient.equals("end"))
                    break;
                if(brok.getService(fromClient)){
                    outC.println("OK");
                }else{
                    outC.println("No existe tal servicio");
                }
            }
            clientSocket.close();
        }catch(IOException e){
            System.out.println("Fallo la conexion: ");
            e.printStackTrace();
        }
    }
}
