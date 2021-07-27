package cac.components.ui.listener.mouse.preset;

import cac.components.ui.attribute.Focusable;
import cac.components.ui.listener.mouse.MouseClickListener;
import cac.components.ui.listener.mouse.MouseEvent;

public class FocusMouseClickListener extends MouseClickListener {
    private final Focusable component;

    public FocusMouseClickListener(Focusable component) {
        this.component = component;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        component.requestFocus();
    }
}
