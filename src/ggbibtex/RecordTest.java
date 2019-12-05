package ggbibtex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecordTest {
    @Test
    void testIfRecordConstructorWorks() {
        Record r = new Record(RecordType.Article);
        assertEquals(r.getType(), RecordType.Article);

    }
}