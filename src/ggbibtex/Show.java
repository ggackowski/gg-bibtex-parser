package ggbibtex;

import java.util.HashMap;

public class Show implements IShow {
    private char a;
    private int length;
    Show(char c, int l) {
        a = c;
        length = l;
    }
    public void show(HashMap<String, Record> records) {
       for (String s : records.keySet())
           System.out.println(records.get(s).print(a, length));
    }

}
