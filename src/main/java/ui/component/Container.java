package ui.component;

import ui.attribute.Holdable;
import ui.attribute.Holder;
import ui.layout.Layout;

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
