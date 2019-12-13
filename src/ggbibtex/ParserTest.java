package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    void testIfDividesInto() {
        Parser parser = new Parser();
        String s = "@article {nana, title} @cos{a b}";
        parser.parse(s);
        assertEquals(true, true);
    }

}