package ggbibtex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {

    static HashMap<String, Record> records;
    static IParser parser;
    static IShow show;


    public static void main(String[] args) {
        String content = "";
        String contentNoNewlines = "";
        try {

            if (args.length == 0) {
                System.out.println("Welcome to GG Bibtex Parser");
                System.out.println("This piece of software was made by Grzegorz Gackowski in December 2019.");
                System.out.println("How to run the program:");
                System.out.println("1st argument (mandatory) - path to the BIBTEX source file");
                System.out.println("2nd argument (optional) - authors of records that should be shown.\n                          For displaying all the authors write. \"\" ");
                System.out.println("3rd argument (optional) - type of record that should be shown.");
            }
            else {
                content = new String(Files.readAllBytes(Paths.get(args[0])));
                contentNoNewlines = content.replace("\r\n", " ").replace("\n", " ");
                parser = new Parser();
                records = parser.parse(contentNoNewlines);
                show = new Show('█', 140);
                String authorFilter = "";
                String categoryFilter = "";
                if (args.length > 1) {
                    authorFilter = args[1];
                }
                if (args.length > 2) {
                    categoryFilter = args[2];
                }
                IFiltering filterA = new FilteringRecordType();
                HashMap<String, Record> newRecords = filterA.filter(records, categoryFilter);
                IFiltering filterC = new FilteringAuthor();
                HashMap<String, Record> newNewRecords = filterC.filter(newRecords, authorFilter);
                show.show(newNewRecords);
            }
        }
        catch (IOException e) {
            System.out.println("The path to the source file is invalid");
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Program has been launched without all necessary arguments");
        }
    }
}
