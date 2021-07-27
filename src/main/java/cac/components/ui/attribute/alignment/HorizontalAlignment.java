package cac.components.ui.attribute.alignment;

import java.awt.Component;

public enum HorizontalAlignment {
    LEFT(Component.LEFT_ALIGNMENT), CENTER(Component.CENTER_ALIGNMENT), RIGHT(Component.RIGHT_ALIGNMENT);

    private final float rep;

    HorizontalAlignment(float rep) {
        this.rep = rep;
    }

    public float getRep() {
        return rep;
    }
}
