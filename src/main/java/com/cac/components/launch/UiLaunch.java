package com.cac.components.launch;

import com.cac.components.ui.Color;
import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.border.LineBorder;
import com.cac.components.ui.component.Container;
import com.cac.components.ui.component.Frame;
import com.cac.components.ui.component.Panel;
import com.cac.components.ui.component.dialog.ConfirmDialog;
import com.cac.components.ui.component.dialog.Dialog;
import com.cac.components.ui.component.dialog.MessageDialog;
import com.cac.components.ui.component.dialog.MessageType;
import com.cac.components.ui.component.dialog.OptionType;
import com.cac.components.ui.layout.GridLayout;
import com.cac.components.ui.listener.mouse.MouseClickListener;
import com.cac.components.ui.listener.mouse.MouseEvent;
import com.cac.components.ui.listener.mouse.FocusMouseClickListener;
import com.google.common.collect.Lists;
import java.util.List;

public class UiLaunch {
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
        Container container = new Container();
        container.setLayout(new GridLayout(new com.cac.components.collection.Dimension(3, 3)));
        List<Color> colors = Lists.newArrayList(RED, GREEN, BLUE, YELLOW, PURPLE, PINK, ORANGE, TEAL, BROWN);
        for (Color color : colors) {
            Holdable colorPanel = createPanel(color);
            container.add(colorPanel);
        }
        Frame frame = new Frame("Test", container);
        frame.show();
    }

    private static Holdable createPanel(Color color) {
        Panel panel = new Panel();
        panel.setBackground(color);
        panel.setBorder(new LineBorder(BLACK, 3));
        panel.setSize(new com.cac.components.ui.Dimension(SIZE, SIZE));
        panel.addMouseListener(new FocusMouseClickListener(panel));
        panel.addMouseListener(new DialogMouseClickListener(panel));
        return panel;
    }

    private static class DialogMouseClickListener extends MouseClickListener {
        private Panel panel;

        public DialogMouseClickListener(Panel panel) {
            this.panel = panel;
        }

        @Override
        public void mouseClicked(MouseEvent event) {
            MessageDialog dialog = new MessageDialog("Title", "Message", MessageType.INFORMATION);
            dialog.show();
        }
    }
}
