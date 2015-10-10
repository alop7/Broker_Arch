package View;

import Model.Evento;

import javax.swing.*;

/**
 * Created by Cesar on 10/09/2015.
 */
public interface Observer {
    JPanel panel = new JPanel();

    void update(Evento e);
}