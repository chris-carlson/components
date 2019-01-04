package com.cac.components.ui.listener.mouse;

import com.cac.components.ui.attribute.Focusable;

public class FocusMouseClickListener extends MouseClickListener {
    private Focusable component;

    public FocusMouseClickListener(Focusable component) {
        this.component = component;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        component.requestFocus();
    }
}
