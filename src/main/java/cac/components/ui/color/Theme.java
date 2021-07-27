package cac.components.ui.color;

public class Theme {
    private static final Theme instance = new Theme(Color.DEFAULT, Color.DEFAULT, Color.DEFAULT);

    public static Theme getInstance() {
        return instance;
    }

    private Color defaultColor;
    private Color highlightColor;
    private Color disabledColor;

    public Theme(Color defaultColor, Color highlightColor, Color disabledColor) {
        setColors(defaultColor, highlightColor, disabledColor);
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public Color getHighlightColor() {
        return highlightColor;
    }

    public Color getDisabledColor() {
        return disabledColor;
    }

    public void setColors(Color defaultColor, Color highlightColor, Color disabledColor) {
        this.defaultColor = defaultColor;
        this.highlightColor = highlightColor;
        this.disabledColor = disabledColor;
    }
}
