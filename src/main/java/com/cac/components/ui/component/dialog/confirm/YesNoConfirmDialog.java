package com.cac.components.ui.component.dialog.confirm;

import com.cac.components.ui.component.dialog.MessageType;
import com.cac.components.ui.component.dialog.OptionType;

public class YesNoConfirmDialog extends ConfirmDialog {
    public YesNoConfirmDialog(String title, String message, MessageType messageType) {
        super(title, message, messageType, OptionType.YES_NO);
    }

    public YesNoOption getResponse() {
        int response = getResponseRep();
        if (response == 0) {
            return YesNoOption.YES;
        }
        return YesNoOption.NO;
    }
}
