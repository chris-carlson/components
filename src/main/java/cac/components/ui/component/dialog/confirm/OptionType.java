package cac.components.ui.component.dialog.confirm;

import javax.swing.JOptionPane;

public enum OptionType {
    YES_NO(JOptionPane.YES_NO_OPTION), YES_NO_CANCEL(JOptionPane.YES_NO_CANCEL_OPTION),
    OK_CANCEL(JOptionPane.OK_CANCEL_OPTION);

    private int rep;

    OptionType(int rep) {
        this.rep = rep;
    }

    public int getRep() {
        return rep;
    }
}
