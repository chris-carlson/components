package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Holder;
import com.cac.components.ui.layout.Layout;

import javax.swing.JPanel;

public class Container implements Holdable, Holder {
    private JPanel rep;

    public Container() {
        rep = new JPanel();
    }

    @Override
    public java.awt.Container getRep() {
        return rep;
    }

    public void setLayout(Layout layout) {
        rep.setLayout(layout.getRep());
    }
}
