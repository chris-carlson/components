package ui.listener.mouse;

public abstract class MouseHoverListener implements MouseListener {
    private MouseConnector rep;

    public MouseHoverListener() {
        rep = new MouseConnector(this);
    }

    @Override
    public MouseConnector getRep() {
        return rep;
    }

    public abstract void mouseEntered(MouseEvent event);

    public abstract void mouseExited(MouseEvent event);
}
