package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Holder;
import com.cac.components.ui.attribute.Listenable;
import com.cac.components.ui.attribute.Sizable;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;

public class Layer implements Holdable, Holder, Listenable, Sizable {
    private JLayeredPane rep;

    public Layer() {
        rep = new JLayeredPane();
    }

    @Override
    public JComponent getRep() {
        return rep;
    }

    @Override
    public void add(Holdable holdable) {
        rep.add(holdable.getRep(), 0);
    }

    public void remove() {
        rep.remove(0);
        rep.repaint();
        rep.revalidate();
    }
}
