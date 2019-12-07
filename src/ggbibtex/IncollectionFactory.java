package ggbibtex;

public class IncollectionFactory implements IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "booktitle", "publisher", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"editor", "volume", "number", "series", "type", "chapter", "pages", "address", "edition", "month", "note", "key"};
        return optional;
    }

    public static IncollectionFactory getInstance() {
        return new IncollectionFactory();
    }
}
