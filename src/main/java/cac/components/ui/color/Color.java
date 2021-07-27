package cac.components.ui.color;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Color {
    public static final Color DEFAULT = new Color(238, 238, 238);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);

    private final java.awt.Color rep;

    public Color(int red, int green, int blue) {
        rep = new java.awt.Color(red, green, blue);
    }

    public java.awt.Color getRep() {
        return rep;
    }

    public int getRed() {
        return rep.getRed();
    }

    public int getGreen() {
        return rep.getGreen();
    }

    public int getBlue() {
        return rep.getBlue();
    }
}
