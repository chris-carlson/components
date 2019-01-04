package com.cac.components.ui.text;

public class Font {
    private java.awt.Font rep;

    public Font(FontType name, FontStyle style, int size) {
        rep = new java.awt.Font(name.getRep(), style.getRep(), size);
    }

    public java.awt.Font getRep() {
        return rep;
    }
}
