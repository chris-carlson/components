package com.cac.components.ui.listener.key;

import com.google.common.collect.Sets;

import java.util.Set;

public enum Key {
    ESC, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, BACK_QUOTE, NUM_1, NUM_2, NUM_3, NUM_4, NUM_5, NUM_6, NUM_7,
    NUM_8, NUM_9, NUM_0, EXCLAMATION_MARK, AT, POUND, DOLLAR, CARET, AMPERSAND, ASTERISK, LEFT_PARENTHESIS,
    RIGHT_PARENTHESIS, UNDERSCORE, PLUS, DASH, EQUALS, BACK_SPACE, TAB, Q, W, E, R, T, Y, U, I, O, P,
    LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET, LEFT_BRACE, RIGHT_BRACE, BACK_SLASH, A, S, D, F, G, H, J, K, L,
    SEMICOLON, COLON, SINGLE_QUOTE, DOUBLE_QUOTE, ENTER, SHIFT, Z, X, C, V, B, N, M, COMMA, PERIOD, LEFT_ANGLE_BRACKET,
    RIGHT_ANGLE_BRACKET, SLASH, CTRL, ALT, SPACE, UP, DOWN, LEFT, RIGHT, INSERT, DELETE, HOME, END, PAGE_UP, PAGE_DOWN;

    private static final Set<Key> LETTERS =
            Sets.newHashSet(Key.Q, Key.W, Key.E, Key.R, Key.T, Key.Y, Key.U, Key.I, Key.O, Key.P, Key.A, Key.S, Key.D,
                    Key.F, Key.G, Key.H, Key.J, Key.K, Key.L, Key.Z, Key.X, Key.C, Key.V, Key.B, Key.N, Key.M);
    private static final Set<Key> NUMBERS =
            Sets.newHashSet(Key.NUM_1, Key.NUM_2, Key.NUM_3, Key.NUM_4, Key.NUM_5, Key.NUM_6, Key.NUM_7, Key.NUM_8,
                    Key.NUM_9, Key.NUM_0);

    public static boolean isNumber(Key key) {
        return NUMBERS.contains(key);
    }

    public static boolean isLetter(Key key) {
        return LETTERS.contains(key);
    }
}
