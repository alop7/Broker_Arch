package Server;

import java.io.*;
import java.net.Socket;

public class Connection extends Thread{
    Socket socket;
    ServerProxy server;

    public Connection(Socket socket, ServerProxy server){
        this.socket = socket;
        this.server = server;
    }

    public void run(){
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        System.out.println("in thread init");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        out.println("Hola, broker");

        while (true){
            String input = in.readLine();
            String result = server.doSomething(input);
            out.println(result);
        }
    }
}
