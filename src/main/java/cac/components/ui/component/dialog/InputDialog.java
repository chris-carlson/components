package cac.components.ui.component.dialog;

import javax.swing.JOptionPane;

public class InputDialog implements Dialog {
    private final String title;
    private final String message;
    private final MessageType type;
    private String input;

    public InputDialog(String title, String message, MessageType type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    @Override
    public void show() {
        input = JOptionPane.showInputDialog(null, message, title, type.getRep());
    }

    public String getInput() {
        return input;
    }
}
