package com.cac.components.ui.listener.mouse.preset;

import com.cac.components.ui.Color;
import com.cac.components.ui.attribute.Colorable;
import com.cac.components.ui.listener.mouse.MouseEvent;
import com.cac.components.ui.listener.mouse.MouseHoverListener;

public class BackgroundMouseHoverListener extends MouseHoverListener {
    private Colorable component;
    private Color defaultColor;
    private Color highlightColor;

    public BackgroundMouseHoverListener(Colorable component, Color defaultColor, Color highlightColor) {
        this.component = component;
        this.defaultColor = defaultColor;
        this.highlightColor = highlightColor;
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        component.setBackground(highlightColor);
    }

    @Override
    public void mouseExited(MouseEvent event) {
        component.setBackground(defaultColor);
    }
}
