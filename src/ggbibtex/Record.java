package ggbibtex;

import java.util.HashMap;
import java.util.Map;

public class Record {
    private Map<String, String> necessary;
    private Map<String, String> optional;

    private RecordType type;
    public Record(RecordType t) {
       type = t;
       necessary = new HashMap<String, String>();
       optional = new HashMap<String, String>();
    }

    public void addNecessary(String name) {
        necessary.put(name, "");
    }

    public void addOptional(String name) {
        optional.put(name, "");
    }

    public void fillNecessary(String name, String value) {
        try {
            if (necessary.keySet().contains(name)) {
                necessary.replace(name, value);
            }
            else throw new Exception();
        }
        catch (Exception e) {
            System.out.println("wrong necessary field");
        }
    }

    public void fillOptional(String name, String value) {
        try {
            if (optional.keySet().contains(name)) {
                optional.replace(name, value);
            } else throw new Exception();
        }
        catch (Exception e) {
            System.out.println("wrong optional field");
        }
    }


    public RecordType getType() {
        return type;
    }

    @Override
    public String toString() {
        String res = "Record type: " + getType() + "\nNecessary fields:\n";
        for (String s : necessary.keySet())
            res += s + ": " + necessary.get(s) + "\n";
        res += "Optional fields:\n";
        for (String s : optional.keySet())
            res += s + ": " + optional.get(s) + "\n";
        return res;

    }
}
