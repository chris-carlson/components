package cac.components.ui.layout;

import cac.components.ui.component.Container;
import lombok.EqualsAndHashCode;

import javax.swing.BoxLayout;
import java.awt.LayoutManager;

@EqualsAndHashCode
public class LineLayout implements Layout {
    private final LayoutManager rep;

    public LineLayout(Container container, LayoutDirection direction) {
        int axis = direction == LayoutDirection.LEFT_TO_RIGHT ? BoxLayout.X_AXIS : BoxLayout.Y_AXIS;
        rep = new BoxLayout(container.getRep(), axis);
    }

    @Override
    public LayoutManager getRep() {
        return rep;
    }
}
