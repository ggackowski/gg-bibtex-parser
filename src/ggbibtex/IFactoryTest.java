package ggbibtex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFactoryTest {

    @Test
    void testIfArticleProduced() {
        assertNotEquals(ArticleFactory.getInstance().produceRecord(), null);
    }
}