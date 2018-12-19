package ui.attribute;

import javax.swing.JLabel;

public interface Writable {
    JLabel getRep();

    default void setText(String text) {
        getRep().setText(text);
    }
}
