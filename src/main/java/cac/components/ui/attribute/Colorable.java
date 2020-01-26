package cac.components.ui.attribute;

import cac.components.ui.color.Color;

import javax.swing.JComponent;

public interface Colorable {
    JComponent getRep();

    default Color getBackground() {
        java.awt.Color repColor = getRep().getBackground();
        return new Color(repColor.getRed(), repColor.getBlue(), repColor.getGreen());
    }

    default Color getForeground() {
        java.awt.Color repColor = getRep().getForeground();
        return new Color(repColor.getRed(), repColor.getBlue(), repColor.getGreen());
    }

    default void setBackground(Color color) {
        getRep().setBackground(color.getRep());
    }

    default void setForeground(Color color) {
        getRep().setForeground(color.getRep());
    }
}
