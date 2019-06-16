package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Modifiable;
import cac.components.ui.attribute.Sizable;
import cac.components.ui.attribute.Writable;
import cac.components.ui.text.Font;
import cac.components.ui.text.HorizontalTextAlignment;
import cac.components.ui.text.VerticalTextAlignment;

import javax.swing.JLabel;

public class Label implements Bordered, Colorable, Focusable, Holdable, Modifiable, Sizable, Writable {
    private JLabel rep;

    public Label(String text, Font font) {
        rep = new JLabel();
        rep.setOpaque(true);
        setText(text);
        setFont(font);
        setAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.CENTER);
    }

    @Override
    public JLabel getRep() {
        return rep;
    }
}