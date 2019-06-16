package cac.components.ui;

public class Dimension {
    private java.awt.Dimension rep;

    public Dimension(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException(
                    "The width \"" + width + "\" and height \"" + height + "\" must be non-negative");
        }
        rep = new java.awt.Dimension(width, height);
    }

    public java.awt.Dimension getRep() {
        return rep;
    }

    public int getWidth() {
        return rep.width;
    }

    public int getHeight() {
        return rep.height;
    }

    @Override
    public String toString() {
        return "(" + rep.width + ", " + rep.height + ")";
    }
}
