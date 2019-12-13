package ggbibtex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.HashMap;

public class Main {

    static HashMap<String, Record> records;



    public static void main(String[] args) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(args[0])));
            System.out.println(content);
        }
        catch (IOException e) {
            System.out.println("IO error");
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("err");
        }

        String test = "asodg odsfigj dfg";
        String lastword = test.substring(test.lastIndexOf(" ") + 1);
        System.out.println(lastword);
        records = new HashMap<String, Record>();

        Record r = BookFactory.getInstance().produceRecord();
        r.fillNecessary("author", "Lipcoll, Dawid J. and Lawrie, D. H. and Sameh, A. H.");
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
        d.fillNecessary("author", "Aamport, Leaslie A.");
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
        IFiltering filterA = new FilteringAuthor();
        HashMap<String, Record> newNewRecords = filterA.filter(newRecords, "D. H. Lawrie");
        s.show(newNewRecords);

    }
}
