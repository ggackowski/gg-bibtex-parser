package ggbibtex;

public class BookFactory implements IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {"Author", "Title", "Publisher", "Year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"Volume", "Series", "Address", "Edition", "Month", "Note", "Key"};

        return optional;
    }

    public static BookFactory getInstance() {
        return new BookFactory();
    }
}
