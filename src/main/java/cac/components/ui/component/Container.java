package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Clickable;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Holder;
import cac.components.ui.attribute.Typeable;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Container implements Bordered, Clickable, Colorable, Focusable, Holdable, Holder, Typeable {
    private JPanel rep;

    public Container() {
        rep = new JPanel();
        rep.setLayout(new BoxLayout(rep, BoxLayout.X_AXIS));
    }

    public Container(Holdable holdable) {
        this();
        add(holdable);
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
