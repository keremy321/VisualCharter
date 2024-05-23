package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class LineChartMaker extends JFrame {
    public LineChartMaker(DefaultCategoryDataset dataset, String chartTitle, String xAxisLabel, String yAxisLabel){
        // Create chart

        JFreeChart chart = ChartFactory.createLineChart(
                chartTitle, // Chart title
                xAxisLabel, // X-Axis Label
                yAxisLabel, // Y-Axis Label
                dataset
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        setTitle("Line Chart Example");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void createAndShowLineChart(DefaultCategoryDataset dataset, String chartTitle, String xAxisLabel, String yAxisLabel) {
        LineChartMaker chartFrame = new LineChartMaker(dataset, chartTitle, xAxisLabel, yAxisLabel);
        chartFrame.setVisible(true);
    }
}
