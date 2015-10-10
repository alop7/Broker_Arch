package Model;

/**
 * Created by Cesar on 10/09/2015.
 */
public class Evento {
    private int id;
    private String name;
    private String info;

    public Evento(int i, String s){
        id = i;
        info = s;
    }

    public int getId(){
        return id;
    }
    public String getInfo(){
        return info;
    }
}