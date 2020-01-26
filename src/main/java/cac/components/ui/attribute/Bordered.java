package cac.components.ui.attribute;

import java.awt.Insets;

import javax.swing.JComponent;

import cac.components.ui.border.Border;
import cac.components.ui.border.CompoundBorder;
import cac.components.ui.border.EmptyBorder;
import cac.components.ui.border.LineBorder;
import cac.components.ui.color.Color;

public interface Bordered {
    JComponent getRep();

    static Border getBorder(javax.swing.border.Border repBorder) {
        if (repBorder.getClass().equals(javax.swing.border.LineBorder.class)) {
            javax.swing.border.LineBorder repLineBorder = (javax.swing.border.LineBorder) repBorder;
            java.awt.Color repColor = repLineBorder.getLineColor();
            Color color = new Color(repColor.getRed(), repColor.getBlue(), repColor.getGreen());
            return new LineBorder(color, repLineBorder.getThickness());
        }
        if (repBorder.getClass().equals(javax.swing.border.EmptyBorder.class)) {
            javax.swing.border.EmptyBorder repEmptyBorder = (javax.swing.border.EmptyBorder) repBorder;
            Insets insets = repEmptyBorder.getBorderInsets();
            return new EmptyBorder(insets.left, insets.right, insets.top, insets.bottom);
        }
        if (repBorder.getClass().equals(javax.swing.border.CompoundBorder.class)) {
            javax.swing.border.CompoundBorder repCompoundBorder = (javax.swing.border.CompoundBorder) repBorder;
            javax.swing.border.Border repOutsideBorder = repCompoundBorder.getOutsideBorder();
            javax.swing.border.Border repInsideBorder = repCompoundBorder.getInsideBorder();
            return new CompoundBorder(getBorder(repOutsideBorder), getBorder(repInsideBorder));
        }
        return null;
    }

    default Border getBorder() {
        javax.swing.border.Border repBorder = getRep().getBorder();
        return getBorder(repBorder);
    }

    default void setBorder(Border border) {
        getRep().setBorder(border.getRep());
    }
}
