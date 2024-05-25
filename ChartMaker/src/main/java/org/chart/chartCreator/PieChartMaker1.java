package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class PieChartMaker1 {
    private String choose;
    private static String[] columnHeaders;
    private static String[][] rowData;
    private static String chartTitle;
    private static String xAxisLabel;
    private static String yAxisLabel;
    public PieChartMaker1(String choose, String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) throws IOException {
        this.choose = choose;
        this.columnHeaders = headers;
        this.rowData = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
    }
    public static ChartPanel getPanel(){
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (int i = 0; i < rowData.length; i++) {
            try {
                double value = Double.parseDouble(rowData[i][1]); // İkinci sütunu değer olarak kabul ediyoruz
                pieDataset.setValue(rowData[i][0], value); // İlk sütunu kategori olarak kullanıyoruz
            } catch (NumberFormatException e) {
                // Eğer değer bir sayı değilse, grafiğe eklemiyoruz
            }
        }
        JFreeChart chart = ChartFactory.createPieChart(
                chartTitle,
                pieDataset,
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
        int sectionCount = pieDataset.getItemCount();

        for (int i = 0; i < sectionCount; i++) {
            plot.setSectionPaint(pieDataset.getKey(i), colors[i % colors.length]);
        }

        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);


        return new ChartPanel(chart);
    }
}
