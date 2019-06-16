package cac.components.ui.listener.window;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowConnector implements WindowListener {
    private WindowCloseListener closeListener;

    public WindowConnector(WindowCloseListener closeListener) {
        this.closeListener = closeListener;
    }

    @Override
    public void windowOpened(WindowEvent event) {
    }

    @Override
    public void windowClosing(WindowEvent event) {
        if (closeListener != null) {
            closeListener.windowClosing();
        }
    }

    @Override
    public void windowClosed(WindowEvent event) {
    }

    @Override
    public void windowIconified(WindowEvent event) {
    }

    @Override
    public void windowDeiconified(WindowEvent event) {
    }

    @Override
    public void windowActivated(WindowEvent event) {
    }

    @Override
    public void windowDeactivated(WindowEvent event) {
    }
}
