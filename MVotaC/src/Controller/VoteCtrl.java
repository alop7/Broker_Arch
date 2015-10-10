package Controller;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VoteCtrl extends Control{

    public VoteCtrl(Model m){
        super(m);
        init();
    }

    public void addCandidate(String s) {
        JButton nb;
        panel.add(nb = new JButton(s), BorderLayout.AFTER_LAST_LINE);
        nb.addActionListener(listener);
    }
    @Override
    public void init(){
        super.init();

        this.setTitle("Vote!");
        this.setSize(200, 300);
    }

    @Override
    String getEvtStr(ActionEvent e) {
        return e.getActionCommand();
    }
}
