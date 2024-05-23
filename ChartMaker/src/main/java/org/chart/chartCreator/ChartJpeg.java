package org.chart.chartCreator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChartJpeg {
    public static void BarChartJpeg(CategoryDataset dataset, String chartTitle, String xAxisLabel, String yAxisLabel) throws IOException {
        JFreeChart barChart = ChartFactory.createBarChart(
                "CAR USAGE STATIStICS",
                "Category", "Score",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
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

        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File BarChart = new File( "BarChart.jpeg" );
        ChartUtils.saveChartAsJPEG( BarChart , barChart , width , height );
    }
    public static void LineChartJpeg(DefaultCategoryDataset dataset, String chartTitle, String xAxisLabel, String yAxisLabel)throws IOException{
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Schools Vs Years","Year",
                "Schools Count",
                dataset,PlotOrientation.VERTICAL,
                true,true,false);

        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File lineChart = new File( "LineChart.jpeg" );
        ChartUtils.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
    }
    public static void PieChartJpeg(DefaultPieDataset dataset, String chartTitle)throws IOException{
        JFreeChart chart = ChartFactory.createPieChart(
                "Mobile Sales",   // chart title
                dataset,          // data
                true,             // include legend
                true,             //tooltips
                false);           //urls
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

        int width = 640;   /* Width of the image */
        int height = 480;  /* Height of the image */
        File pieChart = new File( "PieChart.jpeg" );
        ChartUtils.saveChartAsJPEG( pieChart , chart , width , height );
    }
    public static void ScatterChartJpeg(XYSeriesCollection dataset, String chartTitle, String xAxisLabel, String yAxisLabel)throws IOException{
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Boys VS Girls weight comparison chart",//grafik başlığı
                "X-Axis", "Y-Axis", dataset);//x ve y eksenlerinin isimleri
        int width = 640;
        int height = 480;
        File ScatterChart = new File( "ScatterChart.jpeg" );
        ChartUtils.saveChartAsJPEG( ScatterChart , chart , width , height );
    }
}
