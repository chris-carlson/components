package cac.components.ui.component.dialog.confirm;

import cac.components.ui.component.dialog.MessageType;

public class OkCancelConfirmDialog extends ConfirmDialog<OkCancelOption> {
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
