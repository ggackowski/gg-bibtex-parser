package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFactoryTest {

    @Test
    void testIfArticleProduced() {
        assertNotEquals(ArticleFactory.getInstance().produceRecord(), null);
    }

    @Test
    void testIfBookProduced() {
        assertNotEquals(BookFactory.getInstance().produceRecord(), null);
    }


    @Test
    void testIfBookletProduced() {
        assertNotEquals(BookletFactory.getInstance().produceRecord(), null);
    }


    @Test
    void testIfInbookProduced() {
        assertNotEquals(InbookFactory.getInstance().produceRecord(), null);
    }

    @Test
    void testIfIncollectionProduced() {
        assertNotEquals(IncollectionFactory.getInstance().produceRecord(), null);
    }

    @Test
    void testIfInproceedingsProduced() {
        assertNotEquals(InproceedingsFactory.getInstance().produceRecord(), null);
    }

    @Test
    void testIfManualProduced() {
        assertNotEquals(ManualFactory.getInstance().produceRecord(), null);
    }

    @Test
    void testIfMastersthesisProduced() {
        assertNotEquals(MastersthesisFactory.getInstance().produceRecord(), null);
    }


    @Test
    void testIfMiscProduced() {
        assertNotEquals(MiscFactory.getInstance().produceRecord(), null);
    }


    @Test
    void testIfPhdthesisProduced() {
        assertNotEquals(PhdthesisFactory.getInstance().produceRecord(), null);
    }


    @Test
    void testIfTechReportProduced() {
        assertNotEquals(TechreportFactory.getInstance().produceRecord(), null);
    }


    @Test
    void testIfUnpublishedProduced() {
        assertNotEquals(UnpublishedFactory.getInstance().produceRecord(), null);
    }


}