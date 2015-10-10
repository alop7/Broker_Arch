package View;

import javax.swing.*;

import Model.Evento;
import View.Observer;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

/**
 * Created by Cesar on 02/09/2015.
 */
public class PieView extends JFrame implements Observer{
    private static JFXPanel chartFxPanel= new JFXPanel();
    private PieChart chart;

    public PieView(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = new Scene(new Group());

                ObservableList<PieChart.Data> pieChartData =
                        FXCollections.observableArrayList();

                chart = new PieChart(pieChartData);
                chart.setTitle("Elections 2015");

                ((Group) scene.getRoot()).getChildren().add(chart);
                chartFxPanel.setScene(scene);
            }
        });
        this.add(chartFxPanel);
        this.setVisible(true);
        this.setSize(500, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(150, 0);
    }

    public void addVote(int n){
        chart.getData().get(n).setPieValue(getCandidVotes(n) + 1);
    }

    public void addCandid(String s, String t){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chart.getData().add(new PieChart.Data(s, Integer.parseInt(t)));
            }
        });
    }

    public int getCandidVotes(int n) {
        return (int)chart.getData().get(n).getPieValue();
    }

    @Override
    public void update(Evento e) {
        if(e.getId()==1){
            addVote(Integer.parseInt(e.getInfo())); // not ready yet. must check!
        }
        if(e.getId()==2){
            addCandid(e.getInfo().split(" ")[0],e.getInfo().split(" ")[1]); // this too. just an idea
        }
    }
}
