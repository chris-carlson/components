package cac.components.ui.component;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Holder;

public class Container implements Bordered, Colorable, Holdable, Holder {
    private JPanel rep;
    private List<Holdable> components;

    public Container() {
        rep = new JPanel();
        rep.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        components = new ArrayList<>();
    }

    public Container(Holdable holdable) {
        this();
        add(holdable);
    }

    @Override
    public JComponent getRep() {
        return rep;
    }

    @Override
    public List<Holdable> getComponents() {
        return components;
    }
}
