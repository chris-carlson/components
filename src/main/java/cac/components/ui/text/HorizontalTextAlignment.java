package cac.components.ui.text;

import javax.swing.SwingConstants;

public enum HorizontalTextAlignment {
    LEFT(SwingConstants.LEFT), CENTER(SwingConstants.CENTER), RIGHT(SwingConstants.RIGHT);

    private int rep;

    HorizontalTextAlignment(int rep) {
        this.rep = rep;
    }

    public int getRep() {
        return rep;
    }
}
