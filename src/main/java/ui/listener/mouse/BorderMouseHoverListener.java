package ui.listener.mouse;

import ui.attribute.Bordered;
import ui.border.Border;

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
