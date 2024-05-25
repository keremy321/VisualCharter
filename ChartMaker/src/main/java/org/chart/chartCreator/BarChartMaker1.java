package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.IOException;

public class BarChartMaker1 {
    private String choose;
    private static String[] columnHeaders;
    private static String[][] rowData;
    private static String chartTitle;
    private static String xAxisLabel;
    private static String yAxisLabel;

    public BarChartMaker1(String choose, String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) throws IOException {
        this.choose = choose;
        this.columnHeaders = headers;
        this.rowData = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
    }
    public static ChartPanel getPanel(){
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        for (int i = 0; i < rowData.length; i++) {
            for (int j = 1; j < rowData[i].length; j++) {
                try {
                    double value = Double.parseDouble(rowData[i][j]);
                    barDataset.addValue(value, columnHeaders[j], rowData[i][0]);
                } catch (NumberFormatException e) {
                    // Eğer değer bir sayı değilse, grafiğe eklemiyoruz
                }
            }
        }
        JFreeChart chart = ChartFactory.createBarChart(
                chartTitle, // Chart Title
                xAxisLabel, // Category axis
                yAxisLabel, // Value axis
                barDataset,
                PlotOrientation.VERTICAL,
                true, true, false
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
        for (int i = 0; i < barDataset.getRowCount(); i++) {
            renderer.setSeriesPaint(i, colors[i % colors.length]);
        }
        return new ChartPanel(chart);
    }
}
