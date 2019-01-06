package com.cac.components.launch;

import com.google.common.io.Resources;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class SwingLaunch {
    public static final int SIZE = 128;

    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(64, 64, 64);
    public static final Color WHITE = new Color(255, 255, 255);

    public static final Color RED = new Color(255, 128, 128);
    public static final Color GREEN = new Color(0, 255, 128);
    public static final Color BLUE = new Color(0, 162, 232);
    public static final Color YELLOW = new Color(239, 228, 176);
    public static final Color PURPLE = new Color(200, 191, 231);
    public static final Color PINK = new Color(255, 128, 255);
    public static final Color ORANGE = new Color(255, 128, 0);
    public static final Color TEAL = new Color(0, 128, 128);
    public static final Color BROWN = new Color(128, 64, 64);

    public static void main(String[] args) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
//        mainPanel.setLayout(new GridLayout(3, 3));
//        List<Color> colors = Lists.newArrayList(RED, GREEN, BLUE, YELLOW, PURPLE, PINK, ORANGE, TEAL, BROWN);
//        for (Color color : colors) {
//            JPanel colorPanel = createPanel(color);
//            mainPanel.add(colorPanel);
//        }
        JLayeredPane pane = new JLayeredPane();
        pane.add(createIcon("icons/asterisk.png"));
        pane.add(createIcon("icons/fill.png"));
        pane.add(createIcon("icons/outline.png"));
        pane.setPreferredSize(new Dimension(256, 256));
        mainPanel.add(pane);
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel createPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBorder(new LineBorder(BLACK, 3));
        panel.setPreferredSize(new Dimension(SIZE, SIZE));
        return panel;
    }

    private static JLabel createIcon(String iconPath) {
        JLabel icon = new JLabel(new ImageIcon(Resources.getResource(iconPath)));
        icon.setBounds(0, 0, 32, 32);
        return icon;
    }
}
