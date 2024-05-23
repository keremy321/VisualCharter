package org.chart.chartCreator;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.IOException;

public class CreateDataset {
    private String choose;
    private String[] columnHeaders;
    private String[][] rowData;
    private String chartTitle;
    private String xAxisLabel;
    private String yAxisLabel;

    public CreateDataset(String choose, String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel)throws IOException {
        this.choose = choose;
        this.columnHeaders = headers;
        this.rowData = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        switch (choose) {
            case "Line Chart":
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
                LineChartMaker.createAndShowLineChart(lineDataset, chartTitle, xAxisLabel, yAxisLabel);
                break;

            case "Bar Chart":
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
                BarChartMaker.createAndShowBarChart(barDataset, chartTitle, xAxisLabel, yAxisLabel);
                break;

            case "Pie Chart":
                DefaultPieDataset pieDataset = new DefaultPieDataset();
                for (int i = 0; i < rowData.length; i++) {
                    try {
                        double value = Double.parseDouble(rowData[i][1]); // İkinci sütunu değer olarak kabul ediyoruz
                        pieDataset.setValue(rowData[i][0], value); // İlk sütunu kategori olarak kullanıyoruz
                    } catch (NumberFormatException e) {
                        // Eğer değer bir sayı değilse, grafiğe eklemiyoruz
                    }
                }
                PieChartMaker.createAndShowPieChart(pieDataset, chartTitle);
                break;

            case "Scatter Chart":
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
                ScatterChartMaker.createAndShowPieChart(scatterDataset, chartTitle, xAxisLabel, yAxisLabel);
                break;

            default:
                throw new IllegalArgumentException("Unknown chart type: " + choose);
        }
    }

}

