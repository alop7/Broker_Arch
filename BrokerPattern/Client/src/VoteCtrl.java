package Client;

import javax.swing.*;
import java.awt.*;

public class VoteCtrl extends Controller {

    public VoteCtrl(ClientProxy proxy){
        super(proxy);
        init();
    }

    public void addCandidate(String s) {
        System.out.println("Adding..."+s);
        JButton nb;
        panel.add(nb = new JButton(s), BorderLayout.AFTER_LAST_LINE);
        nb.addActionListener(listener);
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void init(){
        super.init();
        this.setTitle("A votar!");
        this.setSize(200, 300);
        this.setLocation(0,200);
    }

    @Override
    String getAction() {
        sender = "Vote|" + sender;
        return sender;
    }
}
