package cac.components.ui.component;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cac.components.ui.attribute.Holdable;

public class Swapper implements Holdable {
    private JPanel rep;

    public Swapper() {
        rep = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    public Swapper(Holdable holdable) {
        this();
        rep.add(holdable.getRep());
    }

    @Override
    public JComponent getRep() {
        return rep;
    }

    public void setContent(Holdable holdable) {
        rep.removeAll();
        rep.add(holdable.getRep());
        rep.repaint();
        rep.revalidate();
    }
}
