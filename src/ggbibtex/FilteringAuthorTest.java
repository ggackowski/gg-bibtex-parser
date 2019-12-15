package ggbibtex;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FilteringAuthorTest {
    @Test
    void testIfWillFindSurname() {
        HashMap<String, Record> data = new HashMap<>();
        IFiltering filter = new FilteringAuthor();
        Record r1 = MiscFactory.getInstance().produceRecord();
        r1.setKey("r1");
        r1.fillOptional("author", "Smith, Adam");
        Record r2 = MiscFactory.getInstance().produceRecord();
        r2.setKey("r2");
        r2.fillOptional("author", "Smith, Adak");
        Record r3 = MiscFactory.getInstance().produceRecord();
        r3.setKey("r3");
        r3.fillOptional("author", "AaAa, Ab");
        Record r4 = MiscFactory.getInstance().produceRecord();
        r4.setKey("r4");
        r4.fillOptional("author", "Smith, Adam and YYY, YY");
        data.put(r1.getKey(), r1);
        data.put(r2.getKey(), r2);
        data.put(r3.getKey(), r3);
        data.put(r4.getKey(), r4);
        HashMap<String, Record> filteredData = filter.filter(data, "Smith");
        assertEquals(3, filteredData.size());
    }

    @Test
    void testIfWontFindAnything() {
        HashMap<String, Record> data = new HashMap<>();
        IFiltering filter = new FilteringAuthor();
        Record r1 = MiscFactory.getInstance().produceRecord();
        r1.setKey("r1");
        r1.fillOptional("author", "Smith, Adam");
        Record r2 = MiscFactory.getInstance().produceRecord();
        r2.setKey("r2");
        r2.fillOptional("author", "Smith, Adak");
        Record r3 = MiscFactory.getInstance().produceRecord();
        r3.setKey("r3");
        r3.fillOptional("author", "AaAa, Ab");
        Record r4 = MiscFactory.getInstance().produceRecord();
        r4.setKey("r4");
        r4.fillOptional("author", "Smith, Adam and YYY, YY");
        data.put(r1.getKey(), r1);
        data.put(r2.getKey(), r2);
        data.put(r3.getKey(), r3);
        data.put(r4.getKey(), r4);
        HashMap<String, Record> filteredData = filter.filter(data, "S");
        assertEquals(0, filteredData.size());
    }

    @Test
    void testIfWillFindNameSurname() {
        HashMap<String, Record> data = new HashMap<>();
        IFiltering filter = new FilteringAuthor();
        Record r1 = MiscFactory.getInstance().produceRecord();
        r1.setKey("r1");
        r1.fillOptional("author", "Smith, Adam");
        Record r2 = MiscFactory.getInstance().produceRecord();
        r2.setKey("r2");
        r2.fillOptional("author", "Smith, Adak");
        Record r3 = MiscFactory.getInstance().produceRecord();
        r3.setKey("r3");
        r3.fillOptional("author", "AaAa, Ab");
        Record r4 = MiscFactory.getInstance().produceRecord();
        r4.setKey("r4");
        r4.fillOptional("author", "Smith, Adam and YYY, YY");
        data.put(r1.getKey(), r1);
        data.put(r2.getKey(), r2);
        data.put(r3.getKey(), r3);
        data.put(r4.getKey(), r4);
        HashMap<String, Record> filteredData = filter.filter(data, "Adam Smith");
        assertEquals(2, filteredData.size());
    }

}