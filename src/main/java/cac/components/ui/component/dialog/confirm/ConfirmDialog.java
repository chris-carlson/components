package cac.components.ui.component.dialog.confirm;

import cac.components.ui.component.dialog.Dialog;
import cac.components.ui.component.dialog.MessageType;

import javax.swing.JOptionPane;

public abstract class ConfirmDialog<E> implements Dialog {
    private final String title;
    private final String message;
    private final MessageType messageType;
    private final OptionType optionType;
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

    public abstract E getResponse();

    protected int getResponseRep() {
        return response;
    }
}
