package ggbibtex;

public class BookletFactory implements IFactory {
    @Override
    public String[] getNecessary() {
        String[] necessary = {"title"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"author", "howpublished", "address", "month", "year", "note", "key"};
        return optional;
    }

    public static BookletFactory getInstance() {
        return new BookletFactory();
    }
}
