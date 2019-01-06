package com.cac.components.ui.component.dialog;

import javax.swing.JOptionPane;

public enum MessageType {
    ERROR(JOptionPane.ERROR_MESSAGE), INFORMATION(JOptionPane.INFORMATION_MESSAGE),
    WARNING(JOptionPane.WARNING_MESSAGE), QUESTION(JOptionPane.QUESTION_MESSAGE), PLAIN(JOptionPane.PLAIN_MESSAGE);

    private int rep;

    MessageType(int rep) {
        this.rep = rep;
    }

    public int getRep() {
        return rep;
    }
}
