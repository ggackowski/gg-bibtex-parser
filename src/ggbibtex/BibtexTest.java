package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibtexTest {

    @Test
    void testCreateArticleRecord() {
        Record r = Bibtex.createRecord("Article");
        assertEquals(r.getType(), RecordType.Article);
    }

    @Test
    void testCreateBookRecord() {
        Record r = Bibtex.createRecord("Book");
        assertEquals(r.getType(), RecordType.Book);
    }

    @Test
    void testCreateBookletRecord() {
        Record r = Bibtex.createRecord("Booklet");
        assertEquals(r.getType(), RecordType.Booklet);
    }

    @Test
    void testCreateInbookRecord() {
        Record r = Bibtex.createRecord("Inbook");
        assertEquals(r.getType(), RecordType.Inbook);
    }

    @Test
    void testCreateIncollectionRecord() {
        Record r = Bibtex.createRecord("Incollection");
        assertEquals(r.getType(), RecordType.Incollection);
    }

    @Test
    void testCreateInproceedingRecord() {
        Record r = Bibtex.createRecord("Inproceeding");
        assertEquals(r.getType(), RecordType.Inproceeding);
    }

    @Test
    void testCreateManualRecord() {
        Record r = Bibtex.createRecord("Manual");
        assertEquals(r.getType(), RecordType.Manual);
    }

    @Test
    void testCreateMiscRecord() {
        Record r = Bibtex.createRecord("Misc");
        assertEquals(r.getType(), RecordType.Misc);
    }
    @Test
    void testCreateMthesisRecord() {
        Record r = Bibtex.createRecord("Mthesis");
        assertEquals(r.getType(), RecordType.Mthesis);
    }

    @Test
    void testCreatePhdthesisRecord() {
        Record r = Bibtex.createRecord("Phdthesis");
        assertEquals(r.getType(), RecordType.Phdthesis);
    }

    @Test
    void testCreateTechreportRecord() {
        Record r = Bibtex.createRecord("Techreport");
        assertEquals(r.getType(), RecordType.Techreport);
    }

    @Test
    void testCreateUnpublishedRecord() {
        Record r = Bibtex.createRecord("Unpublished");
        assertEquals(r.getType(), RecordType.Unpublished);
    }
}