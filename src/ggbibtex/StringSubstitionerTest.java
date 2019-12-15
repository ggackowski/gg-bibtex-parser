package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSubstitionerTest {
    @Test
    void testIfWorksStringSubs() {
        IStringSubstitioner sub = new StringSubstitioner();


        String input = "@string { variable = \"test\" }  @misc { title = variable # \" test\"   }  ";
        String ress = sub.substitute(input);
        assertEquals(67, ress.length());
    }

}