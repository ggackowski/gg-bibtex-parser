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

    public static String mkstr(String s) {
        if (s.equals("")) return "";
        String res = new String();
        res += Character.toUpperCase(s.charAt(0));
        for (int i = 1; i < s.length(); ++i)
            res += Character.toLowerCase(s.charAt(i));
        return res;
    }

    public boolean hasNecessary(String name) { return necessary.containsKey(Record.mkstr(name));}
    public boolean hasOptional(String name) { return optional.containsKey(Record.mkstr(name));}
    public String getNecessary(String name) { return necessary.get(Record.mkstr(name)); }
    public String getOptional(String name) { return optional.get(Record.mkstr(name)); }

    public void printDev() {
        System.out.println(this.type.toString());
        System.out.println(this.key);
        for (String s : necessary.keySet())
            System.out.println(s + ": " + necessary.get(s));
        for (String s : optional.keySet())
            System.out.println(s + ": " + optional.get(s));
    }

    public void addNecessary(String name) {
        necessary.put(mkstr(name), "");
    }

    public void addOptional(String name) {
        optional.put(mkstr(name), "");
    }

    public void fillNecessary(String name, String value) {
        try {
            if (necessary.keySet().contains(mkstr(name))) {
                necessary.replace(mkstr(name), value);
            }
            else throw new Exception();
        }
        catch (Exception e) {
            System.out.println("wrong necessary field");
        }
    }

    public void fillOptional(String name, String value) {
        try {
            if (optional.keySet().contains(mkstr(name))) {
                optional.replace(mkstr(name), value);
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
        String[] strs = authors.split(" and ");
        String[] res = new String[strs.length];
        for (int i = 0; i < strs.length; ++i) {
            String surname = strs[i].split(",")[0];
            String name = strs[i].split(",")[1];
            res[i] = name + " " + surname;
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
            if (s.equals("Author")) {
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

    public String print(char a, int len) {
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
