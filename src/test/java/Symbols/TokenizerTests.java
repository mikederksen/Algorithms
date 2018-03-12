package Symbols;

import org.junit.Test;

import java.io.StringReader;

import static junit.framework.TestCase.assertEquals;

public class TokenizerTests {

    @Test
    public void something() {
        Tokenizer sut = new Tokenizer(new StringReader("Something"));

        assertEquals("Something", sut.toString());
        assertEquals("Something", sut.toString());
        assertEquals("Something", sut.toString());
        assertEquals("Something", sut.toString());
    }
}
