package org.chart.gui.frames;

import org.chart.gui.customizations.ButtonMouseListener;
import org.chart.gui.customizations.CirclePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MainFrame extends JFrame implements ActionListener {
    JButton buttonEnterData;
    JButton buttonOpenFile;

    public MainFrame(){

        URL iconURL = getClass().getResource("/icon.png");
        assert iconURL != null;
        ImageIcon icon  = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());

        JPanel panelTop = new JPanel();
        panelTop.setBackground(new Color(0x363636));
        panelTop.setBounds(0, 0, 920, 200);
        panelTop.setLayout(null);

        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(new Color(0x262626));
        panelBottom.setBounds(0, 200, 920, 600);
        panelBottom.setLayout(null);

        CirclePanel panelCircle = new CirclePanel();
        panelCircle.setBounds(320, 120, 160, 160);

        JLabel labelWelcomeText = new JLabel("Welcome to the App!");
        labelWelcomeText.setFont(new Font("Arial Black", Font.PLAIN, 24));
        labelWelcomeText.setForeground(Color.WHITE);
        labelWelcomeText.setBounds(0,100,800,30);
        labelWelcomeText.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelInfoText = new JLabel("This app made by Kerem YILMAZ, Salih Kerim ASLAN, Semih BEKDAŞ, Ahmet Emin ÇAKIR in 2024");
        labelInfoText.setFont(new Font("Cambria Math", Font.PLAIN, 16));
        labelInfoText.setForeground(Color.WHITE);
        labelInfoText.setBounds(0,530,800,20);
        labelInfoText.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelButtonEffectEnterData = new JLabel();
        labelButtonEffectEnterData.setBounds(140, 220, 200, 190);
        labelButtonEffectEnterData.setBackground(new Color(0x363636));
        labelButtonEffectEnterData.setOpaque(false);

        //Enter Data Button
        buttonEnterData = new JButton("<html><div style='text-align: center;'>Enter<br>Data</div></html>");
        buttonEnterData.setBackground(new Color(0x217346));
        buttonEnterData.setBounds(140, 220, 200, 190);
        buttonEnterData.setFocusable(false);
        buttonEnterData.setForeground(Color.WHITE);
        buttonEnterData.setFont(new Font("Arial Black", Font.PLAIN, 32));
        buttonEnterData.addActionListener(this);
        buttonEnterData.setBorderPainted(false);
        buttonEnterData.addMouseListener(new ButtonMouseListener(buttonEnterData, labelButtonEffectEnterData));

        JLabel labelButtonEffectOpenFile = new JLabel();
        labelButtonEffectOpenFile.setBounds(460, 220, 200, 190);
        labelButtonEffectOpenFile.setBackground(new Color(0x363636));
        labelButtonEffectOpenFile.setOpaque(false);

        //Open File Button
        buttonOpenFile = new JButton("<html><div style='text-align: center;'>Open<br>File</div></html>");
        buttonOpenFile.setBackground(new Color(0x217346));
        buttonOpenFile.setBounds(460, 220, 200, 190);
        buttonOpenFile.setFocusable(false);
        buttonOpenFile.setForeground(Color.WHITE);
        buttonOpenFile.setFont(new Font("Arial Black", Font.PLAIN, 32));
        buttonOpenFile.addActionListener(this);
        buttonOpenFile.setBorderPainted(false);
        buttonOpenFile.addMouseListener(new ButtonMouseListener(buttonOpenFile, labelButtonEffectOpenFile));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,816,800);

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
        this.setSize(816, 800);
        this.setLocationRelativeTo(null);
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
