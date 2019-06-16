package cac.components.ui.listener.mouse.preset;

import cac.components.ui.color.Color;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.listener.mouse.MouseEvent;
import cac.components.ui.listener.mouse.MousePressListener;

public class BackgroundMousePressListener extends MousePressListener {
    private Colorable component;
    private Color defaultColor;
    private Color highlightColor;

    public BackgroundMousePressListener(Colorable component, Color defaultColor, Color highlightColor) {
        this.component = component;
        this.defaultColor = defaultColor;
        this.highlightColor = highlightColor;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        component.setBackground(highlightColor);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        component.setBackground(defaultColor);
    }
}
