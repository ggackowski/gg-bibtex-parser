package ggbibtex;

import java.util.HashMap;

public class Show implements IShow {
    private char a;
    Show(char c) {
        a = c;
    }
    public void show(HashMap<String, Record> records) {
       for (String s : records.keySet())
           System.out.println(records.get(s).print(a));
    }

}
