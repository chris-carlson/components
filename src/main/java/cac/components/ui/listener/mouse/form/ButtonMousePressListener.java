package cac.components.ui.listener.mouse.form;

import cac.components.ui.color.Theme;
import cac.components.ui.component.form.Button;
import cac.components.ui.listener.mouse.MouseEvent;
import cac.components.ui.listener.mouse.MousePressListener;

public class ButtonMousePressListener extends MousePressListener {
    private static final Theme theme = Theme.getInstance();

    private Button button;

    public ButtonMousePressListener(Button button) {
        this.button = button;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (button.isEnabled()) {
            button.setBackground(theme.getHighlightColor());
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (button.isEnabled()) {
            button.setBackground(theme.getDefaultColor());
        }
    }
}
