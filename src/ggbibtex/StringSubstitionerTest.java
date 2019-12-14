package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSubstitionerTest {
    @Test
    void testIfWorksStringSubs() {
        IStringSubstitioner sub = new StringSubstitioner();
        String res = sub.substitute("@string { foo = \"xd\"} @article { author = foo # \" cnie\"}");
        System.out.println(res);


        String input = "@string { name = \"Oren\"} @misc{ patashnik-bibtexing, author = name # \" \"  # \"Patashnik\", title = \"BIBTEXing\", year = \"1988\" }";
        String ress = sub.substitute(input);
        Parser p = new Parser();
        IShow show = new Show('a', 40);
        show.show(p.parse(ress));
    }

}