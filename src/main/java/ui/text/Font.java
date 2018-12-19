package ui.text;

public class Font {
    private java.awt.Font rep;

    public Font(FontType name, FontStyle style, int size) {
        rep = new java.awt.Font(getSwingName(name), getSwingStyle(style), size);
    }

    public java.awt.Font getRep() {
        return rep;
    }

    private String getSwingName(FontType name) {
        if (name == FontType.SANS_SERIF) {
            return java.awt.Font.SANS_SERIF;
        } else if (name == FontType.SERIF) {
            return java.awt.Font.SERIF;
        }
        return java.awt.Font.MONOSPACED;
    }

    private int getSwingStyle(FontStyle style) {
        if (style == FontStyle.BOLD) {
            return java.awt.Font.BOLD;
        } else if (style == FontStyle.ITALIC) {
            return java.awt.Font.ITALIC;
        }
        return java.awt.Font.PLAIN;
    }
}
