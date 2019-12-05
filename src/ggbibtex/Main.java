package ggbibtex;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Record record = Bibtex.createRecord("Article");
        record.fillNecessary("title", "Justynq");
        System.out.println(record);
    }
}
