package ui.component;

import ui.attribute.Bordered;
import ui.attribute.Colorable;
import ui.attribute.Focusable;
import ui.attribute.Holdable;
import ui.attribute.Listenable;
import ui.attribute.Sizable;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel implements Bordered, Colorable, Focusable, Holdable, Listenable, Sizable {
    private JPanel rep;

    public Panel() {
        rep = new JPanel();
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
