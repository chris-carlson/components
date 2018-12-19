package ui;

public class Color {
    private java.awt.Color rep;

    public Color(int red, int green, int blue) {
        rep = new java.awt.Color(red, green, blue);
    }

    public java.awt.Color getRep() {
        return rep;
    }
}
