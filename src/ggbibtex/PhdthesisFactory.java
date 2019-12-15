package ggbibtex;

public class PhdthesisFactory implements IFactory {
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


    public static PhdthesisFactory getInstance() {
        return new PhdthesisFactory();
    }
}
