package ggbibtex;

public class ArticleFactory implements IFactory {

    @Override
    public String[] getNecessary() {
        String[] necessary = {"author", "title", "journal", "year"};
        return necessary;
    }

    @Override
    public String[] getOptional() {
        String[] optional = {"volume", "number", "pages", "month", "note", "key"};
        return optional;
    }

    public static ArticleFactory getInstance() {
        return new ArticleFactory();
    }

}
