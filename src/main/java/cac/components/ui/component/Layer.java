package cac.components.ui.component;

import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Holder;
import cac.components.ui.attribute.Modifiable;
import cac.components.ui.attribute.Sizable;

import java.awt.Dimension;

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
        JComponent component = holdable.getRep();
        Dimension dimension = component.getPreferredSize();
        component.setBounds(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight());
        rep.setPreferredSize(dimension);
        rep.add(component, 0);
    }

    public void remove() {
        rep.remove(0);
        rep.repaint();
        rep.revalidate();
    }
}
