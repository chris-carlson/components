package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Clickable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Holder;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Arrays;

public class Layer implements Bordered, Clickable, Holdable, Holder {
    private final JLayeredPane rep;

    public Layer() {
        rep = new JLayeredPane();
    }

    @Override
    public JComponent getRep() {
        return rep;
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
        rep.add(component, Integer.valueOf(layer));
    }

    public void remove(Holdable holdable) {
        rep.remove(holdable.getRep());
        rep.repaint();
        rep.revalidate();
    }

    public void remove(int layer) {
        Component[] components = rep.getComponentsInLayer(layer);
        Arrays.stream(components).forEach(rep::remove);
    }
}
