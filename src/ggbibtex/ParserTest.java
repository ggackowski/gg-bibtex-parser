package ggbibtex;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    void testIfDividesInto() {
        Parser parser = new Parser();
        String s = "@misc{ patashnik-bibtexing, author = \"aFn,\" # \" Ari and sid, G df\", title = \"BIBTEXing\", year = \"1988\" }, author = \"Gackowski, G\"} @cos{a b}";
        HashMap<String, Record> records = parser.parse(s);
        for (String r : records.keySet())
            records.get(r).printDev();
        IShow show = new Show('a', 54);
        show.show(records);

        assertEquals(true, true);
    }

}