package cac.components.ui.component.form;

import cac.components.ui.UiDimension;
import cac.components.ui.attribute.Axis;
import cac.components.ui.color.Theme;
import cac.components.ui.component.Container;
import cac.components.ui.component.Label;
import cac.components.ui.component.Panel;
import cac.components.ui.listener.action.DataAction;
import cac.components.ui.listener.mouse.form.CheckboxClickListener;
import cac.components.ui.listener.mouse.form.CheckboxMouseHoverListener;
import cac.components.ui.listener.mouse.form.FormBorder;
import cac.components.ui.text.Font;
import cac.components.ui.text.HorizontalTextAlignment;
import cac.components.ui.text.VerticalTextAlignment;

public class Checkbox extends Container {
    private static final int GAP = 10;

    private static final Theme theme = Theme.getInstance();

    private boolean isChecked;
    private boolean isEnabled;
    private Panel panel;

    public Checkbox(String text, Font font, UiDimension dimension, DataAction<Boolean> action) {
        isChecked = false;
        isEnabled = true;
        this.panel = new Panel();
        panel.setBackground(theme.getDefaultColor());
        panel.setBorder(FormBorder.DEFAULT_BORDER);
        panel.setSize(new UiDimension(dimension.getHeight(), dimension.getHeight()));
        panel.addMouseListener(new CheckboxMouseHoverListener(this));
        panel.addMouseListener(new CheckboxClickListener(this, action));
        Label label = new Label(text, font);
        label.setAlignment(HorizontalTextAlignment.LEFT, VerticalTextAlignment.CENTER);
        label.setSize(new UiDimension(dimension.getWidth() - dimension.getHeight(), dimension.getHeight()));
        add(panel);
        addGap(GAP, Axis.HORIZONTAL);
        add(label);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void check() {
        isChecked = true;
        panel.setBackground(theme.getHighlightColor());
    }

    public void uncheck() {
        isChecked = false;
        panel.setBackground(theme.getDefaultColor());
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void enable() {
        isEnabled = true;
        if (isChecked) {
            panel.setBackground(theme.getHighlightColor());
        } else {
            panel.setBackground(theme.getDefaultColor());
        }
    }

    public void disable() {
        isEnabled = false;
        panel.setBackground(theme.getDisabledColor());
    }

    public void highlight() {
        panel.setBorder(FormBorder.HIGHLIGHT_BORDER);
    }

    public void unhighlight() {
        panel.setBorder(FormBorder.DEFAULT_BORDER);
    }
}
