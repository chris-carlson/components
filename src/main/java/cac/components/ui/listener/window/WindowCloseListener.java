package cac.components.ui.listener.window;

public abstract class WindowCloseListener implements WindowListener {
    private WindowConnector rep;

    public WindowCloseListener() {
        rep = new WindowConnector(this);
    }

    @Override
    public WindowConnector getRep() {
        return rep;
    }

    public abstract void windowClosing();
}
