package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class ScatterChartMaker {
    private static String[] columnHeaders;
    private static String[][] rowData;
    private static String chartTitle;
    private static String xAxisLabel;
    private static String yAxisLabel;
    public ScatterChartMaker(String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) {
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

        // Set background color
        chart.setBackgroundPaint(new Color(0x363636));

        // Set chart title
        TextTitle title = chart.getTitle();
        title.setPaint(Color.WHITE);
        title.setPadding(new RectangleInsets(10, 0, 0, 0));

        // Customize plot
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(new Color(0x363636));

        // Customize axes
        plot.getDomainAxis().setLabelPaint(Color.WHITE);
        plot.getRangeAxis().setLabelPaint(Color.WHITE);
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        plot.getDomainAxis().setAxisLinePaint(Color.WHITE);
        plot.getRangeAxis().setAxisLinePaint(Color.WHITE);

        // Customize legend
        chart.getLegend().setBackgroundPaint(new Color(0x363636));
        chart.getLegend().setItemPaint(Color.WHITE);

        // Customize series colors (optional)
        plot.getRenderer().setSeriesPaint(0, new Color(0x2D7C3C));
        plot.getRenderer().setSeriesPaint(1, new Color(0xD24738));
        plot.getRenderer().setSeriesPaint(2, new Color(0x5EADD6));


        return new ChartPanel(chart);
    }
}
