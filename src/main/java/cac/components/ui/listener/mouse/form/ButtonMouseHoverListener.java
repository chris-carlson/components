package cac.components.ui.listener.mouse.form;

import cac.components.ui.component.form.Button;
import cac.components.ui.listener.mouse.MouseEvent;
import cac.components.ui.listener.mouse.MouseHoverListener;

public class ButtonMouseHoverListener extends MouseHoverListener {
    private Button button;

    public ButtonMouseHoverListener(Button button) {
        this.button = button;
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        if (button.isEnabled()) {
            button.setBorder(FormBorder.HIGHLIGHT_BORDER);
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        if (button.isEnabled()) {
            button.setBorder(FormBorder.DEFAULT_BORDER);
        }
    }
}
