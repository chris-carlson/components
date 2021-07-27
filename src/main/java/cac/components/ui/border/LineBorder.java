package cac.components.ui.border;

import cac.components.ui.color.Color;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class LineBorder implements Border {
    private final javax.swing.border.Border rep;

    public LineBorder(Color color, int thickness) {
        rep = new javax.swing.border.LineBorder(color.getRep(), thickness);
    }

    @Override
    public javax.swing.border.Border getRep() {
        return rep;
    }
}
