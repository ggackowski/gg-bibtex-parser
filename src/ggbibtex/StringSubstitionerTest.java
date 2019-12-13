package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSubstitionerTest {
    @Test
    void testIfWorksStringSubs() {
        IStringSubstitioner sub = new StringSubstitioner();
        sub.substitute("@string { foo = \"xd\"} @article { author = foo # \" cnie\"}");
    }

}