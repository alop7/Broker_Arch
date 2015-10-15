package Server;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javax.swing.*;

public class PieView extends JFrame{
    private static JFXPanel chartFxPanel= new JFXPanel();
    private PieChart chart;
    JPanel panel = new JPanel();

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
        this.setLocation(800, 0);
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

}
