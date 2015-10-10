package Controller;

import Model.Evento;
import View.Observer;
import Model.Model;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cesar on 12/09/2015.
 */
public abstract class Control extends JFrame implements Observer{
    Model model;
    ActionListener listener;
    protected JPanel panel = new JPanel();

    public Control(Model m){
        model = m;
        init();
    }

    @Override
    public void update(Evento e) {

    }

    public void init(){
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.notifyMe(getEvtStr(e));
            }
        };
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
    }

    abstract String getEvtStr(ActionEvent e);
}
