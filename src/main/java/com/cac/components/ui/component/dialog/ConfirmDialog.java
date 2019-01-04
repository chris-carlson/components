package com.cac.components.ui.component.dialog;

import javax.swing.JOptionPane;

public abstract class ConfirmDialog implements Dialog, Response {
    private String title;
    private String message;
    private MessageType messageType;
    private OptionType optionType;
    private int response;

    public ConfirmDialog(String title, String message, MessageType messageType, OptionType optionType) {
        this.title = title;
        this.message = message;
        this.messageType = messageType;
        this.optionType = optionType;
    }

    @Override
    public void show() {
        response = JOptionPane.showConfirmDialog(null, message, title, optionType.getRep(), messageType.getRep());
    }

    protected int getResponseRep() {
        return response;
    }
}
