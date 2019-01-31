package com.cac.components.ui.component.dialog.confirm;

import com.cac.components.ui.component.dialog.MessageType;

public class YesNoCancelConfirmDialog extends ConfirmDialog<YesNoCancelOption> {
    public YesNoCancelConfirmDialog(String title, String message, MessageType messageType) {
        super(title, message, messageType, OptionType.YES_NO_CANCEL);
    }

    public YesNoCancelOption getResponse() {
        int response = getResponseRep();
        if (response == 0) {
            return YesNoCancelOption.YES;
        } else if (response == 1) {
            return YesNoCancelOption.NO;
        }
        return YesNoCancelOption.CANCEL;
    }
}
