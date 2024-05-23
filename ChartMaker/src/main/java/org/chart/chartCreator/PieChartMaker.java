package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class PieChartMaker extends JFrame {
    public PieChartMaker(DefaultPieDataset dataset, String chartTitle){
        JFreeChart chart = ChartFactory.createPieChart(
                chartTitle,
                dataset,
                true,
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);

        Paint[] colors = {
                new Color(0, 172, 178),  // blue
                new Color(239, 70, 55),  // red
                new Color(85, 177, 69)   // green
        };

// Change the default colors
        int sectionCount = dataset.getItemCount();

        for (int i = 0; i < sectionCount; i++) {
            plot.setSectionPaint(dataset.getKey(i), colors[i % colors.length]);
        }

        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        setTitle("Pie Chart Example");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void createAndShowPieChart(DefaultPieDataset dataset, String chartTitle) {
        PieChartMaker chartFrame = new PieChartMaker(dataset, chartTitle);
        chartFrame.setVisible(true);
    }
}
