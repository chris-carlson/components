package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Holder;

import javax.swing.JFrame;

public class Frame {
    private JFrame rep;

    public Frame(String title, Holder holder) {
        rep = new JFrame(title);
        rep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rep.setContentPane(holder.getRep());
        rep.pack();
    }

    public void show() {
        rep.setVisible(true);
    }
}
