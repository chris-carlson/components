package cac.components.ui.attribute;

import cac.components.ui.attribute.alignment.HorizontalAlignment;
import cac.components.ui.attribute.alignment.VerticalAlignment;

import java.awt.Component;

import javax.swing.JComponent;

public interface Holdable {
    JComponent getRep();

    default HorizontalAlignment getHorizontalAlignment() {
        float alignmentX = getRep().getAlignmentX();
        if (alignmentX == Component.LEFT_ALIGNMENT) {
            return HorizontalAlignment.LEFT;
        }
        if (alignmentX == Component.CENTER_ALIGNMENT) {
            return HorizontalAlignment.CENTER;
        }
        if (alignmentX == Component.RIGHT_ALIGNMENT) {
            return HorizontalAlignment.RIGHT;
        }
        return null;
    }

    default VerticalAlignment getVerticalAlignment() {
        float alignmentY = getRep().getAlignmentY();
        if (alignmentY == Component.TOP_ALIGNMENT) {
            return VerticalAlignment.TOP;
        }
        if (alignmentY == Component.CENTER_ALIGNMENT) {
            return VerticalAlignment.CENTER;
        }
        if (alignmentY == Component.BOTTOM_ALIGNMENT) {
            return VerticalAlignment.BOTTOM;
        }
        return null;
    }

    default void setAlignment(HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        getRep().setAlignmentX(horizontalAlignment.getRep());
        getRep().setAlignmentY(verticalAlignment.getRep());
    }
}
