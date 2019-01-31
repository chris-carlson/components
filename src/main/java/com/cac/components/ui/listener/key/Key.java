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

    public static Integer getNumber(Key key) {
        if (key == Key.NUM_1) {
            return 1;
        } else if (key == Key.NUM_2) {
            return 2;
        } else if (key == Key.NUM_3) {
            return 3;
        } else if (key == Key.NUM_4) {
            return 4;
        } else if (key == Key.NUM_5) {
            return 5;
        } else if (key == Key.NUM_6) {
            return 6;
        } else if (key == Key.NUM_7) {
            return 7;
        } else if (key == Key.NUM_8) {
            return 8;
        } else if (key == Key.NUM_9) {
            return 9;
        } else if (key == Key.NUM_0) {
            return 0;
        }
        return null;
    }

    public static Character getLetter(Key key) {
        if (key == Key.Q) {
            return 'Q';
        } else if (key == Key.W) {
            return 'W';
        } else if (key == Key.E) {
            return 'E';
        } else if (key == Key.R) {
            return 'R';
        } else if (key == Key.T) {
            return 'T';
        } else if (key == Key.Y) {
            return 'Y';
        } else if (key == Key.U) {
            return 'U';
        } else if (key == Key.I) {
            return 'I';
        } else if (key == Key.O) {
            return 'O';
        } else if (key == Key.P) {
            return 'P';
        } else if (key == Key.A) {
            return 'A';
        } else if (key == Key.S) {
            return 'S';
        } else if (key == Key.D) {
            return 'D';
        } else if (key == Key.F) {
            return 'F';
        } else if (key == Key.G) {
            return 'G';
        } else if (key == Key.H) {
            return 'H';
        } else if (key == Key.J) {
            return 'J';
        } else if (key == Key.K) {
            return 'K';
        } else if (key == Key.L) {
            return 'L';
        } else if (key == Key.Z) {
            return 'Z';
        } else if (key == Key.X) {
            return 'X';
        } else if (key == Key.C) {
            return 'C';
        } else if (key == Key.V) {
            return 'V';
        } else if (key == Key.B) {
            return 'B';
        } else if (key == Key.N) {
            return 'N';
        } else if (key == Key.M) {
            return 'M';
        }
        return null;
    }
}
