package org.chart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JButton buttonEnterData;
    JButton buttonOpenFile;

    MainFrame(){
        ImageIcon icon  = new ImageIcon("src/main/java/images/icon.png");
        this.setIconImage(icon.getImage());

        JPanel panelTop = new JPanel();
        panelTop.setBackground(new Color(0x363636));
        panelTop.setBounds(0, 0, 920, 250);
        panelTop.setLayout(null);

        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(new Color(0x262626));
        panelBottom.setBounds(0, 250, 920, 670);
        panelBottom.setLayout(null);

        CirclePanel panelCircle = new CirclePanel();
        panelCircle.setBounds(360, 150, 200, 200);

        JLabel labelWelcomeText = new JLabel("Welcome to the App!");
        labelWelcomeText.setFont(new Font("Arial Black", Font.PLAIN, 29));
        labelWelcomeText.setForeground(Color.WHITE);
        labelWelcomeText.setBounds(0,0,920,300);
        labelWelcomeText.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelInfoText = new JLabel("This app made by ... in 2024");
        labelInfoText.setFont(new Font("Cambria Math", Font.PLAIN, 16));
        labelInfoText.setForeground(Color.WHITE);
        labelInfoText.setBounds(0,450,920,300);
        labelInfoText.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelButtonEffectEnterData = new JLabel();
        labelButtonEffectEnterData.setBounds(200, 250, 200, 190);
        labelButtonEffectEnterData.setBackground(new Color(0x363636));
        labelButtonEffectEnterData.setOpaque(false);

        //Enter Data Button
        buttonEnterData = new JButton("<html><div style='text-align: center;'>Enter<br>Data</div></html>");
        buttonEnterData.setBackground(new Color(0x217346));
        buttonEnterData.setBounds(200, 250, 200, 190);
        buttonEnterData.setFocusable(false);
        buttonEnterData.setForeground(Color.WHITE);
        buttonEnterData.setFont(new Font("Arial Black", Font.PLAIN, 32));
        buttonEnterData.addActionListener(this);
        buttonEnterData.setBorderPainted(false);
        buttonEnterData.addMouseListener(new ButtonMouseListener(buttonEnterData, labelButtonEffectEnterData));

        JLabel labelButtonEffectOpenFile = new JLabel();
        labelButtonEffectOpenFile.setBounds(520, 250, 200, 190);
        labelButtonEffectOpenFile.setBackground(new Color(0x363636));
        labelButtonEffectOpenFile.setOpaque(false);

        //Open File Button
        buttonOpenFile = new JButton("<html><div style='text-align: center;'>Open<br>File</div></html>");
        buttonOpenFile.setBackground(new Color(0x217346));
        buttonOpenFile.setBounds(520, 250, 200, 190);
        buttonOpenFile.setFocusable(false);
        buttonOpenFile.setForeground(Color.WHITE);
        buttonOpenFile.setFont(new Font("Arial Black", Font.PLAIN, 32));
        buttonOpenFile.addActionListener(this);
        buttonOpenFile.setBorderPainted(false);
        buttonOpenFile.addMouseListener(new ButtonMouseListener(buttonOpenFile, labelButtonEffectOpenFile));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,920,920);

        this.add(layeredPane);
        layeredPane.add(panelTop);
        layeredPane.add(panelBottom);
        layeredPane.add(panelCircle, Integer.valueOf(1));
        panelBottom.add(buttonEnterData);
        panelBottom.add(buttonOpenFile);
        panelBottom.add(labelWelcomeText);
        panelBottom.add(labelInfoText);
        panelBottom.add(labelButtonEffectEnterData);
        panelBottom.add(labelButtonEffectOpenFile);

        this.setLayout(null);
        this.setTitle("Chart");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(920, 920);
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonEnterData){
            this.dispose();
            EnterDataFrame enterDataFrame = new EnterDataFrame();
        }

        if (e.getSource() == buttonOpenFile){
            this.dispose();
            OpenFileFrame openFileFrame = new OpenFileFrame();
        }
    }
}
