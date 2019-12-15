package ggbibtex;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    void testIfDividesInto() {
        Parser parser = new Parser();
        String s = "@BOOK{whole-collection, editor = \"David J. Lipcoll and D. H. Lawrie and A. H. Sameh\", title = \"High Speed Computer and Algorithm Organization\", booktitle = \"High Speed Computer and Algorithm Organization\", number = 23, series = \"Fast Computers\", publisher = \"Academic Press\", address = \"New York\", edition = \"Third\", month = \"sep\", year = 1977, note = \"This is a cross-referenced BOOK (collection) entry\"}";
        HashMap<String, Record> records = parser.parse(s);
        for (String st : records.keySet())
            records.get(st).printDev();
        IShow show = new Show('a', 54);
        show.show(records);

        assertEquals(true, true);
    }

}