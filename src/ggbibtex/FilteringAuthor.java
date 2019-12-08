package ggbibtex;

import java.util.HashMap;

public class FilteringAuthor implements IFiltering {
    public HashMap<String, Record> filter(HashMap<String, Record> records, String constr) {
        return records;
    }
}
