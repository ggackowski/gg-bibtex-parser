package ggbibtex;

public class ManualFactory implements IFactory {
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
        String[] optional = {"author", "organization", "address", "edition", "month", "year", "note", "key"};
        return optional;
    }
}
