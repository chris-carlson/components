package ui.layout;

import ui.component.Container;

import javax.swing.BoxLayout;
import java.awt.LayoutManager;

public class LineLayout implements Layout {
    private LayoutManager rep;

    public LineLayout(Container container, LayoutDirection direction) {
        int axis = direction == LayoutDirection.LEFT_TO_RIGHT ? BoxLayout.X_AXIS : BoxLayout.Y_AXIS;
        rep = new BoxLayout(container.getRep(), axis);
    }

    @Override
    public LayoutManager getRep() {
        return rep;
    }
}
