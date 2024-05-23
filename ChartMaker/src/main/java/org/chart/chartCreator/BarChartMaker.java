package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class BarChartMaker extends JFrame {
    public BarChartMaker(CategoryDataset dataset, String chartTitle, String xAxisLabel, String yAxisLabel){
        JFreeChart chart= ChartFactory.createBarChart(
                chartTitle, //Chart Title
                xAxisLabel, // Category axis
                yAxisLabel, // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);
        plot.setOutlineVisible(false);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setGradientPaintTransformer(null);

        Paint[] colors = {
                new Color(0, 172, 178),      // blue
                new Color(239, 70, 55),      // red
                new Color(85, 177, 69)       // green
        };

        // Change the default colors
        for (int i = 0; i < dataset.getRowCount(); i++) {
            renderer.setSeriesPaint(i, colors[i % colors.length]);
        }

        ChartPanel panel=new ChartPanel(chart);
        setContentPane(panel);
        setTitle("Bar Chart Example");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void createAndShowBarChart(DefaultCategoryDataset dataset, String chartTitle, String xAxisLabel, String yAxisLabel) {
        BarChartMaker chartFrame = new BarChartMaker(dataset, chartTitle, xAxisLabel, yAxisLabel);
        chartFrame.setVisible(true);
    }
}
