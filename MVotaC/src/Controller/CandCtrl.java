package Controller;

import Model.Model;
import Model.Evento;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CandCtrl extends Control{
    public CandCtrl(Model m){
        super(m);
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
    String getEvtStr(ActionEvent e) {
        return ((JTextField)panel.getComponent(1)).getText();
    }

    public void update(Evento e){
        System.out.println();
    }

    public static void main(String[] args) {
        new CandCtrl(new Model());
    }
}