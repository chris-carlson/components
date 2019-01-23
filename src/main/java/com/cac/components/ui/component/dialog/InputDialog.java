package com.cac.components.ui.component.dialog;

import javax.swing.JOptionPane;

public class InputDialog implements Dialog {
    private String title;
    private String message;
    private MessageType type;
    private String input;

    public InputDialog(String title, String message, MessageType type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    @Override
    public void show() {
        input = (String) JOptionPane
                .showInputDialog(null, message, title, type.getRep(), null, new Object[]{"OK", "Cancel"}, "OK");
    }

    public String getInput() {
        return input;
    }
}
