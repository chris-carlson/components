package cac.components.ui.listener.key;

import cac.components.ui.listener.InputEvent;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class KeyEvent extends InputEvent {
    private static final Map<Integer, Key> KEY_MAPPER =
            new ImmutableMap.Builder<Integer, Key>().put(java.awt.event.KeyEvent.VK_ESCAPE, Key.ESC)
                    .put(java.awt.event.KeyEvent.VK_F1, Key.F1).put(java.awt.event.KeyEvent.VK_F2, Key.F2)
                    .put(java.awt.event.KeyEvent.VK_F3, Key.F3).put(java.awt.event.KeyEvent.VK_F4, Key.F4)
                    .put(java.awt.event.KeyEvent.VK_F5, Key.F5).put(java.awt.event.KeyEvent.VK_F6, Key.F6)
                    .put(java.awt.event.KeyEvent.VK_F7, Key.F7).put(java.awt.event.KeyEvent.VK_F8, Key.F8)
                    .put(java.awt.event.KeyEvent.VK_F9, Key.F9).put(java.awt.event.KeyEvent.VK_F10, Key.F10)
                    .put(java.awt.event.KeyEvent.VK_F11, Key.F11).put(java.awt.event.KeyEvent.VK_F12, Key.F12)
                    .put(java.awt.event.KeyEvent.VK_BACK_QUOTE, Key.BACK_QUOTE)
                    .put(java.awt.event.KeyEvent.VK_1, Key.NUM_1).put(java.awt.event.KeyEvent.VK_2, Key.NUM_2)
                    .put(java.awt.event.KeyEvent.VK_3, Key.NUM_3).put(java.awt.event.KeyEvent.VK_4, Key.NUM_4)
                    .put(java.awt.event.KeyEvent.VK_5, Key.NUM_5).put(java.awt.event.KeyEvent.VK_6, Key.NUM_6)
                    .put(java.awt.event.KeyEvent.VK_7, Key.NUM_7).put(java.awt.event.KeyEvent.VK_8, Key.NUM_8)
                    .put(java.awt.event.KeyEvent.VK_9, Key.NUM_9).put(java.awt.event.KeyEvent.VK_0, Key.NUM_0)
                    .put(java.awt.event.KeyEvent.VK_EXCLAMATION_MARK, Key.EXCLAMATION_MARK)
                    .put(java.awt.event.KeyEvent.VK_AT, Key.AT).put(java.awt.event.KeyEvent.VK_NUMBER_SIGN, Key.POUND)
                    .put(java.awt.event.KeyEvent.VK_DOLLAR, Key.DOLLAR)
                    .put(java.awt.event.KeyEvent.VK_CIRCUMFLEX, Key.CARET)
                    .put(java.awt.event.KeyEvent.VK_AMPERSAND, Key.AMPERSAND)
                    .put(java.awt.event.KeyEvent.VK_ASTERISK, Key.ASTERISK)
                    .put(java.awt.event.KeyEvent.VK_LEFT_PARENTHESIS, Key.LEFT_PARENTHESIS)
                    .put(java.awt.event.KeyEvent.VK_RIGHT_PARENTHESIS, Key.RIGHT_PARENTHESIS)
                    .put(java.awt.event.KeyEvent.VK_UNDERSCORE, Key.UNDERSCORE)
                    .put(java.awt.event.KeyEvent.VK_PLUS, Key.PLUS).put(java.awt.event.KeyEvent.VK_SUBTRACT, Key.DASH)
                    .put(java.awt.event.KeyEvent.VK_EQUALS, Key.EQUALS)
                    .put(java.awt.event.KeyEvent.VK_BACK_SPACE, Key.BACK_SPACE)
                    .put(java.awt.event.KeyEvent.VK_TAB, Key.TAB).put(java.awt.event.KeyEvent.VK_Q, Key.Q)
                    .put(java.awt.event.KeyEvent.VK_W, Key.W).put(java.awt.event.KeyEvent.VK_E, Key.E)
                    .put(java.awt.event.KeyEvent.VK_R, Key.R).put(java.awt.event.KeyEvent.VK_T, Key.T)
                    .put(java.awt.event.KeyEvent.VK_Y, Key.Y).put(java.awt.event.KeyEvent.VK_U, Key.U)
                    .put(java.awt.event.KeyEvent.VK_I, Key.I).put(java.awt.event.KeyEvent.VK_O, Key.O)
                    .put(java.awt.event.KeyEvent.VK_P, Key.P)
                    .put(java.awt.event.KeyEvent.VK_OPEN_BRACKET, Key.LEFT_SQUARE_BRACKET)
                    .put(java.awt.event.KeyEvent.VK_CLOSE_BRACKET, Key.RIGHT_SQUARE_BRACKET)
                    .put(java.awt.event.KeyEvent.VK_BRACELEFT, Key.LEFT_BRACE)
                    .put(java.awt.event.KeyEvent.VK_BRACERIGHT, Key.RIGHT_BRACE)
                    .put(java.awt.event.KeyEvent.VK_BACK_SLASH, Key.BACK_SLASH).put(java.awt.event.KeyEvent.VK_A, Key.A)
                    .put(java.awt.event.KeyEvent.VK_S, Key.S).put(java.awt.event.KeyEvent.VK_D, Key.D)
                    .put(java.awt.event.KeyEvent.VK_F, Key.F).put(java.awt.event.KeyEvent.VK_G, Key.G)
                    .put(java.awt.event.KeyEvent.VK_H, Key.H).put(java.awt.event.KeyEvent.VK_J, Key.J)
                    .put(java.awt.event.KeyEvent.VK_K, Key.K).put(java.awt.event.KeyEvent.VK_L, Key.L)
                    .put(java.awt.event.KeyEvent.VK_SEMICOLON, Key.SEMICOLON)
                    .put(java.awt.event.KeyEvent.VK_COLON, Key.COLON)
                    .put(java.awt.event.KeyEvent.VK_QUOTE, Key.SINGLE_QUOTE)
                    .put(java.awt.event.KeyEvent.VK_QUOTEDBL, Key.DOUBLE_QUOTE)
                    .put(java.awt.event.KeyEvent.VK_ENTER, Key.ENTER).put(java.awt.event.KeyEvent.VK_SHIFT, Key.SHIFT)
                    .put(java.awt.event.KeyEvent.VK_Z, Key.Z).put(java.awt.event.KeyEvent.VK_X, Key.X)
                    .put(java.awt.event.KeyEvent.VK_C, Key.C).put(java.awt.event.KeyEvent.VK_V, Key.V)
                    .put(java.awt.event.KeyEvent.VK_B, Key.B).put(java.awt.event.KeyEvent.VK_N, Key.N)
                    .put(java.awt.event.KeyEvent.VK_M, Key.M).put(java.awt.event.KeyEvent.VK_COMMA, Key.COMMA)
                    .put(java.awt.event.KeyEvent.VK_PERIOD, Key.PERIOD)
                    .put(java.awt.event.KeyEvent.VK_LESS, Key.LEFT_ANGLE_BRACKET)
                    .put(java.awt.event.KeyEvent.VK_GREATER, Key.RIGHT_ANGLE_BRACKET)
                    .put(java.awt.event.KeyEvent.VK_SLASH, Key.SLASH).put(java.awt.event.KeyEvent.VK_CONTROL, Key.CTRL)
                    .put(java.awt.event.KeyEvent.VK_ALT, Key.ALT).put(java.awt.event.KeyEvent.VK_SPACE, Key.SPACE)
                    .put(java.awt.event.KeyEvent.VK_UP, Key.UP).put(java.awt.event.KeyEvent.VK_DOWN, Key.DOWN)
                    .put(java.awt.event.KeyEvent.VK_LEFT, Key.LEFT).put(java.awt.event.KeyEvent.VK_RIGHT, Key.RIGHT)
                    .put(java.awt.event.KeyEvent.VK_INSERT, Key.INSERT)
                    .put(java.awt.event.KeyEvent.VK_DELETE, Key.DELETE).put(java.awt.event.KeyEvent.VK_HOME, Key.HOME)
                    .put(java.awt.event.KeyEvent.VK_END, Key.END).put(java.awt.event.KeyEvent.VK_PAGE_UP, Key.PAGE_UP)
                    .put(java.awt.event.KeyEvent.VK_PAGE_DOWN, Key.PAGE_DOWN).build();

    private java.awt.event.KeyEvent rep;

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
