package ggbibtex;

public class MthesisFactory implements IFactory {

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

    public static MthesisFactory getInstance() {
        return new MthesisFactory();
    }
}
