package org.chart.gui.customizations;

import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    public CirclePanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int diameter = Math.min(width, height);

        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        g.setColor(Color.BLACK);
        g.fillOval(x, y, diameter, diameter);
    }
}
