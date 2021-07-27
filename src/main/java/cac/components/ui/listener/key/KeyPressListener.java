package cac.components.ui.listener.key;

public abstract class KeyPressListener implements KeyListener {
    private final KeyConnector rep;

    public KeyPressListener() {
        rep = new KeyConnector(this);
    }

    @Override
    public KeyConnector getRep() {
        return rep;
    }

    public abstract void keyPressed(KeyEvent event);
}
