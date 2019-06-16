package cac.components.ui.component;

import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Holder;
import cac.components.ui.attribute.Modifiable;
import cac.components.ui.attribute.Sizable;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;

public class Layer implements Holdable, Holder, Modifiable, Sizable {
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
