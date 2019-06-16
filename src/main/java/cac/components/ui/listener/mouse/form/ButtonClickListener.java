package cac.components.ui.listener.mouse.form;

import cac.components.ui.component.form.Button;
import cac.components.ui.listener.action.SimpleAction;
import cac.components.ui.listener.mouse.MouseClickListener;
import cac.components.ui.listener.mouse.MouseEvent;

public class ButtonClickListener extends MouseClickListener {
    private Button button;
    private SimpleAction action;

    public ButtonClickListener(Button button, SimpleAction action) {
        this.button = button;
        this.action = action;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (button.isEnabled()) {
            action.execute();
        }
    }
}
