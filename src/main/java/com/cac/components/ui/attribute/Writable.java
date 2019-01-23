package com.cac.components.ui.attribute;

import com.cac.components.ui.text.Font;
import com.cac.components.ui.text.HorizontalTextAlignment;
import com.cac.components.ui.text.VerticalTextAlignment;

import javax.swing.JLabel;

public interface Writable {
    JLabel getRep();

    default void setText(String text) {
        getRep().setText("<html>" + text + "</html>");
    }

    default void setText(String text, Font font, HorizontalTextAlignment horizontalAlignment,
                         VerticalTextAlignment verticalAlignment) {
        setText(text);
        getRep().setFont(font.getRep());
        getRep().setHorizontalAlignment(horizontalAlignment.getRep());
        getRep().setVerticalAlignment(verticalAlignment.getRep());
    }
}
