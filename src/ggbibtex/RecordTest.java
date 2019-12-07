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
    void testIfShowingWrongArticleCreatesExeption() {
        Record r = ArticleFactory.getInstance().produceRecord();
        r.fillNecessary("title", "test");
        r.fillNecessary("year", "1993");
        assertEquals("Not enough necessary fields", r.toString());
    }

    @Test
    void testifShowingGoodArticleCreatesException() {
        Record r = ArticleFactory.getInstance().produceRecord();
        r.fillNecessary("author", "Wąsik Justyn");
        r.fillNecessary("title", "Topologia w zadaniach");
        r.fillNecessary("journal", "Bravo");
        r.fillNecessary("year", "2019");
        System.out.println(r);
        assertNotEquals("Not enough necessary fields", r.toString());
    }
}