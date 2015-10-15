package Client;

import javax.swing.*;
import java.awt.*;

public class RegisterCtrl extends Controller{
    VoteCtrl votes;

    public RegisterCtrl(ClientProxy proxy){
        super(proxy);
        init();
    }

    @Override
    public void init(){
        super.init();
        panel.add(new JLabel("New Candid: "), BorderLayout.PAGE_START);
        panel.add(new JTextField(15), BorderLayout.PAGE_START);
        panel.add(new JButton("Add"), BorderLayout.CENTER);
        ((JButton)panel.getComponent(2)).addActionListener(listener);

        this.setTitle("Add a new Candidate");
        this.setSize(300, 120);
    }

    @Override
    String getAction() {
        votes.addCandidate(((JTextField)panel.getComponent(1)).getText());
        sender = sender +"|"+ ((JTextField)panel.getComponent(1)).getText();
        ((JTextField)panel.getComponent(1)).setText("");
        panel.revalidate();
        panel.repaint();
        return sender;
    }

    public void bindMeSomeCands(VoteCtrl c){
        votes = c;
    }
}
