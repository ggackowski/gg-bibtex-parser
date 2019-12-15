package ggbibtex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecordTest {
    @Test
    void testIfRecordConstructorWorks() {
        Record r = new Record(RecordType.Article, "k");
        assertEquals(r.getType(), RecordType.Article);

    }

    @Test
    void testIfMakeStrWorks() {
        String s = "IFmakeStrWORKS";
        assertEquals(Record.mkstr(s), "Ifmakestrworks");
    }

    @Test
    void testIfShowingWrongArticleCreatesException() {
        Record r = ArticleFactory.getInstance().produceRecord();
        r.fillNecessary("title", "test");
        r.fillNecessary("year", "1993");
        assertEquals("Not enough necessary fields", r.print('a', 70));
    }

    @Test
    void testifShowingGoodArticleCreatesException() {
        Record r = ArticleFactory.getInstance().produceRecord();
        r.fillNecessary("author", "W J");
        r.fillNecessary("title", "Topologia w zadaniach");
        r.fillNecessary("journal", "Bravo");
        r.fillNecessary("year", "2019");
        assertNotEquals("Not enough necessary fields", r.print('a', 70));
    }
}