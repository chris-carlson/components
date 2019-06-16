package cac.components.io;

import com.google.common.collect.Sets;

import java.util.Set;

public class Consumer {
    private String rep;

    public Consumer(String rep) {
        this.rep = rep;
    }

    public boolean hasInput() {
        return !rep.isEmpty();
    }

    public boolean startsWith(String sequence) {
        return rep.startsWith(sequence);
    }

    public boolean contains(String sequence) {
        return rep.contains(sequence);
    }

    public int length() {
        return rep.length();
    }

    public Character peek() {
        if (rep.isEmpty()) {
            throw new AssertionError("Consumer is empty");
        }
        return rep.charAt(0);
    }

    public Character consumeCharacter() {
        return consumeCharacter(null);
    }

    public Character consumeCharacter(Character expected) {
        Character consumedChar = peek();
        if (expected != null && consumedChar != expected) {
            throw new AssertionError("Expected \"" + expected + "\" but consumed \"" + consumedChar + "\"");
        }
        rep = rep.substring(1);
        return consumedChar;
    }

    public Character consumeOneOf(Set<Character> characters) {
        Character consumedChar = peek();
        if (!characters.contains(consumedChar)) {
            throw new AssertionError("Expected one of \"" + characters + "\" but consumed \"" + consumedChar + "\"");
        }
        return consumeCharacter();
    }

    public String consumeCharacters(Integer numCharacters) {
        if (rep.length() < numCharacters) {
            throw new IllegalArgumentException("Cannot consume \"" + numCharacters + "\" characters");
        }
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < numCharacters; index++) {
            builder.append(consumeCharacter());
        }
        return builder.toString();
    }

    public String consumeSequence(String sequence) {
        return consumeThrough(sequence);
    }

    public String consumeTo(Character character) {
        return consumeToOneOf(Sets.newHashSet(character));
    }

    public String consumeToOneOf(Set<Character> characters) {
        if (!containsOneOf(characters)) {
            throw new AssertionError("Could not find one of \"" + characters + "\" in the consumer");
        }
        StringBuilder consumedCharacters = new StringBuilder();
        while (!characters.contains(peek())) {
            consumedCharacters.append(consumeCharacter());
        }
        return consumedCharacters.toString();
    }

    public String consumeTo(String sequence) {
        int index = rep.indexOf(sequence);
        if (index == -1) {
            throw new AssertionError("Could not find \"" + sequence + "\" in the consumer");
        }
        String consumedCharacters = rep.substring(0, index);
        rep = rep.substring(index);
        return consumedCharacters;
    }

    public String consumeThrough(Character character) {
        return consumeThroughOneOf(Sets.newHashSet(character));
    }

    public String consumeThroughOneOf(Set<Character> characters) {
        return consumeToOneOf(characters) + consumeCharacter();
    }

    public String consumeThrough(String sequence) {
        String consumedCharacters = consumeTo(sequence);
        consumedCharacters += rep.substring(0, sequence.length());
        rep = rep.substring(sequence.length());
        return consumedCharacters;
    }

    public void consumeWhitespace() {
        while (Character.isWhitespace(peek())) {
            consumeCharacter();
        }
    }

    public String consumeToWhitespace() {
        StringBuilder builder = new StringBuilder();
        while (!Character.isWhitespace(peek())) {
            builder.append(consumeCharacter());
        }
        return builder.toString();
    }

    public String consumeToEnd() {
        String consumedCharacters = rep;
        rep = "";
        return consumedCharacters;
    }

    private boolean containsOneOf(Set<Character> characters) {
        for (Character character : characters) {
            if (rep.indexOf(character) != -1) {
                return true;
            }
        }
        return false;
    }

    String getRep() {
        return rep;
    }

    @Override
    public String toString() {
        return rep;
    }
}
