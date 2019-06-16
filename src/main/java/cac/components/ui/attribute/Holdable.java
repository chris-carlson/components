package cac.components.ui.attribute;

import cac.components.ui.attribute.alignment.HorizontalAlignment;
import cac.components.ui.attribute.alignment.VerticalAlignment;

import javax.swing.JComponent;

public interface Holdable {
    JComponent getRep();

    default void setAlignment(HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        getRep().setAlignmentX(horizontalAlignment.getRep());
        getRep().setAlignmentY(verticalAlignment.getRep());
    }
}
