package ggbibtex;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static HashMap<String, Record> records;



    public static void main(String[] args) {
        records = new HashMap<String, Record>();

        Record r = BookFactory.getInstance().produceRecord();
        r.fillNecessary("author", "Adrian Mickiewicz and Janusz Słowacki");
        r.fillNecessary("title" , "Pan Tadeusz");
        r.fillNecessary("publisher", "Gazeta");
        r.fillNecessary("year", "1998");
        r.setKey("MckPtd");

        Record d = MiscFactory.getInstance().produceRecord();
        d.fillOptional("author", "Ja and Ty");
        d.fillOptional("title" , "xdddddkh");
        d.fillOptional("howpublished", "Magazyn");
        d.fillOptional("year", "2020");
        d.setKey("dsfni");

        records.put(d.getKey(), d);
        records.put(r.getKey(), r);

        IShow s = new Show('x');
        IFiltering filter = new FilteringRecordType();
        HashMap<String, Record> newRecords = filter.filter(records, "Book");
        System.out.println("REKORDY W BIBLIOGRAFII PRZED FILTROWANIEM");
        s.show(records);
        System.out.println("FILTROWANIE: TYLKO KSIĄŻKI");
        s.show(newRecords);

    }
}
