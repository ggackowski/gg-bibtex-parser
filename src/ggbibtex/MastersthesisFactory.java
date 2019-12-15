package ggbibtex;

public class MastersthesisFactory implements IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "school", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"type", "address", "month", "key", "note"};
        return optional;
    }

    public static MastersthesisFactory getInstance() {
        return new MastersthesisFactory();
    }
}
