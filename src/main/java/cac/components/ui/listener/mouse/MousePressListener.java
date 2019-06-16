package cac.components.ui.listener.mouse;

public abstract class MousePressListener implements MouseListener {
    private MouseConnector rep;

    public MousePressListener() {
        rep = new MouseConnector(this);
    }

    @Override
    public MouseConnector getRep() {
        return rep;
    }

    public abstract void mousePressed(MouseEvent event);

    public abstract void mouseReleased(MouseEvent event);
}
