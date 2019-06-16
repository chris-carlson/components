package cac.components.io;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsumerTest {
    private Consumer instance;

    @Test
    void hasInput() {
        instance = new Consumer("*");
        Assertions.assertTrue(instance.hasInput());
    }

    @Test
    void doesNotHaveInput() {
        instance = new Consumer("");
        Assertions.assertFalse(instance.hasInput());
    }

    @Test
    void startsWith() {
        instance = new Consumer("abcdef");
        Assertions.assertTrue(instance.startsWith("abc"));
    }

    @Test
    void doesNotStartWith() {
        instance = new Consumer("abcdef");
        Assertions.assertFalse(instance.startsWith("def"));
    }

    @Test
    void contains() {
        instance = new Consumer("abcdef");
        Assertions.assertTrue(instance.contains("def"));
    }

    @Test
    void doesNotContain() {
        instance = new Consumer("abcdef");
        Assertions.assertFalse(instance.contains("ghi"));
    }

    @Test
    void length() {
        instance = new Consumer("abcdef");
        Assertions.assertEquals(6, instance.length());
    }

    @Test
    void peek() {
        instance = new Consumer("abc");
        Assertions.assertEquals(Character.valueOf('a'), instance.peek());
    }

    @Test
    void cannotPeek() {
        instance = new Consumer("");
        assertThrows(AssertionError.class, () -> instance.peek());
    }

    @Test
    void consumeAnyCharacter() {
        instance = new Consumer("abc");
        Assertions.assertEquals(Character.valueOf('a'), instance.consumeCharacter());
        Assertions.assertEquals("bc", instance.getRep());
    }

    @Test
    void consumeSpecificCharacter() {
        instance = new Consumer("abc");
        Assertions.assertEquals(Character.valueOf('a'), instance.consumeCharacter('a'));
        Assertions.assertEquals("bc", instance.getRep());
    }

    @Test
    void cannotConsumeSpecificCharacter() {
        instance = new Consumer("abc");
        assertThrows(AssertionError.class, () -> instance.consumeCharacter('b'));
    }

    @Test
    void consumeOneOf() {
        instance = new Consumer("abc");
        Assertions.assertEquals(Character.valueOf('a'), instance.consumeOneOf(Sets.newHashSet('a', 'b')));
        Assertions.assertEquals("bc", instance.getRep());
    }

    @Test
    void cannotConsumeOneOf() {
        instance = new Consumer("abc");
        assertThrows(AssertionError.class, () -> instance.consumeOneOf(Sets.newHashSet('b', 'c')));
    }

    @Test
    void consumeSequence() {
        instance = new Consumer("abcdef");
        Assertions.assertEquals("abc", instance.consumeSequence("abc"));
        Assertions.assertEquals("def", instance.getRep());
    }

    @Test
    void consumeTo() {
        instance = new Consumer("abcdef");
        Assertions.assertEquals("abc", instance.consumeTo('d'));
        Assertions.assertEquals("def", instance.getRep());
    }

    @Test
    void consumeToOneOf() {
        instance = new Consumer("abcdef");
        Assertions.assertEquals("abc", instance.consumeToOneOf(Sets.newHashSet('d', 'e', 'f')));
        Assertions.assertEquals("def", instance.getRep());
    }

    @Test
    void cannotConsumeToOneOf() {
        instance = new Consumer("abcdef");
        assertThrows(AssertionError.class, () -> instance.consumeToOneOf(Sets.newHashSet('g', 'h', 'i')));
    }

    @Test
    void consumeToSequence() {
        instance = new Consumer("abcdef");
        Assertions.assertEquals("abc", instance.consumeTo("def"));
        Assertions.assertEquals("def", instance.getRep());
    }

    @Test
    void cannotConsumeToSequence() {
        instance = new Consumer("abcdef");
        assertThrows(AssertionError.class, () -> instance.consumeTo("ghi"));
    }

    @Test
    void consumeThrough() {
        instance = new Consumer("abcdefghi");
        Assertions.assertEquals("abcdef", instance.consumeThrough('f'));
        Assertions.assertEquals("ghi", instance.getRep());
    }

    @Test
    void consumeThroughOneOf() {
        instance = new Consumer("abcdefghi");
        Assertions.assertEquals("abcdef", instance.consumeThroughOneOf(Sets.newHashSet('f')));
        Assertions.assertEquals("ghi", instance.getRep());
    }

    @Test
    void consumeThroughSequence() {
        instance = new Consumer("abcdefghi");
        Assertions.assertEquals("abcdef", instance.consumeThrough("def"));
        Assertions.assertEquals("ghi", instance.getRep());
    }

    @Test
    void consumeWhitespace() {
        instance = new Consumer(" \t\r\n abc");
        instance.consumeWhitespace();
        Assertions.assertEquals("abc", instance.getRep());
    }

    @Test
    void consumeToWhitespace() {
        instance = new Consumer("abc \t\r\n def");
        Assertions.assertEquals("abc", instance.consumeToWhitespace());
        Assertions.assertEquals(" \t\r\n def", instance.getRep());
    }

    @Test
    void consumeToEnd() {
        instance = new Consumer("abcdef");
        Assertions.assertEquals("abcdef", instance.consumeToEnd());
        Assertions.assertFalse(instance.hasInput());
    }

    @Test
    void stringRep() {
        instance = new Consumer("abc");
        Assertions.assertEquals("abc", instance.toString());
    }
}
