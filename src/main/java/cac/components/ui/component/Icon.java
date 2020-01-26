package cac.components.ui.component;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import cac.components.path.File;
import cac.components.ui.UiDimension;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Typeable;
import cac.components.ui.listener.key.KeyListener;
import cac.components.ui.listener.mouse.MouseListener;
import cac.components.ui.attribute.Clickable;

public class Icon implements Focusable, Holdable, Clickable, Typeable {
    private JLabel rep;
    private List<MouseListener> mouseListeners;
    private List<KeyListener> keyListeners;

    public Icon(File file, UiDimension dimension) {
        rep = new JLabel(new ImageIcon(file.getPath()));
        mouseListeners = new ArrayList<>();
        keyListeners = new ArrayList<>();
        rep.setBounds(0, 0, dimension.getRep().width, dimension.getRep().height);
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
