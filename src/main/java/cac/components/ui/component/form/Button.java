package cac.components.ui.component.form;

import cac.components.ui.UiDimension;
import cac.components.ui.attribute.alignment.HorizontalAlignment;
import cac.components.ui.attribute.alignment.VerticalAlignment;
import cac.components.ui.color.Theme;
import cac.components.ui.component.Label;
import cac.components.ui.listener.action.SimpleAction;
import cac.components.ui.listener.mouse.form.ButtonClickListener;
import cac.components.ui.listener.mouse.form.ButtonMouseHoverListener;
import cac.components.ui.listener.mouse.form.ButtonMousePressListener;
import cac.components.ui.listener.mouse.form.FormBorder;
import cac.components.ui.text.Font;
import cac.components.ui.text.HorizontalTextAlignment;
import cac.components.ui.text.VerticalTextAlignment;

public class Button extends Label {
    private static final Theme theme = Theme.getInstance();

    private boolean isEnabled;

    public Button(String text, Font font, UiDimension dimension, SimpleAction action) {
        super(text, font);
        isEnabled = true;
        setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        setAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.CENTER);
        setBorder(FormBorder.DEFAULT_BORDER);
        setSize(dimension);
        addMouseListener(new ButtonMouseHoverListener(this));
        addMouseListener(new ButtonMousePressListener(this));
        addMouseListener(new ButtonClickListener(this, action));
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void enable() {
        isEnabled = true;
        setBackground(theme.getDefaultColor());
    }

    public void disable() {
        isEnabled = false;
        setBackground(theme.getDisabledColor());
    }
}
