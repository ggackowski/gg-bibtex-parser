package ggbibtex;

import java.util.HashMap;

public class FilteringAuthor implements IFiltering {
    public HashMap<String, Record> filter(HashMap<String, Record> records, String constr) {
        HashMap<String, Record> filtered = new HashMap<>();

        for (String s : records.keySet()) {
            String authors = "";
            if (s.necessary.contains("author"))
                authors = s.necessary.get(s);
            else if (s.optional.contains("author"))
                authors = s.necessary.get(s);
            if (authors != "") {
                String[] authorsArray = authors.split(" and ");
                for (String auth : authorsArray)
                    if (auth == constr) {
                            filtered.put(s, records.get(s));
                    }
            }
        }
        return records;
    }
}
