package ggbibtex;

import java.util.HashMap;

public class Show implements IShow {
    public void show(HashMap<String, Record> records) {
       for (String s : records.keySet())
           System.out.println(records.get(s));
    }

}
