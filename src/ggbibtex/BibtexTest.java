package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibtexTest {

    @Test
    void TestCreateRecord() {
        Record r = Bibtex.createRecord("Article");
        assertEquals(r.getType(), RecordType.Article);
    }
}