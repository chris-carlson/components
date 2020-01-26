package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Clickable;
import cac.components.ui.attribute.Sizable;
import cac.components.ui.attribute.Typeable;
import cac.components.ui.attribute.Writable;
import cac.components.ui.listener.key.KeyListener;
import cac.components.ui.listener.mouse.MouseListener;
import cac.components.ui.text.Font;
import cac.components.ui.text.HorizontalTextAlignment;
import cac.components.ui.text.VerticalTextAlignment;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Label implements Bordered, Colorable, Focusable, Holdable, Clickable, Typeable, Sizable, Writable {
    private JLabel rep;
    private List<MouseListener> mouseListeners;
    private List<KeyListener> keyListeners;

    public Label(String text, Font font) {
        rep = new JLabel();
        mouseListeners = new ArrayList<>();
        keyListeners = new ArrayList<>();
        rep.setOpaque(true);
        setText(text);
        setFont(font);
        setAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.CENTER);
    }

    @Override
    public JLabel getRep() {
        return rep;
    }

    @Override
    public List<MouseListener> getMouseListeners() {
        return mouseListeners;
    }

    @Override
    public List<KeyListener> getKeyListeners() {
        return keyListeners;
    }
}
