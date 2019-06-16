package cac.components.ui.listener.mouse;

public abstract class MouseClickListener implements MouseListener {
    private MouseConnector rep;

    public MouseClickListener() {
        rep = new MouseConnector(this);
    }

    @Override
    public MouseConnector getRep() {
        return rep;
    }

    public abstract void mouseClicked(MouseEvent event);
}
