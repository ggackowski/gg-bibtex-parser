package ggbibtex;

public class ArticleFactory implements IFactory {

    @Override
    public Record produceRecord() {
        Record r = new Record(RecordType.Article);
        String[] necs = getNecessary();
        String[] ops = getOptional();
        for (String nec : necs)
            r.addNecessary(nec);
        for (String op : ops)
            r.addOptional(op);
        return r;
    }

    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "journal", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"volume", "number", "pages", "month", "note", "key"};
        return optional;
    }

    public static ArticleFactory getInstance() {
        return new ArticleFactory();
    }

}
