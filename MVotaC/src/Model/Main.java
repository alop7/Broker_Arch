package Model;

import Controller.CandCtrl;
import Controller.VoteCtrl;
import View.BarView;
import View.PieView;

import java.util.ArrayList;

/**
 * Created by Cesar on 02/09/2015.
 */
public class Main extends Model{
    private PieView p = new PieView();
    private BarView b = new BarView();
    DatabaseManager db = new DatabaseManager();
    ArrayList<String[]> candids = new ArrayList<>();

    public Main(){
        if(db.getCandids().isEmpty()) {
            db.addCandid("Jorge");
            db.addCandid("Pablo");
            db.addCandid("Nicolas");
        }
        candids = db.getCandids();
        for(String[] ss : candids){
            p.addCandid(ss[1],ss[3]);
            b.addCandid(ss[1],ss[3]);
        }
    }

    public void notifyMe(int n){
        if(saveVote(n)){
            p.addVote(n-1);
            b.addVote(n-1);
        }
    }

    public boolean saveVote(int n){
        return db.addVote(n);
    }

    public static void main(String[] args) {
        Model m = new Main();
        m.add(new PieView());
        m.add(new BarView());
        m.add(new VoteCtrl(m));
    }
}
