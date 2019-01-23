package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Listenable;

import javax.swing.JPanel;
import java.awt.Container;
import java.awt.FlowLayout;

public class Swapper implements Holdable, Listenable {
    private JPanel rep;

    public Swapper() {
        rep = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    public Swapper(Holdable holdable) {
        this();
        rep.add(holdable.getRep());
    }

    @Override
    public Container getRep() {
        return rep;
    }

    public void setContent(Holdable holdable) {
        rep.removeAll();
        rep.add(holdable.getRep());
        rep.repaint();
        rep.revalidate();
    }
}
