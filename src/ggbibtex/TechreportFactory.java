package ggbibtex;

public class TechreportFactory implements IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "institution", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"editor", "volume", "number", "series", "address", "month", "organization", "publisher", "note", "key"};
        return optional;
    }

    public static TechreportFactory getInstance() {
        return new TechreportFactory();
    }
}
