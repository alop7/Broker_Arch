import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    protected Socket clientSocket;

    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void run(){
        try(PrintWriter outC = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader inC = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Socket socket = new Socket("",8888);
            PrintWriter outS = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader inS = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            outC.println("hello");
            System.out.println(inS.readLine());
            String fromClient, fromServer;

            while (true){
                fromClient = inC.readLine();
                System.out.println("Client"+this.hashCode()+": "+fromClient);
                outS.println(fromClient);
                fromServer = inS.readLine();
                System.out.println("Server: "+fromServer);
                outC.println("kk. "+fromServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
