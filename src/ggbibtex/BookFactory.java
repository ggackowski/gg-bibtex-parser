package ggbibtex;

public class BookFactory implements IFactory {
    @Override
    public Record produceRecord() {
        return null;
    }
    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "editor", "title", "publisher", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"volume", "series", "number", "pages", "month", "note", "key"};
        return optional;
    }
}
