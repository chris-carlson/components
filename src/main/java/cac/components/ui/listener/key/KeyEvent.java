package cac.components.ui.listener.key;

import cac.components.ui.listener.InputEvent;

import java.util.Map;

public class KeyEvent extends InputEvent {
    private static final Map<Integer, Key> KEY_MAPPER =
            Map.ofEntries(Map.entry(java.awt.event.KeyEvent.VK_ESCAPE, Key.ESC),
                    Map.entry(java.awt.event.KeyEvent.VK_F1, Key.F1), Map.entry(java.awt.event.KeyEvent.VK_F2, Key.F2),
                    Map.entry(java.awt.event.KeyEvent.VK_F3, Key.F3), Map.entry(java.awt.event.KeyEvent.VK_F4, Key.F4),
                    Map.entry(java.awt.event.KeyEvent.VK_F5, Key.F5), Map.entry(java.awt.event.KeyEvent.VK_F6, Key.F6),
                    Map.entry(java.awt.event.KeyEvent.VK_F7, Key.F7), Map.entry(java.awt.event.KeyEvent.VK_F8, Key.F8),
                    Map.entry(java.awt.event.KeyEvent.VK_F9, Key.F9),
                    Map.entry(java.awt.event.KeyEvent.VK_F10, Key.F10),
                    Map.entry(java.awt.event.KeyEvent.VK_F11, Key.F11),
                    Map.entry(java.awt.event.KeyEvent.VK_F12, Key.F12),
                    Map.entry(java.awt.event.KeyEvent.VK_BACK_QUOTE, Key.BACK_QUOTE),
                    Map.entry(java.awt.event.KeyEvent.VK_1, Key.NUM_1),
                    Map.entry(java.awt.event.KeyEvent.VK_2, Key.NUM_2),
                    Map.entry(java.awt.event.KeyEvent.VK_3, Key.NUM_3),
                    Map.entry(java.awt.event.KeyEvent.VK_4, Key.NUM_4),
                    Map.entry(java.awt.event.KeyEvent.VK_5, Key.NUM_5),
                    Map.entry(java.awt.event.KeyEvent.VK_6, Key.NUM_6),
                    Map.entry(java.awt.event.KeyEvent.VK_7, Key.NUM_7),
                    Map.entry(java.awt.event.KeyEvent.VK_8, Key.NUM_8),
                    Map.entry(java.awt.event.KeyEvent.VK_9, Key.NUM_9),
                    Map.entry(java.awt.event.KeyEvent.VK_0, Key.NUM_0),
                    Map.entry(java.awt.event.KeyEvent.VK_EXCLAMATION_MARK, Key.EXCLAMATION_MARK),
                    Map.entry(java.awt.event.KeyEvent.VK_AT, Key.AT),
                    Map.entry(java.awt.event.KeyEvent.VK_NUMBER_SIGN, Key.POUND),
                    Map.entry(java.awt.event.KeyEvent.VK_DOLLAR, Key.DOLLAR),
                    Map.entry(java.awt.event.KeyEvent.VK_CIRCUMFLEX, Key.CARET),
                    Map.entry(java.awt.event.KeyEvent.VK_AMPERSAND, Key.AMPERSAND),
                    Map.entry(java.awt.event.KeyEvent.VK_ASTERISK, Key.ASTERISK),
                    Map.entry(java.awt.event.KeyEvent.VK_LEFT_PARENTHESIS, Key.LEFT_PARENTHESIS),
                    Map.entry(java.awt.event.KeyEvent.VK_RIGHT_PARENTHESIS, Key.RIGHT_PARENTHESIS),
                    Map.entry(java.awt.event.KeyEvent.VK_UNDERSCORE, Key.UNDERSCORE),
                    Map.entry(java.awt.event.KeyEvent.VK_PLUS, Key.PLUS),
                    Map.entry(java.awt.event.KeyEvent.VK_SUBTRACT, Key.DASH),
                    Map.entry(java.awt.event.KeyEvent.VK_EQUALS, Key.EQUALS),
                    Map.entry(java.awt.event.KeyEvent.VK_BACK_SPACE, Key.BACK_SPACE),
                    Map.entry(java.awt.event.KeyEvent.VK_TAB, Key.TAB), Map.entry(java.awt.event.KeyEvent.VK_Q, Key.Q),
                    Map.entry(java.awt.event.KeyEvent.VK_W, Key.W), Map.entry(java.awt.event.KeyEvent.VK_E, Key.E),
                    Map.entry(java.awt.event.KeyEvent.VK_R, Key.R), Map.entry(java.awt.event.KeyEvent.VK_T, Key.T),
                    Map.entry(java.awt.event.KeyEvent.VK_Y, Key.Y), Map.entry(java.awt.event.KeyEvent.VK_U, Key.U),
                    Map.entry(java.awt.event.KeyEvent.VK_I, Key.I), Map.entry(java.awt.event.KeyEvent.VK_O, Key.O),
                    Map.entry(java.awt.event.KeyEvent.VK_P, Key.P),
                    Map.entry(java.awt.event.KeyEvent.VK_OPEN_BRACKET, Key.LEFT_SQUARE_BRACKET),
                    Map.entry(java.awt.event.KeyEvent.VK_CLOSE_BRACKET, Key.RIGHT_SQUARE_BRACKET),
                    Map.entry(java.awt.event.KeyEvent.VK_BRACELEFT, Key.LEFT_BRACE),
                    Map.entry(java.awt.event.KeyEvent.VK_BRACERIGHT, Key.RIGHT_BRACE),
                    Map.entry(java.awt.event.KeyEvent.VK_BACK_SLASH, Key.BACK_SLASH),
                    Map.entry(java.awt.event.KeyEvent.VK_A, Key.A), Map.entry(java.awt.event.KeyEvent.VK_S, Key.S),
                    Map.entry(java.awt.event.KeyEvent.VK_D, Key.D), Map.entry(java.awt.event.KeyEvent.VK_F, Key.F),
                    Map.entry(java.awt.event.KeyEvent.VK_G, Key.G), Map.entry(java.awt.event.KeyEvent.VK_H, Key.H),
                    Map.entry(java.awt.event.KeyEvent.VK_J, Key.J), Map.entry(java.awt.event.KeyEvent.VK_K, Key.K),
                    Map.entry(java.awt.event.KeyEvent.VK_L, Key.L),
                    Map.entry(java.awt.event.KeyEvent.VK_SEMICOLON, Key.SEMICOLON),
                    Map.entry(java.awt.event.KeyEvent.VK_COLON, Key.COLON),
                    Map.entry(java.awt.event.KeyEvent.VK_QUOTE, Key.SINGLE_QUOTE),
                    Map.entry(java.awt.event.KeyEvent.VK_QUOTEDBL, Key.DOUBLE_QUOTE),
                    Map.entry(java.awt.event.KeyEvent.VK_ENTER, Key.ENTER),
                    Map.entry(java.awt.event.KeyEvent.VK_SHIFT, Key.SHIFT),
                    Map.entry(java.awt.event.KeyEvent.VK_Z, Key.Z), Map.entry(java.awt.event.KeyEvent.VK_X, Key.X),
                    Map.entry(java.awt.event.KeyEvent.VK_C, Key.C), Map.entry(java.awt.event.KeyEvent.VK_V, Key.V),
                    Map.entry(java.awt.event.KeyEvent.VK_B, Key.B), Map.entry(java.awt.event.KeyEvent.VK_N, Key.N),
                    Map.entry(java.awt.event.KeyEvent.VK_M, Key.M),
                    Map.entry(java.awt.event.KeyEvent.VK_COMMA, Key.COMMA),
                    Map.entry(java.awt.event.KeyEvent.VK_PERIOD, Key.PERIOD),
                    Map.entry(java.awt.event.KeyEvent.VK_LESS, Key.LEFT_ANGLE_BRACKET),
                    Map.entry(java.awt.event.KeyEvent.VK_GREATER, Key.RIGHT_ANGLE_BRACKET),
                    Map.entry(java.awt.event.KeyEvent.VK_SLASH, Key.SLASH),
                    Map.entry(java.awt.event.KeyEvent.VK_CONTROL, Key.CTRL),
                    Map.entry(java.awt.event.KeyEvent.VK_ALT, Key.ALT),
                    Map.entry(java.awt.event.KeyEvent.VK_SPACE, Key.SPACE),
                    Map.entry(java.awt.event.KeyEvent.VK_UP, Key.UP),
                    Map.entry(java.awt.event.KeyEvent.VK_DOWN, Key.DOWN),
                    Map.entry(java.awt.event.KeyEvent.VK_LEFT, Key.LEFT),
                    Map.entry(java.awt.event.KeyEvent.VK_RIGHT, Key.RIGHT),
                    Map.entry(java.awt.event.KeyEvent.VK_INSERT, Key.INSERT),
                    Map.entry(java.awt.event.KeyEvent.VK_DELETE, Key.DELETE),
                    Map.entry(java.awt.event.KeyEvent.VK_HOME, Key.HOME),
                    Map.entry(java.awt.event.KeyEvent.VK_END, Key.END),
                    Map.entry(java.awt.event.KeyEvent.VK_PAGE_UP, Key.PAGE_UP),
                    Map.entry(java.awt.event.KeyEvent.VK_PAGE_DOWN, Key.PAGE_DOWN));

    private final java.awt.event.KeyEvent rep;

    public KeyEvent(java.awt.event.KeyEvent rep) {
        super(rep);
        this.rep = rep;
    }

    public Key getKey() {
        return KEY_MAPPER.get(rep.getKeyCode());
    }

    @Override
    public String toString() {
        return getKey().toString();
    }
}
