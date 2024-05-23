package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class ScatterChartMaker extends JFrame{
    public ScatterChartMaker(XYSeriesCollection dataset, String chartTitle, String xAxisLabel, String yAxisLabel){
        JFreeChart chart = ChartFactory.createScatterPlot(
                chartTitle,
                xAxisLabel,
                yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        setTitle("Scatter Chart Example");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void createAndShowPieChart(XYSeriesCollection dataset, String chartTitle, String xAxisLabel, String yAxisLabel) {
        ScatterChartMaker chartFrame = new ScatterChartMaker(dataset, chartTitle, xAxisLabel, yAxisLabel);
        chartFrame.setVisible(true);
    }

}
