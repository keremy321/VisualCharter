package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.IOException;

public class LineChartMaker1 {
    private String choose;
    private static String[] columnHeaders;
    private static String[][] rowData;
    private static String chartTitle;
    private static String xAxisLabel;
    private static String yAxisLabel;
    public LineChartMaker1(String choose, String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) throws IOException {
        this.choose = choose;
        this.columnHeaders = headers;
        this.rowData = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
    }
    public static ChartPanel getPanel(){
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
        for (int i = 0; i < rowData.length; i++) {
            for (int j = 1; j < rowData[i].length; j++) {
                try {
                    double value = Double.parseDouble(rowData[i][j]);
                    lineDataset.addValue(value, columnHeaders[j], rowData[i][0]);
                } catch (NumberFormatException e) {
                    // Eğer değer bir sayı değilse, grafiğe eklemiyoruz
                }
            }
        }
        JFreeChart chart = ChartFactory.createLineChart(
                chartTitle, // Chart title
                xAxisLabel, // X-Axis Label
                yAxisLabel, // Y-Axis Label
                lineDataset
        );

        return new ChartPanel(chart);
    }
}
