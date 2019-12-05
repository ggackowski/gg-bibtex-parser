package ggbibtex;

public class InproceedingFactory implements IFactory {
    @Override
    public Record produceRecord() {
        return null;
    }
    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "booktitle", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"editor", "volume", "number", "series", "pages", "address", "month", "organization", "publisher", "note", "key"};
        return optional;
    }
}
