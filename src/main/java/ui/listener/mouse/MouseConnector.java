package ui.listener.mouse;

import java.awt.event.MouseListener;

public class MouseConnector implements MouseListener {
    private MouseClickListener clickListener;
    private MousePressListener pressListener;
    private MouseHoverListener hoverListener;

    public MouseConnector(MouseClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public MouseConnector(MousePressListener pressListener) {
        this.pressListener = pressListener;
    }

    public MouseConnector(MouseHoverListener hoverListener) {
        this.hoverListener = hoverListener;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent event) {
        if (clickListener != null) {
            clickListener.mouseClicked(new MouseEvent(event));
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent event) {
        if (pressListener != null) {
            pressListener.mousePressed(new MouseEvent(event));
        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent event) {
        if (pressListener != null) {
            pressListener.mouseReleased(new MouseEvent(event));
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent event) {
        if (hoverListener != null) {
            hoverListener.mouseEntered(new MouseEvent(event));
        }
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent event) {
        if (hoverListener != null) {
            hoverListener.mouseExited(new MouseEvent(event));
        }
    }
}
