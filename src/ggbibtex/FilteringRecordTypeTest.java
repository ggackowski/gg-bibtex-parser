package ggbibtex;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FilteringRecordTypeTest {

    @Test
    void testIfFilteringByJustManualWorks() {
        HashMap<String, Record> records = new HashMap<>();
        Record r1 = ManualFactory.getInstance().produceRecord();
        r1.fillNecessary("title", "Manual 1");
        r1.fillOptional("author", "JW");
        r1.setKey("AAA");

        Record r2 = MthesisFactory.getInstance().produceRecord();
        r2.fillNecessary("author", "GG");
        r2.fillNecessary("title", "M");
        r2.fillNecessary("school", "AGH UST");
        r2.fillNecessary("year", "2018");
        r2.setKey("BBB");

        records.put(r1.getKey(), r1);
        records.put(r2.getKey(), r2);
        IFiltering f = new FilteringRecordType();
        assertEquals(1, f.filter(records, "Manual").size());

    }
}