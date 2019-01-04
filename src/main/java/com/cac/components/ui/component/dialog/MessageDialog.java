package com.cac.components.ui.component.dialog;

import javax.swing.JOptionPane;

public class MessageDialog implements Dialog {
    private String title;
    private String message;
    private MessageType type;

    public MessageDialog(String title, String message, MessageType type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    @Override
    public void show() {
        JOptionPane.showMessageDialog(null, message, title, type.getRep());
    }
}
