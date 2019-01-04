package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Listenable;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.FlowLayout;

public class Swapper implements Holdable, Listenable {
    private JPanel rep;

    public Swapper(Holdable holdable) {
        rep = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        rep.add(holdable.getRep());
    }

    @Override
    public Component getRep() {
        return rep;
    }

    public void setContent(Holdable holdable) {
        rep.removeAll();
        rep.add(holdable.getRep());
        rep.repaint();
        rep.revalidate();
    }
}
