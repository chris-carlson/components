package cac.components.ui.component;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import cac.components.ui.attribute.CloseOperation;
import cac.components.ui.attribute.Holder;
import cac.components.ui.attribute.Windowed;
import cac.components.ui.listener.window.WindowListener;

public class Frame implements Windowed {
    private JFrame rep;
    private List<WindowListener> windowListeners;

    public Frame(String title) {
        this(title, CloseOperation.EXIT);
    }

    public Frame(String title, CloseOperation closeOperation) {
        rep = new JFrame(title);
        windowListeners = new ArrayList<>();
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

    @Override
    public List<WindowListener> getWindowListeners() {
        return windowListeners;
    }
}
