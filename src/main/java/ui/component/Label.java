package ui.component;

import ui.attribute.Bordered;
import ui.attribute.Colorable;
import ui.attribute.Focusable;
import ui.attribute.Holdable;
import ui.attribute.Listenable;
import ui.attribute.Sizable;
import ui.attribute.Writable;
import ui.text.Font;
import ui.text.HorizontalTextAlignment;
import ui.text.VerticalTextAlignment;

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
