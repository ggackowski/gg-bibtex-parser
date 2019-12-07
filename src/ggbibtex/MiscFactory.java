package ggbibtex;

public class MiscFactory implements  IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"author", "title", "howpublished",  "month", "year", "note", "key"};
        return optional;
    }

    public static ManualFactory getInstance() {
        return new ManualFactory();
    }
}
