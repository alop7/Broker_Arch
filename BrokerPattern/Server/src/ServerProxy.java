package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Cesar on 14/10/2015.
 */
public class ServerProxy extends Thread{
    PieView view;
    ServerSocket serverSock;
    Socket socket;
    int port = 8888;
    ArrayList<String> candidates = new ArrayList();

    public ServerProxy(){   }

    public void run(){dispatchConnections();}

    private void dispatchConnections(){
        try {
            serverSock = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                socket = serverSock.accept();
                System.out.println("Se acepto nueva conn");
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Connection(socket,this).start();
        }
    }

    public String doSomething(String s){
        if(s.split("\\|")[0].equals("Add")){
            view.addCandid(s.split("\\|")[1],"0");
            candidates.add(s.split("\\|")[1]);
        }
        if(s.split("\\|")[0].equals("Vote")){
            int i;
            for(i=0;i<candidates.size();i++) {
                if(s.split("\\|")[1].equals(candidates.get(i))){
                view.addVote(i);}
            }
        }
        return "Executing: "+s;
    }

    public void setView(PieView view){
        this.view = view;
    }
}