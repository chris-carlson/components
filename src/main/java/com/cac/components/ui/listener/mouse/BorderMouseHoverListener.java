package com.cac.components.ui.listener.mouse;

import com.cac.components.ui.attribute.Bordered;
import com.cac.components.ui.border.Border;

public class BorderMouseHoverListener extends MouseHoverListener {
    private Bordered component;
    private Border defaultBorder;
    private Border highlightBorder;

    public BorderMouseHoverListener(Bordered component, Border defaultBorder, Border highlightBorder) {
        this.component = component;
        this.defaultBorder = defaultBorder;
        this.highlightBorder = highlightBorder;
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        component.setBorder(highlightBorder);
    }

    @Override
    public void mouseExited(MouseEvent event) {
        component.setBorder(defaultBorder);
    }
}
