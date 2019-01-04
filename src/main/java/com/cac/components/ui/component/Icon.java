package com.cac.components.ui.component;

import com.google.common.io.Resources;
import com.cac.components.ui.Dimension;
import com.cac.components.ui.attribute.Focusable;
import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Listenable;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Icon implements Focusable, Holdable, Listenable {
    private JLabel rep;

    public Icon(String iconPath, Dimension dimension) {
        rep = new JLabel(new ImageIcon(Resources.getResource(iconPath)));
        rep.setBounds(0 ,0, dimension.getRep().width, dimension.getRep().height);
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
