package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Bordered;
import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Holder;
import com.cac.components.ui.layout.Layout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Container implements Bordered, Holdable, Holder {
    private JPanel rep;

    public Container() {
        rep = new JPanel();
        rep.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    @Override
    public JComponent getRep() {
        return rep;
    }

    public void setLayout(Layout layout) {
        rep.setLayout(layout.getRep());
    }
}
