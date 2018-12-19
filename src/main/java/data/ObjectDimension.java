package data;

public class ObjectDimension {
    private java.awt.Dimension rep;

    public ObjectDimension(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException(
                "The width \"" + width + "\" and height \"" + height + "\" must be non-negative");
        }
        rep = new java.awt.Dimension(width, height);
    }

    public java.awt.Dimension getRep() {
        return rep;
    }

    @Override
    public String toString() {
        return "(" + rep.width + ", " + rep.height + ")";
    }
}
