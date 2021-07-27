package cac.components.ui.text;

import java.awt.Font;

public enum FontStyle {
    PLAIN(Font.PLAIN), BOLD(Font.BOLD), ITALIC(Font.ITALIC);

    private final int rep;

    FontStyle(int rep) {
        this.rep = rep;
    }

    public int getRep() {
        return rep;
    }
}
