package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Controller extends JFrame{
    ClientProxy proxy;
    ActionListener listener;
    String sender;
    public boolean ready = false;
    protected JPanel panel = new JPanel();
    String name;

    public Controller(ClientProxy proxy){
        this.proxy = proxy;
        name = this.getClass().getSimpleName();
        init();
    }

    public void init(){
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sender = e.getActionCommand();
                ready = true;
                synchronized (proxy){proxy.notify();}
            }
        };
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
    }

    abstract String getAction();

    public void setProxy(ClientProxy proxy){
        this.proxy = proxy;
    }
}