package ui.component;

import com.google.common.io.Resources;
import data.ObjectDimension;
import ui.attribute.Focusable;
import ui.attribute.Holdable;
import ui.attribute.Listenable;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Icon implements Focusable, Holdable, Listenable {
    private JLabel rep;

    public Icon(String iconPath, ObjectDimension dimension) {
        rep = new JLabel(new ImageIcon(Resources.getResource(iconPath)));
        rep.setBounds(0 ,0, dimension.getRep().width, dimension.getRep().height);
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
