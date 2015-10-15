package Client;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ClientProxy extends Thread{
    private String host = "localhost";
    private int port = 1111;
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    ArrayList<Controller> ctrls;

    public ClientProxy(ArrayList<Controller> controllers){
        ctrls = controllers;
    }

    public void run(){
        connect();
    }
    private void connect(){
        try {
            socket = new Socket(host,port);
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Connected to server");

            while(true){
                System.out.println("Server: "+in.readLine());

                synchronized (this) { wait(); }
                for(Controller ctrl : ctrls) {
                    if (ctrl.ready == true) {
                        String fromUse = ctrl.getAction();
                        System.out.println("Sending: "+fromUse);
                        out.println(fromUse);
                        ctrl.ready = false;
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
