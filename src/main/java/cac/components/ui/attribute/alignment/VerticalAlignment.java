package cac.components.ui.attribute.alignment;

import java.awt.Component;

public enum VerticalAlignment {
    TOP(Component.TOP_ALIGNMENT), CENTER(Component.CENTER_ALIGNMENT), BOTTOM(Component.BOTTOM_ALIGNMENT);

    private final float rep;

    VerticalAlignment(float rep) {
        this.rep = rep;
    }

    public float getRep() {
        return rep;
    }
}
