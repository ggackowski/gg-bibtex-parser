package ggbibtex;

import java.util.HashMap;

public class FilteringAuthor implements IFiltering {
    public HashMap<String, Record> filter(HashMap<String, Record> records, String constr) {
        HashMap<String, Record> filtered = new HashMap<>();
        String[] condition = constr.split(" ");
        for (String s : records.keySet()) {
            String authors = "";
            if (records.get(s).hasNecessary("author"))
                authors = records.get(s).getNecessary("author");
            else if (records.get(s).hasOptional("author"))
                authors = records.get(s).getOptional("author");
            if (authors != "") {
                String[] authorsArray = authors.split(" and ");
                for (String auth : authorsArray) {
                    int count = 0;
                    String[] namesSurname = auth.split(",");
                    for (String ns : namesSurname) {
                        for (String c : condition) {
                            if (c.equals(ns)) count++;
                        }
                    }
                    if (count > condition.length) filtered.put(s, records.get(s));
                }
            }
        }
        return filtered;
    }
}
