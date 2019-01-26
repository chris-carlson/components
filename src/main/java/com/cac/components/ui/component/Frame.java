package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Holder;
import com.cac.components.ui.attribute.Listenable;

import javax.swing.JFrame;
import java.awt.Component;

public class Frame implements Listenable {
    private JFrame rep;

    public Frame(String title) {
        rep = new JFrame(title);
        rep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public Component getRep() {
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
