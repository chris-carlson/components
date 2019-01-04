package com.cac.components.ui.component;

import com.cac.components.ui.attribute.Bordered;
import com.cac.components.ui.attribute.Colorable;
import com.cac.components.ui.attribute.Focusable;
import com.cac.components.ui.attribute.Holdable;
import com.cac.components.ui.attribute.Listenable;
import com.cac.components.ui.attribute.Sizable;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel implements Bordered, Colorable, Focusable, Holdable, Listenable, Sizable {
    private JPanel rep;

    public Panel() {
        rep = new JPanel();
    }

    @Override
    public JComponent getRep() {
        return rep;
    }
}
