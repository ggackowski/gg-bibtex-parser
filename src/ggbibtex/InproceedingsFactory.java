package ggbibtex;

public class InproceedingsFactory implements IFactory {

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

    public static InproceedingsFactory getInstance() {
        return new InproceedingsFactory();
    }
}
