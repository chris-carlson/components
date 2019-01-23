package com.cac.components.ui.listener.mouse.preset;

import com.cac.components.ui.attribute.Focusable;
import com.cac.components.ui.listener.mouse.MouseClickListener;
import com.cac.components.ui.listener.mouse.MouseEvent;

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
