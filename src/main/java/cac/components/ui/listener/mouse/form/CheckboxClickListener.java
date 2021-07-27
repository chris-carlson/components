package cac.components.ui.listener.mouse.form;

import cac.components.ui.component.form.Checkbox;
import cac.components.ui.listener.action.DataAction;
import cac.components.ui.listener.mouse.MouseClickListener;
import cac.components.ui.listener.mouse.MouseEvent;

public class CheckboxClickListener extends MouseClickListener {
    private final Checkbox checkbox;
    private final DataAction<Boolean> action;

    public CheckboxClickListener(Checkbox checkbox, DataAction<Boolean> action) {
        this.checkbox = checkbox;
        this.action = action;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (checkbox.isEnabled()) {
            if (checkbox.isChecked()) {
                checkbox.uncheck();
            } else {
                checkbox.check();
            }
            action.execute(checkbox.isChecked());
        }
    }
}
