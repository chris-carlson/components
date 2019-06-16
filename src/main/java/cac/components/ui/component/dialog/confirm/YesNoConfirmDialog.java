package cac.components.ui.component.dialog.confirm;

import cac.components.ui.component.dialog.MessageType;

public class YesNoConfirmDialog extends ConfirmDialog<YesNoOption> {
    public YesNoConfirmDialog(String title, String message, MessageType messageType) {
        super(title, message, messageType, OptionType.YES_NO);
    }

    @Override
    public YesNoOption getResponse() {
        int response = getResponseRep();
        if (response == 0) {
            return YesNoOption.YES;
        }
        return YesNoOption.NO;
    }
}
