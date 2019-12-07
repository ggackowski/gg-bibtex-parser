package ggbibtex;

import java.util.HashMap;

public interface IFiltering {
    public HashMap<String, Record> filter(HashMap<String, Record> records, String constr);
}
