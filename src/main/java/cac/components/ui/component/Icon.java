package cac.components.ui.component;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import cac.components.path.File;
import cac.components.ui.Dimension;
import cac.components.ui.attribute.Focusable;
import cac.components.ui.attribute.Holdable;
import cac.components.ui.attribute.Modifiable;

public class Icon implements Focusable, Holdable, Modifiable {
    private JLabel rep;

    public Icon(File file, Dimension dimension) {
        rep = new JLabel(new ImageIcon(file.getPath()));
        rep.setBounds(0, 0, dimension.getRep().width, dimension.getRep().height);
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
