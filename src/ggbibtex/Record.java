package ggbibtex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Record {
    private Map<String, String> necessary;
    private Map<String, String> optional;
    private String key;
    private RecordType type;
    public Record(RecordType t, String key) {
       type = t;
       this.key = key;
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
    public String getKey() { return key; }
    public void setKey(String k) {
       key = k;
    }

    static String[] parseAuthors(String authors) {
        int i = 0;
        String auth = authors;
        int index = 0;
        while (index != -1) {
            index = auth.indexOf(" and ");
            if (index != -1) {
                auth = auth.substring(index + 5);
                ++i;
            }
        }
        if (i == 0) {
            String [] res = new String[1];
            res[0] = authors;
            return res;
        }
       String[] res = new String[i + 1];
       int j = 0;
       index = 0;
       while (index != -1) {
           index = authors.indexOf(" and ");
               if (authors.indexOf(" and ") != -1)
               res[j] = authors.substring(0, authors.indexOf(" and "));
               else res[j] = authors.substring(1);
               j++;
               authors = authors.substring(index + 4);
       }
       return res;
    }

    public String printSet(Map<String, String> map, char a, int len, int maxLength) {
        String str = "";
        String line = "";
        for (String s : map.keySet()) {
            if (map.get(s) == "") continue;
            line = "";
            line += " " + s;
            if (s == "author") {
                for (int i = 0; i < maxLength - s.length() + 1; ++i)
                    line += " ";
                line += a;
                str += a;
                int lineLen = line.length() + 1;
                for (int i = 0; i < len - lineLen - 1; ++i)
                    line += " ";
                line += a + "\n";
                str += line;
                String[] authors = parseAuthors(map.get(s));
                for (String author : authors) {
                    line = Character.toString(a);
                    for (int i = 0; i < lineLen - 2; ++i)
                        line += " ";
                    line += a + " >" + author;
                    str += line;
                    for (int i = 0; i < len - line.length() - 1; ++i)
                        str += " ";
                    str += a + "\n";
                }
                for (int i = 0; i < len; ++i)
                    str += a;
                str += "\n";
                continue;
            }
            for (int i = 0; i < maxLength - s.length(); ++i)
                line += " ";
            line += " " + a + " " + map.get(s);
            str += a;
            str += line;
            for (int i = 0; i < len - line.length() - 2; ++i)
                str += " ";
            str += a;
            str += '\n';
            for (int i = 0; i < len; ++i)
                str += a;
            str += '\n';
        }
        return str;
    }

    public String print(char a) {
        int len = 50;
        try {
            String str = "";
            for (String s : necessary.keySet()) {
                if (necessary.get(s) == "") throw new Exception("Not enough necessary fields");
            }
            for (int i = 0; i < len; ++i) str += a;
            str += '\n';
            str += a;
            String line = " " + getType() + " (" + getKey() + ")";
            str += line;
            for (int i = 0; i < len - line.length() - 2; ++i) str += " ";
            str += a;
            str += '\n';
            for (int i = 0; i < len; ++i)
                str += a;
            str += '\n';
            int maxLength = 0;
            for (String s : necessary.keySet()) {
               if (s.length() > maxLength)
                   maxLength = s.length();
            }
            for (String s : optional.keySet()) {
                if (s.length() > maxLength)
                    maxLength = s.length();
            }
            str += printSet(necessary, a, len, maxLength);
            str += printSet(optional, a, len, maxLength);

            return str;
        }
        catch (Exception e) {
            System.out.println(this.key);
            return e.getMessage();
        }
    }
}
