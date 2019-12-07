package ggbibtex;

import java.awt.print.Book;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static List<Record> records;

    public static void main(String[] args) {
        records = new LinkedList<Record>();
        Record r = BookFactory.getInstance().produceRecord();
        r.fillNecessary("author", "Mickiewicz and Justi W");
        r.fillNecessary("title" , "Pan Tadeusz");
        r.fillNecessary("publisher", "Gazeta");
        r.fillNecessary("year", "1998");
        r.setKey("MckPtd");
        System.out.println(r);

        for (String s : Record.parseAuthors("aaaa and aa aa ")) System.out.println(s);
    }
}
