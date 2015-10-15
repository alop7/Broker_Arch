package Server;

/**
 * Created by Cesar on 14/10/2015.
 */
public class Launcher {
    public static void main(String[] args) {
        ServerProxy proxy = new ServerProxy();
        PieView pie = new PieView();
        proxy.setView(pie);
        proxy.start();
        //BarView bar = new BarView();
    }
}
