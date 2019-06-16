package cac.components.ui.listener.key;

import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyConnector implements KeyListener {
    private KeyPressListener pressListener;
    private KeyReleaseListener releaseListener;
    private Set<Integer> pressedKeys;

    private KeyConnector() {
        pressedKeys = new HashSet<>();
    }

    public KeyConnector(KeyPressListener pressListener) {
        this();
        this.pressListener = pressListener;
    }

    public KeyConnector(KeyReleaseListener releaseListener) {
        this();
        this.releaseListener = releaseListener;
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent event) {
        // Unused
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent event) {
        if (pressListener != null && !pressedKeys.contains(event.getKeyCode())) {
            pressListener.keyPressed(new KeyEvent(event));
        }
        pressedKeys.add(event.getKeyCode());
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent event) {
        if (releaseListener != null) {
            releaseListener.keyReleased(new KeyEvent(event));
        }
        pressedKeys.remove(event.getKeyCode());
    }
}
