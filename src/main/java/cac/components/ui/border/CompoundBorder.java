package cac.components.ui.border;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CompoundBorder implements Border {
    private javax.swing.border.Border rep;

    public CompoundBorder(Border outerBorder, Border innerBorder) {
        rep = new javax.swing.border.CompoundBorder(outerBorder.getRep(), innerBorder.getRep());
    }

    @Override
    public javax.swing.border.Border getRep() {
        return rep;
    }
}
