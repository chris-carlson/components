package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Modifiable;
import cac.components.ui.attribute.Sizable;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel implements Bordered, Colorable, Focusable, Holdable, Modifiable, Sizable {
    private JPanel rep;

    public Panel() {
        rep = new JPanel();
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
