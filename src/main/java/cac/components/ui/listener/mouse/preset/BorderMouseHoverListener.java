package cac.components.ui.listener.mouse.preset;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.border.Border;
import cac.components.ui.listener.mouse.MouseEvent;
import cac.components.ui.listener.mouse.MouseHoverListener;

public class BorderMouseHoverListener extends MouseHoverListener {
    private final Bordered component;
    private final Border defaultBorder;
    private final Border highlightBorder;

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
