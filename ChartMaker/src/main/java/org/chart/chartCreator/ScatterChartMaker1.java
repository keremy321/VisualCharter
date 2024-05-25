package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.IOException;

public class ScatterChartMaker1 {
    private String choose;
    private static String[] columnHeaders;
    private static String[][] rowData;
    private static String chartTitle;
    private static String xAxisLabel;
    private static String yAxisLabel;
    public ScatterChartMaker1(String choose, String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) throws IOException {
        this.choose = choose;
        this.columnHeaders = headers;
        this.rowData = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
    }
    public static ChartPanel getPanel(){
        XYSeriesCollection scatterDataset = new XYSeriesCollection();
        for (int j = 1; j < columnHeaders.length; j++) { // Assume the first column is the category
            XYSeries series = new XYSeries(columnHeaders[j]);
            for (int i = 0; i < rowData.length; i++) {
                try {
                    double xValue = Double.parseDouble(rowData[i][0]); // X-axis value
                    double yValue = Double.parseDouble(rowData[i][j]); // Y-axis value
                    series.add(xValue, yValue);
                } catch (NumberFormatException e) {
                    // If the value is not a number, do not add it to the chart
                }
            }
            scatterDataset.addSeries(series);
        }
        JFreeChart chart = ChartFactory.createScatterPlot(
                chartTitle,
                xAxisLabel,
                yAxisLabel,
                scatterDataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return new ChartPanel(chart);
    }
}
