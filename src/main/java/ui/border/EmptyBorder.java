package ui.border;

public class EmptyBorder implements Border {
    private javax.swing.border.Border rep;

    public EmptyBorder(int thickness) {
        this(thickness, thickness, thickness, thickness);
    }

    public EmptyBorder(int horizontal, int vertical) {
        this(horizontal, horizontal, vertical, vertical);
    }

    public EmptyBorder(int left, int right, int top, int bottom) {
        rep = new javax.swing.border.EmptyBorder(top, left, bottom, right);
    }

    @Override
    public javax.swing.border.Border getRep() {
        return rep;
    }
}
