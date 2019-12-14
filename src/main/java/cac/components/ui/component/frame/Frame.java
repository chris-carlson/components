package cac.components.ui.component.frame;

import java.awt.Window;

import javax.swing.JFrame;

import cac.components.ui.attribute.Holder;
import cac.components.ui.attribute.Modifiable;
import cac.components.ui.attribute.Windowed;

public class Frame implements Modifiable, Windowed {
    private JFrame rep;

    public Frame(String title) {
        this(title, CloseOperation.EXIT);
    }

    public Frame(String title, CloseOperation closeOperation) {
        rep = new JFrame(title);
        rep.setDefaultCloseOperation(
                closeOperation == CloseOperation.EXIT ? JFrame.EXIT_ON_CLOSE : JFrame.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public Window getRep() {
        return rep;
    }

    public void setContent(Holder holder) {
        rep.setContentPane(holder.getRep());
    }

    public void pack() {
        rep.pack();
    }

    public void show() {
        rep.setVisible(true);
    }

    public void close() {
        rep.dispose();
    }
}
