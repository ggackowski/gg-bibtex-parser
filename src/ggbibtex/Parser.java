package ggbibtex;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public HashMap<String, Record> parse(String input) {
        HashMap<String, Record> records = new HashMap<>();
        Pattern p = Pattern.compile("@\\w+ *\\{.*?\\}");
        Matcher m = p.matcher(input);
        while (m.find()) {
            String s = m.group();
            System.out.println(s);
        }
        return null;
    }
}
