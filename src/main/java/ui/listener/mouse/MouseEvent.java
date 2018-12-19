package ui.listener.mouse;

import ui.listener.InputEvent;

public class MouseEvent extends InputEvent {
    private java.awt.event.MouseEvent rep;

    public MouseEvent(java.awt.event.MouseEvent rep) {
        super(rep);
        this.rep = rep;
    }

    public MouseButton getButton() {
        if (rep.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            return MouseButton.RIGHT;
        }
        return MouseButton.LEFT;
    }

    public int getClickCount() {
        return rep.getClickCount();
    }
}
