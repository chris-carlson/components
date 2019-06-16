package cac.components.ui.listener.mouse.form;

import cac.components.ui.border.Border;
import cac.components.ui.border.LineBorder;
import cac.components.ui.color.Color;

public class FormBorder {
    public static final Border DEFAULT_BORDER = new LineBorder(Color.BLACK, 3);
    public static final Border HIGHLIGHT_BORDER = new LineBorder(new Color(0, 128, 255), 3);

    private FormBorder() {
    }
}
