package cac.components.ui.text;

import java.awt.Font;

public enum FontType {
    SANS_SERIF(Font.SANS_SERIF), SERIF(Font.SERIF), MONOSPACED(Font.MONOSPACED);

    private String rep;

    FontType(String rep) {
        this.rep = rep;
    }

    public String getRep() {
        return rep;
    }
}
