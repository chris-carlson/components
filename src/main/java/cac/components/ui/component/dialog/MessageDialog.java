package cac.components.ui.component.dialog;

import javax.swing.JOptionPane;

public record MessageDialog(String title, String message, MessageType type) implements Dialog {
    @Override
    public void show() {
        JOptionPane.showMessageDialog(null, message, title, type.getRep());
    }
}
