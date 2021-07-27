package cac.components.ui.text;

import javax.swing.SwingConstants;

public enum VerticalTextAlignment {
    TOP(SwingConstants.TOP), CENTER(SwingConstants.CENTER), BOTTOM(SwingConstants.BOTTOM);

    private final int rep;

    VerticalTextAlignment(int rep) {
        this.rep = rep;
    }

    public int getRep() {
        return rep;
    }
}
