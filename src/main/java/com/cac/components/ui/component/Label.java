package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Bordered;
import com.cac.components.ui.attribute.Colorable;
import com.cac.components.ui.attribute.Focusable;
import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Listenable;
import com.cac.components.ui.attribute.Sizable;
import com.cac.components.ui.attribute.Writable;
import com.cac.components.ui.text.Font;
import com.cac.components.ui.text.HorizontalTextAlignment;
import com.cac.components.ui.text.VerticalTextAlignment;

import javax.swing.JLabel;

public class Label implements Bordered, Colorable, Focusable, Holdable, Listenable, Sizable, Writable {
    private JLabel rep;

    public Label(String text, Font font, HorizontalTextAlignment horizontalAlignment,
                 VerticalTextAlignment verticalAlignment) {
        rep = new JLabel(text, horizontalAlignment.getRep());
        rep.setVerticalAlignment(verticalAlignment.getRep());
        rep.setFont(font.getRep());
        rep.setOpaque(true);
    }

    @Override
    public JLabel getRep() {
        return rep;
    }
}
