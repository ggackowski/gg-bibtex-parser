package ggbibtex;

public interface IFactory {
    Record produceRecord();
    String[] getNecessary();
    String[] getOptional();

}
