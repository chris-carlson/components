package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Holder;
import cac.components.ui.layout.Layout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Container implements Bordered, Colorable, Holdable, Holder {
    private JPanel rep;

    public Container() {
        rep = new JPanel();
        rep.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    public Container(Holdable holdable) {
        this();
        add(holdable);
    }

    @Override
    public JComponent getRep() {
        return rep;
    }

    public void setLayout(Layout layout) {
        rep.setLayout(layout.getRep());
    }
}
