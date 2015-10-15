package Server;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.*;

public class BarView extends JFrame{
    private static JFXPanel chartFxPanel = new JFXPanel();
    private BarChart<String,Number> bc;
    XYChart.Series series1 = new XYChart.Series();

    public BarView(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                bc = new BarChart<String, Number>(xAxis, yAxis);
                bc.setTitle("Elections 2015");
                yAxis.setLabel("Votes");

                Scene scene = new Scene(bc, 500, 350);
                bc.getData().add(series1);

                chartFxPanel.setScene(scene);
            }
        });
        this.add(chartFxPanel);
        this.setVisible(true);
        this.setSize(550, 450);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(650, 0);
    }

    public void addCandid(String s, String t){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                series1.getData().add(new XYChart.Data(s, (double) Integer.parseInt(t)));
            }
        });
    }

    public void addVote(int n){
        bc.getData().get(0).getData().get(n).setYValue(bc.getData().get(0).getData().get(n).getYValue().intValue()+1);
    }
}
