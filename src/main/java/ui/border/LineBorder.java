package ui.border;

import ui.Color;

public class LineBorder implements Border {
    private javax.swing.border.Border rep;

    public LineBorder(Color color, int thickness) {
        rep = new javax.swing.border.LineBorder(color.getRep(), thickness);
    }

    @Override
    public javax.swing.border.Border getRep() {
        return rep;
    }
}
