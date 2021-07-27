package cac.components.ui.component;

import cac.components.path.File;
import cac.components.ui.UiDimension;
import cac.components.ui.attribute.Clickable;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Typeable;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Icon implements Focusable, Holdable, Clickable, Typeable {
    private JLabel rep;

    public Icon(File file, UiDimension dimension) {
        rep = new JLabel(new ImageIcon(file.getPath()));
        rep.setBounds(0, 0, dimension.getRep().width, dimension.getRep().height);
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
