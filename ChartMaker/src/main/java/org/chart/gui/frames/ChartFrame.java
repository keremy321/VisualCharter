package org.chart.gui.frames;

import org.chart.chartCreator.BarChartMaker;
import org.chart.chartCreator.LineChartMaker;
import org.chart.chartCreator.PieChartMaker;
import org.chart.chartCreator.ScatterChartMaker;
import org.chart.gui.customizations.ButtonMouseListener;
import org.chart.gui.customizations.ButtonMouseListenerMenu;
import org.chart.gui.customizations.CirclePanel;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class ChartFrame extends JFrame implements ActionListener {
    String choose;
    String[] headers;
    String[][] data;
    String chartTitle;
    String xAxisLabel;
    String yAxisLabel;

    JButton buttonBack;
    JButton buttonEnterData;
    JButton buttonClear;
    JButton button;

    JScrollPane scrollPane;

    JButton buttonSave;

    public ChartFrame(String choose, String[] headers, String[][] data, String chartTitle, String xAxisLabel, String yAxisLabel) throws IOException {
        this.choose = choose;
        this.headers = headers;
        this.data = data;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(0x363636));
        panelMenu.setBounds(0, 40, 800, 50);
        panelMenu.setLayout(null);

        CirclePanel panelCircle = new CirclePanel();
        panelCircle.setBounds(360, 25, 80, 80);

        ImageIcon lineGreen = null;
        try {
            URL lineGreenURL = getClass().getResource("/greenLine.png");
            if (lineGreenURL != null) {
                lineGreen = new ImageIcon(lineGreenURL);
            } else {
                System.err.println("Resource not found: /greenLine.png");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel labelMenuLine1 = new JLabel();
        labelMenuLine1.setIcon(lineGreen);
        labelMenuLine1.setBounds(17, 55, 60, 20);

        JLabel labelMenuLine2 = new JLabel();
        labelMenuLine2.setIcon(lineGreen);
        labelMenuLine2.setBounds(180, 55, 60, 20);

        JLabel labelMenuLine3 = new JLabel();
        labelMenuLine3.setIcon(lineGreen);
        labelMenuLine3.setBounds(343, 55, 60, 20);

        JLabel labelMenuLine4 = new JLabel();
        labelMenuLine4.setIcon(lineGreen);
        labelMenuLine4.setBounds(457, 55, 60, 20);

        JLabel labelMenuLine5 = new JLabel();
        labelMenuLine5.setIcon(lineGreen);
        labelMenuLine5.setBounds(620, 55, 60, 20);

        JLabel labelMenuLine6 = new JLabel();
        labelMenuLine6.setIcon(lineGreen);
        labelMenuLine6.setBounds(783, 55, 60, 20);

        JLabel labelButtonEffectBack = new JLabel();
        labelButtonEffectBack.setBounds(34, 50, 129, 30);
        labelButtonEffectBack.setBackground(new Color(0x0E5C2F));
        labelButtonEffectBack.setOpaque(false);

        buttonBack = new JButton("Back");
        buttonBack.setBounds(34, 50, 129, 30);
        buttonBack.setFocusable(false);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonBack.addActionListener(this);
        buttonBack.setBorderPainted(false);
        buttonBack.setBackground(new Color(0x262626));
        buttonBack.addMouseListener(new ButtonMouseListenerMenu(buttonBack, labelButtonEffectBack));
        buttonBack.setContentAreaFilled(false);

        JLabel labelButtonEffectEnterData = new JLabel();
        labelButtonEffectEnterData.setBounds(197, 50, 129, 30);
        labelButtonEffectEnterData.setBackground(new Color(0x0E5C2F));
        labelButtonEffectEnterData.setOpaque(false);

        buttonEnterData = new JButton("Enter Data");
        buttonEnterData.setBounds(197, 50, 129, 30);
        buttonEnterData.setFocusable(false);
        buttonEnterData.setForeground(Color.WHITE);
        buttonEnterData.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonEnterData.addActionListener(this);
        buttonEnterData.setBorderPainted(false);
        buttonEnterData.setBackground(new Color(0x262626));
        buttonEnterData.addMouseListener(new ButtonMouseListenerMenu(buttonEnterData, labelButtonEffectEnterData));
        buttonEnterData.setContentAreaFilled(false);

        JLabel labelButtonEffectClear = new JLabel();
        labelButtonEffectClear.setBounds(474, 50, 129, 30);
        labelButtonEffectClear.setBackground(new Color(0x0E5C2F));
        labelButtonEffectClear.setOpaque(false);

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(474, 50, 129, 30);
        buttonClear.setFocusable(false);
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFont(new Font("Arial Black", Font.PLAIN, 14));
        buttonClear.addActionListener(this);
        buttonClear.setBorderPainted(false);
        buttonClear.setBackground(new Color(0x262626));
        buttonClear.addMouseListener(new ButtonMouseListenerMenu(buttonClear, labelButtonEffectClear));
        buttonClear.setContentAreaFilled(false);

        JLabel labelButtonEffect = new JLabel();
        labelButtonEffect.setBounds(637, 50, 129, 30);
        labelButtonEffect.setBackground(new Color(0x0E5C2F));
        labelButtonEffect.setOpaque(false);

        button = new JButton("Button");
        button.setBounds(637, 50, 129, 30);
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial Black", Font.PLAIN, 14));
        button.addActionListener(this);
        button.setBorderPainted(false);
        button.setBackground(new Color(0x262626));
        button.addMouseListener(new ButtonMouseListenerMenu(button, labelButtonEffect));
        button.setContentAreaFilled(false);

        ChartPanel chartPanel = getPanel();
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 120, 700, 400);
        scrollPane.setBackground(new Color(0x363636));
        scrollPane.getViewport().setBackground(new Color(0x363636));

        JLabel labelButtonEffectSave = new JLabel();
        labelButtonEffectSave.setBounds(680, 450, 40, 40);
        labelButtonEffectSave.setBackground(new Color(0x262626));
        labelButtonEffectSave.setOpaque(false);

        ImageIcon saveIcon = null;
        try {
            URL saveIconURL = getClass().getResource("/saveIconWhite.png");
            if (saveIconURL != null) {
                saveIcon = new ImageIcon(saveIconURL);
            } else {
                System.err.println("Resource not found: /saveIconWhite.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonSave = new JButton();
        buttonSave.setBackground(new Color(0x217346));
        buttonSave.setBounds(680, 450, 40, 40);
        buttonSave.setIcon(saveIcon);
        buttonSave.setFocusable(false);
        buttonSave.addActionListener(this);
        buttonSave.setBorderPainted(false);
        buttonSave.addMouseListener(new ButtonMouseListener(buttonSave, labelButtonEffectSave));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,920,920);

        this.add(layeredPane);
        layeredPane.add(panelMenu);

        layeredPane.add(panelCircle, Integer.valueOf(1));

        layeredPane.add(buttonBack, Integer.valueOf(1));
        layeredPane.add(buttonEnterData, Integer.valueOf(1));
        layeredPane.add(buttonClear, Integer.valueOf(1));
        layeredPane.add(button, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectBack, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectEnterData, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectClear, Integer.valueOf(1));
        layeredPane.add(labelButtonEffect, Integer.valueOf(1));

        layeredPane.add(chartPanel, Integer.valueOf(1));

        layeredPane.add(buttonSave, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectSave, Integer.valueOf(1));

        layeredPane.add(labelMenuLine1, Integer.valueOf(1));
        layeredPane.add(labelMenuLine2, Integer.valueOf(1));
        layeredPane.add(labelMenuLine3, Integer.valueOf(1));
        layeredPane.add(labelMenuLine4, Integer.valueOf(1));
        layeredPane.add(labelMenuLine5, Integer.valueOf(1));
        layeredPane.add(labelMenuLine6, Integer.valueOf(1));

        this.getContentPane().setBackground(new Color(0x262626));
        this.setLayout(null);
        this.setTitle("Open File Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(816, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBack){
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }

        if (e.getSource() == buttonEnterData){
            this.dispose();
            EnterDataFrame enterDataFrame = new EnterDataFrame();
        }

        if (e.getSource() == buttonSave){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG & JPG Files","png", "jpg");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){

            }
        }
    }

    public ChartPanel getPanel() throws IOException {
        if (choose.equals("Line Chart")){
            LineChartMaker chartMaker = new LineChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            ChartPanel chartPanel = chartMaker.getPanel();
            chartPanel.setBounds(50, 120, 700, 400);
            return chartPanel;
        }
        else if (choose.equals("Pie Chart")){
            PieChartMaker chartMaker = new PieChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            ChartPanel chartPanel = chartMaker.getPanel();
            chartPanel.setBounds(50, 120, 700, 400);
            return chartPanel;
        }
        else if (choose.equals("Scatter Chart")){
            ScatterChartMaker chartMaker = new ScatterChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            ChartPanel chartPanel = chartMaker.getPanel();
            chartPanel.setBounds(50, 120, 700, 400);
            return chartPanel;
        }
        else if (choose.equals("Bar Chart")){
            BarChartMaker chartMaker = new BarChartMaker(headers, data, chartTitle, xAxisLabel, yAxisLabel);
            ChartPanel chartPanel = chartMaker.getPanel();
            chartPanel.setBounds(50, 120, 700, 400);
            return chartPanel;
        }
        return null;
    }
}