package ui.listener.key;

import java.awt.event.KeyEvent;
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
    public void keyTyped(KeyEvent event) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (pressListener != null && !pressedKeys.contains(event.getKeyCode())) {
            pressListener.keyPressed(new ui.listener.key.KeyEvent(event));
        }
        pressedKeys.add(event.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (releaseListener != null) {
            releaseListener.keyReleased(new ui.listener.key.KeyEvent(event));
        }
        pressedKeys.remove(event.getKeyCode());
    }
}
