package ggbibtex;

import java.util.HashMap;

public class Main {

    static HashMap<String, Record> records;



    public static void main(String[] args) {
        records = new HashMap<String, Record>();

        Record r = BookFactory.getInstance().produceRecord();
        r.fillNecessary("author", "Dawid J. Lipcoll and D. H. Lawrie and A. H. Sameh");
        r.fillNecessary("title" , "High Speed Computer and Algorithm Organization");
        r.fillOptional("series", "Fast Computers");
        r.fillNecessary("publisher", "Academic Press");
        r.fillOptional("address", "New York");
        r.fillOptional("edition", "Third");
        r.fillOptional("month", "sep");
        r.fillNecessary("year", "1977");
        r.fillOptional("note", "This is a cross-referenced BOOK (collection) entry");
        r.setKey("whole-collection");

        Record d = ArticleFactory.getInstance().produceRecord();
        d.fillNecessary("title", "The Gnats and Gnus Document Preparation System");
        d.fillNecessary("author", "Leaslie A. Aamport");
        d.fillNecessary("journal", "G-Animal's Journal");
        d.fillNecessary("year", "1986");
        d.setKey("article-minimal");

        records.put(d.getKey(), d);
        records.put(r.getKey(), r);

        IShow s = new Show('█', 70);
        IFiltering filter = new FilteringRecordType();
        HashMap<String, Record> newRecords = filter.filter(records, "Book");
        System.out.println("Records before filtering");
        s.show(records);
        System.out.println("After filtering: only books");
        s.show(newRecords);

    }
}
