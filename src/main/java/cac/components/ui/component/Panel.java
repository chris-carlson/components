package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Clickable;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Sizable;
import cac.components.ui.attribute.Typeable;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel implements Bordered, Colorable, Focusable, Holdable, Clickable, Typeable, Sizable {
    private final JPanel rep;

    public Panel() {
        rep = new JPanel();
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
