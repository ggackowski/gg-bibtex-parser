package ggbibtex;

public class ArticleFactory implements IFactory {

    @Override
    public Record produceRecord() {
        Record r = new Record(RecordType.Article);
        return r;
    }

    public static ArticleFactory getInstance() {
        return new ArticleFactory();
    }
}
