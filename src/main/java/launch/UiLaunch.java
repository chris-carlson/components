package launch;

import data.ObjectDimension;
import ui.Color;
import ui.attribute.Holdable;
import ui.border.LineBorder;
import ui.component.Container;
import ui.component.Frame;
import ui.component.Panel;
import ui.layout.LayoutDirection;
import ui.layout.LineLayout;
import ui.listener.mouse.FocusMouseClickListener;

public class UiLaunch {
    public static final int SIZE = 256;

    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GRAY = new Color(64, 64, 64);
    public static final Color WHITE = new Color(255, 255, 255);

    public static final Color RED = new Color(255, 128, 128);
    public static final Color GREEN = new Color(0, 255, 128);
    public static final Color BLUE = new Color(0, 162, 232);
    public static final Color YELLOW = new Color(239, 228, 176);
    public static final Color PURPLE = new Color(200, 191, 231);
    public static final Color PINK = new Color(255, 128, 255);
    public static final Color ORANGE = new Color(255, 128, 0);
    public static final Color TEAL = new Color(0, 128, 128);
    public static final Color BROWN = new Color(128, 64, 64);

    public static void main(String[] args) {
        Container container = new Container();
        container.setLayout(new LineLayout(container, LayoutDirection.LEFT_TO_RIGHT));
//        container.setLayout(new GridLayout(new GridDimension(3, 3)));
//        List<Color> colors = Lists.newArrayList(RED, GREEN, BLUE, YELLOW, PURPLE, PINK, ORANGE, TEAL, BROWN);
//        for (Color color : colors) {
//            Holdable colorPanel = createPanel(color);
//            container.add(colorPanel);
//        }
        Frame frame = new Frame("Test", container);
        frame.show();
    }

    private static Holdable createPanel(Color color) {
        Panel panel = new Panel();
        panel.setBackground(color);
        panel.setBorder(new LineBorder(BLACK, 3));
        panel.setSize(new ObjectDimension(SIZE, SIZE));
        panel.addMouseListener(new FocusMouseClickListener(panel));
        return panel;
    }
}
