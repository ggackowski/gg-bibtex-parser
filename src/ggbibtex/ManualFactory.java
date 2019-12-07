package ggbibtex;

public class ManualFactory implements IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {"title"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"author", "organization", "address", "edition", "month", "year", "note", "key"};
        return optional;
    }

    public static ManualFactory getInstance() {
        return new ManualFactory();
    }
}
