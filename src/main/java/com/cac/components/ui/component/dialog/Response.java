package com.cac.components.ui.component.dialog;

import com.cac.components.ui.component.dialog.option.DialogOption;

public interface Response {
    <T extends DialogOption> T getResponse();
}
