package cac.components.ui.component;

import cac.components.ui.attribute.Bordered;
import cac.components.ui.attribute.Colorable;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Clickable;
import cac.components.ui.attribute.Sizable;
import cac.components.ui.attribute.Typeable;
import cac.components.ui.listener.key.KeyListener;
import cac.components.ui.listener.mouse.MouseListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel implements Bordered, Colorable, Focusable, Holdable, Clickable, Typeable, Sizable {
    private JPanel rep;
    private List<MouseListener> mouseListeners;
    private List<KeyListener> keyListeners;

    public Panel() {
        rep = new JPanel();
        mouseListeners = new ArrayList<>();
        keyListeners = new ArrayList<>();
    }

    @Override
    public JComponent getRep() {
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
