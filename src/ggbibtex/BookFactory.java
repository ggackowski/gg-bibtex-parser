package ggbibtex;

public class BookFactory implements IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "publisher", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"volume", "series", "number", "pages", "month", "note", "key"};
        return optional;
    }

    public static BookFactory getInstance() {
        return new BookFactory();
    }
}
