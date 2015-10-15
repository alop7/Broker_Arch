package Broker;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public final class Broker {
    ArrayList<BrokerService> services = new ArrayList();
    final int port = 1111;
    ServerSocket serverSocket = null;
    Socket socket = null;

    public Broker(){
        registerService("Vote");
        registerService("Add");
        initCom();
    }

    public void registerService(String name){
        BrokerService service = new BrokerService(name);
        services.add(service);
    }

    public boolean getService(String n){
        return services.stream().anyMatch((b) -> (b.getName().equals(n)));
    }

    private void initCom(){
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
            new ClientThread(socket,this).start();
        }
    }

    public static void main(String[] args) {   
        Broker broker = new Broker();
    }
}
