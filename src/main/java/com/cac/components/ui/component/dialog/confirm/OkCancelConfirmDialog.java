package com.cac.components.ui.component.dialog.confirm;

import com.cac.components.ui.component.dialog.MessageType;
import com.cac.components.ui.component.dialog.OptionType;

public class OkCancelConfirmDialog extends ConfirmDialog {
    public OkCancelConfirmDialog(String title, String message, MessageType messageType) {
        super(title, message, messageType, OptionType.OK_CANCEL);
    }

    public OkCancelOption getResponse() {
        int response = getResponseRep();
        if (response == 0) {
            return OkCancelOption.OK;
        }
        return OkCancelOption.CANCEL;
    }
}
