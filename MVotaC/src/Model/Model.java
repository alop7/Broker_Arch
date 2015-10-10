package Model;

import View.Observer;

import java.util.ArrayList;

/**
 * Created by Cesar on 10/09/2015.
 */
public class Model{
    ArrayList<Observer> obs = new ArrayList();
    Evento e;

    public void add(Observer o){
        obs.add(o);
    }

    private void notifyObservers(int i, String s){
        Evento evt = new Evento(i,s);
    }

    public void notifyMe(String s){

    }

    //public void notifyMe(int n){}
}