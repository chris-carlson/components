package cac.components.ui.listener.key;

public abstract class KeyReleaseListener implements KeyListener {
    private KeyConnector rep;

    public KeyReleaseListener() {
        rep = new KeyConnector(this);
    }

    @Override
    public KeyConnector getRep() {
        return rep;
    }

    public abstract void keyReleased(KeyEvent event);
}
