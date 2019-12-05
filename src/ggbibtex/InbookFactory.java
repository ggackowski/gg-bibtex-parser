package ggbibtex;

public class InbookFactory implements IFactory {
    @Override
    public Record produceRecord() {
        return null;
    }
    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "editor", "title", "chapter", "pages", "publisher", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"volume", "number", "series", "type", "address", "edition", "month", "note", "key"};
        return optional;
    }
}
