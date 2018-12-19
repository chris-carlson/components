package ui.component;

import ui.attribute.Holdable;
import ui.attribute.Listenable;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.FlowLayout;

public class Switcher implements Holdable, Listenable {
    private JPanel rep;
    private Holdable holdable1;
    private Holdable holdable2;
    private boolean displayingFirstContent;

    public Switcher(Holdable holdable1, Holdable holdable2) {
        rep = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        rep.add(holdable1.getRep());
        this.holdable1 = holdable1;
        this.holdable2 = holdable2;
        displayingFirstContent = true;
    }

    @Override
    public Component getRep() {
        return rep;
    }

    public void switchContent() {
        rep.removeAll();
        if (displayingFirstContent) {
            rep.add(holdable2.getRep());
            displayingFirstContent = false;
        } else {
            rep.add(holdable1.getRep());
            displayingFirstContent = true;
        }
        rep.repaint();
        rep.revalidate();
    }
}
