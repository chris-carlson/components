package cac.components.ui.attribute;

import cac.components.ui.color.Color;
import cac.components.ui.text.Font;
import cac.components.ui.text.HorizontalTextAlignment;
import cac.components.ui.text.VerticalTextAlignment;

import javax.swing.JLabel;
import java.util.Map;

public interface Writable {
    JLabel getRep();

    default String getText() {
        return getRep().getText();
    }

    default void setText(String text) {
        getRep().setText("<html>" + text + "</html>");
    }

    default void setText(Map<String, Color> textColors) {
        setText(getColoredText(textColors));
    }

    private String getColoredText(Map<String, Color> textColors) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Color> textColor : textColors.entrySet()) {
            Color color = textColor.getValue();
            builder.append("<span style=\"color: rgb(").append(color.getRed()).append(",").append(color.getGreen())
                    .append(",").append(color.getBlue()).append(")\">").append(textColor.getKey()).append("</span>");
        }
        return builder.toString();
    }

    default void setFont(Font font) {
        getRep().setFont(font.getRep());
    }

    default void setAlignment(HorizontalTextAlignment horizontalAlignment, VerticalTextAlignment verticalAlignment) {
        getRep().setHorizontalAlignment(horizontalAlignment.getRep());
        getRep().setVerticalAlignment(verticalAlignment.getRep());
    }
}
