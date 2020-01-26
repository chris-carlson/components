package cac.components.ui.component;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;

import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Holder;
import cac.components.ui.attribute.Sizable;

public class Layer implements Holdable, Holder, Sizable {
    private JLayeredPane rep;
    private List<Holdable> components;

    public Layer() {
        rep = new JLayeredPane();
        components = new ArrayList<>();
    }

    @Override
    public JComponent getRep() {
        return rep;
    }

    @Override
    public List<Holdable> getComponents() {
        return components;
    }

    @Override
    public void add(Holdable holdable) {
        add(holdable, 0);
    }

    public void add(Holdable holdable, int layer) {
        JComponent component = holdable.getRep();
        Dimension dimension = component.getPreferredSize();
        component.setBounds(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight());
        rep.setPreferredSize(dimension);
        rep.add(component, layer);
    }

    public void remove(Holdable holdable) {
        rep.remove(holdable.getRep());
        rep.repaint();
        rep.revalidate();
    }
}
