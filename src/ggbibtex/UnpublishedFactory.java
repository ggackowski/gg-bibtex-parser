package ggbibtex;

public class UnpublishedFactory implements  IFactory{

    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "note"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"year", "month", "key"};
        return optional;
    }


    public static UnpublishedFactory getInstance() {
        return new UnpublishedFactory();
    }
}
