package com.cac.components.ui.attribute;

import java.awt.Component;

public enum Alignment {
    LEFT(Component.LEFT_ALIGNMENT), CENTER(Component.CENTER_ALIGNMENT), RIGHT(Component.RIGHT_ALIGNMENT);

    private float rep;

    Alignment(float rep) {
        this.rep = rep;
    }

    public float getRep() {
        return rep;
    }
}
