package org.chart;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ChartFrame extends JFrame implements ActionListener {
    JButton buttonBack;
    JButton buttonEnterData;
    JButton buttonClear;
    JButton button;

    JScrollPane scrollPane;

    JButton buttonSave;

    ChartFrame(){
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

        scrollPane = new JScrollPane();
        scrollPane.setBounds(70, 146, 780, 450);
        scrollPane.setBackground(new Color(0x363636));
        scrollPane.getViewport().setBackground(new Color(0x363636));

        JLabel labelButtonEffectSave = new JLabel();
        labelButtonEffectSave.setBounds(770, 516, 40, 40);
        labelButtonEffectSave.setBackground(new Color(0x262626));
        labelButtonEffectSave.setOpaque(false);

        ImageIcon saveIcon = new ImageIcon("src/main/java/images/saveIconWhite.png");

        buttonSave = new JButton();
        buttonSave.setBackground(new Color(0x217346));
        buttonSave.setBounds(770, 516, 40, 40);
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

        layeredPane.add(scrollPane);

        layeredPane.add(buttonSave, Integer.valueOf(1));
        layeredPane.add(labelButtonEffectSave, Integer.valueOf(1));

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

        if (e.getSource() == buttonSave){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG & JPG Files","png", "jpg");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){

            }
        }
    }

    public static BufferedImage getChartScreenShot(JScrollPane component){
        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_ARGB);
        component.paint(image.getGraphics());
        return image;
    }
}