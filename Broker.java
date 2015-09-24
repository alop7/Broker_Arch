import java.io.*;
import java.net.*;
public class Broker {
    public static void main(String[] args) {
        final int port = 1111;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new ClientThread(socket).start();
        }
    }
}
