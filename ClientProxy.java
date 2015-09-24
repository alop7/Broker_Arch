import java.io.*;
import java.net.*;

public class ClientProxy {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 1111;

        try(Socket socket = new Socket(host,port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            System.out.println("Connected to server");

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServ, fromUse;

            while(true){
                fromServ = in.readLine();
                System.out.println("Server: "+fromServ);
                fromUse = stdIn.readLine();
                out.println(fromUse);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
