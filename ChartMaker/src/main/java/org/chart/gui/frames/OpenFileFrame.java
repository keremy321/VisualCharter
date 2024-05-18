package org.chart.gui.frames;

import org.chart.fileReader.CSVReader;
import org.chart.fileReader.ExcelReader;
import org.chart.gui.customizations.ButtonMouseListener;
import org.chart.gui.customizations.ButtonMouseListenerMenu;
import org.chart.gui.customizations.CenterTextCellRenderer;
import org.chart.gui.customizations.CirclePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenFileFrame extends JFrame implements ActionListener {
    JButton buttonBack;
    JButton buttonEnterData;
    JButton buttonClear;
    JButton button;
    JButton buttonCreate;
    JButton buttonOpenFile;

    JComboBox comboBoxChartType;

    JTextField textFieldChartTitle;
    JTextField textFieldNumberOfRows;
    JTextField textFieldNumberOfColumns;

    DefaultTableModel tableModel;

    int rowsCount;
    int columnsCount;

    String filePath;

    OpenFileFrame(){

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(0x363636));
        panelMenu.setBounds(0, 50, 920, 60);
        panelMenu.setLayout(null);

        CirclePanel panelCircle = new CirclePanel();
        panelCircle.setBounds(400, 30, 100, 100);

        ImageIcon lineGreen = new ImageIcon("src/main/java/images/greenLine.png");

        JLabel labelMenuLine1 = new JLabel();
        labelMenuLine1.setIcon(lineGreen);
        labelMenuLine1.setBounds(8, 65, 60, 30);

        JLabel labelMenuLine2 = new JLabel();
        labelMenuLine2.setIcon(lineGreen);
        labelMenuLine2.setBounds(195, 65, 60, 30);

        JLabel labelMenuLine3 = new JLabel();
        labelMenuLine3.setIcon(lineGreen);
        labelMenuLine3.setBounds(518, 65, 60, 30);

        JLabel labelMenuLine4 = new JLabel();
        labelMenuLine4.setIcon(lineGreen);
        labelMenuLine4.setBounds(705, 65, 60, 30);

        JLabel labelMenuLine5 = new JLabel();
        labelMenuLine5.setIcon(lineGreen);
        labelMenuLine5.setBounds(382, 65, 60, 30);

        JLabel labelMenuLine6 = new JLabel();
        labelMenuLine6.setIcon(lineGreen);
        labelMenuLine6.setBounds(892, 65, 60, 30);

        JLabel labelButtonEffectBack = new JLabel();
        labelButtonEffectBack.setBounds(26, 60, 151, 40);
        labelButtonEffectBack.setBackground(new Color(0x0E5C2F));
        labelButtonEffectBack.setOpaque(false);

        buttonBack = new JButton("Back");
        buttonBack.setBounds(26, 60, 151, 40);
        buttonBack.setFocusable(false);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font("Arial Black", Font.PLAIN, 20));
        buttonBack.addActionListener(this);
        buttonBack.setBorderPainted(false);
        buttonBack.setBackground(new Color(0x262626));
        buttonBack.addMouseListener(new ButtonMouseListenerMenu(buttonBack, labelButtonEffectBack));
        buttonBack.setContentAreaFilled(false);

        JLabel labelButtonEffectEnterData = new JLabel();
        labelButtonEffectEnterData.setBounds(213, 60, 151, 40);
        labelButtonEffectEnterData.setBackground(new Color(0x0E5C2F));
        labelButtonEffectEnterData.setOpaque(false);

        buttonEnterData = new JButton("Enter Data");
        buttonEnterData.setBounds(213, 60, 151, 40);
        buttonEnterData.setFocusable(false);
        buttonEnterData.setForeground(Color.WHITE);
        buttonEnterData.setFont(new Font("Arial Black", Font.PLAIN, 20));
        buttonEnterData.addActionListener(this);
        buttonEnterData.setBorderPainted(false);
        buttonEnterData.setBackground(new Color(0x262626));
        buttonEnterData.addMouseListener(new ButtonMouseListenerMenu(buttonEnterData, labelButtonEffectEnterData));
        buttonEnterData.setContentAreaFilled(false);

        JLabel labelButtonEffectClear = new JLabel();
        labelButtonEffectClear.setBounds(536, 60, 151, 40);
        labelButtonEffectClear.setBackground(new Color(0x0E5C2F));
        labelButtonEffectClear.setOpaque(false);

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(536, 60, 151, 40);
        buttonClear.setFocusable(false);
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFont(new Font("Arial Black", Font.PLAIN, 20));
        buttonClear.addActionListener(this);
        buttonClear.setBorderPainted(false);
        buttonClear.setBackground(new Color(0x262626));
        buttonClear.addMouseListener(new ButtonMouseListenerMenu(buttonClear, labelButtonEffectClear));
        buttonClear.setContentAreaFilled(false);

        JLabel labelButtonEffect = new JLabel();
        labelButtonEffect.setBounds(723, 60, 151, 40);
        labelButtonEffect.setBackground(new Color(0x0E5C2F));
        labelButtonEffect.setOpaque(false);

        button = new JButton("Button");
        button.setBounds(723, 60, 151, 40);
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial Black", Font.PLAIN, 20));
        button.addActionListener(this);
        button.setBorderPainted(false);
        button.setBackground(new Color(0x262626));
        button.addMouseListener(new ButtonMouseListenerMenu(button, labelButtonEffect));
        button.setContentAreaFilled(false);

        ImageIcon labelTextfield = new ImageIcon("src/main/java/images/textFieldName.png");

        JLabel labelTextfieldChartTitle = new JLabel();
        labelTextfieldChartTitle.setIcon(labelTextfield);
        labelTextfieldChartTitle.setBounds(90, 146, 160, 34);
        labelTextfieldChartTitle.setText("Chart Title");
        labelTextfieldChartTitle.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldChartTitle.setForeground(Color.WHITE);
        labelTextfieldChartTitle.setHorizontalTextPosition(JLabel.CENTER);

        textFieldChartTitle = new JTextField("Chart Title");
        textFieldChartTitle.setBounds(70, 170, 300, 40);
        textFieldChartTitle.setBackground(new Color(0x363636));
        textFieldChartTitle.setForeground(Color.WHITE);
        textFieldChartTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldChartTitle.setCaretColor(new Color(0xC9C9C9));
        textFieldChartTitle.setHorizontalAlignment(JTextField.CENTER);

        JLabel labelButtonEffectOpenFile = new JLabel();
        labelButtonEffectOpenFile.setBounds(550, 180, 300, 40);
        labelButtonEffectOpenFile.setBackground(new Color(0x363636));
        labelButtonEffectOpenFile.setOpaque(false);

        buttonOpenFile = new JButton("<html><div style='text-align: center;'>Open File</div></html>");
        buttonOpenFile.setBackground(new Color(0x217346));
        buttonOpenFile.setBounds(550, 170, 300, 40);
        buttonOpenFile.setFocusable(false);
        buttonOpenFile.setForeground(Color.WHITE);
        buttonOpenFile.setFont(new Font("Arial Black", Font.PLAIN, 16));
        buttonOpenFile.addActionListener(this);
        buttonOpenFile.setBorderPainted(false);
        buttonOpenFile.addMouseListener(new ButtonMouseListener(buttonOpenFile, labelButtonEffectOpenFile));

        JLabel labelTextfieldRow = new JLabel();
        labelTextfieldRow.setIcon(labelTextfield);
        labelTextfieldRow.setBounds(90, 226, 160, 34);
        labelTextfieldRow.setText("Number of Rows");
        labelTextfieldRow.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldRow.setForeground(Color.WHITE);
        labelTextfieldRow.setHorizontalTextPosition(JLabel.CENTER);

        textFieldNumberOfRows = new JTextField("Number of Rows");
        textFieldNumberOfRows.setBounds(70, 250, 300, 40);
        textFieldNumberOfRows.setBackground(new Color(0x363636));
        textFieldNumberOfRows.setForeground(Color.WHITE);
        textFieldNumberOfRows.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldNumberOfRows.setCaretColor(new Color(0xC9C9C9));
        textFieldNumberOfRows.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfRows.setEditable(false);

        JLabel labelTextfieldColumn = new JLabel();
        labelTextfieldColumn.setIcon(labelTextfield);
        labelTextfieldColumn.setBounds(570, 226, 160, 34);
        labelTextfieldColumn.setText("Number of Columns");
        labelTextfieldColumn.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelTextfieldColumn.setForeground(Color.WHITE);
        labelTextfieldColumn.setHorizontalTextPosition(JLabel.CENTER);

        textFieldNumberOfColumns = new JTextField("Number of Columns");
        textFieldNumberOfColumns.setBounds(550, 250, 300, 40);
        textFieldNumberOfColumns.setBackground(new Color(0x363636));
        textFieldNumberOfColumns.setForeground(Color.WHITE);
        textFieldNumberOfColumns.setFont(new Font("Arial Black", Font.PLAIN, 16));
        textFieldNumberOfColumns.setCaretColor(new Color(0xC9C9C9));
        textFieldNumberOfColumns.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfColumns.setEditable(false);

        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setFont(new Font("Arial Black", Font.PLAIN, 16));
        table.setBackground(new Color(0x217346));
        table.setForeground(Color.WHITE);
        table.setRowHeight(36);
        table.getTableHeader().setFont(new Font("Arial Black", Font.PLAIN, 24));
        table.getTableHeader().setBackground(new Color(0x0E5C2F));
        table.getTableHeader().setForeground(Color.WHITE);
        rowsCount = table.getRowCount();
        columnsCount = table.getColumnCount();
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        table.setSelectionBackground(new Color(0x0E5C2F));
        table.setSelectionForeground(Color.WHITE);

        CenterTextCellRenderer centerRenderer = new CenterTextCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 320, 780, 450);
        scrollPane.setBackground(new Color(0x363636));
        scrollPane.getViewport().setBackground(new Color(0x363636));

        JLabel labelButtonEffectCreate = new JLabel();
        labelButtonEffectCreate.setBounds(550, 800, 300, 40);
        labelButtonEffectCreate.setBackground(new Color(0x363636));
        labelButtonEffectCreate.setOpaque(false);

        buttonCreate = new JButton("<html><div style='text-align: center;'>Create</div></html>");
        buttonCreate.setBackground(new Color(0x217346));
        buttonCreate.setBounds(550, 800, 300, 40);
        buttonCreate.setFocusable(false);
        buttonCreate.setForeground(Color.WHITE);
        buttonCreate.setFont(new Font("Arial Black", Font.PLAIN, 16));
        buttonCreate.addActionListener(this);
        buttonCreate.setBorderPainted(false);
        buttonCreate.addMouseListener(new ButtonMouseListener(buttonCreate, labelButtonEffectCreate));

        String[] chartTypes = {"Line Chart", "Bar Chart", "Scatter Chart", "Pie Chart"};
        comboBoxChartType = new JComboBox(chartTypes);
        comboBoxChartType.setBounds(70, 800, 300, 40);
        comboBoxChartType.addActionListener(this);
        comboBoxChartType.setFont(new Font("Arial Black", Font.PLAIN, 16));
        comboBoxChartType.setBackground(new Color(0x217346));
        comboBoxChartType.setForeground(Color.WHITE);
        comboBoxChartType.setFocusable(false);
        comboBoxChartType.insertItemAt("Select a Chart Type", 0);
        comboBoxChartType.setSelectedIndex(0);
        comboBoxChartType.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        layeredPane.add(buttonOpenFile);
        layeredPane.add(labelButtonEffectOpenFile);
        layeredPane.add(buttonCreate);
        layeredPane.add(labelButtonEffectCreate);
        layeredPane.add(textFieldChartTitle);
        layeredPane.add(comboBoxChartType);

        layeredPane.add(scrollPane);
        layeredPane.add(textFieldNumberOfRows);
        layeredPane.add(textFieldNumberOfColumns);
        layeredPane.add(labelMenuLine1, Integer.valueOf(1));
        layeredPane.add(labelMenuLine2, Integer.valueOf(1));
        layeredPane.add(labelMenuLine3, Integer.valueOf(1));
        layeredPane.add(labelMenuLine4, Integer.valueOf(1));
        layeredPane.add(labelMenuLine5, Integer.valueOf(1));
        layeredPane.add(labelMenuLine6, Integer.valueOf(1));

        layeredPane.add(labelTextfieldChartTitle, Integer.valueOf(2));
        layeredPane.add(labelTextfieldRow, Integer.valueOf(2));
        layeredPane.add(labelTextfieldColumn, Integer.valueOf(2));

        this.getContentPane().setBackground(new Color(0x262626));
        this.setLayout(null);
        this.setTitle("Open File Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(920, 920);
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

        if (e.getSource() == buttonClear){
            clear();
        }

        if (e.getSource() == buttonOpenFile){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel & CSV Files","xlsx", "csv");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                clear();

                filePath = String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile());

                File file = new File(filePath);
                String fileExtension = getFileExtension(file);

                ImageIcon excelIcon = new ImageIcon("src/main/java/images/excelButtonIcon.png");
                ImageIcon csvIcon = new ImageIcon("src/main/java/images/csvButtonIcon.png");

                buttonOpenFile.setHorizontalAlignment(SwingConstants.LEFT);
                buttonOpenFile.setText(file.getName());


                if (fileExtension.equalsIgnoreCase("xlsx")){ // If it's an Excel file...
                    buttonOpenFile.setIcon(excelIcon);

                    try {
                        ExcelReader excelReader = new ExcelReader(filePath);
                        rowsCount = excelReader.getRowCount();
                        columnsCount = excelReader.getColumnCount();

                        String[] headers = excelReader.headersToArray();
                        String[][] data = excelReader.dataToArray();

                        tableModel.setColumnIdentifiers(headers);

                        for (int i = 0; i < data.length; i++){
                            tableModel.addRow(data[i]);
                        }
                    }

                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else if (fileExtension.equalsIgnoreCase("csv")){ // If it's an CSV file...
                    buttonOpenFile.setIcon(csvIcon);

                    try {
                        CSVReader csvReader = new CSVReader(filePath);
                        rowsCount = csvReader.getRowCount();
                        columnsCount = csvReader.getColumnCount();

                        String[] headers = csvReader.getHeader();
                        String[][] data = csvReader.getData();

                        tableModel.setColumnIdentifiers(headers);

                        for (int i = 0; i < data.length; i++){
                            tableModel.addRow(data[i]);
                        }

                    }

                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else {
                    System.out.println("Error!");
                }

                textFieldNumberOfRows.setText( String.valueOf(rowsCount));
                textFieldNumberOfColumns.setText(String.valueOf(columnsCount));
            }
        }

        if (e.getSource() == buttonCreate){
            this.dispose();
            ChartFrame chartFrame = new ChartFrame();
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == 0 || dotIndex == fileName.length() - 1) {
            return "";
        }
        else {
            return fileName.substring(dotIndex + 1);
        }
    }

    public void clear(){
        textFieldChartTitle.setText("Chart Title");
        textFieldNumberOfRows.setText("Number of Rows");
        textFieldNumberOfColumns.setText("Number of Columns");

        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);

        comboBoxChartType.setSelectedIndex(0);

        buttonOpenFile.setIcon(null);
        buttonOpenFile.setText("<html><div style='text-align: center;'>Open File</div></html>");
        buttonOpenFile.setHorizontalAlignment(SwingConstants.CENTER);

        filePath = null;
    }
}