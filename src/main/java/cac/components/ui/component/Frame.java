package cac.components.ui.component;

import cac.components.ui.attribute.CloseOperation;
import cac.components.ui.attribute.Holder;
import cac.components.ui.attribute.Windowed;

import javax.swing.JFrame;
import java.awt.Window;

public class Frame implements Windowed {
    private final JFrame rep;

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
