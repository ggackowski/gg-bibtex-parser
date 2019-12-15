package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSubstitionerTest {
    @Test
    void testIfWorksStringSubs() {
        IStringSubstitioner sub = new StringSubstitioner();


        String input = "@string { editor1 = \"David J. Lipcoll\" }  @BOOK{whole-collection, editor = editor1 # \" and D. H. Lawrie and A. H. Sameh\", title = \"High Speed Computer and Algorithm Organization\", booktitle = \"High Speed Computer and Algorithm Organization\", number = 23, series = \"Fast Computers\", publisher = \"Academic Press\", address = \"New York\", edition = \"Third\", month = sep, year = 1977, note = \"This is a cross-referenced BOOK (collection) entry\",}";
        String ress = sub.substitute(input);
        Parser p = new Parser();
        IShow show = new Show('a', 80);
        show.show(p.parse(ress));
    }

}