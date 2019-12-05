package ggbibtex;

public class BookletFactory implements IFactory {
    @Override
    public Record produceRecord() {
        return null;
    }
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
}
