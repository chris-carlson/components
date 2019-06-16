package cac.components.ui.listener.mouse.form;

import cac.components.ui.component.form.Checkbox;
import cac.components.ui.listener.mouse.MouseEvent;
import cac.components.ui.listener.mouse.MouseHoverListener;

public class CheckboxMouseHoverListener extends MouseHoverListener {
    private Checkbox checkbox;

    public CheckboxMouseHoverListener(Checkbox checkbox) {
        this.checkbox = checkbox;
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        if (checkbox.isEnabled()) {
            checkbox.highlight();
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        if (checkbox.isEnabled()) {
            checkbox.unhighlight();
        }
    }
}
