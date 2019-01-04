package com.cac.components.ui.border;

import com.cac.components.ui.Color;

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
