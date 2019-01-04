package com.cac.components.ui.listener;

public class InputEvent {
    private java.awt.event.InputEvent rep;

    public InputEvent(java.awt.event.InputEvent rep) {
        this.rep = rep;
    }

    public boolean isCtrlDown() {
        return rep.isControlDown();
    }

    public boolean isShiftDown() {
        return rep.isShiftDown();
    }

    public boolean isAltDown() {
        return rep.isAltDown();
    }
}
